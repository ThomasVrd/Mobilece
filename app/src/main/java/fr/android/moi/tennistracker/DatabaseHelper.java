package fr.android.moi.tennistracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //VARIABLES

    public static final String DATABASE_NAME = "tennis .db";
    public static final String TABLE_NAME = "match";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Joueur1";
    public static final String COL_3 = "Joueur2";
    public static final String COL_4 = "Gagnant";
    public static final String COL_5 = "PremierServiceJ1";
    public static final String COL_6 = "PremierServiceJ2";
    public static final String COL_7 = "DFServiceJ1";
    public static final String COL_8 = "DFServiceJ2";
    public static final String COL_9 = "PointGagnantJ1";
    public static final String COL_10 = "PointGagnantJ2";
    public static final String COL_11 = "FautesJ1";
    public static final String COL_12 = "FautesJ2";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, Joueur1 TEXT, Joueur2 TEXT, Gagnant TEXT, PremierServiceJ1 FLOAT, PremierServiceJ2 FLOAT, DFServiceJ1 FLOAT, DFServiceJ2 FLOAT, PointGagnantJ1 FLOAT, PointgagnantJ2 FLOAT, FautesJ1 FLOAT, FautesJ2 FLOAT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String joueur1, String joueur2, String gagnant, float premierServiceJ1, float premierServiceJ2, float dFServiceJ1, float dFServiceJ2, float pointGagnantJ1, float pointGagnantJ2, float fautesJ1, float fautesJ2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, joueur1);
        contentValues.put(COL_3, joueur2);
        contentValues.put(COL_4, gagnant);
        contentValues.put(COL_5, premierServiceJ1);
        contentValues.put(COL_6, premierServiceJ2);
        contentValues.put(COL_7, dFServiceJ1);
        contentValues.put(COL_8, dFServiceJ2);
        contentValues.put(COL_9, pointGagnantJ1);
        contentValues.put(COL_10, pointGagnantJ2);
        contentValues.put(COL_11, fautesJ1);
        contentValues.put(COL_12, fautesJ2);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

     public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME,  null);
        return res;
     }

     public Cursor getAllGames() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;

     }

     public Cursor getDataGame(int IDgame) {
        Log.d("alors?", "oui");
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor res = db.rawQuery("select * from "+ TABLE_NAME + "where ID = "+ IDgame, null);
         return res;
     }
}
