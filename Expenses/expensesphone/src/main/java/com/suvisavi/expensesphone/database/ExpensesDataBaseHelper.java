package com.suvisavi.expensesphone.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.suvisavi.expensesphone.model.GroupsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suvisavi on 15/07/15.
 */
public class ExpensesDataBaseHelper extends SQLiteOpenHelper {

    //app specific
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cc_expenses";

    //Table Names
    private static final String TABLE_GROUPS = "groups";
    private static final String TABLE_USERS= "users";
    private static final String TABLE_EXPENSES = "expenses";
    private static final String TABLE_USERGROUPS = "usergroups";
    private static final String TABLE_EXPENSESSHARE = "expensesshare";

    //TABLE_GROUPS columns
    private static final String GROUP_ID=" group_id";
    private static final String GROUP_NAME=" group_name";


    //TABLE_USERS columns
    private static final String USER_ID = " user_id";
    private static final String LOGON_ID = " logon_id";
    private static final String PASSWORD = " password";
    private static final String NICKNAME = " nickname";

    //TABLE_USERGROUPS column names are already defined above

    //TABLE_EXPENSES columns
    private static final String EXP_ID = " exp_id";
    private static final String EXP_NAME = " exp_name";
    private static final String PAID_BY = " paid_by";
    private static final String AMOUNT = " amount";

    //TABLE_EXPENSESSHARE columns
    private static final String SHARED_AMOUNT = " amount";


    //general string constants for SQLs




    public ExpensesDataBaseHelper(Context context){
        super(context, "expenses", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createAppTables(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + TABLE_GROUPS);
        db.execSQL(DROP_TABLE + TABLE_USERS);
        db.execSQL(DROP_TABLE + TABLE_EXPENSES);
        db.execSQL(DROP_TABLE + TABLE_USERGROUPS);
        db.execSQL(DROP_TABLE + TABLE_EXPENSESSHARE);
        onCreate(db);
    }

    /**
     * Creates the tables required for the application.
     * Any new table creation method should be added here.
     * @param db
     */
    private void createAppTables(SQLiteDatabase db){
        createTable(db, getCreateTableSQLForGroups());
        createTable(db, getCreateTableSQLForUsers());
        createTable(db, getCreateTableSQLForExpenses());
        createTable(db, getCreateTableSQLForUserGroups());
        createTable(db, getCreateTableSQLForExpensesShare());    }

    /**
     * Creates the tables required for the application.
     * Any new table creation method should be added here.
     */
    public void insertDummyData(){

        SQLiteDatabase db = this.getWritableDatabase();

        //first row
        ContentValues values = new ContentValues();
        values.put(GROUP_ID,new Integer(1));
        values.put(GROUP_NAME, "Chindi");
        db.insert(TABLE_GROUPS, null, values);

        //next
        values = new ContentValues();
        values.put(GROUP_ID,new Integer(2));
        values.put(GROUP_NAME, "chors");
        db.insert(TABLE_GROUPS, null, values);

        //next
        values = new ContentValues();
        values.put(GROUP_ID,new Integer(3));
        values.put(GROUP_NAME, "amshravan");
        db.insert(TABLE_GROUPS, null, values);

        //next
        values = new ContentValues();
        values.put(GROUP_ID,new Integer(4));
        values.put(GROUP_NAME, "jd");
        db.insert(TABLE_GROUPS, null, values);

        //next
        values = new ContentValues();
        values.put(GROUP_ID,new Integer(5));
        values.put(GROUP_NAME, "Q");
        db.insert(TABLE_GROUPS, null, values);

        //next
        values = new ContentValues();
        values.put(GROUP_ID,new Integer(6));
        values.put(GROUP_NAME, "mote");
        db.insert(TABLE_GROUPS, null, values);
        System.out.println("Successfully inserted rows");

        db.close();


    }

    public List<GroupsModel> getGroupsData(){
        List<GroupsModel> groupsModelList = new ArrayList<GroupsModel>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query= "SELECT * FROM "+TABLE_GROUPS;

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                GroupsModel groupsModel = new GroupsModel();
                groupsModel.setGroupId(new Integer(c.getInt(c.getColumnIndex(GROUP_ID.trim()))));
                groupsModel.setGroupName(c.getString(c.getColumnIndex(GROUP_NAME.trim())));

                groupsModelList.add(groupsModel);
            }while(c.moveToNext());
        }

