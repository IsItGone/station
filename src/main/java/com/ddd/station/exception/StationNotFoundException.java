package com.ddd.station.exception;

public class StationNotFoundException extends RuntimeException {

    public StationNotFoundException() {
        super("Station not found");
    }
}
