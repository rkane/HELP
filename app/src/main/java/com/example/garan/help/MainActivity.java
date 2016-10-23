package com.example.garan.help;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URL;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    static final String url = "jdbc:oracle://192.168.43.218:3306/gh_persons";
    static final int ID = 101;
    public String UUID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.textResult);
        Button btnGet = (Button)findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Connect(MainActivity.this, url, id).execute();
                result.setText(Connect.person);

            }
        });

    }
}
