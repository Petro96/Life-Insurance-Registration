package fei.stuba.oop.contracts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

public class InjuryInsurance extends LifeInsurance
{
    private final String insName = "InjuryInsurance: ";
    public enum territorialValidity
    {
        SLOVAKIA,
        WORLD,
        SLOVAKIA_AND_WORLD
    }

    private float longTermCompensation;
    private float deathCompensation;
    private float dailyHospitalCompenstaion;
    private territorialValidity terrVal;

    public InjuryInsurance(long id, long insurerId, long insuredId, Date signDate, Date beginDate, Date endDate, float monthlySum, float indemnitySum, float longTerm, float death, float daily, territorialValidity territory ) {
        super(id, insurerId, insuredId, signDate, beginDate, endDate, monthlySum, indemnitySum);
        this.longTermCompensation = longTerm;
        this.deathCompensation = death;
        this.dailyHospitalCompenstaion = daily;
        this.terrVal = territory;

    }

    @Override
    public String toString() {
        return this.insName + super.toString() +
                ", longTermCompensation=" + longTermCompensation +
                ", deathCompensation=" + deathCompensation +
                ", dailyHospitalCompenstaion=" + dailyHospitalCompenstaion +
                ", terrVal=" + terrVal.toString();
    }

    @Override
    public void edit() throws IOException, ParseException {
        super.edit();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        System.out.println("longTermCompensation=");
        this.longTermCompensation = Float.parseFloat(reader.readLine());
        System.out.println("deathCompensation=");
        this.deathCompensation = Float.parseFloat(reader.readLine());
        System.out.println("dailyHospitalCompenstaion=");
        this.dailyHospitalCompenstaion = Float.parseFloat(reader.readLine());
        System.out.println("terrVal=(sk, w, wsk): ");
        switch (reader.readLine())
        {
            case "sk":
                this.terrVal = territorialValidity.SLOVAKIA;
                break;
            case "w":
                this.terrVal = territorialValidity.WORLD;
                break;
            case "wsk":
                this.terrVal = territorialValidity.SLOVAKIA_AND_WORLD;
        }
    }

    public float getLongTermCompensation() {
        return longTermCompensation;
    }

    public float getDeathCompensation() {
        return deathCompensation;
    }

    public float getDailyHospitalCompenstaion() {
        return dailyHospitalCompenstaion;
    }

    public territorialValidity getTerrVal() {
        return terrVal;
    }

    public void setLongTermCompensation(float longTermCompensation) {
        this.longTermCompensation = longTermCompensation;
    }

    public void setDeathCompensation(float deathCompensation) {
        this.deathCompensation = deathCompensation;
    }

    public void setDailyHospitalCompenstaion(float dailyHospitalCompenstaion) {
        this.dailyHospitalCompenstaion = dailyHospitalCompenstaion;
    }

    public void setTerrVal(territorialValidity terrVal) {
        this.terrVal = terrVal;
    }
}
