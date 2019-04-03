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
    public static final String KEY_EMAIL= "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAME = "name";
    private static final String TAG = "DBAdapter";
    private static final String SCORE_1 = "score_1";
    private static final String SCORE_2 = "score_2";
    private static final String SCORE_3 = "score_3";
    private static final String SCORE_4 = "score_4";
    private static final String SCORE_5 = "score_5";
    private static final String SCORE_6 = "score_6";
    private static final String SCORE_7 = "score_7";
    private static final String SCORE_8 = "score_8";
    private static final String SCORE_9 = "score_9";
    private static final String SCORE_10 = "score_10";
    private static final String SCORE_11 = "score_11";
    private static final String SCORE_12 = "score_12";
    private static final String SCORE_13 = "score_13";
    private static final String SCORE_14 = "score_14";
    private static final String SCORE_15 = "score_15";
    private static final String SCORE_16 = "score_16";
    private static final String SCORE_17 = "score_17";
    private static final String SCORE_18 = "score_18";
    private static final String SCORE_19 = "score_19";

    private static final String DATABASE_NAME = "usersdb";
    private static final String DATABASE_TABLE = "users";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table users (_id integer primary key autoincrement, "
                    + "email text not null, "
                    + "password text not null,"
                    + "name text ,"
                    + "score_1 int DEFAULT 0,"
                    + "score_2 int DEFAULT 0,"
                    + "score_3 int DEFAULT 0,"
                    + "score_4 int DEFAULT 0,"
                    + "score_5 int DEFAULT 0,"
                    + "score_6 int DEFAULT 0,"
                    + "score_7 int DEFAULT 0,"
                    + "score_8 int DEFAULT 0,"
                    + "score_9 int DEFAULT 0,"
                    + "score_10 int DEFAULT 0,"
                    + "score_11 int DEFAULT 0,"
                    + "score_12 int DEFAULT 0,"
                    + "score_13 int DEFAULT 0,"
                    + "score_14 int DEFAULT 0,"
                    + "score_15 int DEFAULT 0,"
                    + "score_16 int DEFAULT 0,"
                    + "score_17 int DEFAULT 0,"
                    + "score_18 int DEFAULT 0,"
                    + "score_19 int DEFAULT 0);";

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

    public void updateScore(Integer score_number, String name, Integer score){
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        switch (score_number) {
            case 1:
                values.put(SCORE_1, score);
                break;
            case 2:
                values.put(SCORE_2, score);
                break;
            case 3:
                values.put(SCORE_3, score);
                break;
            case 4:
                values.put(SCORE_4, score);
                break;
            case 5:
                values.put(SCORE_5, score);
                break;
            case 6:
                values.put(SCORE_6, score);
                break;
            case 7:
                values.put(SCORE_7, score);
                break;
            case 8:
                values.put(SCORE_8, score);
                break;
            case 9:
                values.put(SCORE_9, score);
                break;
            case 10:
                values.put(SCORE_10, score);
                break;
            case 11:
                values.put(SCORE_11, score);
                break;
            case 12:
                values.put(SCORE_12, score);
                break;
            case 13:
                values.put(SCORE_13, score);
                break;
            case 14:
                values.put(SCORE_14, score);
                break;
            case 15:
                values.put(SCORE_15, score);
                break;
            case 16:
                values.put(SCORE_16, score);
                break;
            case 17:
                values.put(SCORE_17, score);
                break;
            case 18:
                values.put(SCORE_18, score);
                break;
            case 19:
                values.put(SCORE_19, score);
                break;
        }
        String[] whereArgs= {name};
        int count = db.update(DATABASE_TABLE, values, KEY_EMAIL+" = ?",whereArgs );
    }

    public UserData addUser(UserData user) {

    //get writable database
    SQLiteDatabase db = DBHelper.getWritableDatabase();
        String whereClause = KEY_EMAIL + " =? OR " + KEY_NAME + " =?";
        String[] whereArgs = new String[] {
                user.email,
                user.name
        };
     Cursor cursor = db.query(DATABASE_TABLE, new String[]{KEY_ROWID}, whereClause, whereArgs,null,null,null);
     Log.d("QUERYNAME", cursor.toString());
    if (cursor.getCount()>0){
        return null;
        }else {
        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put(KEY_EMAIL, user.email);

        values.put(KEY_NAME, user.name);
        //Put password in  @values
        values.put(KEY_PASSWORD, user.password);

        // insert row
        long todo_id = db.insert(DATABASE_TABLE, null, values);
        return user;
        }
    }

    public UserData Authenticate(UserData user) {
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE,// Selecting Table
                new String[]{KEY_ROWID, KEY_EMAIL, KEY_PASSWORD, KEY_NAME, SCORE_1, SCORE_2, SCORE_3, SCORE_4, SCORE_5, SCORE_6, SCORE_7, SCORE_8, SCORE_9, SCORE_10, SCORE_11, SCORE_12, SCORE_13, SCORE_14, SCORE_15, SCORE_16, SCORE_17, SCORE_18, SCORE_19},//Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{user.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            UserData user1 = new UserData(  cursor.getString(0),
                                            cursor.getString(1),
                                            cursor.getString(2),
                                            cursor.getString(3),
                                            cursor.getInt(4),
                                            cursor.getInt(5),
                                            cursor.getInt(6),
                                            cursor.getInt(7),
                                            cursor.getInt(8),
                                            cursor.getInt(9),
                                            cursor.getInt(10),
                                            cursor.getInt(11),
                                            cursor.getInt(12),
                                            cursor.getInt(13),
                                            cursor.getInt(14),
                                            cursor.getInt(15),
                                            cursor.getInt(16),
                                            cursor.getInt(17),
                                            cursor.getInt(18),
                                            cursor.getInt(19),
                                            cursor.getInt(20),
                                            cursor.getInt(21),
                                            cursor.getInt(22));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public void updateName(String email,String name){
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
                values.put(KEY_NAME, name);
        String[] whereArgs= {email};
        int count = db.update(DATABASE_TABLE, values, KEY_EMAIL+" = ?",whereArgs );
    }

}
