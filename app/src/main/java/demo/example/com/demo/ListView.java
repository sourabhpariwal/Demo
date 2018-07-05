package demo.example.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

public class ListView extends AppCompatActivity {
    android.widget.ListView view;
    String[] a = {"aman", "naman", "sourabh"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        view = findViewById(R.id.lv);
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, a);
        view.setAdapter(arrayAdapter);
    }
}
