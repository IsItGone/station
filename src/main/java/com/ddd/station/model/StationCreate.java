package com.ddd.station.model;

import com.ddd.station.Station;

public record StationCreate(String name, String address, Double latitude, Double longitude) {

	public Station convert() {
		return Station.builder()
				.name(name)
				.address(address)
				.latitude(latitude)
				.longitude(longitude)
				.build();
	}
}
