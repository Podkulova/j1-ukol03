package cz.czechitas.ukol3.model;

public class Procesor {
    private String vyrobce;
    private long rychlost;

    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }

    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long rychlost) {
        this.rychlost = rychlost;
    }

    @Override
    public String toString() {
        return "Procesor{" +
                "vyrobce='" + vyrobce + '\'' +
                ", rychlost=" + rychlost +
                '}';
    }
}
