package ui;

import model.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int odgovor;
        Kupac trenutniKupac = new Kupac();

        System.out.println("1. Kreiraj nalog");
        System.out.println("2. Prijavi se");
        System.out.println("Izaberi opciju: ");

        odgovor = s.nextInt();
        s.nextLine();

        if(odgovor == 1){

            trenutniKupac = kreirajKupca();
            dodajKupca(trenutniKupac);

        }else if(odgovor == 2){

            System.out.println("Unesite svoj email: ");
            trenutniKupac = pronadjiPoEmailu(s.nextLine());

        }else{

            System.out.println("Pogresan unos!");

        }

        prikaziRacunare();

        System.out.println("Unesite model racunara koji zelite da kupite: ");
        String model = s.nextLine();

        poruci(trenutniKupac,model);
    }

    static void poruci(Kupac kupac, String model){
        Racunar racunar = pronadjiRacunarPoModelu(model);
        Status status = pronadjiStatus1();
        Placanje placanje = new Placanje();
        placanje.setNacinPlacanja("kes");
        placanje.setIznos(racunar.getCena());
        upisiPlacanje(placanje);

        Date datum = new Date(System.currentTimeMillis());

        Porudzbina porudzbina = new Porudzbina(datum,kupac,placanje,status);

        RacunarPorudzbina racunarPorudzbina = new RacunarPorudzbina(racunar,porudzbina);

        try {
            upisiPorudzbinu(porudzbina);
            upisiRacunarPorudzbina(racunarPorudzbina);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\nRacunar je uspesno porucen!");
    }

    static void upisiRacunarPorudzbina(RacunarPorudzbina rp){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(rp);
        tx.commit();
        em.close();
    }

    static void upisiPlacanje(Placanje p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(p);
        tx.commit();
        em.close();
    }
    static void upisiPorudzbinu(Porudzbina p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(p);
        tx.commit();
        em.close();
    }

    static void pronadjiRacunarPoDatumu(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();


        Query q = em.createQuery("select r from Racunar r inner join r.racunar_porudzbina rp inner join rp.porudzbina p  where p.datumPorudzbine = '2020-01-11'");

        List<Racunar> racunari= q.getResultList();

        if(racunari.isEmpty()){
            System.out.println("Nema trazenih racunara!");
        }else{
            for(Racunar r: racunari){
                System.out.println(r);
            }
        }

        em.close();
    }

    static Kupac pronadjiPoEmailu(String unos){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Kupac> q = cb.createQuery(Kupac.class);
        Root<Kupac> c = q.from(Kupac.class);
        ParameterExpression<String> email = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("email"), email));

        TypedQuery<Kupac> qu = em.createQuery(q);
        qu.setParameter(email,unos);

        Kupac k = qu.getSingleResult();

        em.close();

        return k;

    }

    static void pronadjiBeogradjane(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();


        Query q = em.createNamedQuery("Kupac.beograd",Kupac.class);

        List<Kupac> kupci= q.getResultList();

        if(kupci.isEmpty()){
            System.out.println("Nema trazenih kupaca!");
        }else{
            for(Kupac k: kupci){
                System.out.println(k);
            }
        }

        em.close();
    }

    static void pronadjiPreko25(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();


        Query q = em.createNamedQuery("Kupac.over25",Kupac.class);

        List<Kupac> kupci= q.getResultList();

        if(kupci.isEmpty()){
            System.out.println("Nema trazenih kupaca!");
        }else{
            for(Kupac k: kupci){
                System.out.println(k);
            }
        }

        em.close();
    }

    static void dodajKupca(Kupac k){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            em.persist(k);
            tx.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\nKupac je uspesno dodat u tabelu!");
    }

    static Kupac kreirajKupca(){
        Kupac k = new Kupac();

        System.out.println("Ime: ");
        k.setIme(s.nextLine());

        System.out.println("Prezime: ");
        k.setPrezime(s.nextLine());

        System.out.println("Adresa: ");
        k.setAdresa(s.nextLine());

        System.out.println("Grad: ");
        k.setGrad(s.nextLine());

        System.out.println("Mejl: ");
        k.setEmail(s.nextLine());

        return k;
    }

//    static void prikaziProizvodjace(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
//        EntityManager em = emf.createEntityManager();
//
//        Query query1 = em.createQuery("select p.naziv from Proizvodjac p");
//        List<String> marke = query1.getResultList();
//
//        for(String m: marke){
//            System.out.println(m);
//        }
//
//        em.close();
//    }

    static void prikaziNajnizuCenu(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Double> q = em.createQuery("SELECT min(r.cena) FROM Racunar r", Double.class);

        double rez = q.getSingleResult();

        System.out.println(rez);

        em.close();
    }

    static void prikaziRacunare(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select r from Racunar r");
        List<Racunar> racunari = q.getResultList();

        for(Racunar r: racunari){
            System.out.println(r);
        }


        em.close();
    }

    static Status pronadjiStatus1(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select s from Status s");
        List<Status> statusi = q.getResultList();

        em.close();

        return statusi.get(0);
    }
    static Status pronadjiStatus2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select s from Status s");
        List<Status> statusi = q.getResultList();

        em.close();

        return statusi.get(1);
    }

    static Racunar pronadjiRacunarPoModelu(String model){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza");
        EntityManager em = emf.createEntityManager();


        Query q = em.createNamedQuery("find racunar by model");
        q.setParameter("model",model);

        List<Racunar> racunari = q.getResultList();

        if(racunari.isEmpty()){
            System.out.println("Nema trazenog racunara!");
        }else{
            for(Racunar r: racunari){
                System.out.println(r);
            }
        }

        em.close();

        return racunari.get(0);
    }

}
