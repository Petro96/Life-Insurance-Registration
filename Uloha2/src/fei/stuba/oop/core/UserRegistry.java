package fei.stuba.oop.core;

import fei.stuba.oop.contracts.Contract;
import fei.stuba.oop.utilities.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserRegistry {
    List<User> users = new ArrayList<>();

    // -------------------------------

    public void addUser(User u) // pridanie user-a
    {
        this.users.add(u);
    }

    public User getUser(long id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public void editUser(long id) { // uprava user-a
        for (User u : users) {
            if (u.getId() == id) {
                u.edit();
                return;
            }
        }
        System.out.println("User not found");
    }

    public void printAllUsers() {
        for (User u : users) {
            System.out.println(u.toString());
            ;
        }
    }
    // ------------------------------

    public void printAllContracts() { // all users contract
        for (User u : users) {
            System.out.println(u.toString());
            u.printContracts();
        }
    }

    public void addContract(long user_id, Contract c) {// pridanie do zmluvy
        if (getUser(user_id) != null) // null -> method return object
            getUser(user_id).addContract(c); // reference to...
        else
            System.out.println("User not found");
    }

    public void editContract(long id) { // uprava zmluvy
        boolean ret = false;
        for (User u : users) {
            ret = u.editContract(id);
            if (ret)
                return;
        }
        System.out.println("Contract id not found");
    }
}
