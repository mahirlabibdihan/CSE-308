package com.dihu.subscriber;

import com.dihu.io.Console;
import com.dihu.client.Main;
import com.dihu.publisher.Company;

public class PremiumUser extends User {
    public PremiumUser(int id) {
        this.state = UserState.ABC;
        this.id = id;
    }

    @Override
    public void update(Company com) {
        System.out.println("\n\t" + "<< " + this + " console >>");
        int prev = com.getPrevState();
        int curr = com.getCurrState();

        System.out.println("\t" + "ABC Server is now " + Main.getServerState(curr));
        if (prev == 1 && curr == 2) {
            System.out.println("\t" + "1. Use service from two servers");
            System.out.println("\t" + "2. Use service from one server");
            System.out.print("\t");
            int choice = Console.getOption(1, 2);
            switch (choice) {
                case 1:
                    setState(UserState.ABC_DEF);
                    break;
                case 2:
                    setState(UserState.DEF);
                    break;
                default:
                    break;
            }
        } else if ((prev == 1 || (prev == 2 && getState() == UserState.ABC_DEF)) && curr == 3) {
            setState(UserState.DEF);
        } else if (prev == 2 && curr == 1) {
        } else if (prev == 2 && curr == 3) {
        } else if (prev == 3 && curr == 1) {
        } else if (prev == 3 && curr == 2) {
        }
        printState();
    }

    public void printState() {
        switch (state) {
            case ABC:
                System.out.println("\t" + ">> Using ABC server");
                break;
            case ABC_DEF:
                System.out.println("\t" + ">> Using both ABC and DEF server");
                break;
            case DEF:
                System.out.println("\t" + ">> Using DEF server");
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Premium user #id:" + id;
    }
}
