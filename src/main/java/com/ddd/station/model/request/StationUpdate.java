package com.ddd.station.model.request;

public record StationUpdate(String id, String name, String address, Double latitude,
							Double longitude) {

}
