package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt,Long>{
    @Query("SELECT COALESCE(SUM(r.amount),0) FROM Receipt r WHERE r.debtReference=:debtReference")
    double getRemainingAmount(@Param("debtReference") int debtReference);
}
