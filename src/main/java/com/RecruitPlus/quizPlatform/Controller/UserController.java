package com.RecruitPlus.quizPlatform.Controller;

import com.RecruitPlus.quizPlatform.Model.User;
import com.RecruitPlus.quizPlatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/v1")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    public UserService userService;

    //Get all users
    @GetMapping("/")
    public List<User> getAllUsers( ){

        return userService.allUsers();
    }

    @GetMapping("/users/{user_id}")
    public Optional<User> getUserById(@PathVariable String user_id){
        return userService.getUserById(user_id);

    }

    @GetMapping("/user/{role}")
    public List<User> getUserByRole(@PathVariable(value = "role") String role){
        return userService.getUserByRole(role);
    }

    // Get User of specific Email
    @GetMapping("/email")
    public List<User> getUserByEmail(@RequestParam(required =true) String email){

        return userService.getUserByEmail(email);
    }

    //update user
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/user/{user_id}")
    public void updateById(@RequestBody User user,@PathVariable(value="user_id") String userId )
    {
        userService.updateRole(userId,user);
    }

    //save user
    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User saveUser(@RequestBody User user)
    {
        User saveUser = userService.saveUser(user);
        return saveUser;
    }

}
