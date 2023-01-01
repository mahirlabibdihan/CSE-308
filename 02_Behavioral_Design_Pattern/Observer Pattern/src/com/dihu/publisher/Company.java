package com.dihu.publisher;

import com.dihu.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Company implements Publisher {
    private int nextId;
    private int prevState;
    private int currState;
    private List<Subscriber> subscribers;

    public Company() {
        this.nextId = 1905001;
        this.currState = 1;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber o) {
        subscribers.add(o);
    }

    @Override
    public void unsubscribe(Subscriber o) {
        subscribers.remove(o);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    public int getCurrState() {
        return currState;
    }

    public void setCurrState(int state) {
        this.prevState = currState;
        this.currState = state;
    }

    public int getPrevState() {
        return prevState;
    }

    public void setPrevState(int state) {
        this.prevState = state;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public int generateSubscriberId(){
        return nextId++;
    }
}
