package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findById(String id);
}
