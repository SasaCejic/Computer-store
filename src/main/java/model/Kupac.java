package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "kupac")
@NamedQueries({
        @NamedQuery(name="Kupac.over25",
                query="SELECT k FROM Kupac k inner join k.porudzbina p  inner join p.placanje pl where pl.iznos > 25000"),
        @NamedQuery(name="Kupac.beograd",
                query="select k from Kupac k where k.grad like 'Beograd'"),
})
public class Kupac implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKupac;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String email;

    @OneToMany(mappedBy="kupac")
    private List<Porudzbina> porudzbina;

    public Kupac() {
        super();
    }

    public Kupac(String ime, String prezime, String adresa, String grad, String email) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.email = email;
    }


    public int getIdKupac() {
        return idKupac;
    }

    public void setIdKupac(int idKupac) {
        this.idKupac = idKupac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Kupac{" +
                "idKupac=" + idKupac +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
