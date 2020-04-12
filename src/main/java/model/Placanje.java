package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "placanje")
public class Placanje implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placanje;
    private String nacinPlacanja;
    private double iznos;

    @OneToMany(mappedBy="placanje")
    private List<Porudzbina> porudzbina;

    public Placanje() {
    }

    public Placanje(String nacinPlacanja, double iznos, List<Porudzbina> porudzbina) {
        this.nacinPlacanja = nacinPlacanja;
        this.iznos = iznos;
        this.porudzbina = porudzbina;
    }

    public int getPlacanje() {
        return placanje;
    }

    public void setPlacanje(int placanje) {
        this.placanje = placanje;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public List<Porudzbina> getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(List<Porudzbina> porudzbina) {
        this.porudzbina = porudzbina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return "Placanje{" +
                "nacinPlacanja='" + nacinPlacanja + '\'' +
                ", iznos=" + iznos +
                '}';
    }

}
