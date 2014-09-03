package com.jd.d2counter.database;


public interface Database {
    void open();

    void beginTransaction();
    void endTransaction();
    boolean inTransaction();
    void setTransactionSuccessful();

    void addHero(long id, String name, int type, int resourceId);

}
