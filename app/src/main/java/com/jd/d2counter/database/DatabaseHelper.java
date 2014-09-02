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
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dota.database";

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
        sqLiteDatabase.execSQL(CREATE_TABLE_HERO_COUNTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO_COUNTER);
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

    private List<Hero> getHeroList(String query) {
        List<Hero> heroes = new ArrayList<Hero>();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                heroes.add(getHero(cursor.getLong(0)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return heroes;
    }

    private Hero getHero(long id) {
        Hero hero = null;
        String query = "SELECT * FROM " + TABLE_HERO + " WHERE " + COLUMN_HERO_ID + " = " + id;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            hero = new Hero(cursor.getLong(1), cursor.getString(2), cursor.getInt(3));
        }

        return hero;
    }

    public void addHero(Hero hero) {
        SQLiteStatement statement = Statement.with(database).get(STATEMENT_HERO);
        statement.bindLong(1, hero.getId());
        statement.bindString(2, hero.getName());
        statement.bindLong(3, hero.getType());
        statement.execute();
        statement.clearBindings();
    }

    public void addCounter(long idHero, long idCounter, long idSupport, long posicao){
        SQLiteStatement statement = Statement.with(database).get(STATEMENT_HERO_COUNTER);
        statement.bindLong(1, idHero);
        statement.bindLong(2, idCounter);
        statement.bindLong(3, idSupport);
        statement.bindLong(4, posicao);
        statement.execute();
        statement.clearBindings();
    }

    private static final String TABLE_HERO = "hero";
    private static final String TABLE_HERO_COUNTER = "hero_counter";


    private static final String COLUMN_HERO_ID = "id";
    private static final String COLUMN_HERO_NAME = "name";
    private static final String COLUMN_HERO_TYPE = "type";
    private static final String COLUMN_HERO_COUNTER_ID = "id_counter";
    private static final String COLUMN_HERO_COUNTER_POSITION = "position";
    private static final String COLUMN_HERO_COUNTER_SUPPORT_ID = "id_counter_support";

    private static final String CREATE_TABLE_HERO = "CREATE TABLE " + TABLE_HERO + "("
            + COLUMN_HERO_ID + " LONG PRIMARY KEY, "
            + COLUMN_HERO_NAME + " TEXT NOT NULL, "
            + COLUMN_HERO_TYPE + " INTEGER NOT NULL );";

    private static final String CREATE_TABLE_HERO_COUNTER = "CREATE TABLE " + TABLE_HERO_COUNTER + "("
            + COLUMN_HERO_ID + " LONG NOT NULL, "
            + COLUMN_HERO_COUNTER_ID + " LONG NOT NULL,"
            + COLUMN_HERO_COUNTER_SUPPORT_ID + " LONG NOT NULL,"
            + COLUMN_HERO_COUNTER_POSITION + " LONG NOT NULL"
            +");";

    private static final String STATEMENT_HERO = "INSERT INTO " + TABLE_HERO + " VALUES (?, ?, ?)";
    private static final String STATEMENT_HERO_COUNTER = "INSERT INTO " + TABLE_HERO_COUNTER + " VALUES (?, ?, ?, ?)";
}
