package com.dihu.subscriber;

import com.dihu.publisher.Company;

import java.io.IOException;

public abstract class User implements Subscriber {
    public enum UserState{
        ABC,
        ABC_HALF,
        ABC_DEF,
        DEF,
        NONE
    }
    protected UserState state; // 1:ABC 2:ABC+DEF 3:DEF 4:NONE
    protected int id;

    public UserState getState() {
        return state;
    }
    public int getId() {
        return id;
    }
    public void setState(UserState state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

}
