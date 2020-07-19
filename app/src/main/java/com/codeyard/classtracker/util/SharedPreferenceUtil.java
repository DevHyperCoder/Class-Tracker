package com.codeyard.classtracker.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

/**
 * Utility methods for SharedPreferences
 */
public class SharedPreferenceUtil {

    SharedPreferences sharedPreferences;

    public SharedPreferenceUtil(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setSharedPreferenceString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();

    }

    public String getSharedPreferenceString(String key) {
        return sharedPreferences.getString(key, "");

    }

    public void setSharedPreferenceInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();

    }

    public int setSharedPrefernceInt(String key) {
        return sharedPreferences.getInt(key, 0);

    }
}
