package com.open.lms.repository;

import com.open.lms.model.LmsUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LmsUserRepository extends MongoRepository<LmsUser, String> {
    List<LmsUser> findByIdIn(List<String> collect);
}
