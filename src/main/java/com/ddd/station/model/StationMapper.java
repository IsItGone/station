package com.ddd.station.model;

import com.ddd.station.Station;
import com.ddd.station.model.request.StationCreate;
import com.ddd.station.model.request.StationUpdate;
import com.ddd.station.model.response.StationResponse;
import org.bson.types.ObjectId;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StationMapper {

	Station toEntity(StationCreate stationCreate);

	Station toEntity(StationUpdate stationUpdate);

	StationResponse toResponse(Station station);

	default ObjectId stringToObjectId(String id) {
		return new ObjectId(id);
	}

	default String objectIdToString(ObjectId objectId) {
		return objectId.toString();
	}
}
