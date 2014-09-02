package com.jd.d2counter.database;


import com.jd.d2counter.objects.Hero;

public interface Database {
    void open();

    void beginTransaction();
    void endTransaction();
    boolean inTransaction();
    void setTransactionSuccessful();

    void addHero(Hero hero);

}
