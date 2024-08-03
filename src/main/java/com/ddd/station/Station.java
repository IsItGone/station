package com.ddd.station;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stations")
@Getter
@Builder
public class Station {

	@Id
	private String id;
	private String name;
	private String description;
	private String address;
	private Double latitude;
	private Double longitude;
	private Boolean isDeparture;
	private List<ObjectId> routes;
}
