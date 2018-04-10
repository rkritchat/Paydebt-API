package com.paydebt.paydebt.service;

import com.paydebt.paydebt.form.PaymentForm;
import com.paydebt.paydebt.model.DebtDetail;
import com.paydebt.paydebt.repository.DebtRepository;
import com.paydebt.paydebt.repository.ReceiptRepository;
import com.paydebt.paydebt.utils.ResultsUtils;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DebtService extends ResultsUtils {

    @Resource
    private DebtRepository debtRepository;
    @Resource
    private ReceiptRepository receiptRepository;

    public ResultJson createDebt(PaymentForm form){
        debtRepository.save(new DebtDetail(form.getDescription(),form.getAmount(),
                form.getCreditorReference(),form.getUser(),form.getStatus(),new Date()));
        return new ResultJson("OK",null,"Create Debt Successfully");
    }

    public ResultJson getDebtDetail(PaymentForm form){
        List<DebtDetail> debt = debtRepository.findByDebtorReferenceAndStatus(form.getUser(),form.getStatus());
        List<DebtDetail> results = getTotalDebt(debt);
        return new ResultJson("OK",null,results);
    }

    public ResultJson getAllDebt(PaymentForm form){
        List<DebtDetail> debt = debtRepository.findByCreditorReferenceAndStatus(form.getCreditorReference(),form.getStatus());
        List<DebtDetail> results = getTotalDebt(debt);
        return new ResultJson("OK",null,results);
    }

    public List<DebtDetail> getTotalDebt(List<DebtDetail> debt){
        List<DebtDetail> results = new ArrayList<>();
        debt.forEach(obj->{
            double amountPaid = receiptRepository.getRemainingAmount(obj.getId());
            if(amountPaid>0){
                obj.setAmount(obj.getAmount()-amountPaid);
            }
            results.add(obj);
        });
        return results;
    }
}
