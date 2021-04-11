package it.akademy.barbecueapi.models;

import javax.persistence.Entity;

@Entity


public class Sausage extends Food {
    private  Meat meat;

    public Sausage() {}

    public Sausage(String name, boolean cooked, Meat meat) {
        super(name, cooked);
        this.meat = meat;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }
}
