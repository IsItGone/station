package com.ddd.station;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stations")
@Getter
@Builder
public class Station {

	@Id
	private String id;
	private String name;
	private String address;
	private Double latitude;
	private Double longitude;
	private LocalTime stopTime;
	private Boolean isDeparture;
}
