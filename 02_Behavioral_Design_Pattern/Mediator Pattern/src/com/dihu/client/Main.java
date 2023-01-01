package com.dihu.client;

import com.dihu.result.ExamScript;
import com.dihu.io.Console;
import com.dihu.participant.Examinee;
import com.dihu.participant.Examiner;
import com.dihu.mediator.ExamControllerOffice;

import java.util.*;

public class Main {
    public static void recheckMenu(Examiner examiner) {
        List<ExamScript> recheckScripts = examiner.getRecheckScripts();
        if (recheckScripts == null || recheckScripts.isEmpty()) {
            System.out.println("No Recheck requests");
            return;
        }
        for (int i = 0; i < recheckScripts.size(); i++) {
            System.out.println((i + 1) + ". Student id: " + recheckScripts.get(i).getExamineeId() + ", Previous Mark: " + recheckScripts.get(i).getMark());
        }
        int serial = Console.getOption(1, recheckScripts.size());
        System.out.println("Is there any correction?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int option = Console.getOption(1, 2);
        switch (option) {
            case 1: {
                int mark = Console.getRangeInt("Enter new mark: ", 0, 100);
                examiner.recheck(serial, mark);
            }
            break;
            case 2: {
                examiner.recheck(serial, recheckScripts.get(serial - 1).getMark());
            }
            break;
            default:
                break;
        }
    }
    public static void recheckMenu(Examinee examinee) {
        List<ExamScript> examScripts = examinee.getExamScripts();
        int i = 1;
        for (ExamScript script : examScripts) {
            System.out.println((i++) + ". Teacher Id: " + script.getExaminerId() + "; Mark: " + script.getMark());
        }
        int serial = Console.getOption(1, examScripts.size());
        examinee.requestRecheck(serial);
    }
    private static void examinerMenu(Examiner examiner) {
        System.out.println("Logged in successfully!");
        while (true) {
            System.out.println("\nExaminer menu");
            System.out.println("1. Publish result");
            System.out.println("2. Recheck menu");
            System.out.println("3. Log out");
            int option = Console.getOption(1, 3);
            switch (option) {
                case 1:
                    examiner.publishResult();
                    break;
                case 2:
                    recheckMenu(examiner);
                    break;
                case 3:
                    System.out.println("Logging you out..");
                    return;
                default:
                    break;
            }
        }
    }
    private static void examineeMenu(Examinee examinee) {
        System.out.println("Logged in successfully!");
        while (true) {
            System.out.println("\nExaminee menu");
            System.out.println("1. Request recheck");
            System.out.println("2. Log out");
            int option = Console.getOption(1, 2);
            switch (option) {
                case 1:
                    recheckMenu(examinee);
                    break;
                case 2:
                    System.out.println("Logging you out..");
                    return;
                default:
                    break;
            }
        }
    }
    public static void main(String[] args) {
        ExamControllerOffice eco = new ExamControllerOffice();
        List<Examinee> examinees = new ArrayList<>();
        List<Examiner> examiners = new ArrayList<>();

        int examinerNum = Console.getPositiveInt("Enter number of examiners: ");
        int examineeNum = Console.getPositiveInt("Enter number of examinees: ");

        for (int id = 1; id <= examineeNum; id++) {
            examinees.add(new Examinee(id, eco));
        }

        for (int id = 1; id <= examinerNum; id++) {
            Examiner examiner = new Examiner(id, eco);
            List<ExamScript> scripts = new ArrayList<>();
            for (Examinee examinee : examinees) {
                scripts.add(new ExamScript(examinee.getId(), examiner.getId()));
            }
            examiner.setExamScripts(scripts);
            examiners.add(examiner);
        }
        eco.setExaminees(examinees);
        eco.setExaminers(examiners);

        while (true) {
            System.out.println("Login as:");
            System.out.println("1. Examiner");
            System.out.println("2. Examinee");
            int type = Console.getOption(1, 2);
            while (true) {
                if (type == 1) {
                    int id = Console.getPositiveInt("Examiner Id: ");
                    if (id <= examinerNum) {
                        examinerMenu(examiners.get(id - 1));
                        break;
                    } else {
                        System.out.println("No examiner with this id");
                    }
                } else if (type == 2) {
                    int id = Console.getPositiveInt("Examinee Id: ");
                    if (id <= examineeNum) {
                        examineeMenu(examinees.get(id - 1));
                        break;
                    } else {
                        System.out.println("No examinee with this id");
                    }
                }
            }
        }
    }
}
