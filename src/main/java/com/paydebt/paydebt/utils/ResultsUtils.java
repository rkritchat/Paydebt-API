package com.paydebt.paydebt.utils;

import com.paydebt.paydebt.model.ModelMarker;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.stereotype.Component;

import java.util.List;

public class ResultsUtils {
    /**
     * This method for prepare ResultJson
     * @param model
     * @param errorMessage
     * @return
     */
    protected ResultJson json(ModelMarker model, String errorMessage){
        return (model!=null) ?
                new ResultJson("OK",model,null)
                : new ResultJson("OK",model, errorMessage);
    }

    protected ResultJson json(List<ModelMarker> model, String errorMessage){
        return (model!=null) ?
                new ResultJson("OK",model,null)
                : new ResultJson("OK",model, errorMessage);
    }
}
