package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.Payment;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Payment p SET p.status=:status WHERE p.debtorReference = :debtReference")
    int updatePaymentStatus(@Param("status") int status, @Param("debtReference") int debtReference);
}
