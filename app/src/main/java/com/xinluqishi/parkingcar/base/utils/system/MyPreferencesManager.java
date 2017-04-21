package com.xinluqishi.parkingcar.base.utils.system;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


/**
 * Interface for accessing and modifying preference data returned by {@link
 * Context#getSharedPreferences}.  For any particular set of preferences,
 * there is a single instance of this class that all clients share.
 *
 * 此接口的目的是为了依靠Context.getSharedPreferences获取返回数据而实现访问和修改
 *
 * Modifications to the preferences must go through an {@link android.content.SharedPreferences.Editor} object
 * to ensure the preference values remain in a consistent state and control
 * when they are committed to storage.  Objects that are returned from the
 * various <code>get</code> methods must be treated as immutable by the application.
 *
 * 修改这类preferences数据必须要通过一个Editor类型的对象，目的是为了确保preference的值当被提交到存储目的地
 * 的时候仍然保持一致性和可控性。对象可以通过多个get方法方被返回并且是要被作为整个应用中的不可变对象
 *
 * <p><em>Note: This class does not support use across multiple processes.</em>
 * 不支持跨进程
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using SharedPreferences, read the
 * <a href="{@docRoot}guide/topics/data/data-storage.html#pref">Data Storage</a>
 * developer guide.</p></div>
 *
 * @see Context#getSharedPreferences
 */

/**
 *
 */
public class MyPreferencesManager {

    public static SharedPreferences getSharedPreferences_PARAM(Context ctx) {
        return ctx.getSharedPreferences("_PARAM_", 0);
    }

    public static SharedPreferences getSharedPreferences_PACKAGE(Activity ctx) {
        return ctx.getSharedPreferences(ctx.getPackageName(), 0);
    }

    public static boolean getBoolean(Context ctx,String key,boolean defaultValue) {
        SharedPreferences s = getSharedPreferences_PARAM(ctx);
        return s.getBoolean(key, defaultValue);
    }

    public static void saveBoolean(Context ctx, String key,boolean value) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        SharedPreferences.Editor ed = share.edit();
        ed.putBoolean(key, value);
        ed.commit();
    }


    public static boolean isFirstTime(Activity ctx) {
        SharedPreferences s = getSharedPreferences_PACKAGE(ctx);
        boolean is = s.getBoolean("_firstTime_", true);
        // 立刻设置为false
        SharedPreferences.Editor ed = s.edit();
        ed.putBoolean("_firstTime_", false);
        ed.commit();
        return is;
    }

    public static void saveString(Context ctx, String key, String value) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        SharedPreferences.Editor ed = share.edit();
        ed.putString(key, value);
        ed.commit();
    }

    public static void saveInt(Context ctx, String key, int value) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        SharedPreferences.Editor ed = share.edit();
        ed.putInt(key, value);
        ed.commit();
    }

    public static void saveFloat(Context ctx, String key, Float value) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        SharedPreferences.Editor ed = share.edit();
        ed.putFloat(key, value);
        ed.commit();
    }

    public static void clear(Context ctx) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        SharedPreferences.Editor ed = share.edit();
        ed.clear();
        ed.commit();
    }

    public static String getString(Context ctx, String key) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        return share.getString(key, "");
    }

    public static Float getFloat(Context ctx, String key) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        return share.getFloat(key,0);
    }

    public static String getString(Context ctx, String key,String defaultValue) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        return share.getString(key, defaultValue);
    }

    public static int getInt(Context ctx, String key) {
        SharedPreferences share = getSharedPreferences_PARAM(ctx);
        return share.getInt(key, 0);
    }

}
