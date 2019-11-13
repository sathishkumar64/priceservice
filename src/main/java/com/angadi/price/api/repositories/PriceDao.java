package com.angadi.price.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.angadi.price.api.model.PriceData;

@Repository
public interface PriceDao extends MongoRepository<PriceData, String>{

}
