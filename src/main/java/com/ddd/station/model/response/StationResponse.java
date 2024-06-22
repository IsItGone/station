package com.ddd.station.model.response;

import java.util.List;
import lombok.Builder;

@Builder
public record StationResponse(String id, String name, String description, String address,
							  Double latitude, Double longitude, String stopTime,
							  Boolean isDeparture, List<String> routes) {

}
