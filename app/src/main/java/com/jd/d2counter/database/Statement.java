package com.jd.d2counter.database;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;

public class Statement {

    private static Statement instance;
    private SQLiteDatabase database;
    private SparseArray<SQLiteStatement> statementList;

    private Statement(SQLiteDatabase database) {
        this.database = database;
        this.statementList = new SparseArray<SQLiteStatement>();
    }

    public static Statement with(SQLiteDatabase database) {
        if (database == null) {
            throw new NullPointerException("Database should not be null.");
        }
        if (instance == null) {
            instance = new Statement(database);
        }
        return instance;
    }

    public SQLiteStatement get(String sql) {
        SQLiteStatement sqLiteStatement = statementList.get(sql.hashCode());
        if (sqLiteStatement == null) {
            sqLiteStatement = database.compileStatement(sql);
            statementList.put(sql.hashCode(), sqLiteStatement);
        }
        return sqLiteStatement;
    }
}