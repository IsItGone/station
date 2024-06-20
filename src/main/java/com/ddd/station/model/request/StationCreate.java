package com.ddd.station.model.request;

import java.time.LocalTime;

public record StationCreate(String name, String address, Double latitude, Double longitude,
							LocalTime stopTime, Boolean isDeparture) {

}
