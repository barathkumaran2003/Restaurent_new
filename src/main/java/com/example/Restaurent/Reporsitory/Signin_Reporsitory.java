package com.example.Restaurent.Reporsitory;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.stereotype.Repository;

import com.example.Restaurent.entity.Signin;

//@Repository
@EnableMongoRepositories
public interface Signin_Reporsitory extends MongoRepository<Signin, Long> {
    Signin findByEmail(String email);
}
