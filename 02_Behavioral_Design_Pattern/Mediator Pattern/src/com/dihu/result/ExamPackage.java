package com.dihu.result;

import java.util.List;

public class ExamPackage {
    private List<ExamScript> examScripts;
    private List<Integer> marksheet;

    public ExamPackage(List<ExamScript> examScripts){
        this.examScripts = examScripts;
        this.marksheet = null;
    }
    public ExamPackage(List<ExamScript> examScripts, List<Integer> marksheet){
        this.examScripts = examScripts;
        this.marksheet = marksheet;
    }

    public List<Integer> getMarksheet() {
        return marksheet;
    }

    public List<ExamScript> getExamScripts() {
        return examScripts;
    }

    public void setMarksheet(List<Integer> marksheet) {
        this.marksheet = marksheet;
    }

    public void setExamScripts(List<ExamScript> examScripts) {
        this.examScripts = examScripts;
    }
}
