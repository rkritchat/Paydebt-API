package com.paydebt.paydebt.web.controller;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.service.DebtService;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debt")
public class DebtController {

    @Autowired
    private DebtService debtService;

    @PostMapping("/detail")
    public ResultJson getDebtDetail(@RequestBody PaymentForm form){
        return debtService.getDebtDetail(form);
    }

}
