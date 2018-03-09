package me.circuitrcay.euler;

import java.text.NumberFormat;

public class Timer {
    private static final NumberFormat formatter = NumberFormat.getInstance();

    private long start, stop;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        stop = System.currentTimeMillis();
    }

    private long getDuration() {
        stop();
        return stop - start;
    }

    String formatDuration() {
        return formatter.format((double) getDuration() / 1000) + "s";
    }
}
