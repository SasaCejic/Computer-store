package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "proizvodjac")
public class Proizvodjac implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naziv;

    @OneToMany(mappedBy="proizvodjac")
    private List<Racunar> racunar;

    public Proizvodjac() {
    }

    public Proizvodjac(String naziv, List<Racunar> racunar) {
        this.naziv = naziv;
        this.racunar = racunar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Racunar> getRacunar() {
        return racunar;
    }

    public void setRacunar(List<Racunar> racunar) {
        this.racunar = racunar;
    }

    @Override
    public String toString() {
        return "Proizvodjac{" +
                "naziv='" + naziv + '\'' +
                ", racunar=" + racunar +
                '}';
    }
}
