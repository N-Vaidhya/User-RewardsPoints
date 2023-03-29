# User-RewardsPoints
User Rewards-Calculator

java 1.8 -> Gradel -> H2 

URLs
 GET : http://localhost:8080/users/1/rewards
 GET : http://localhost:8080/users/2/rewards
 GET : http://localhost:8080/users/3/rewards
 
 Sample Output -> {
	"rewardsFromLastMonth": 2402,
	"rewardsFromTwoMonthsAgo": 0,
	"rewardsFromThreeMonthsAgo": 2456,
	"totalRewards": 4858,
	"userId": 3
}

=> enable Auto - import for Gradel and 1.8 as SDK.
=> Use any h2 plugin from intellij (or localhost:8080/h2-console) and run data.sql,
once the data is visilbe in H2 console run the application and use the given get request to wquesrry database.
