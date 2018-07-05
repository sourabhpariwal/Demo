package demo.example.com.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Shared_Preferences extends AppCompatActivity {
    EditText user, pwd;
    Button save;
   /* SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String MYPREFERENCES = "loginPreferences";
    private static final String USER_ID = "userId";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared__preferences);
        user = findViewById(R.id.user);
        pwd = findViewById(R.id.pwd);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr = user.getText().toString();
                String pass = pwd.getText().toString();
                Toast.makeText(Shared_Preferences.this, "Values has been Stored " + usr + " password entered is " + pass, Toast.LENGTH_LONG).show();
                /*sharedPreferences=getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
                editor=sharedPreferences.edit();
                editor.putString(USER_ID,"value to store from edit text");
                editor.apply();

                String id = sharedPreferences.getString(USER_ID,"");
*/
            }
        });

    }
}
