package com.dihu.participant;

import com.dihu.mediator.Mediator;
import com.dihu.result.ExamPackage;
import com.dihu.result.ExamScript;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Examiner extends Participant {
    private Mediator eco;
    private List<Integer> marksheet;
    private List<ExamScript> examScripts;
    private List<ExamScript> recheckScripts;

    public Examiner(int tid, Mediator eco) {
        this.id = tid;
        this.eco = eco;
        this.recheckScripts = new ArrayList<>();
    }

    public void recheck(int serial, int mark) {
        ExamScript script = recheckScripts.get(serial - 1);
        if (mark == script.getMark()) {
            script.setStatus(ExamScript.ScriptStatus.RECHECK_UNCHANGED);
        } else if (mark > script.getMark()) {
            script.setStatus(ExamScript.ScriptStatus.RECHECK_INCREASED);
        } else {
            script.setStatus(ExamScript.ScriptStatus.RECHECK_DECREASED);
        }
        script.setMark(mark);
        List<ExamScript> dummy = new ArrayList<>();
        dummy.add(script);
        System.out.println(this + " => Re-examination update sent from examiner id " + this.id);
        eco.send(this, new ExamPackage(dummy));
        recheckScripts.remove(id - 1);
    }

    public void setExamScripts(List<ExamScript> examScripts) {
        Random ran = new Random();
        marksheet = new ArrayList<>();
        this.examScripts = examScripts;
        int i = 0;
        for (ExamScript script : examScripts) {
            Integer num = ran.nextInt(100);
            script.setMark(num);
            if (i % 2 == 0) {
                marksheet.add(ran.nextInt(100));
            } else {
                marksheet.add(num);
            }
            i++;
        }
    }

    public void publishResult() {
        if (examScripts != null) {
            System.out.println(this + " => Exam scripts and marksheet sent from examiner with id " + id);
            eco.send(this, new ExamPackage(examScripts, marksheet)); // send - Marksheet, Scripts
            marksheet = null;
            examScripts = null;
        } else {
            System.out.println("Error: Result already sent to Exam controller office!");
        }
    }

    @Override
    public String toString() {
        return "[Examiner #id:" + id + "]";
    }

    @Override
    public void receive(ExamPackage pack) {
        System.out.println(this + " => Re-examination request received by examiner with id " + id);
        recheckScripts.add(pack.getExamScripts().get(0));
    }

    public List<ExamScript> getRecheckScripts() {
        return recheckScripts;
    }
}
