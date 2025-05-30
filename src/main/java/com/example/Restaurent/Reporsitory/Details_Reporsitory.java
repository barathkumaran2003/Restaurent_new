package com.example.Restaurent.Reporsitory;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.stereotype.Repository;

import com.example.Restaurent.entity.Details;

//@Repository
@EnableMongoRepositories
public interface Details_Reporsitory extends MongoRepository<Details, Long>{
	
	Details findByEmail(String email);
	Details findById(long id);
}
