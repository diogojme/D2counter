package com.jd.d2counter.database;


import com.jd.d2counter.objects.Hero;

import java.util.List;

public interface Database {

    void beginTransaction();
    void endTransaction();
    boolean inTransaction();
    void setTransactionSuccessful();

    void open();

    void insertHero();
    void insertCounter();

    Hero getHero(long idHero);
    List<Hero> getHeroList(String query);

    void addHero(Hero hero);

}
