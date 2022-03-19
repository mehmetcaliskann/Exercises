package model.insurance;

import java.util.Date;

public abstract class Insurance {
    private String name;
    private double price;
    private Date beginningDate;
    private Date endingDate;

    public abstract double calculate();
}
