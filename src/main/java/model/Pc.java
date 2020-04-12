package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "pc")
public class Pc extends Racunar{


   private String napajanje;

    public Pc() {
    }

    public Pc(String model, Proizvodjac proizvodjac, String procesor, Integer hdd, Integer ramMemorija, double cena, String tip, String napajanje) {
        super(model, proizvodjac, procesor, hdd, ramMemorija, cena, tip);
        this.napajanje = napajanje;
    }


    public String getNapajanje() {
        return napajanje;
    }

    public void setNapajanje(String napajanje) {
        this.napajanje = napajanje;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "napajanje='" + napajanje + '\'' +
                '}';
    }
}
