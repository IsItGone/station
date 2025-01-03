package com.ddd.station.model.request;

import java.util.List;

public record StationCreate(String name, String description, String address,
							Double latitude, Double longitude, Boolean isDeparture,
							List<String> routes) {

}
