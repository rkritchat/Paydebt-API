package com.paydebt.paydebt.web.controller;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.service.DebtService;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debt")
public class DebtController {

    @Autowired
    private DebtService debtService;

    @PutMapping("/create")
    public ResultJson createDebt(@RequestBody PaymentForm form){
        return debtService.createDebt(form);
    }

    @PostMapping
    public ResultJson getDebtDetail(@RequestBody PaymentForm form){
        return debtService.getDebtDetail(form);
    }

    @PostMapping("/all")
    public ResultJson getAllDebt(@RequestBody PaymentForm form){
        return debtService.getAllDebt(form);
    }

}
