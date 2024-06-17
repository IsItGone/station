package com.ddd.station.model.response;

import lombok.Builder;

@Builder
public record StationResponse(String id, String name, String address, Double latitude,
							  Double longitude) {

}
