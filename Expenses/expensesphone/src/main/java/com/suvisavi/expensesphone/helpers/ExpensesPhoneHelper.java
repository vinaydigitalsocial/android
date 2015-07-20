package com.suvisavi.expensesphone.helpers;

import com.suvisavi.expensesphone.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suvisavi on 12/07/15.
 */
public class ExpensesPhoneHelper {
    private static ExpensesPhoneHelper expensesPhoneHelper = new ExpensesPhoneHelper();

    public static ExpensesPhoneHelper getInstance() {
        return expensesPhoneHelper;
    }

    private static Map<String,String> layoutMapping = null;

    private ExpensesPhoneHelper() {
        setLayoutMapping();
    }

    private static void setLayoutMapping(){
        expensesPhoneHelper.layoutMapping = new HashMap<>();
        expensesPhoneHelper.layoutMapping.put("1",String.valueOf(R.layout.group_page_fragment));
        expensesPhoneHelper.layoutMapping.put("2",String.valueOf(R.layout.group_new_fragment));
        expensesPhoneHelper.layoutMapping.put("3",String.valueOf(R.layout.group_new_fragment));
        expensesPhoneHelper.layoutMapping.put("4",String.valueOf(R.layout.group_new_fragment));
    }

    public static String getLayout(String key){
        if(expensesPhoneHelper.layoutMapping == null){
            setLayoutMapping();
        }
        return expensesPhoneHelper.layoutMapping.get(key);
    }


}
