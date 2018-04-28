package com.qiuhong.qhlibrary.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by qiuhong on 9/9/16.
 */
public class PrefUtil {

    public static void putBoolean(String spName, String key, boolean value, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String spName, String key, boolean defValue, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void putString(String spName, String key, String value, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    public static String getString(String spName, String key, String defValue, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void putInt(String spName, String key, int value, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(String spName, String key, int defValue, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void putLong(String spName, String key, long value, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).apply();
    }

    public static long getLong(String spName, String key, long defValue, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }

    public static void remove(String spName, String key, Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }
}
