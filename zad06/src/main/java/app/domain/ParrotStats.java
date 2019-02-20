package app.domain;

import app.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParrotStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView(View.BasicParrotInfo.class)
    private String nickName;
    @JsonView(View.DetailedParrotInfo.class)
    private int timesSold;
    @JsonView(View.DetailedParrotInfo.class)
    private String color;

    public ParrotStats() {}

    public ParrotStats(String nickName, int timesSold, String color) {
        this.nickName = nickName;
        this.timesSold = timesSold;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getTimesSold() {
        return timesSold;
    }

    public void setTimesSold(int timesSold) {
        this.timesSold = timesSold;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
