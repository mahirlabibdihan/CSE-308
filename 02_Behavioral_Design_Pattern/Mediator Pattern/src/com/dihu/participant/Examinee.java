package com.dihu.participant;

import com.dihu.result.ExamScript;
import com.dihu.mediator.Mediator;
import com.dihu.result.ExamPackage;

import java.util.*;

public class Examinee extends Participant {
    private List<ExamScript> examScripts;
    private Mediator eco;
    public Examinee(int sid, Mediator eco) {
        this.id = sid;
        this.eco = eco;
        this.examScripts = new ArrayList<>();
    }
    public void storeResult(ExamScript script) {
        System.out.println(this + " => Exam result received by examinee with id " + id);
        System.out.println(this + " => Examiner Id: " + script.getExaminerId() + ", Mark: " + script.getMark());
        examScripts.add(script);
    }

    public void recheckUpdate(ExamScript script) {
        System.out.println(this + " => Re-examine result received by examinee with id " + id);
        System.out.println(this + " => Examiner Id: " + script.getExaminerId() + ", Corrected Mark: " + script.getMark());
        examScripts.add(script);
    }

    public void requestRecheck(int serial) {
        System.out.println("Applied for recheck to teacher: " + id);
        System.out.println(this + " => Re-examine request sent from examinee with id " + this.id);
        List<ExamScript> dummy = new ArrayList<>();
        dummy.add(examScripts.get(serial - 1));
        eco.send(this, new ExamPackage(dummy)); // send teacher_id
    }

    public List<ExamScript> getExamScripts() {
        return examScripts;
    }

    @Override
    public String toString() {
        return "[Examinee #id:" + id + "]";
    }

    @Override
    public void receive(ExamPackage pack) {
        ExamScript script = pack.getExamScripts().get(0);
        switch (script.getStatus()) {
            case PUBLISHED:
                storeResult(script);
                break;
            default:
                recheckUpdate(script);
                break;
        }
    }
}
