package com.me.coopapp.android;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.me.coopapp.*;

public class AndroidActionResolver implements IActionResolver {

    Handler uiThread;
    Context appContext;

    public AndroidActionResolver(Context appContext) {
            uiThread = new Handler();
            this.appContext = appContext;
    }

    @Override
    public Connection getConnection() {
            String url = "jdbc:sqldroid:/data/data/CoopApp/databases/data.sqlite";
            try {
                    Class.forName("org.sqldroid.SQLDroidDriver").newInstance();
                    return DriverManager.getConnection(url);
            } catch (InstantiationException e) {
                    Log.e("sql", e.getMessage());
            } catch (IllegalAccessException e) {
                    Log.e("sql", e.getMessage());
            } catch (ClassNotFoundException e) {
                    Log.e("sql", e.getMessage());
            } catch (SQLException e) {
                    Log.e("sql", e.getMessage());
            }
            return null;
    }
}