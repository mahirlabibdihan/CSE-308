package com.dihu.client;

import com.dihu.io.Console;
import com.dihu.publisher.Company;
import com.dihu.subscriber.PremiumUser;
import com.dihu.subscriber.RegularUser;
import com.dihu.subscriber.Subscriber;

import java.util.List;

public class Main {
    public static String getServerState(int state) {
        switch (state) {
            case 1:
                return "Operational";
            case 2:
                return "Partially Down";
            case 3:
                return "Fully Down";
            default:
                break;
        }
        return "Unknown state";
    }

    public static void main(String[] args) {
        Company abc = new Company();
        while (true) {
            System.out.println("\nServer status: " + getServerState(abc.getCurrState()));
            System.out.println("1. Add subscriber");
            System.out.println("2. Remove subscriber");
            System.out.println("3. Change server state");
            int choice = Console.getOption(1, 3);
            switch (choice) {
                case 1:
                    if (abc.getCurrState() != 1) {
                        System.out.println();
                        Console.printError("Operation failed, server not operational:(");
                    } else {
                        System.out.println("\nSubscriber type");
                        System.out.println("1. Regular");
                        System.out.println("2. Premium");
                        int option = Console.getOption(1, 2);
                        switch (option) {
                            case 1: {
                                int id = abc.generateSubscriberId();
                                Subscriber newS = new RegularUser(id);
                                abc.subscribe(newS);
                                Console.printSuccess(newS + " added");
                            }
                            break;
                            case 2: {
                                int id = abc.generateSubscriberId();
                                Subscriber newS = new PremiumUser(id);
                                abc.subscribe(newS);
                                Console.printSuccess(newS + " added");
                            }
                            break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2: {
                    if (abc.getCurrState() != 1) {
                        System.out.println();
                        Console.printError("Operation failed, server not operational:(");
                    } else {
                        List<Subscriber> subscribers = abc.getSubscribers();
                        if (subscribers.isEmpty()) {
                            System.out.println();
                            Console.printError("No subscribers");
                        } else {
                            System.out.println("\nSubscriber List");
                            for (int i = 0; i < subscribers.size(); i++) {
                                System.out.println(i + 1 + ". " + subscribers.get(i));
                            }
                            int option = Console.getOption(1, subscribers.size());
                            Subscriber oldS = subscribers.get(option - 1);
                            abc.unsubscribe(oldS);
                            Console.printSuccess(oldS + " removed");
                        }
                    }
                }
                break;
                case 3: {
                    System.out.println("\nAvailable server state:");
                    System.out.println("1. Operational");
                    System.out.println("2. Partially Down");
                    System.out.println("3. Fully Down");
                    choice = Console.getOption(1, 3);
                    if (abc.getCurrState() == choice) {
                        Console.printWarning("Server already " + getServerState(abc.getCurrState()));
                    } else {
                        switch (choice) {
                            case 1:
                                abc.setCurrState(1);
                                Console.printSuccess("Server state changed to Operational");
                                break;
                            case 2:
                                abc.setCurrState(2);
                                Console.printSuccess("Server state changed to Partially Down");
                                break;
                            case 3:
                                abc.setCurrState(3);
                                Console.printSuccess("Server state changed to Fully Down");
                                break;
                            default:
                                break;
                        }
                        abc.notifySubscribers();
                    }
                }
                break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}