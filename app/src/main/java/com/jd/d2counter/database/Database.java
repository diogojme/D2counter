package com.jd.d2counter.database;


public interface Database {

    void insertHero();
    void insertCounter();

    interface CallBack{
        void onSuccess();
        void onFailure();
    }

}
