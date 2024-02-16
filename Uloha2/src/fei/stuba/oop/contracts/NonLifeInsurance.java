package fei.stuba.oop.contracts;


import fei.stuba.oop.utilities.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

public class NonLifeInsurance extends Contract
{
    public enum type
    {
        APARTMENT,
        HOUSE_STONE,
        HOUSE_WOOD,
        UNKNOWN
    }
    private Address address;
    private float propertyValue;
    private type propertyType;

    public NonLifeInsurance()
    {}

    public NonLifeInsurance(long id, long insurerId, Date signDate, Date beginDate, Date endDate, float monthlySum, float indemnitySum, Address addr, float propVal, type propertyType)
    {
        super(id, insurerId, signDate, beginDate, endDate, monthlySum, indemnitySum);
        this.address = addr;
        this.propertyValue = propVal;
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", address=" + address.toString() +
                ", propertyValue=" + propertyValue +
                ", propertyType=" + propertyType.toString();
    }

    @Override
    public void edit() throws IOException, ParseException {
        super.edit();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        System.out.println("address=");
        this.address = new Address(reader);
        System.out.println("propertyValue=");
        this.propertyValue = Float.parseFloat(reader.readLine());
        System.out.println("propertyType=");
        String type = reader.readLine();

        switch (type)
        {
            case "flat":
               this.propertyType = NonLifeInsurance.type.APARTMENT;
                break;
            case "stone":
                this.propertyType = NonLifeInsurance.type.HOUSE_STONE;
                break;
            case"wood":
                this.propertyType = NonLifeInsurance.type.HOUSE_WOOD;
                break;
            default:
                this.propertyType = NonLifeInsurance.type.UNKNOWN;
        }
    }

    public Address getAddress() {
        return address;
    }

    public float getPropertyValue() {
        return propertyValue;
    }

    public NonLifeInsurance.type getPropertyType() {
        return propertyType;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPropertyValue(float propertyValue) {
        this.propertyValue = propertyValue;
    }

    public void setPropertyType(NonLifeInsurance.type propertyType) {
        this.propertyType = propertyType;
    }
}
