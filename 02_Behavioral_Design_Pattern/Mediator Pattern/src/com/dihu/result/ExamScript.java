package com.dihu.result;

public class ExamScript {
    public enum ScriptStatus {
        NOT_PUBLISHED,
        PUBLISHED,
        RECHECK_REQUESTED,
        RECHECK_UNCHANGED,
        RECHECK_INCREASED,
        RECHECK_DECREASED
    }

    private int mark;
    private int examineeId;
    private int examinerId;
    private ScriptStatus status;
    public ExamScript(int examineeId, int examinerId) {
        this.mark = -1;
        this.examineeId = examineeId;
        this.examinerId = examinerId;
    }
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Integer getExamineeId() {
        return examineeId;
    }

    public void setExamineeId(Integer examineeId) {
        this.examineeId = examineeId;
    }

    public int getExaminerId() {
        return examinerId;
    }

    public ScriptStatus getStatus() {
        return status;
    }

    public void setExamineeId(int examineeId) {
        this.examineeId = examineeId;
    }

    public void setExaminerId(int examinerId) {
        this.examinerId = examinerId;
    }

    public void setStatus(ScriptStatus status) {
        this.status = status;
    }
}
