package com.example.liuqahs15.japapp;

/**
 * Created by liuqahs15 on 2/23/15.
 */
public class MoreInfo {
    String english;
    String kana;
    String romaji;
    String kanji;
    String definitions[];

    MoreInfo(String rom, String kanj, String kan, String[]defs){
        romaji = rom;
        kanji = kanj;
        kana = kan;
        definitions = defs;
    }

}
