package com.example.ejesh.health;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created on 25/2/2018.
 *
 * @author Mandeep
 */

public class HealthilyPreference {
    private static final String PREFS_NAME = "HealthilyPreference";

    private static final String IS_LOGGED_IN_ANY_ACCOUNT = "accountLogFlag";

    private static final String ACCOUNT_NAME = "accountName";
    private static final String ACCOUNT_AGE = "accountAge";
    private static final String ACCOUNT_GENDER = "accountGender";
    private static final String ACCOUNT_PREFERED_TIME = "accountPreferedTime";
    private static final String ACCOUNT_PREFERED_DATE = "accountPreferedDate";


    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;
    private Context mContext;


    public HealthilyPreference(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = mContext.getSharedPreferences (PREFS_NAME, Context.MODE_PRIVATE);
    }

    public String getAccountPreferedDate() {
        return mSharedPreference.getString (ACCOUNT_PREFERED_DATE, null);
    }

    public void setAccountPreferedDate(String accountId) {
        mEditor = mSharedPreference.edit ( );
        mEditor.putString (ACCOUNT_PREFERED_DATE, accountId);
        mEditor.apply ( );
    }

    public String getAccountPreferedTime() {
        return mSharedPreference.getString (ACCOUNT_PREFERED_TIME, null);
    }

    public void setAccountPreferedTime(String accountId) {
        mEditor = mSharedPreference.edit ( );
        mEditor.putString (ACCOUNT_PREFERED_TIME, accountId);
        mEditor.apply ( );
    }


    public String getAccountAge() {
        return mSharedPreference.getString (ACCOUNT_AGE, null);
    }

    public void setAccountAge(String accountId) {
        mEditor = mSharedPreference.edit ( );
        mEditor.putString (ACCOUNT_AGE, accountId);
        mEditor.apply ( );
    }

    public String getAccountGender() {
        return mSharedPreference.getString (ACCOUNT_GENDER, null);
    }

    public void setAccountGender(String accountId) {
        mEditor = mSharedPreference.edit ( );
        mEditor.putString (ACCOUNT_GENDER, accountId);
        mEditor.apply ( );
    }


    public boolean hasLoggedIn() {
        return mSharedPreference.getBoolean (IS_LOGGED_IN_ANY_ACCOUNT, false);
    }

    public void hasLoggedIn(boolean hasLoggedIn) {
        mEditor = mSharedPreference.edit ( );
        mEditor.putBoolean (IS_LOGGED_IN_ANY_ACCOUNT, hasLoggedIn);
        mEditor.apply ( );
    }


    public String getAccountName() {
        return mSharedPreference.getString (ACCOUNT_NAME, null);
    }

    public void setAccountName(String accountName) {
        mEditor = mSharedPreference.edit ( );
        mEditor.putString (ACCOUNT_NAME, accountName);
        mEditor.apply ( );
    }

}
