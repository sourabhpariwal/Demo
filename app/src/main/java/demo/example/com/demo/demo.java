package demo.example.com.demo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class demo extends AppCompatActivity {

    ImageView imageView;
    Button button, btn, video, exit;
    String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbbJgyO1AUApgMpcx7bA7LQ3p5LZlHy4d7gd6-I5olge4yFirj";
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.btn);
        exit = findViewById(R.id.exit);
        btn = findViewById(R.id.online_image);
        video = findViewById(R.id.vid);
        videoView = findViewById(R.id.vv);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setVisibility(View.VISIBLE);
                btn.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");
                startActivityForResult(intent, 200);
            }
        });


        // to set image from resource
        /*imageView.setPadding(10,10,10,10);
        imageView.setImageResource(R.drawable.scan);*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implicit intent
                if (ContextCompat.checkSelfPermission(demo.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(demo.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            99);

                } else {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, 100);

                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get().load(url).into(imageView);

            }
        });
        //method for alertDailog on exit button
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(demo.this);
                builder.setIcon(android.R.drawable.sym_def_app_icon);
                builder.setTitle("Alert Dailog Example");
                builder.setMessage("Do you really want to exit");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 99 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.length > 0) {

            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 100);
        } else {
            Toast.makeText(demo.this, "you have not granted permission", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(demo.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    99);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        } else {
            Uri uri = data.getData();
            videoView.setVideoURI(uri);
            videoView.start();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.about:
                Intent i = new Intent(demo.this, CVDemo.class);
                startActivity(i);
                finish();
                break;
            case R.id.listview:
                Intent j = new Intent(demo.this, ListView.class);
                startActivity(j);
                finish();
                break;
            case R.id.recyclerview:
                Intent k = new Intent(demo.this, RView.class);
                startActivity(k);
                finish();
                break;
            case R.id.database:
                Intent l = new Intent(this, Database.class);
                startActivity(l);
                finish();
            case R.id.fragment1:
                Intent m = new Intent(this, Fragment1Activity.class);
                startActivity(m);
                finish();
            case R.id.view_pager:
                Intent vp = new Intent(this, ViewPagerActivity.class);
                startActivity(vp);
                finish();
            case R.id.collapsing_toolbar:
                Intent ct = new Intent(this, CPToolbar.class);
                startActivity(ct);
                finish();
            case R.id.gmail_menu:
                Intent g = new Intent(this, GmailSignIN.class);
                startActivity(g);
                finish();
            case R.id.volley_menu:
                Intent v = new Intent(this, VolleyDemo.class);
                startActivity(v);
                finish();
            case R.id.shared_preference:
                Intent sp = new Intent(this, Shared_Preferences.class);
                startActivity(sp);
                finish();

        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(demo.this);
        View view = getLayoutInflater().inflate(R.layout.dailog, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button yes = view.findViewById(R.id.yes);
        Button no = view.findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
