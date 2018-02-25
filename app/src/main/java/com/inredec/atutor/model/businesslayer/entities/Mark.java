package com.inredec.atutor.model.businesslayer.entities;



public class Mark {

    private Test test;
    private int mark;

    public Mark(Test test, int mark) {
        this.test = test;
        this.mark = mark;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
