package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.jd.d2counter.R;
import com.jd.d2counter.database.DatabaseManager;


public class SplashActivity extends ActionBarActivity {
    private ProgressBar mProgress;
    private DatabaseManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mProgress = (ProgressBar) findViewById(R.id.loading);
        mManager = new DatabaseManager(SplashActivity.this);
        new DataTask().execute();

    }

    private class DataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setLoading(true);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mManager.insertHero();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setLoading(false);
            finish();
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        }
    }

    private void setLoading(boolean loading) {
        mProgress.setVisibility(loading ? View.VISIBLE : View.INVISIBLE);
    }

}
