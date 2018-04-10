package com.paydebt.paydebt.repository;

import com.paydebt.paydebt.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdRepository extends JpaRepository<UserId,Long>{
    UserId findByIdAndPwd(String id,String pwd);
}
