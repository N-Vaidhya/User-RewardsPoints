package com.Client.rewards.UserRepository;

import com.Client.rewards.UserEntity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface User_TransactionRepository extends CrudRepository<Transaction,Long> {
    List<Transaction> findAllByUserId(Long userId);

    List<Transaction> findAllByUserIdAndTransactionDateBetween(Long userID, Timestamp from, Timestamp to);
}
