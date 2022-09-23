package com.RecruitPlus.quizPlatform.Repository;

import com.RecruitPlus.quizPlatform.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByRole(String role);
}
