package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "status")
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @OneToMany(mappedBy="status")
    private List<Porudzbina> porudzbina;

    public Status() {
    }

    public Status(String status, List<Porudzbina> porudzbina) {
        this.status = status;
        this.porudzbina = porudzbina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Porudzbina> getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(List<Porudzbina> porudzbina) {
        this.porudzbina = porudzbina;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", porudzbina=" + porudzbina +
                '}';
    }


}
