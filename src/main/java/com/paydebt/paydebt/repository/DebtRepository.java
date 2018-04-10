package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.DebtDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<DebtDetail,Long> {
    List<DebtDetail> findByDebtorReferenceAndStatus(String debtorReference, int status);

    List<DebtDetail> findByCreditorReferenceAndStatus(String creditor, int status);

    DebtDetail findById(int id);
}
