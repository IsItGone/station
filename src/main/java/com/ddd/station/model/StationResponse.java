package com.ddd.station.model;

import com.ddd.station.Station;
import lombok.Builder;

@Builder
public record StationResponse(String id, String name, String address, Double latitude,
							  Double longitude) {

	public static StationResponse convert(Station station) {
		return StationResponse.builder()
				.id(station.getId())
				.name(station.getName())
				.address(station.getAddress())
				.latitude(station.getLatitude())
				.longitude(station.getLongitude())
				.build();
	}
}
