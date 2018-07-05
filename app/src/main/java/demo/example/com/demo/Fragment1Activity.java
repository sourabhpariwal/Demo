package demo.example.com.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class Fragment1Activity extends AppCompatActivity {

    Button button, btn2;
    FrameLayout frameLayout;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        button = findViewById(R.id.btn_fragment);
        frameLayout = findViewById(R.id.fm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fm, new FragmentOne()).commit();
            }
        });
    }
}
