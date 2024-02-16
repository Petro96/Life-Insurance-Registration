package fei.stuba.oop.utilities;

import fei.stuba.oop.contracts.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private int idNumber;
    private String email;
    private Address permAddress; // example of aggregation
    private Address corrAddress; // example of aggregation

    // main part of user contract definition
    private List<Contract> contracts; // list of users Contract Object-usage

    public User(long id, String firstName, String lastName, int idNumber, String email, Address permAddress,
            Address corrAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.email = email;
        this.permAddress = permAddress; // Address object
        if (corrAddress == null) {
            this.corrAddress = permAddress; // perm - trvala
        } else {
            this.corrAddress = corrAddress;
        }
        this.contracts = new ArrayList<>(); // create arrayList of users
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber=" + idNumber +
                ", email='" + email + '\'' +
                ", permAddress=" + permAddress.toString() +
                (permAddress.equals(corrAddress) ? "" : ", corrAddress=" + corrAddress.toString());
    }

    public void edit() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("id=");
            this.id = Long.parseLong(reader.readLine());
            System.out.println("firstName=");
            this.firstName = reader.readLine();
            System.out.println("lastName=");
            this.lastName = reader.readLine();
            System.out.println("idNumber=");
            this.idNumber = Integer.parseInt(reader.readLine());
            System.out.println("email=");
            this.email = reader.readLine();
            System.out.println("permAddress=");
            this.permAddress = new Address(reader);
            System.out.println("corrAddress=");
            this.corrAddress = new Address(reader);
        } catch (IOException e) {
            System.out.println("Invalid value entered");
        }
    }

    public long getId() {
        return id;
    }

    // import Contract object
    public void printContracts() { // vypis zmluv
        for (Contract c : contracts) {
            System.out.println(c.toString());
        }
    }

    public void addContract(Contract c) { // pridanie zmluvi
        c.setInsurerId(this.id); // referencia na poistovatela
        this.contracts.add(c);
    }

    public boolean editContract(long id) {
        try {
            for (Contract c : contracts) {
                if (c.getId() == id) {
                    c.edit();
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Invalid value entered");
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        return false;
    }

}
