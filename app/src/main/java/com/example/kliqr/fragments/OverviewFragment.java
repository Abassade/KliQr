package com.example.kliqr.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kliqr.R;
import com.example.kliqr.adapters.BalanceAdapter;
import com.example.kliqr.adapters.BaseAdapter;
import com.example.kliqr.models.Card;
import com.example.kliqr.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView recyclerViewF;
    BaseAdapter baseAdapter;
    BalanceAdapter balanceAdapter;
    List<Card> mCard;
    List<Card> mCardF;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        mCard = new ArrayList<>();
        mCardF = new ArrayList<>();

        mCardF.add(new Card(Utils.sumOfAmount(mCard)));

        for (int i = 0; i < 10; i++) {
            mCard.add(new Card(R.drawable.ic_android_black_24dp, "0434640833",
                    "GT Bank", "April 19th 2020", "150000"));
        }

        recyclerView = view.findViewById(R.id.recycler);
        recyclerViewF = view.findViewById(R.id.balance_rc);
        baseAdapter = new BaseAdapter(mCard, getContext());
        balanceAdapter = new BalanceAdapter(mCardF, mCard, getContext());

        recyclerViewF.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewF.setAdapter(balanceAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(baseAdapter);

        return view;
    }

}
