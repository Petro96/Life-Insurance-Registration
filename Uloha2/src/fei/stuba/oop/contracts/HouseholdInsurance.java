package fei.stuba.oop.contracts;

import fei.stuba.oop.utilities.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

// domacnost poistenie
public class HouseholdInsurance extends NonLifeInsurance {
    private final String insName = "HouseholdInsurance: ";
    private float equipmentValue;

    public HouseholdInsurance(long id, long insurerId, Date signDate, Date beginDate, Date endDate, float monthlySum,
            float indemnitySum, Address addr, float propVal, NonLifeInsurance.type type, float eqVal) {
        super(id, insurerId, signDate, beginDate, endDate, monthlySum, indemnitySum, addr, propVal, type);
        this.equipmentValue = eqVal;
    }

    @Override
    public String toString() {
        return this.insName + super.toString() +
                ", equipmentValue=" + equipmentValue;
    }

    @Override
    public void edit() throws IOException, ParseException {
        super.edit();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("equipmentValue=");
        this.equipmentValue = Float.parseFloat(reader.readLine());
    }

    public float getEquipmentValue() {
        return equipmentValue;
    }

    public void setEquipmentValue(float equipmentValue) {
        this.equipmentValue = equipmentValue;
    }
}
