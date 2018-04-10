package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Payment p SET p.status=:status WHERE p.debtReference = :debtReference AND p.transactionReference=:transaction")
    int updatePaymentStatus(@Param("status") int status, @Param("debtReference") int debtReference, @Param("transaction") int transaction);

    Payment findByDebtReferenceAndStatus(int id, int status);
}
