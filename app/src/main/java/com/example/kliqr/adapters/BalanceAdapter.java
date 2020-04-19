package com.example.kliqr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kliqr.R;
import com.example.kliqr.models.Card;

import java.util.List;


public class BalanceAdapter extends RecyclerView.Adapter<BalanceAdapter.MyHolder> {

    List<Card> mCardF;
    List<Card> mList;
    Context context;

    public BalanceAdapter(List<Card> mCard, List<Card> mList, Context context) {
        this.mCardF = mCard;
        this.mList = mList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.first_card, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.Total_amount_txt.setText(mCardF.get(position).getTotal_amount(mList));

    }

    @Override
    public int getItemCount() {
        return mCardF.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView Total_amount_txt;

        public MyHolder(View itemView) {
            super(itemView);

            Total_amount_txt = itemView.findViewById(R.id.total_amount);
        }

    }
}
