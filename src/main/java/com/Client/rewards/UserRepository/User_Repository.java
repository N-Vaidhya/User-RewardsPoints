package com.Client.rewards.UserRepository;

import com.Client.rewards.UserEntity.User;
import org.springframework.data.repository.CrudRepository;

public interface User_Repository extends CrudRepository<User,Long> {
    User findByUserId(Long UserId);
}
