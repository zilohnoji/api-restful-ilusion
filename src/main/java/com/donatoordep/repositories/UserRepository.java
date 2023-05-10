package com.donatoordep.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.donatoordep.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
