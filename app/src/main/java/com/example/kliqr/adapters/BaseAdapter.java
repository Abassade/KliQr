package com.example.kliqr.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kliqr.R;
import com.example.kliqr.models.Card;

import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.MyHolder> {

    List<Card> mCard;
    Context context;

    public BaseAdapter(List<Card> mCard, Context context) {
        this.mCard = mCard;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.bank_logo_img.setImageResource(mCard.get(position).getBank_logo());
        holder.acc_no.setText(mCard.get(position).getAcc_number());
        holder.bank_name_txt.setText(mCard.get(position).getBank_name());
        holder.checked_date_txt.setText(mCard.get(position).getChecked_date());
        holder.amount_txt.setText(mCard.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return mCard.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView acc_no, bank_name_txt, checked_date_txt, amount_txt;
        ImageView bank_logo_img;
        ImageButton close_card_btn;

        public MyHolder(View itemView) {
            super(itemView);

            bank_logo_img =itemView.findViewById(R.id.bank_logo);
            acc_no = itemView.findViewById(R.id.acc_number);
            bank_name_txt = itemView.findViewById(R.id.bank_name);
            checked_date_txt = itemView.findViewById(R.id.checked_date);
            amount_txt = itemView.findViewById(R.id.amount);
            close_card_btn = itemView.findViewById(R.id.close_card);

            close_card_btn.setOnClickListener(this);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v.equals(close_card_btn)){
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                removeAt(mCard, getAbsoluteAdapterPosition());
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                dialog.dismiss();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Remove Balance Card").setIcon(R.drawable.ic_close_black_24dp);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }

        }

        public void removeAt(List<Card> list,  int position) {
            list.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, list.size());
        }
    }
}
