package com.dihu.mediator;

import com.dihu.participant.Examiner;
import com.dihu.participant.Participant;
import com.dihu.participant.Examinee;
import com.dihu.result.ExamPackage;
import com.dihu.result.ExamScript;

import java.util.ArrayList;
import java.util.List;

public class ExamControllerOffice implements Mediator {
    private List<Examinee> examinees;
    private List<Examiner> examiners;

    public ExamControllerOffice() {
    }

    public void setExaminees(List<Examinee> examinees) {
        this.examinees = examinees;
    }

    public void setExaminers(List<Examiner> examiners) {
        this.examiners = examiners;
    }

    public void recheckRequest(Examinee examinee, ExamPackage pack) {
        ExamScript script = pack.getExamScripts().get(0);
        script.setStatus(ExamScript.ScriptStatus.RECHECK_REQUESTED);
        System.out.println(this + " => Re-examine request received from examinee id " + examinee.getId());
        System.out.println(this + " => Re-examine request sent to examiner id " + script.getExaminerId());
        examiners.get(script.getExaminerId() - 1).receive(pack);
    }

    public void publishResult(Examiner examiner, ExamPackage pack) {
        System.out.println(this + " => Exam scripts and marksheet received from examiner with id " + examiner.getId());
        List<Integer> marksheet = pack.getMarksheet();
        List<ExamScript> examScripts = pack.getExamScripts();

        for (int i = 0; i < marksheet.size(); i++) {
            System.out.println(this + " => Examinee id: " + examScripts.get(i).getExamineeId() + ", Mark:" + marksheet.get(i));
        }

        System.out.println(this + " => Case of mistakes");
        for (int i = 0; i < examScripts.size(); i++) {
            if (examScripts.get(i).getMark() != marksheet.get(i)) {
                System.out.println(this + " => Examinee id: " + examScripts.get(i).getExamineeId() + ", Previous mark:" + marksheet.get(i) + ", Corrected mark: " + examScripts.get(i).getMark());
                marksheet.set(i, examScripts.get(i).getMark());
            }
        }

        for (ExamScript script : examScripts) {
            script.setStatus(ExamScript.ScriptStatus.PUBLISHED);
            List<ExamScript> dummy = new ArrayList<>();
            dummy.add(script);
            System.out.println(this + " => Exam result sent to examinee with id " + script.getExamineeId());
            examinees.get(script.getExamineeId() - 1).receive(new ExamPackage(dummy));
        }
    }

    public void recheckUpdate(Examiner examiner, ExamPackage pack) {
        ExamScript script = pack.getExamScripts().get(0);
        System.out.println(this + " => Re-examine update got from examiner with id " + examiner.getId());

        System.out.println(this + " => Re-examine update sent to examinee with id " + script.getExamineeId());
        switch (pack.getExamScripts().get(0).getStatus()) {
            case RECHECK_UNCHANGED:
                System.out.println(this + " => Marks unchanged");
                break;
            case RECHECK_INCREASED:
                System.out.println(this + " => Marks increased");
                break;
            case RECHECK_DECREASED:
                System.out.println(this + " => Marks decreased");
                break;
            default:
                break;
        }
        List<ExamScript> dummy = new ArrayList<>();
        dummy.add(script);
        examinees.get(script.getExamineeId() - 1).receive(new ExamPackage(dummy));
    }

    @Override
    public String toString() {
        return "[Exam Controller Office]";
    }


    @Override
    public void send(Participant sender, ExamPackage pack) {
        if (sender instanceof Examinee) {
            recheckRequest((Examinee) sender, pack);
        } else if (sender instanceof Examiner) {
            if (pack.getMarksheet() != null) {
                publishResult((Examiner) sender, pack);
            }
            if (pack.getMarksheet() == null) {
                recheckUpdate((Examiner) sender, pack);
            }
        }
    }
}
