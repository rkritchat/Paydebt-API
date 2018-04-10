package com.paydebt.paydebt.service;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.model.DebtDetail;
import com.paydebt.paydebt.repository.DebtRepository;
import com.paydebt.paydebt.repository.ReceiptRepository;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DebtService {

    @Resource
    private DebtRepository debtRepository;
    @Resource
    private ReceiptRepository receiptRepository;

    public ResultJson getDebtDetail(PaymentForm form){
        List<DebtDetail> debt = debtRepository.findByDebtorReferenceAndStatus(form.getUser(),form.getStatus());
        List<DebtDetail> results = new ArrayList<>();
        if(debt.size()>0){
            debt.forEach(obj->{
                double amountPaid = receiptRepository.getRemainingAmount(obj.getId());
                if(amountPaid>0){
                    obj.setAmount(obj.getAmount()-amountPaid);
                }
                results.add(obj);
            });
        }
        return new ResultJson("OK",results,null);
    }
}
