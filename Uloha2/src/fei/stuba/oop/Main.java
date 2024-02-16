package fei.stuba.oop;

//import fei.stuba.oop.contracts.LifeInsurance;
import fei.stuba.oop.contracts.TravelInsurance;
import fei.stuba.oop.core.UserRegistry;
import fei.stuba.oop.utilities.Address;
import fei.stuba.oop.utilities.User;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        UserRegistry register = new UserRegistry();
        Address address1 = new Address(84104, "Bratislava", "Karlova ves", "Stare Grunty", 53);
        Address address2 = new Address(84104, "Bratislava", "Karlova ves", "Stare Grunty", 60);
        User u1 = new User(1, "Jozef", "Mrkvicka", 123456, "jozef@mrkvica.com", address1, address1);
        User u2 = new User(2, "Tomas", "Fabcic", 654321, "tomsa@fabcic.com", address2, address1);
        // ----------------------------------------------------
        register.addUser(u1);
        register.addUser(u2);

        register.editUser(3);
        // register.editUser(2);
        // ------------------------------------------------------

        TravelInsurance travelInsurance = new TravelInsurance(1, 1, 2, new Date(),
                new Date(), new Date(), 100.00f,
                10000.00f, TravelInsurance.territory.EU, TravelInsurance.purpose.TOURIST);
        register.addContract(1, travelInsurance);

        // register.editContract(2);
        // register.editContract(1);

        register.printAllUsers();
        register.printAllContracts();

        System.out.println("Vypisat vsetke zmluvy isteho pouzivatela");

        register.getUser(1).printContracts();

    }
}
