package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    @Query("SELECT MAX(t.id) FROM Transaction t ")
    int getMaxId();

    @Modifying
    @Transactional
    @Query("UPDATE Transaction t SET t.status =:status, t.description =:description WHERE t.id =:id")
    int updateTransaction(@Param("status") int status,@Param("description") String description, @Param("id") int id);
}
