package fei.stuba.oop.contracts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Contract {
    private long id;
    private long insurerId;
    private Date signDate;
    private Date startDate;
    private Date endDate;
    private float monthPayment;
    private float compensation;

    public Contract()
    {

    }
    public Contract(long id, long insurerId, Date signDate, Date startDate, Date endDate, float monthPayment, float compensation)
    {
        this.id = id;
        this.insurerId = insurerId;
        this.signDate = signDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthPayment = monthPayment;
        this.compensation = compensation;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", insurerId=" + insurerId +
                ", signDate=" + signDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", monthPayment=" + monthPayment +
                ", compensation=" + compensation;
    }

    public void edit() throws IOException, ParseException {
        System.out.println(this.toString());
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        System.out.println("Enter new values:");
        System.out.println("insurerId=");
        this.insurerId = Long.parseLong(reader.readLine());
        System.out.println("signDate= <dd/mm/yyyy>");
        this.signDate = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
        System.out.println("startDate= <dd/mm/yyyy>");
        this.startDate = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
        System.out.println("endDate= <dd/mm/yyyy>");
        this.endDate = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
        System.out.println("monthPayment=");
        this.monthPayment = Float.parseFloat(reader.readLine());
        System.out.println("compensation=");
        this.compensation = Float.parseFloat(reader.readLine());

    }

    public long getId() {
        return id;
    }

    public long getInsurerId() {
        return insurerId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public float getMonthPayment() {
        return monthPayment;
    }

    public float getCompensation() {
        return compensation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInsurerId(long insurerId) {
        this.insurerId = insurerId;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMonthPayment(float monthPayment) {
        this.monthPayment = monthPayment;
    }

    public void setCompensation(float compensation) {
        this.compensation = compensation;
    }
}
