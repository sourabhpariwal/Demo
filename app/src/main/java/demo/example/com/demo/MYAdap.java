package demo.example.com.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MYAdap extends RecyclerView.Adapter<MYAdap.VH> {
    Context context;
    ArrayList list, list1;


    public MYAdap(VolleyDemo volleyDemo, ArrayList list, ArrayList list1) {

        this.list = list;
        this.list1 = list1;
        context = volleyDemo;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rviewlayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.textView.setText(list.get(position).toString());
        holder.textView1.setText(list1.get(position).toString());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView textView, textView1;
        ImageView imageView;

        public VH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView1 = itemView.findViewById(R.id.textView1);

        }
    }
}
