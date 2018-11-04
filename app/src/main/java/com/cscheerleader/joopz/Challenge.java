package com.cscheerleader.joopz;

import java.io.Serializable;

public class Challenge implements Serializable {

    private int mTimesSolved;
    private String mLoop;
    private String mExpected;
    private int mInitialization;
    private int mBound;
    private String mIteration;
    private String mType;
    private boolean mSolved;

    public Challenge( String typ, String loopy, String output, int init, int bd, String iter){
        mType = typ;
        mLoop = loopy;
        mExpected = output;
        mInitialization = init;
        mBound = bd;
        mIteration = iter;
        mSolved = false;
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

    public String getType() {
        return mType;
    }

    public boolean isSolved() {
        return mSolved;
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

    public void setType(String type) {
        mType = type;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
