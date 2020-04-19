package com.example.kliqr.models;

import com.example.kliqr.utils.Utils;

import java.util.List;

import static com.example.kliqr.utils.Utils.sumOfAmount;

public class Card {

    private int bank_logo;
    private String acc_number;
    private String bank_name;
    private String checked_date;
    private String amount;

    private String total_amount;

    public int getBank_logo() {
        return bank_logo;
    }

    public String getAcc_number() {
        return acc_number;
    }

    public String getBank_name() {
        return bank_name;
    }

    public String getChecked_date() {
        return checked_date;
    }

    public String getAmount() {
        return amount;
    }


    public void setBank_logo(int bank_logo) {
        this.bank_logo = bank_logo;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setChecked_date(String checked_date) {
        this.checked_date = checked_date;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public Card(int bank_logo, String acc_number, String bank_name, String checked_date, String amount) {
        this.bank_logo = bank_logo;
        this.acc_number = acc_number;
        this.bank_name = bank_name;
        this.checked_date = checked_date;
        this.amount = amount;
    }

    public Card(String total_amount){
        this.total_amount = total_amount;
    }


    public String getTotal_amount(List<Card> list) {
        return Utils.sumOfAmount(list);
    }



}