package com.dihu.publisher;


import com.dihu.subscriber.Subscriber;

public interface Publisher {
    void subscribe(Subscriber o);
    void unsubscribe(Subscriber o);
    void notifySubscribers();
}
