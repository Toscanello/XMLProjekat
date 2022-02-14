package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="term")
public class Term {

    private LocalDateTime start;

    private LocalDateTime finish;

    private boolean taken;

    public Term(){

    }

    public Term(LocalDateTime start, LocalDateTime finish, boolean taken) {
        this.start = start;
        this.finish = finish;
        this.taken = taken;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
