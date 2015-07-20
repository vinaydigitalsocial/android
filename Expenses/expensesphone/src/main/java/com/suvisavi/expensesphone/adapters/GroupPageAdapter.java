package com.suvisavi.expensesphone.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.suvisavi.expensesphone.R;
import com.suvisavi.expensesphone.com.suvisavi.expensesphone.datasource.GroupPageData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suvisavi on 12/07/15.
 */
public class GroupPageAdapter extends ArrayAdapter {


    private List<GroupPageData> groupPageData = getData();
    private Context mContext;


    public GroupPageAdapter(Context context,int resource, ArrayList<GroupPageData> list) {
        super(context, resource, list);
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
        txtViewName.setAllCaps(true);


        TextView txtViewAmount = (TextView)view.findViewById(R.id.group_amount);
        txtViewAmount.setText(groupPageData.get(position).getAmount());
        txtViewAmount.setHighlightColor(Color.MAGENTA);

        return view;
    }

    private List<GroupPageData> getData(){
        List<GroupPageData> groupPageData = new ArrayList<GroupPageData>();

        /**
         * hard coded for now
         * 1. read from local sqlite database and populate the objects
         * 2. Once online integration is complete read from the web service response.
         *
         */
        for(int i=0;i<5;i++){

            GroupPageData grpData = new GroupPageData();
            grpData.setAmount("10");
            grpData.setGroupName("Group "+ i+1);
            groupPageData.add(grpData);

        }

        return groupPageData;

    }




}
