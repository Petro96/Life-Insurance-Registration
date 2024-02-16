package fei.stuba.oop.contracts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

public class TravelInsurance extends LifeInsurance {
    private final String insName = "Travel: ";

    public enum territory {
        EU,
        NON_EU
    }

    public enum purpose {
        BUSINESS,
        MEDICAL,
        TOURIST,
        SPORT
    }

    private territory coverage;
    private purpose insurancePurpose;

    public TravelInsurance(long id, long insurerId, long insuredId, Date signDate, Date beginDate, Date endDate,
            float monthlySum, float compensation, territory terr, purpose pur) {
        super(id, insurerId, insuredId, signDate, beginDate, endDate, monthlySum, compensation);
        this.coverage = terr;
        this.insurancePurpose = pur;
    }

    @Override
    public String toString() {
        return this.insName + super.toString() + ", " +
                "territory=" + coverage +
                ", purpose=" + insurancePurpose;
    }

    @Override
    public void edit() throws IOException, ParseException {
        super.edit();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("territory= <eu, noneu> ");
        switch (reader.readLine()) {
            case "eu":
                this.coverage = TravelInsurance.territory.EU;
                break;
            case "noneu":
                this.coverage = TravelInsurance.territory.NON_EU;
                break;
        }

        System.out.println("purpose= <business, recreational, tourist, sport> ");
        switch (reader.readLine()) {
            case "business":
                this.insurancePurpose = TravelInsurance.purpose.BUSINESS;
                break;
            case "recreational":
                this.insurancePurpose = purpose.MEDICAL;
                break;
            case "tourist":
                this.insurancePurpose = TravelInsurance.purpose.TOURIST;
                break;
            case "sport":
                this.insurancePurpose = TravelInsurance.purpose.SPORT;
                break;
        }
    }

    public TravelInsurance.territory getCoverage() { // return enum
        return coverage;
    }

    public TravelInsurance.purpose getInsurancePurpose() {
        return insurancePurpose;
    }

    public void setCoverage(TravelInsurance.territory coverage) {
        this.coverage = coverage;
    }

    public void setInsurancePurpose(TravelInsurance.purpose insurancePurpose) {
        this.insurancePurpose = insurancePurpose;
    }

}
