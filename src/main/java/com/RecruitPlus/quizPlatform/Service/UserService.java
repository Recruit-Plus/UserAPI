package com.RecruitPlus.quizPlatform.Service;

import com.RecruitPlus.quizPlatform.Exceptions.UserNotFoundException;
import com.RecruitPlus.quizPlatform.Model.User;
import com.RecruitPlus.quizPlatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByEmail(String email){
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();
        if (email != null && !email.isEmpty())
            criteria.add(Criteria.where("email").is(email));
        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        List<User> user=mongoTemplate.find(query,User.class);
        if(user.isEmpty()){
            return Collections.emptyList();
        }
        else{
            return user;
        }

    }

    public void updateRole(String userId,User user)
    {
        User findById= userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        findById.setRole(user.getRole());
        userRepository.save(findById);
    }
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getUserByRole(String role) {
        return userRepository.findByRole(role);
    }
}
