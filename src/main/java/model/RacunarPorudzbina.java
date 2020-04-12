package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "racunar_porudzbina")
public class RacunarPorudzbina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRacPor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Racunar racunar;

    @ManyToOne(fetch = FetchType.LAZY)
    private Porudzbina porudzbina;

    public RacunarPorudzbina() {
    }

    public RacunarPorudzbina(Racunar racunar, Porudzbina porudzbina) {
        this.racunar = racunar;
        this.porudzbina = porudzbina;
    }

    public int getIdRacPor() {
        return idRacPor;
    }

    public void setIdRacPor(int idRacPor) {
        this.idRacPor = idRacPor;
    }

    @Override
    public String toString() {
        return "RacunarPorudzbina{" +
                "idRacPor=" + idRacPor +
                ", racunar=" + racunar +
                ", porudzbina=" + porudzbina +
                '}';
    }

}
