package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "racunar")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIP")
@NamedQuery(query = "SELECT r FROM Racunar r WHERE r.model=:model",name = "find racunar by model")
public class Racunar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRacunar;
    private String model;
    private String procesor;
    private Integer hdd;
    private Integer ramMemorija;
    private double cena;
    private String tip;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROIZVODJAC")
    private Proizvodjac proizvodjac;

    @OneToMany(mappedBy="racunar")
    private List<RacunarPorudzbina> racunar_porudzbina;



    public Racunar() {

    }

    public Racunar(String model,Proizvodjac proizvodjac, String procesor, Integer hdd, Integer ramMemorija, double cena, String tip) {
        super();
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.procesor = procesor;
        this.hdd = hdd;
        this.ramMemorija = ramMemorija;
        this.cena = cena;
        this.tip = tip;
    }

    public int getIdRacunar() {
        return idRacunar;
    }

    public void setIdRacunar(int idRacunar) {
        this.idRacunar = idRacunar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public List<RacunarPorudzbina> getRacunar_porudzbina() {
        return racunar_porudzbina;
    }

    public void setRacunar_porudzbina(List<RacunarPorudzbina> racunar_porudzbina) {
        this.racunar_porudzbina = racunar_porudzbina;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }

    public Integer getRamMemorija() {
        return ramMemorija;
    }

    public void setRamMemorija(Integer ramMemorija) {
        this.ramMemorija = ramMemorija;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Racunar{" +
                "idRacunar=" + idRacunar +
                ", model='" + model + '\'' +
                ", procesor='" + procesor + '\'' +
                ", hdd=" + hdd +
                ", ramMemorija=" + ramMemorija +
                ", cena=" + cena +
                ", tip='" + tip + '\'' +
                ", proizvodjac='" + proizvodjac + '\'' +
                '}';
    }

}
