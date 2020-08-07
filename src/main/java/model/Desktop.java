package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "desktop")
public class Desktop extends Racunar{


   private String napajanje;

    public Desktop() {
    }

    public Desktop(String model, Proizvodjac proizvodjac, String procesor, Integer hdd, Integer ramMemorija, double cena, String tip, String napajanje) {
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
        return super.toString() + "Desktop{" +
                "napajanje='" + napajanje + '\'' +
                '}';
    }
}
