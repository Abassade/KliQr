package com.example.kliqr.utils;

import com.example.kliqr.models.Card;

import java.text.DecimalFormat;
import java.util.List;

public class Utils {

    public static String sumOfAmount(List<Card> cards) {
        double sum = 0;

        for (Card card: cards) {
            sum += Double.parseDouble(card.getAmount());
        }

        DecimalFormat formatter = new DecimalFormat("#,###");

        return formatter.format(sum);
    }
}
