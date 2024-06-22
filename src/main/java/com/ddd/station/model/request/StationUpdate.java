package com.ddd.station.model.request;

import java.util.List;

public record StationUpdate(String id, String name, String description, String address,
							Double latitude, Double longitude, String stopTime,
							Boolean isDeparture, List<String> routes) {

}
