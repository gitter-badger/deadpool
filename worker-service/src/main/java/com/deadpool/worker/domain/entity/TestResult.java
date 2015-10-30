package com.deadpool.worker.domain.entity;

/**
 * Created by daniel on 2015.10.30..
 */
public class TestResult {

    private long minimumResponseTime;
    private long maximumResponseTime;
    private long averageResponseTime;
    private double throughput;

    public long getMinimumResponseTime() {
        return minimumResponseTime;
    }

    public void setMinimumResponseTime(long minimumResponseTime) {
        this.minimumResponseTime = minimumResponseTime;
    }

    public long getMaximumResponseTime() {
        return maximumResponseTime;
    }

    public void setMaximumResponseTime(long maximumResponseTime) {
        this.maximumResponseTime = maximumResponseTime;
    }

    public long getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(long averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public double getThroughput() {
        return throughput;
    }

    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public TestResult() {
    }
}
