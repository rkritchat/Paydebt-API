package com.paydebt.paydebt.service;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.model.DebtDetail;
import com.paydebt.paydebt.model.Payment;
import com.paydebt.paydebt.model.Receipt;
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

    /**
     * ConfirmPayment
     * if status is 1 it means accept payment
     * if status is -1 it means cancel payment
     * @param form
     * @return
     */
    public ResultJson confirmPayment(PaymentForm form){
        paymentRepository.updatePaymentStatus(form.getStatus(),form.getDebtReference(),
                form.getTransactionRef());
        transactionRepository.updateTransaction(form.getStatus(),form.getDescription(),
                form.getTransactionRef());
        if(form.getStatus()==1) {
            receiptRepository.save(new Receipt(form.getDebtReference(),form.getUser(),
                    form.getCreditorReference(),form.getAmount(), new Date()));
            DebtDetail detail = debtRepository.findById(form.getDebtReference());
            double amtPaid = getAmountPaid(form.getDebtReference());
            if (amtPaid == detail.getAmount()) {
                detail.setStatus(1);
                debtRepository.save(detail);
            }
        }
        return null;
    }

    public ResultJson getPaymentDetail(PaymentForm form){
        System.out.println(form);
        List<DebtDetail> debt = debtRepository.findByCreditorReferenceAndStatus(form.getCreditorReference(),form.getStatus());
        List<Payment> results = new ArrayList<>();
        debt.forEach(obj->{
            System.out.println("------------>ID" + obj.getId());
            Payment payment = paymentRepository.findByDebtReferenceAndStatus(obj.getId(),form.getStatus());
            if(payment!=null){
                results.add(payment);
            }
        });

        return new ResultJson("OK",results,null);
    }

    private int generateTransaction(){
        transactionRepository.save(new Transaction(null,0,new Date()));
        return transactionRepository.getMaxId();
    }

    private double getAmountPaid(int id){
        return receiptRepository.getRemainingAmount(id);
    }
}
