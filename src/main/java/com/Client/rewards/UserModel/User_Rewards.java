package com.Client.rewards.UserModel;

public class User_Rewards {
    private long UserId;
	private long rewardsFromLastMonth;
    private long rewardsFromTwoMonthsAgo;
    private long rewardsFromThreeMonthsAgo;
    private long totalRewards;

    public long getUserId() {
        return UserId;
    }
    public long getRewardsFromLastMonth() {
		return rewardsFromLastMonth;
	}
	public void setUserId(long userId) {
		this.UserId = userId;
	}
	public long getTotalRewards() {
		return totalRewards;
	}
	public long getRewardsFromTwoMonthsAgo() {
		return rewardsFromTwoMonthsAgo;
	}
	public long getRewardsFromThreeMonthsAgo() {
		return rewardsFromThreeMonthsAgo;
	}
	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}

	public void setRewardsFromLastMonth(long rewardsFromLastMonth) {
		this.rewardsFromLastMonth = rewardsFromLastMonth;
	}

	public void setRewardsFromTwoMonthsAgo(long rewardsFromTwoMonthsAgo) {
		this.rewardsFromTwoMonthsAgo = rewardsFromTwoMonthsAgo;
	}
	public void setRewardsFromThreeMonthsAgo(long rewardsFromThreeMonthsAgo) {
		this.rewardsFromThreeMonthsAgo = rewardsFromThreeMonthsAgo;
	}

}
