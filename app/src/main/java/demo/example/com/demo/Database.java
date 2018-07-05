package demo.example.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Database extends AppCompatActivity {
    EditText name, surname, marks;
    Button submit;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        marks = findViewById(R.id.marks);
        submit = findViewById(R.id.submit);
        databaseHelper = new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.insertData(name.getText().toString(), surname.getText().toString(), marks.getText().toString());
            }
        });

    }
}
