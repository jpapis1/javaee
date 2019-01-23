package app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "baskets", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Parrot> parrots = new ArrayList<>();
    public Basket() {
    }
    public Basket(List<Parrot> parrots) {
        this.parrots = parrots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Parrot> getParrots() {
        return parrots;
    }

    public void setParrots(List<Parrot> parrots) {
        this.parrots = parrots;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", parrots=" + parrots +
                '}';
    }
}
