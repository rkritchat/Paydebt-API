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
    public ResultJson confirmPayment(@RequestBody PaymentForm form){
        return paymentService.confirmPayment(form);
    }

    @PostMapping("/detail")
    public ResultJson getPaymentDetail(@RequestBody PaymentForm form){
        return paymentService.getPaymentDetail(form);
    }
}
