package com.cscheerleader.joopz;

import java.io.Serializable;

public class Challenge implements Serializable {

    private int mTimesSolved;
    private String mLoop;
    private String mExpected;
    private int mInitialization;
    private int mBound;
    private String mIteration;

    public Challenge( String loopy, String output, int init, int bd, String iter){
        mLoop = loopy;
        mExpected = output;
        mInitialization = init;
        mBound = bd;
        mIteration = iter;
    }

    public Challenge( ){
    }


    public int getTimesSolved() {
        return mTimesSolved;
    }

    public String getLoop() {
        return mLoop;
    }

    public String getExpected() {
        return mExpected;
    }

    public int getInitialization() {
        return mInitialization;
    }

    public int getBound() {
        return mBound;
    }

    public String getIteration() {
        return mIteration;
    }

    public void setTimesSolved(int timesSolved) {
        mTimesSolved = timesSolved;
    }

    public void setLoop(String loop) {
        mLoop = loop;
    }

    public void setExpected(String expected) {
        mExpected = expected;
    }

    public void setInitialization(int initialization) {
        mInitialization = initialization;
    }

    public void setBound(int bound) {
        mBound = bound;
    }

    public void setIteration(String iteration) {
        mIteration = iteration;
    }
}
