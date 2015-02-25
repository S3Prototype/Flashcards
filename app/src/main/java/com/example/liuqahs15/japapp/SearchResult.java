package com.example.liuqahs15.japapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuqahs15 on 2/17/15.
 */
public class SearchResult implements Parcelable{

    private static final String TAG = "SearchResult";


    public static final int KEY_ENGLISH = 0;
    public static final int KEY_KANA = 1;
    public static final int KEY_KANJI = 2;
    public static final int KEY_POS = 3;

    private final String english;
    private final String kana;
    private final String kanji;
    private final String pos;

    public SearchResult(String eng, String kan, String kanj, String POS){
        english = eng;
        kana = kan;
        kanji = kanj;
        pos = POS;
    }

    public int describeContents(){
        return 0;
    }

    public String getKana() {
        return kana;
    }

    public String getEnglish() {
        return english;
    }

    public String getKanji() {
        return kanji;
    }

    public String getPos() {
        return pos;
    }

    public static String getTag() {
        return TAG;
    }

    public static int getKeyEnglish() {
        return KEY_ENGLISH;
    }

    public static int getKeyKana() {
        return KEY_KANA;
    }

    public static int getKeyPos() {
        return KEY_POS;
    }

    public static int getKeyKanji() {
        return KEY_KANJI;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        String [] infoArray = {english, kana, kanji, pos};
        dest.writeStringArray(infoArray);
    }

    public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {

        @Override
        public SearchResult createFromParcel(Parcel source) {
            final String[] result = source.createStringArray();
            return new SearchResult(result[KEY_ENGLISH], result[KEY_KANA], result[KEY_KANJI], result[KEY_POS]);
        }

        public SearchResult[] newArray(int size){
            return new SearchResult[size];
        }
    };
}//end of class
