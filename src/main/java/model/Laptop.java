package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "laptop")
public class Laptop extends Racunar{


    private String velicina;
    private String kapacitetBaterije;


    public Laptop() {
    }

    public Laptop(String model, Proizvodjac proizvodjac, String procesor, Integer hdd, Integer ramMemorija, double cena, String tip, String velicina, String kapacitetBaterije) {
        super(model, proizvodjac, procesor, hdd, ramMemorija, cena, tip);
        this.velicina = velicina;
        this.kapacitetBaterije = kapacitetBaterije;
    }


    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public String getKapacitetBaterije() {
        return kapacitetBaterije;
    }

    public void setKapacitetBaterije(String kapacitetBaterije) {
        this.kapacitetBaterije = kapacitetBaterije;
    }

    @Override
    public String toString() {
        return super.toString() + "Laptop{" +
                ", velicina='" + velicina + '\'' +
                ", kapacitetBaterije='" + kapacitetBaterije + '\'' +
                '}';
    }
}
