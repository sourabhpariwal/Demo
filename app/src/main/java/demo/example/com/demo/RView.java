package demo.example.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RView extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] ab = {"test1", "test2", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rview);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(ab));
    }
}
