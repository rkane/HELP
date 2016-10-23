package com.example.garan.help;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.garan.help.MainActivity.url;

/**
 * Created by garan on 10/22/16.
 */

public class Connect extends AsyncTask<Void, Void, String> {
    ProgressDialog mProgressDialog;
    Context context;
    private String url;
    public static String person;


    public Connect(Context context, String url, int id) {
        this.context = context;
        this.url = url;
        int some = id;
    }

   /* protected void onPreExecute() {
        mProgressDialog = ProgressDialog.show(context, "", "Accessing database");
    }*/

    protected String doInBackground(Void... params) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con = DriverManager.getConnection(url, "garan", "garan");
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select UUID from person where UUID = id");

            while (rs.next()){
                String text = rs.getString("UUID");
                person = String.valueOf(text);

            }
           /* person = String.valueOf(rs);

            return person;*/


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
