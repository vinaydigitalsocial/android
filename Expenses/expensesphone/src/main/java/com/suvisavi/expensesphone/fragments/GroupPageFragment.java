package com.suvisavi.expensesphone.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.suvisavi.expensesphone.R;
import com.suvisavi.expensesphone.activities.ExpensesPhoneActivity;
import com.suvisavi.expensesphone.adapters.GroupPageAdapter;
import com.suvisavi.expensesphone.database.ExpensesDataBaseHelper;
import com.suvisavi.expensesphone.model.GroupPageData;
import com.suvisavi.expensesphone.model.GroupsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GroupPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GroupPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "position";

    // TODO: Rename and change types of parameters
    private int mParam1=0;

    private OnFragmentInteractionListener mListener;
    private ListView mGroupPageListView;
    private List<GroupPageData> groupPageData;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position
     * @return A new instance of fragment GroupPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroupPageFragment newInstance(int position) {
        GroupPageFragment fragment = new GroupPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    public GroupPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }

        groupPageData = getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mGroupPageListView = (ListView) inflater.inflate(R.layout.group_page_listview,container,false);

        mGroupPageListView.setAdapter(
                new GroupPageAdapter(
                        getActivity().getApplicationContext(),
                        R.layout.group_page_fragment,
                        groupPageData));

        return mGroupPageListView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;

            ((ExpensesPhoneActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_PARAM1));

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }




    private List<GroupPageData> getData(){
        List<GroupPageData> groupPageData = new ArrayList<GroupPageData>();

        ExpensesDataBaseHelper expensesDataBaseHelper = new ExpensesDataBaseHelper(getActivity().getApplicationContext());
        List<GroupsModel> groupsModelList = expensesDataBaseHelper.getGroupsData();

        /**
         * hard coded for now
         * 1. read from local sqlite database and populate the objects
         * 2. Once online integration is complete read from the web service response.
         *
         */
        for(GroupsModel groupsModel : groupsModelList){

            GroupPageData grpData = new GroupPageData();
            grpData.setPay("10");
            grpData.setReceive("100");
            grpData.setGroupName(groupsModel.getGroupName());
            groupPageData.add(grpData);

        }

        return groupPageData;

    }

}
