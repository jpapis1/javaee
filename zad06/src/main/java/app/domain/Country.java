package app.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Country.getCountry", query = "Select c from Country c WHERE c.name=:name")
})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = false)
    private String name;


    public Country() {}
    public Country(String name) {this.name = name;}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
