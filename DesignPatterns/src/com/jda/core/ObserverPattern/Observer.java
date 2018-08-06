package com.jda.core.ObserverPattern;

public interface Observer {
    public void update();

    public void setSubject(Subject sub);
}