        db.close();
        return groupsModelList;

    }

    private void createTable(SQLiteDatabase db, String sql){
        db.execSQL(sql);
    }



    //some common constants required for table creation
    private static final String CREATE_TABLE = "create table if not exists ";
    private static final String DROP_TABLE = "drop table if exists ";

    private static final String OPEN_BRACKET = " (";
    private static final String CLOSE_BRACKET = " )";
    private static final String COMMA = " ,";
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String FOREIGN_KEY = " FOREIGN KEY";

    private static final String DATA_TYPE_INTEGER = " INTEGER";
    private static final String DATA_TYPE_VARCHAR = " VARCHAR";
    private static final String DATA_TYPE_DECIMAL = " DECIMAL";


    /**
     * create the sql for creating the table "groups"
     * @return String - the sql for "groups" table
     */
    private String getCreateTableSQLForGroups() {
        // TODO optimize using StringBuffer
        String createTableGroups =
                CREATE_TABLE+TABLE_GROUPS+
                        OPEN_BRACKET+
                        GROUP_ID+DATA_TYPE_INTEGER+PRIMARY_KEY+COMMA+
                        GROUP_NAME+DATA_TYPE_VARCHAR+"(255)"
                        +CLOSE_BRACKET;

        return createTableGroups;
    }

    /**
     * create the sql for creating the table "users"
     * @return String - the sql for "users" table
     */
    private String getCreateTableSQLForUsers() {
        // TODO optimize using StringBuffer
        String createTableUsers =
                CREATE_TABLE+TABLE_USERS+
                        OPEN_BRACKET+
                        USER_ID+DATA_TYPE_INTEGER+PRIMARY_KEY+COMMA+
                        LOGON_ID+DATA_TYPE_VARCHAR+"(32)"+COMMA+
                        PASSWORD+DATA_TYPE_VARCHAR+"(255)"+COMMA+
                        NICKNAME+DATA_TYPE_VARCHAR+"(255)"
                        +CLOSE_BRACKET;

        return createTableUsers;
    }

    /**
     * create the sql for creating the table "usergroups"
     * @return String - the sql for "usergroups" table
     */
    private String getCreateTableSQLForUserGroups() {
        // TODO optimize using StringBuffer
        String createTableUserGroups =
                CREATE_TABLE+TABLE_USERGROUPS+
                        OPEN_BRACKET+
                        USER_ID+DATA_TYPE_INTEGER+COMMA+
                        GROUP_ID+DATA_TYPE_INTEGER
                        +CLOSE_BRACKET;

        return createTableUserGroups;
    }

    /**
     * create the sql for creating the table "expenses"
     * @return String - the sql for "expenses" table
     */
    private String getCreateTableSQLForExpenses() {
        // TODO optimize using StringBuffer
        String createTableExpenses =
                CREATE_TABLE+TABLE_EXPENSES+
                        OPEN_BRACKET+
                        EXP_ID+DATA_TYPE_INTEGER+PRIMARY_KEY+COMMA+
                        EXP_NAME+DATA_TYPE_VARCHAR+"(255)"+COMMA+
                        GROUP_ID+DATA_TYPE_INTEGER+COMMA+
                        PAID_BY+DATA_TYPE_INTEGER+COMMA+
                        AMOUNT+DATA_TYPE_DECIMAL
                        +CLOSE_BRACKET;

        return createTableExpenses;
    }

    /**
     * create the sql for creating the table "usergroups"
     * @return String - the sql for "usergroups" table
     */
    private String getCreateTableSQLForExpensesShare(){
        // TODO optimize using StringBuffer
        String createTableExpensesShare =
                CREATE_TABLE+TABLE_EXPENSESSHARE+
                        OPEN_BRACKET+
                        EXP_ID+DATA_TYPE_INTEGER+PRIMARY_KEY+COMMA+
                        USER_ID+DATA_TYPE_INTEGER+COMMA+
                        SHARED_AMOUNT+DATA_TYPE_DECIMAL
                        +CLOSE_BRACKET;

        return createTableExpensesShare;
    }
}
