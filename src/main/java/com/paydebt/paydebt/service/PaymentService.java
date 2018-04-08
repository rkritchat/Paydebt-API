package com.paydebt.paydebt.service;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.model.DebtDetail;
import com.paydebt.paydebt.model.Payment;
import com.paydebt.paydebt.model.Transaction;
import com.paydebt.paydebt.repository.DebtRepository;
import com.paydebt.paydebt.repository.PaymentRepository;
import com.paydebt.paydebt.repository.ReceiptRepository;
import com.paydebt.paydebt.repository.TransactionRepository;
import com.paydebt.paydebt.utils.ResultsUtils;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService extends ResultsUtils{
    @Resource
    private PaymentRepository paymentRepository;
    @Resource
    private TransactionRepository transactionRepository;
    @Resource
    private DebtRepository debtRepository;
    @Resource
    private ReceiptRepository receiptRepository;

    public ResultJson pay(PaymentForm form){
        int transactionNo = generateTransaction();
        paymentRepository.save(new Payment(
            form.getUser(),form.getDebtReference(),form.getDescription(),
               form.getAmount(),form.getAmountPaid(),transactionNo,
               form.getStatus(),new Date()
        ));
        return null;
    }

    public ResultJson closePayment(PaymentForm form){
        paymentRepository.updatePaymentStatus(form.getStatus(),form.getDebtReference());
        transactionRepository.updateTransaction(form.getStatus(),form.getDescription(),form.getTransactionRef());
        return null;
    }

    public ResultJson getDebtDetail(PaymentForm form){
        System.out.println(form.toString());
        List<DebtDetail> debt = debtRepository.findByDebtorReferenceAndStatus(form.getUser(),form.getStatus());
        List<DebtDetail> results = new ArrayList<>();
        if(debt.size()>0){
            debt.forEach(obj->{
                double remainingAmt = receiptRepository.getRemainingAmount(obj.getId());
                if(remainingAmt>0){
                    obj.setAmount(obj.getAmount()-remainingAmt);
                }
                results.add(obj);
            });
        }
        return new ResultJson("OK",results,null);
    }

    private int generateTransaction(){
        //Create transaction
        transactionRepository.save(new Transaction(null,0,new Date()));
        return transactionRepository.getMaxId();
    }
}
