package com.Client.rewards.UserServices;

import com.Client.rewards.UserModel.User_Rewards;


public interface RewardsService {
    User_Rewards getRewardsByUserId(Long userId);
}
