package com.Client.rewards.UserController;

import com.Client.rewards.UserEntity.User;
import com.Client.rewards.UserModel.User_Rewards;
import com.Client.rewards.UserRepository.User_Repository;
import com.Client.rewards.UserServices.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RewardsController {

    @Autowired
    RewardsService rewardsService;

    @Autowired
    User_Repository userRepository;
// http://localhost:8080/users/{userId}/rewards
    @GetMapping(value = "/{userId}/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User_Rewards> getRewardsByUserId(@PathVariable("userId") Long userId){
        User customer = userRepository.findByUserId(userId);
        if(customer == null)
        {
        	throw new RuntimeException("Invalid  Request / Missing user Id ");
        }
        User_Rewards userRewards = rewardsService.getRewardsByUserId(userId);
        return new ResponseEntity<>(userRewards,HttpStatus.OK);
    }
}
