package app.domain;

import app.view.View;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "parrot.getAll", query = "Select p from Parrot p"),
        @NamedQuery(name = "parrot.deleteAll", query = "Delete from Parrot "),
        @NamedQuery(name = "parrot.getOwnersParrots", query = "Select p from Parrot p WHERE p.owner.id = :id"),
        @NamedQuery(name = "parrot.betweenDateOfBirth", query = "Select p from Parrot p WHERE p.dateOfBirth>=:fromDate and p.dateOfBirth<=:toDate"),
        @NamedQuery(name = "parrot.delete", query = "Delete from Parrot where id=:id"),
        @NamedQuery(name = "parrot.getAvgWeightByParrotColor", query = "select avg(p.weight) from Parrot p join ParrotStats ps ON ps=p.stats WHERE p.stats.color=:color")

})
        public class Parrot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.BasicParrotInfo.class)
    private int id;
    @JsonView(View.BasicParrotInfo.class)
    private String name;
    @JsonView(View.BasicParrotInfo.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private Date dateOfBirth;
    @JsonView(View.BasicParrotInfo.class)
    private double weight;

    private boolean isExotic;

    @JsonView(View.DetailedParrotInfo.class)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private Owner owner;

    @JsonView(View.BasicParrotInfo.class)
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ParrotStats stats;

    @JsonView(View.DetailedParrotInfo.class)
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Country> countriesVisited;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name="Bakset_Parrot", joinColumns=@JoinColumn(name="parrots_id"), inverseJoinColumns=@JoinColumn(name="baskets_id"))
    private List<Basket> baskets = new ArrayList<>();

    public Parrot(){ }
    public Parrot(String name, Date dateOfBirth, double weight, boolean isExotic, ParrotStats stats,List<Country> countriesVisited) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.isExotic = isExotic;
        this.stats = stats;
        this.countriesVisited = countriesVisited;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public ParrotStats getStats() {
        return stats;
    }

    public void setStats(ParrotStats stats) {
        this.stats = stats;
    }

    public List<Country> getCountriesVisited() {
        return countriesVisited;
    }

    public void setCountriesVisited(List<Country> countriesVisited) {
        this.countriesVisited = countriesVisited;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isExotic() {
        return isExotic;
    }

    public void setExotic(boolean exotic) {
        isExotic = exotic;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", weight=" + weight +
                ", isExotic=" + isExotic +
                '}';
    }
}
