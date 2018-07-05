package demo.example.com.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class FragmentOne extends Fragment {
    private final Handler handler = new Handler();
    View view;
    Button btn2;
    FrameLayout frameLayout;
    Runnable runPager;

    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment_one, container, false);

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        runPager = new Runnable() {

            @Override
            public void run() {
                /*btn2 = view.findViewById(R.id.btn2);
                frameLayout = view.findViewById(R.id.fm1);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        frameLayout.setVisibility(View.INVISIBLE);*/
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fm1, new Fragment2()).commit();
            }
        };
        handler.post(runPager);
    }

}