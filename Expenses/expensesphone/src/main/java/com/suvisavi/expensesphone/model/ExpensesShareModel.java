package com.suvisavi.expensesphone.model;

import java.math.BigDecimal;

/**
 * Created by suvisavi on 16/07/15.
 */
public class ExpensesShareModel {
    private Integer expensesId=null;
    private Integer userId=null;
    private BigDecimal shareAmount=null;

    public Integer getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Integer expensesId) {
        this.expensesId = expensesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }
}
