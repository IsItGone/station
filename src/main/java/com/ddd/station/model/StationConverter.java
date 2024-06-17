package com.ddd.station.model;

import com.ddd.station.Station;
import com.ddd.station.model.request.StationCreate;
import com.ddd.station.model.request.StationUpdate;
import com.ddd.station.model.response.StationResponse;

public class StationConverter {

	public static Station toEntity(StationCreate stationCreate) {
		return Station.builder()
				.name(stationCreate.name())
				.address(stationCreate.address())
				.latitude(stationCreate.latitude())
				.longitude(stationCreate.longitude())
				.build();
	}

	public static Station toEntity(StationUpdate stationUpdate) {
		return Station.builder()
				.id(stationUpdate.id())
				.name(stationUpdate.name())
				.address(stationUpdate.address())
				.latitude(stationUpdate.latitude())
				.longitude(stationUpdate.longitude())
				.build();
	}

	public static StationResponse toResponse(Station station) {
		return StationResponse.builder()
				.id(station.getId())
				.name(station.getName())
				.address(station.getAddress())
				.latitude(station.getLatitude())
				.longitude(station.getLongitude())
				.build();
	}
}
