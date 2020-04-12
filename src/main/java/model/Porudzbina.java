package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "porudzbina")
public class Porudzbina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPorudzbina;
    private Date datumPorudzbine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKupac")
    private Kupac kupac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nacinPlacanja")
    private Placanje placanje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusPorudzbine")
    private Status status;

    @OneToMany(mappedBy="porudzbina")
    private List<RacunarPorudzbina> racunar_porudzbina;

    public Porudzbina() {
    }

    public Porudzbina(Date datumPorudzbine, Kupac kupac, Placanje placanje, Status status) {
        this.datumPorudzbine = datumPorudzbine;
        this.kupac = kupac;
        this.placanje = placanje;
        this.status = status;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Placanje getPlacanje() {
        return placanje;
    }

    public void setPlacanje(Placanje placanje) {
        this.placanje = placanje;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getIdPorudzbina() {
        return idPorudzbina;
    }

    public void setIdPorudzbina(int idPorudzbina) {
        this.idPorudzbina = idPorudzbina;
    }


    public Date getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(Date datumPorudzbine) {
        this.datumPorudzbine = datumPorudzbine;
    }

    @Override
    public String toString() {
        return "Porudzbina{" +
                "idPorudzbina=" + idPorudzbina +
                ", datumPorudzbine=" + datumPorudzbine +
                ", kupac=" + kupac +
                ", placanje=" + placanje +
                ", status=" + status +
                ", racunar_porudzbina=" + racunar_porudzbina +
                '}';
    }

}
