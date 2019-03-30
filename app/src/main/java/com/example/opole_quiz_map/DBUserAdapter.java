package com.example.opole_quiz_map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBUserAdapter
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_USERNAME= "username";
    public static final String KEY_PASSWORD = "password";
    private static final String TAG = "DBAdapter";
    private static final String SCORE = "score";
    private static final String DATABASE_NAME = "usersdb";
    private static final String DATABASE_TABLE = "users";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table users (_id integer primary key autoincrement, "
                    + "username text not null, "
                    + "password text not null," +
                    "score int DEFAULT 0);";

    private Context context = null;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBUserAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }


    public void open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
    }


    public void close()
    {
        DBHelper.close();
    }

    public UserData addUser(UserData user) {

    //get writable database
    SQLiteDatabase db = DBHelper.getWritableDatabase();

    //create content values to insert
    ContentValues values = new ContentValues();

    //Put username in  @values
    values.put(KEY_USERNAME, user.email);

    //Put email in  @values
    values.put(SCORE, user.score);

    //Put password in  @values
    values.put(KEY_PASSWORD, user.password);

    // insert row
    long todo_id = db.insert(DATABASE_TABLE, null, values);
        return user;
    }

    public UserData Authenticate(UserData user) {
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE,// Selecting Table
                new String[]{KEY_ROWID, KEY_USERNAME, KEY_PASSWORD, SCORE},//Selecting columns want to query
                KEY_USERNAME + "=?",
                new String[]{user.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            UserData user1 = new UserData(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

}
