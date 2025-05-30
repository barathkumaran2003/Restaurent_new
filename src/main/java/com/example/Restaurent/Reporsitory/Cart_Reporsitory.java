package com.example.Restaurent.Reporsitory;

import java.time.LocalDate;
import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.stereotype.Repository;
//
//import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;

//@Repository
@EnableMongoRepositories
public interface Cart_Reporsitory extends MongoRepository<Cart, Long>{
	List<Cart> findAll();

}
