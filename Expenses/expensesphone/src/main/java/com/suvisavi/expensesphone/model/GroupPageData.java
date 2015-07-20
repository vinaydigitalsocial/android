package com.suvisavi.expensesphone.model;

/**
 * Created by suvisavi on 12/07/15.
 */
public class GroupPageData {
    private String groupName = null;
    private String pay = null;
    private String receive = null;

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


}
