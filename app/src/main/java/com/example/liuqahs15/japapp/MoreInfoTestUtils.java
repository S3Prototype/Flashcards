package com.example.liuqahs15.japapp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by liuqahs15 on 2/23/15.
 */
public class MoreInfoTestUtils {

private static final String[] engVals = {
        "big", "horse", "killer", "1: bright (esp. of the moon);\n2: broad and empty;\n3: and also doing more stuff", "rapper", "(baseball) taking the field first, thus batting second and also doing more stuff", "beautician", "star", "power"
};

    private static final String[] kanaVals = {
       "パワー", "じょうべき", "パワープラスプラス", "べき", "べきじょう", "でんげんとうにゅう", "マンパワー", "オールドパワー", "そうでんせん"
    };

    private static final String[] romajiVals = {
            "pawaa", "joubeki", "pawaapuraspurasu", "beki", "bekijou", "dengentounyuu", "manpawaa", "oorudopawaa", "soudensen"
    };

    private static final String[] kanjiVals ={
            "空軍力", "羃集合", "配電線", "実権", "", "力感", "乗冪", "カリスマ美容師", "美容師"
    };

    private static final String posVal = "n; suru";

    private final Random rand;

    public MoreInfoTestUtils(long seed){
        rand = new Random(seed);
    }

    public ArrayList<MoreInfo> getNewResults(int count) {
        final ArrayList<MoreInfo> list = new ArrayList<MoreInfo>();
        for (int i = 0; i < count; i++) {
            list.add(getNewMoreInfo());
        }
        return list;
    }

    public MoreInfo getNewMoreInfo(){
        int randVal = rand.nextInt(9);
        int numDefs = randVal/2;
        String defArray[] = new String[numDefs];
        int ranDef;
        for(int i = 0; i < defArray.length; i++){
            ranDef = rand.nextInt(9);
            defArray[i] = engVals[ranDef];
        }

        return new MoreInfo(romajiVals[randVal], kanjiVals[randVal], kanaVals[randVal], defArray);
    }

}
