package com.paydebt.paydebt.service;

import com.paydebt.paydebt.form.UserForm;
import com.paydebt.paydebt.model.UserDetail;
import com.paydebt.paydebt.model.UserId;
import com.paydebt.paydebt.repository.UserIdRepository;
import com.paydebt.paydebt.repository.UserRepository;
import com.paydebt.paydebt.utils.ResultsUtils;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ResultsUtils{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserIdRepository userIdRepository;

    public ResultJson login(UserForm userForm){
        UserDetail result = null;
        if (validateUser(userForm.getId(),userForm.getPwd())) {
            result = userRepository.findById(userForm.getId());
        }
        return json(result, "Invalid Username or Password");
    }

    public ResultJson register(UserForm userForm) {
        UserDetail result = null;
        if (!validateUser(userForm.getId(),userForm.getPwd())) {
            userIdRepository.save(new UserId(userForm.getId(),userForm.getPwd()));
            userRepository.save(new UserDetail(
                    userForm.getId(),userForm.getFirstName(),userForm.getLastName(),
                    userForm.getEmail(),userForm.getTell()
            ));
            result = userRepository.findById(userForm.getId());
        }
        return json(result, "ID already exist.");
    }

    public ResultJson updatePassword(UserForm userForm) {
        UserDetail result = null;
        if (validateUser(userForm.getId(),userForm.getPwd())) {
            userIdRepository.save(new UserId(userForm.getId(),userForm.getPwd()));
            result = userRepository.findById(userForm.getId());
        }
        return json(result, "Invalid Username or Password");
    }

    public ResultJson updateUserDetail(UserForm userForm){
        UserDetail result = null;
        if (validateUser(userForm.getId(),userForm.getPwd())) {
            userRepository.save(new UserDetail(
                    userForm.getId(),userForm.getFirstName(),userForm.getLastName(),
                    userForm.getEmail(),userForm.getTell()));
            result = userRepository.findById(userForm.getId());
        }
        return json(result, "Invalid Username or Password");
    }


    public boolean validateUser(String id, String pwd) {
        return (userIdRepository.findByIdAndPwd(id, pwd) != null)? true:false;
    }

}
