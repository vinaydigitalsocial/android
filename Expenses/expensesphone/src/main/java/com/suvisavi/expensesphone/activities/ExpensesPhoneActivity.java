package com.suvisavi.expensesphone.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.suvisavi.expensesphone.ExpensesPhoneHelper;
import com.suvisavi.expensesphone.R;
import com.suvisavi.expensesphone.fragments.NavigationDrawerFragment;


public class ExpensesPhoneActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    private final String CLASSNAME = getClass().getSimpleName();




    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("enter : " + CLASSNAME + " method : onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_phone);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        System.out.println("exit : " + CLASSNAME + " method : onCreate");
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        System.out.println("enter : " + CLASSNAME + " method : onNavigationDrawerItemSelected");
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
        System.out.println("exit : " + CLASSNAME + " method : onNavigationDrawerItemSelected");
    }

    public void onSectionAttached(int number) {
        System.out.println("enter : " + CLASSNAME + " method : onSectionAttached");
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_Home);
                break;
            case 2:
                mTitle = getString(R.string.title_section1);
                break;
            case 3:
                mTitle = getString(R.string.title_section2);
                break;
            case 4:
                mTitle = getString(R.string.title_section3);
                break;
        }
        System.out.println("exit : " + CLASSNAME + " method : onSectionAttached");
    }

    public void restoreActionBar() {
        System.out.println("enter : " + CLASSNAME + " method : restoreActionBar");
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        System.out.println("exit : " + CLASSNAME + " method : restoreActionBar");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("enter : " + CLASSNAME + " method : onCreateOptionsMenu");
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.expenses_phone, menu);
            restoreActionBar();
            return true;
        }
        System.out.println("exit : " + CLASSNAME + " method : onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("enter : " + CLASSNAME + " method : onOptionsItemSelected");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        System.out.println("exit : " + CLASSNAME + " method : onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String CLASSNAME = "PlaceholderFragment";
        private static final String ARG_LAYOUT_NAME = "layout_name";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            System.out.println("enter : " + CLASSNAME + " method : newInstance");
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);

            args.putString(ARG_LAYOUT_NAME, ExpensesPhoneHelper.getInstance().getLayout(String.valueOf(sectionNumber)));
            fragment.setArguments(args);
            System.out.println("exit : " + CLASSNAME + " method : newInstance");
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            System.out.println("enter : " + CLASSNAME + " method : onCreateView");
            int layout = Integer.valueOf(getArguments().getString(ARG_LAYOUT_NAME)).intValue();
            //View rootView = inflater.inflate(R.layout.group_page_fragment, container, false);
            View rootView = inflater.inflate(layout, container, false);
            System.out.println("exit : " + CLASSNAME + " method : onCreateView");
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            System.out.println("enter : " + CLASSNAME + " method : onAttach");
            super.onAttach(activity);
            ((ExpensesPhoneActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
            System.out.println("exit : " + CLASSNAME + " method : onAttach");
        }
    }

}
