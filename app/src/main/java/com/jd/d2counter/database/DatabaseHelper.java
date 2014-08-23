package com.jd.d2counter.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Hero hero;
    private SQLiteDatabase database;
    private static DatabaseHelper instance;

    private DatabaseHelper(Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper with(Context context) {

        if (instance == null) {
            instance = new DatabaseHelper(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_HERO);
//        sqLiteDatabase.execSQL(CREATE_TABLE_ARTIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYLIST);
        this.onCreate(sqLiteDatabase);
    }

    public void open() {
        if (database == null) {
            database = getWritableDatabase();
        }
    }

    public void beginTransaction() {
        database.beginTransaction();
    }

    public void setTransactionSuccessful() {
        database.setTransactionSuccessful();
    }

    public boolean inTransaction() {
        return database.inTransaction();
    }

    public void endTransaction() {
        database.endTransaction();
    }

    private List<T> getHeroList(String query) {
        List<T> heroes = new ArrayList<T>();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                heroes.add(getHero(cursor.getLong(0)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return heroes;
    }

    private T getHero(long id) {
        T t = null;
        String query = "SELECT * FROM " + TABLE_HERO + " WHERE " + COLUMN_HERO_ID + " = " + id;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            t = new T(); //cursor.getLong(1), cursor.getString(2), cursor.getInt(3)
        }

        return t;
    }

    public void addHero(long id, String name, int type) {
        SQLiteStatement statement = Statement.with(database).get(STATEMENT_HERO);
        statement.bindLong(1, id);
        statement.bindString(2, name);
        statement.bindLong(3, type);
        statement.execute();
        statement.clearBindings();
    }

    public class T {
    }

    private static final int DATABASE_VERSION = 11;
    private static final String DATABASE_NAME = "my.database";

    private static final String TABLE_HERO = "hero";
    private static final String COLUMN_HERO_ID = "id";
    private static final String COLUMN_HERO_NAME = "name";
    private static final String COLUMN_HERO_TYPE = "type";

    private static final String CREATE_TABLE_HERO = "CREATE TABLE " + TABLE_HERO + "("
            + COLUMN_HERO_ID + " LONG PRIMARY KEY, "
            + COLUMN_HERO_NAME + " TEXT NOT NULL, "
            + COLUMN_HERO_TYPE + " INTEGER NOT NULL );";
    private static final String STATEMENT_HERO = "INSERT OR REPLACE INTO " + TABLE_HERO + " VALUES (?, ?, ?)";

}
