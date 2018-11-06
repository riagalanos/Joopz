package com.cscheerleader.joopz;

import java.io.Serializable;

public class Challenge implements Serializable {

    private int mId;
    private String mType;
    private String mLoop; // for (int i = @@; i < $$; ##)\n\tSystem.out.print( i * 3 + " ");
    private String mExpected;
    //private int mInitialization;
    //private int mBound;
    //private String mIteration;
    private int mTimesSolved;

    private boolean mSolved;

    public Challenge( int id, String typ, String loopText, String output){//}, int init, int bd, String iter){
        mId = id;
        mType = typ;
        mLoop = loopText;
        mExpected = output;
        //mInitialization = init;
        //mBound = bd;
        //mIteration = iter;
        mSolved = false;
    }

    public Challenge( ){
    }

    public int getId() { return mId; }

    public int getTimesSolved() {
        return mTimesSolved;
    }

    public String getLoop() {
        return mLoop;
    }

    public String getExpected() {
        return mExpected;
    }

    /*public int getInitialization() {
        return mInitialization;
    }

    public int getBound() {
        return mBound;
    }

    public String getIteration() {
        return mIteration;
    }*/

    public String getType() {
        return mType;
    }

    public boolean isSolved() { return mSolved; }

    public void setTimesSolved(int timesSolved) {
        mTimesSolved = timesSolved;
    }

    public void setLoop(String loop) {
        mLoop = loop;
    }

    public void setExpected(String expected) {
        mExpected = expected;
    }

    /*public void setInitialization(int initialization) {
        mInitialization = initialization;
    }

    public void setBound(int bound) {
        mBound = bound;
    }

    public void setIteration(String iteration) {
        mIteration = iteration;
    }*/

    public void setType(String type) {
        mType = type;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setId(int id) {
        mId = id;
    }
}
