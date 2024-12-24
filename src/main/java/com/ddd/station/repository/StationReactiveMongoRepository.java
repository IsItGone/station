package com.ddd.station.repository;

import com.ddd.station.repository.document.StationDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StationReactiveMongoRepository extends
		ReactiveMongoRepository<StationDocument, String> {

}
