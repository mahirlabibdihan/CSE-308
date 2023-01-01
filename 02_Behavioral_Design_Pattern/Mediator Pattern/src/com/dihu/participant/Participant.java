package com.dihu.participant;

import com.dihu.result.ExamPackage;

public abstract class Participant {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void receive(ExamPackage pack);
}
