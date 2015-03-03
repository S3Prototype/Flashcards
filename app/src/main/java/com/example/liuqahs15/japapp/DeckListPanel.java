package com.example.liuqahs15.japapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liuqahs15 on 3/3/15.
 */
public class DeckListPanel implements Parcelable{

    private static final String TAG = "DeckListPanel";

    private static final int KEY_DESC = 0;
    private static final int KEY_NEXT_REVIEW = 1;
    private static final int KEY_LAST_REVIEW = 2;
    private static final int KEY_DECK_NAME = 3;
    private static final int KEY_NUM_CARDS = 4;

    public final String description;
    public final String nextReview;
    public final String lastReview;
    public final int numCards;
    public final String deckName;

    public DeckListPanel(String desc, String nR, String lR, String dN, int nC){
        description = desc;
        nextReview = nR;
        lastReview = lR;
        deckName = dN;
        numCards = nC;
    }

    public int describeContents(){
        return 0;
    }

    public static String getTag() {
        return TAG;
    }


    public void writeToParcel(Parcel dest, int flags) {
        String [] infoArray = {description, nextReview, lastReview, deckName, Integer.toString(numCards)};
        dest.writeStringArray(infoArray);
    }

    public static final Parcelable.Creator<DeckListPanel> CREATOR = new Parcelable.Creator<DeckListPanel>() {

        public DeckListPanel createFromParcel(Parcel source) {
            final String[] result = source.createStringArray();
            return new DeckListPanel(result[KEY_DESC], result[KEY_NEXT_REVIEW], result[KEY_LAST_REVIEW], result[KEY_DECK_NAME], Integer.valueOf(result[KEY_NUM_CARDS]));
        }

        public DeckListPanel[] newArray(int size){
            return new DeckListPanel[size];
        }
    };
}
