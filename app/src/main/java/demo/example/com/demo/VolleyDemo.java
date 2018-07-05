package demo.example.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VolleyDemo extends AppCompatActivity {
    EditText editText;
    ArrayList list, list1;
    Button button;
    String value;
    RecyclerView recyclerView;
    MYAdap arrayAdapter;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_demo);
        editText = findViewById(R.id.ed);
        button = findViewById(R.id.btn_fetch);
        recyclerView = findViewById(R.id.lv_l);
        manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = editText.getText().toString();
                fetchData();

            }

        });

    }

    private void fetchData() {
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=\"" + value + " \"&image_type=photo&pretty=true&per_page=20";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //System.out.print(response);
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("hits");
                    list = new ArrayList();
                    list1 = new ArrayList();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String likes = object.getString("likes");
                        String usesr = object.getString("user");
                        list.add(usesr);
                        list1.add(likes);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                arrayAdapter = new MYAdap(VolleyDemo.this, list, list1);
                recyclerView.setAdapter(arrayAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.print(error);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(VolleyDemo.this);
        queue.add(stringRequest);
    }

}
