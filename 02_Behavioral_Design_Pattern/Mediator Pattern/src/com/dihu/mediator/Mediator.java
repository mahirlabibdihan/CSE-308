package com.dihu.mediator;

import com.dihu.participant.Participant;
import com.dihu.result.ExamPackage;

public interface Mediator {
    void send(Participant sender, ExamPackage pack);
}
