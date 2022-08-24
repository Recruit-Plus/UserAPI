package com.RecruitPlus.quizPlatform.Repository;

import com.RecruitPlus.quizPlatform.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
