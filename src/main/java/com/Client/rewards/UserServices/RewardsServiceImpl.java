package com.Client.rewards.UserServices;

import com.Client.rewards.UserEntity.Transaction;
import com.Client.rewards.UserModel.User_Rewards;
import com.Client.rewards.UserRepository.User_TransactionRepository;
import com.Client.rewards.UserRewardLimit.User_RewardLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardsServiceImpl implements RewardsService {

	
	@Autowired
	User_TransactionRepository transactionRepository;

	public User_Rewards getRewardsByUserId(Long userId) {

		Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(User_RewardLimit.TotalDaysInMonths);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2* User_RewardLimit.TotalDaysInMonths);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3* User_RewardLimit.TotalDaysInMonths);

		List<Transaction> lastMonthTransactions = transactionRepository.findAllByUserIdAndTransactionDateBetween(
				userId, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = transactionRepository
				.findAllByUserIdAndTransactionDateBetween(userId, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = transactionRepository
				.findAllByUserIdAndTransactionDateBetween(userId, lastThirdMonthTimestamp,
						lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

		User_Rewards customerRewards = new User_Rewards();
		customerRewards.setUserId(userId);
		customerRewards.setRewardsFromLastMonth(lastMonthRewardPoints);
		customerRewards.setRewardsFromTwoMonthsAgo(lastSecondMonthRewardPoints);
		customerRewards.setRewardsFromThreeMonthsAgo(lastThirdMonthRewardPoints);
		customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	private Long getRewardsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewards(Transaction t) {
		if (t.getTransactionAmount() > User_RewardLimit.TotalFirstRewardLimit && t.getTransactionAmount() <= User_RewardLimit.TotalSecondRewardLimit) {
			return Math.round(t.getTransactionAmount() - User_RewardLimit.TotalFirstRewardLimit);
		} else if (t.getTransactionAmount() > User_RewardLimit.TotalSecondRewardLimit) {
			return Math.round(t.getTransactionAmount() - User_RewardLimit.TotalSecondRewardLimit) * 2
					+ (User_RewardLimit.TotalSecondRewardLimit - User_RewardLimit.TotalFirstRewardLimit);
		} else
			return 0l;

	}

	public Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}

}
