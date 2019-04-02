package com.example.opole_quiz_map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuestionQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 3;
    //Table name
    private static final String TABLE_NAME = "TQ";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Answer
    private static final String ANSWER = "ANSWER";

    private static final String MARKERNAME = "MARKER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + MARKERNAME + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    QuestionQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<QuestionQuiz> arraylist = new ArrayList<>();
        String markerName = "Plac daszyńskiego";
        arraylist.add(new QuestionQuiz("Jak nazywana jest fontanna na Placu Ignacego Daszyńskiego?", "Opolska Caryca", "Opolska Ceres", "Wielka fontanna", "Opolska Ceres", markerName));
        arraylist.add(new QuestionQuiz("Co miało sie kiedyś znajdować na miejscu fontanny?", "Pompa Wodna", "Obora", "Studnia", "Studnia", markerName));
        arraylist.add(new QuestionQuiz("Kiedy ukończono budowę fontanny?", "1907", "1909", "1986", "1907", markerName));
        arraylist.add(new QuestionQuiz("Co symbolizują rzeźby fontanny?", "Opolski przemysł wapienniczy i porcelanowy", "Opolskie rybactwo, przemysł porcelanowy oraz wapienniczy", "Opolskie rybactwo, przemysł wapienniczy oraz rolnictwo", "Opolskie rybactwo, przemysł wapienniczy oraz rolnictwo", markerName));
        arraylist.add(new QuestionQuiz("Jaka bogini znajduje się na fontannie?", "Bogini Hesti", "Bogini Ceres", "Bogini Ateny", "Bogini Ceres", markerName));
        markerName = "Most Groszowy";
        arraylist.add(new QuestionQuiz("Jak inaczej nazywany jest Most Groszowy w Opolu?", "Most Zakochanych", "Most Przyjaźni", "Most Pamiętnych Chwil", "Most Zakochanych", markerName));
        arraylist.add(new QuestionQuiz("W którym roku wybudowano most?", "1902", "1897", "1894", "1894", markerName));
        arraylist.add(new QuestionQuiz("Jak żartobliwie nazywano zachodnią stronę ulicy Krakowskiej?", "Droga do przodu", "Droga do małżeństwa", "Droga do rozwodu ", "Droga do małżeństwa", markerName));
        arraylist.add(new QuestionQuiz("Skąd wywodzi się nazwa mostu?", "Nazwa mostu wywodzi się od architekta który miał na nazwisko Groszowski ", "Kiedyś za przejście przez most były pobierane opłaty jednego grosza", "W czasie budowy wszyscy mieszkańcy miasta musieli przeznaczyć na budowę jeden grosz", "Kiedyś za przejście przez most były pobierane opłaty jednego grosza", markerName));
        arraylist.add(new QuestionQuiz("Od którego roku most jest oświetlany nocą?", "2013", "2010", "1999", "2010", markerName));
        markerName = "Staw Zamkowy";
        arraylist.add(new QuestionQuiz("123123", "123123", "123123", "123123", "123123", markerName));
        arraylist.add(new QuestionQuiz("123123", "123123", "123123", "123123", "123123", markerName));
        arraylist.add(new QuestionQuiz("123123", "123123", "123123", "123123", "123123", markerName));
        arraylist.add(new QuestionQuiz("123123", "123123", "123123", "123123", "123123", markerName));
        arraylist.add(new QuestionQuiz("123123", "123123", "123123", "123123", "123123", markerName));


        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<QuestionQuiz> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (QuestionQuiz question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(ANSWER, question.getAnswer());
                values.put(MARKERNAME, question.getMarkerName());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public int checkDBquestions() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String column[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, column, null,null, null, null, null);
        db.endTransaction();
        return cursor.getCount();
    }


    public List<QuestionQuiz> getAllOfTheQuestions(String markerName) {

        List<QuestionQuiz> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String column[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, column, MARKERNAME+ "=?", new String[]{markerName}, null, null, null);


        while (cursor.moveToNext()) {
            QuestionQuiz question = new QuestionQuiz();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setAnswer(cursor.getString(5));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
