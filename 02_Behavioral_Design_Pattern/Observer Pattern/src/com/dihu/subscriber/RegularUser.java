package com.dihu.subscriber;

import com.dihu.io.Console;
import com.dihu.publisher.Company;
import com.dihu.client.Main;

import java.util.Random;

public class RegularUser extends User {
    public RegularUser(int id) {
        this.id = id;
        this.state = UserState.ABC;
    }
    @Override
    public void update(Company com) {
        System.out.println("\n\t" + "<< " + this + " console >>");

        int prev = com.getPrevState();
        int curr = com.getCurrState();

        System.out.println("\t" + "ABC Server is now " + Main.getServerState(curr));
        if (prev == 1 && curr == 2) {
            System.out.println("\t" + "1. Continue using limited functionality");
            System.out.println("\t" + "2. Pay $20 per hour to enjoy the full functionality");
            System.out.print("\t");
            int choice = Console.getOption(1, 2);
            switch (choice) {
                case 1:
                    setState(UserState.ABC_HALF);
                    break;
                case 2:
                    setState(UserState.DEF);
                    break;
                default:
                    break;
            }
        } else if ((prev == 1 || (prev == 2 && getState() == UserState.ABC_HALF)) && curr == 3) {
            System.out.println("\t" + "Would you like to pay $20 per hour to take service from DEF company?");
            System.out.println("\t" + "1. Yes");
            System.out.println("\t" + "2. No");
            System.out.print("\t");
            int option = Console.getOption(1, 2);
            switch (option) {
                case 1:
                    setState(UserState.DEF);
                    break;
                case 2:
                    setState(UserState.NONE);
                    break;
                default:
                    break;
            }
        } else if ((prev == 2 || prev == 3) && curr == 1) {
            if (getState() == UserState.DEF) {
                Random ran = new Random();
                ran.setSeed(System.currentTimeMillis());
                System.out.println("\t" + "<< Total bill for using DEF server: "+(20* ran.nextInt(10))+"$ >>");
            }
            setState(UserState.ABC);
        } else if (prev == 2 && curr == 3) {
        } else if (prev == 3 && curr == 1) {
        } else if (prev == 3 && curr == 2) {
            if (getState() == UserState.NONE) {
                System.out.println("\t" + "1. Use limited functionality");
                System.out.println("\t" + "2. Pay $20 per hour to enjoy the full functionality");
                System.out.print("\t");
                int choice = Console.getOption(1, 2);
                switch (choice) {
                    case 1:
                        setState(UserState.ABC_HALF);
                        break;
                    case 2:
                        setState(UserState.DEF);
                        break;
                    default:
                        break;
                }
            }
        }
        printState();
    }

    public void printState() {
        switch (state) {
            case ABC:
                System.out.println("\t" + ">> Using ABC server");
                break;
            case ABC_HALF:
                System.out.println("\t" + ">> Using limited functionality from ABC server");
                break;
            case DEF:
                System.out.println("\t" + ">> Data copied to DEF server, Using DEF server");
                break;
            case NONE:
                System.out.println("\t" + ">> No service currently, will be notified later");
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Regular user #id:" + id;
    }
}
