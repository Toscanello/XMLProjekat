package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="term")
public class Term {

    private long start;

    private long finish;

    private boolean taken;

    private String location;

    public Term(){

    }

    public Term(long start, long finish, boolean taken, String location) {
        this.start = start;
        this.finish = finish;
        this.taken = taken;
        this.location = location;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getFinish() {
        return finish;
    }

    public void setFinish(long finish) {
        this.finish = finish;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

