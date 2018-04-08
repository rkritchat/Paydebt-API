package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.DebtDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<DebtDetail,Long> {
    List<DebtDetail> findByDebtorReferenceAndStatus(String debtorReference, int status);
}
