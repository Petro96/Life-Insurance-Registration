package fei.stuba.oop.contracts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

public class LifeInsurance extends Contract {
    private long insuredId;

    public LifeInsurance() {
    }

    // dependancy injection ?
    public LifeInsurance(LifeInsurance L) {
        this.setId(L.getId());
        this.setInsurerId(L.getInsurerId());
        this.setInsuredId(L.getInsuredId());
        this.setSignDate(L.getSignDate());
        this.setStartDate(L.getStartDate());
        this.setEndDate(L.getEndDate());
        this.setMonthPayment(L.getMonthPayment());
        this.setCompensation(L.getCompensation());
    }

    public LifeInsurance(long id, long insurerId, long insuredId, Date signDate, Date beginDate, Date endDate,
            float monthlySum, float indemnitySum) {
        super(id, insurerId, signDate, beginDate, endDate, monthlySum, indemnitySum);
        this.insuredId = insuredId;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", insuredId=" + insuredId;
    }

    @Override
    public void edit() throws IOException, ParseException {
        super.edit();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("insuredId=");
        this.insuredId = Long.parseLong(reader.readLine());
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }
}
