package com.RecruitPlus.quizPlatform.Controller;

import com.RecruitPlus.quizPlatform.Model.User;
import com.RecruitPlus.quizPlatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/v1")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers( ){

        return userService.allUsers();
    }
    @GetMapping("/user/{role}")
    public List<User> getUserByRole(@PathVariable(value = "role") String role){
        return userService.getUserByRole(role);
    }

    @GetMapping("/email")
    public List<User> getUserByEmail(@RequestParam(required =true) String email){

        return userService.getUserByEmail(email);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/user/{user_id}")
    public void updateById(@RequestBody User user,@PathVariable(value="user_id") String userId )
    {
        userService.updateRole(userId,user);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User saveUser(@RequestBody User user)
    {
        User saveUser = userService.saveUser(user);
        return saveUser;
    }

}
