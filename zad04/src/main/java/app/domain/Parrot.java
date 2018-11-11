package app.domain;

import java.util.Date;

public class Parrot {
    private int id;
    private String name;
    private Date dateOfBirth;
    private double weight;
    private boolean isExotic;

    public Parrot(String name, Date dateOfBirth, double weight, boolean isExotic) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.isExotic = isExotic;
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
