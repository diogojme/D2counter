package com.jd.d2counter.database;


public interface Database {

    void insertHero();

    interface CallBack{
        void onSuccess();
        void onFailure();
    }

}
