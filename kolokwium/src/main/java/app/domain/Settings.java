package app.domain;

import java.util.Date;

public class Settings {
    private int id;
    private String frequency;
    private Date dateFrom;
    private Date dateTo;
    private boolean europe;
    private boolean australia;
    private boolean india;

    public Settings(int id,String frequency, Date dateFrom, Date dateTo) {
        this.id = id;
        this.frequency = frequency;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isEurope() {
        return europe;
    }

    public void setEurope(boolean europe) {
        this.europe = europe;
    }

    public boolean isAustralia() {
        return australia;
    }

    public void setAustralia(boolean australia) {
        this.australia = australia;
    }

    public boolean isIndia() {
        return india;
    }

    public void setIndia(boolean india) {
        this.india = india;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "frequency='" + frequency + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", europe=" + europe +
                ", australia=" + australia +
                ", india=" + india +
                '}';
    }
}
