package kr.hs.emirim.dgh09053.mirimbook;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<User> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView Title;
        protected TextView Author;
        protected TextView BookNum;


        public CustomViewHolder(View view) {
            super(view);
            this.Title = (TextView) view.findViewById(R.id.id_Title);
            this.Author = (TextView) view.findViewById(R.id.id_Auther);
            this.BookNum = (TextView) view.findViewById(R.id.id_BookNum);
        }
    }


    public CustomAdapter(List<User> list) {
        this.mList = list;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.Title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.Author.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.BookNum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.Title.setGravity(Gravity.CENTER);
        viewholder.Author.setGravity(Gravity.CENTER);
        viewholder.BookNum.setGravity(Gravity.CENTER);



        viewholder.Title.setText(mList.get(position).getTitle());
        viewholder.Author.setText(mList.get(position).getAuther());
        viewholder.BookNum.setText(mList.get(position).getBookNum());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}

