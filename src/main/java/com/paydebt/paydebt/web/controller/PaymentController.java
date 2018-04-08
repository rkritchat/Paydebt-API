package com.paydebt.paydebt.web.controller;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.service.PaymentService;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PutMapping("/pay")
    public ResultJson pay(@RequestBody PaymentForm form){
        return paymentService.pay(form);
    }

    @PostMapping("/status")
    public ResultJson paymentStatus(){
        return null;
    }

    @PatchMapping("/close")
    public ResultJson closePayment(@RequestBody PaymentForm form){
        return paymentService.closePayment(form);
    }

    @PostMapping("/debt")
    public ResultJson getDebtDetail(@RequestBody PaymentForm form){
        return paymentService.getDebtDetail(form);
    }
}
