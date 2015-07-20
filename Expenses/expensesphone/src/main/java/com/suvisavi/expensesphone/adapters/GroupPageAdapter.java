package com.suvisavi.expensesphone.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.suvisavi.expensesphone.R;
import com.suvisavi.expensesphone.model.GroupPageData;


import java.util.List;

/**
 * Created by suvisavi on 12/07/15.
 */
public class GroupPageAdapter extends ArrayAdapter {


    private List<GroupPageData> groupPageData;
    private Context mContext;


    public GroupPageAdapter(Context context,int resource, List<GroupPageData> list) {
        super(context, resource, list);
        groupPageData = list;
        mContext = context;
    }


    @Override
    public int getCount() {
        return groupPageData.size();
    }

    @Override
    public Object getItem(int position) {
        return groupPageData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view;
        if(convertView == null){
            LayoutInflater layoutInflater =
                    (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.group_page_fragment,parent,false);
        }else{
            view = convertView;
        }

        TextView txtViewName = (TextView)view.findViewById(R.id.group_name);
        txtViewName.setText(groupPageData.get(position).getGroupName());
        txtViewName.setTextColor(Color.BLACK);
        txtViewName.setAllCaps(true);


        TextView txtViewPay = (TextView)view.findViewById(R.id.group_pay);
        txtViewPay.setText(groupPageData.get(position).getPay());
        txtViewPay.setTextColor(Color.RED);


        TextView txtViewReceive = (TextView)view.findViewById(R.id.group_receive);
        txtViewReceive.setText(groupPageData.get(position).getReceive());
        txtViewReceive.setHighlightColor(Color.GREEN);

        return view;
    }

}
