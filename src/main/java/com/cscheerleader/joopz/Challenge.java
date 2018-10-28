package com.cscheerleader.joopz;

public class Challenge {

    private static int challenge_number;
    private int mTimesSolved;
    private String mLoop;
    private String mExpected;
    private int mInitialization;
    private int mBound;
    private String mIteration;

    private Challenge( String loopy, String output, int init, int bd, String iter){
        mLoop = loopy;
        mExpected = output;
        mInitialization = init;
        mBound = bd;
        mIteration = iter;
    }

    public static int getChallenge_number() {
        return challenge_number;
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

}
