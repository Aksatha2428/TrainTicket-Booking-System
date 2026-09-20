package model;

import java.time.*;

public class Train {

    private static int start = 1;

    private int trainId;
    private int trainNo;
    private String src;
    private String dest;
    private LocalTime st;
    private LocalTime end;

    public Train(int trainNo, String src, String dest,LocalTime st, LocalTime end) {

        this.trainId = start++;
        this.trainNo = trainNo;
        this.src = src;
        this.dest = dest;
        this.st = st;
        this.end = end;
    }

    public int getTrainId() {
        return trainId;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public String getSrc() {
        return src;
    }

    public String getDest() {
        return dest;
    }

    public LocalTime getSt() {
        return st;
    }

    public LocalTime getEnd() {
        return end;
    }

    public String toString() {
        return trainNo + "    " +src + "     " +dest + "    " +st + "      " +end;
    }
}