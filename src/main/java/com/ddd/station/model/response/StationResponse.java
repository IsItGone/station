package com.ddd.station.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;
import lombok.Builder;

@Builder
public record StationResponse(String id, String name, String address, Double latitude,
							  Double longitude, @JsonFormat(pattern = "HH:mm") LocalTime stopTime,
							  Boolean isDeparture) {

}
