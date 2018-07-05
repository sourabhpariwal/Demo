package demo.example.com.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    ProgressDialog progressDialog;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,0);*/
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

       /* progressDialog = new ProgressDialog(SplashScreen.this);
        progressDialog.setTitle("Please wait....");
        progressDialog.setCancelable(true);
        progressDialog.show();*/

        bar = findViewById(R.id.pb);
        bar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, demo.class);
                startActivity(i);
                finish();


            }
        }, 1000);
    }
}
