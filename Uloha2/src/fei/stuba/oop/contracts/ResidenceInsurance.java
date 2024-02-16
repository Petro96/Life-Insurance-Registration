package fei.stuba.oop.contracts;

import fei.stuba.oop.utilities.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

// dom a byt poistenie  
public class ResidenceInsurance extends NonLifeInsurance {
    private final String insName = "Residence: ";
    private boolean garageInsurance;

    public ResidenceInsurance(long id, long insurerId, Date signDate, Date beginDate, Date endDate, float monthlySum,
            float indemnitySum, Address addr, float propVal, NonLifeInsurance.type type, boolean garageIn) {
        super(id, insurerId, signDate, beginDate, endDate, monthlySum, indemnitySum, addr, propVal, type);
        this.garageInsurance = garageIn;
    }

    @Override
    public String toString() {
        return this.insName + super.toString() +
                ", garageInsurance=" + garageInsurance;
    }

    @Override
    public void edit() throws IOException, ParseException {
        super.edit();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Garage insurance included? (y/n): ");
        switch (Character.toLowerCase(reader.read())) {
            case 'y':
                this.garageInsurance = true;
                break;
            case 'n':
                this.garageInsurance = false;
                break;
        }
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }
}
