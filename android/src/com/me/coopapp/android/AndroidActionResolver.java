package com.me.coopapp.android;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.me.coopapp.IActionResolver;

public class AndroidActionResolver implements IActionResolver {

    Handler uiThread;
    Context appContext;
    String dbPath;
    static String dbName = "sampleDB.db";

    public AndroidActionResolver(Context appContext) {
            uiThread = new Handler();
            this.appContext = appContext;
            dbPath = appContext.getFilesDir().getAbsolutePath().replace("files", "databases")+File.separator + dbName;
    }

    @Override
    public Connection getConnection() {
            String url = "jdbc:sqldroid:"+dbPath;
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
    
//    private Connection openDBSQLite() {
//        String file = dbPath;
//        Connection connection = null;
//        Statement statement = null;
//        PreparedStatement  insertstatement = null;
//        ResultSet rs = null;
//        try
//        {
////            if (!file.getParentFile().exists()) {
////                file.getParentFile().mkdirs();
////            }
//            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(file , null);
//            db.close();
//
//          connection = new org.sqldroid.SQLDroidDriver().connect("jdbc:sqlite:" + file , new Properties());
//
////          statement = connection.createStatement();
////          statement.setQueryTimeout(30);  // set timeout to 30 sec.
////
////          statement.executeUpdate("drop table if exists person3");
////          statement.executeUpdate("create table person3 (id integer primary key, name string, test integer)");
//          
//        } catch (SQLException e) {
//            Log.e("sql", e.getMessage());
//        }
//        
//        return connection;
//    }
}