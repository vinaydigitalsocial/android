package com.suvisavi.expensesphone.model;

import java.math.BigDecimal;

/**
 * Created by suvisavi on 16/07/15.
 */
public class ExpensesModel {
    private Integer expensesId=null;
    private String expName=null;
    private Integer groupId=null;
    private Integer paidBy=null;
    private BigDecimal amount=null;

    public Integer getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Integer expensesId) {
        this.expensesId = expensesId;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Integer paidBy) {
        this.paidBy = paidBy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
