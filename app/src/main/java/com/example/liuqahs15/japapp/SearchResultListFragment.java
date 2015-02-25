package com.example.liuqahs15.japapp;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuqahs15 on 2/17/15.
 */
public class SearchResultListFragment extends ListFragment{

    private static final String ARGUMENT_KEY_SEARCH_RESULTS = "search results";
    private static boolean grayBack = false;

    public static SearchResultListFragment newInstance(ArrayList<SearchResult> searchResults){
        final Bundle args = new Bundle();
        args.putParcelableArrayList(ARGUMENT_KEY_SEARCH_RESULTS, searchResults);

        final SearchResultListFragment frag = new SearchResultListFragment();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final List<SearchResult> searchResults = getArguments().getParcelableArrayList(ARGUMENT_KEY_SEARCH_RESULTS);
        setListAdapter(new SearchResultListAdapter(getActivity(), searchResults));
    }

    private static class SearchResultListAdapter extends ArrayAdapter<SearchResult>{
        private final LayoutInflater srInflater;
        private final String eng;
        private final String kan;
        private final String kanj;
        private final String pos;
        private final String roma;

        public SearchResultListAdapter(Context context, List<SearchResult> objects){
            super(context, -1, objects);
            srInflater = LayoutInflater.from(context);
            final Resources res = context.getResources();
            eng = " " + res.getString(R.string.eng);
            kan = " " + res.getString(R.string.kana);
            kanj = " " + res.getString(R.string.kanji);
            roma = " " + "Romaji";
            pos = " " + res.getString(R.string.pos);
        }

        final int smallFont = 16;
        final int medFont = 18;
        final int largeFont = 22;
        final int maxWidth = 150;

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            final SearchResult searchResult = getItem(position);

            if(convertView == null){
                convertView = srInflater.inflate(R.layout.minimal, parent, false);
            }

                //The following is proof that Java is 5 million times better than c++:
          /*  String truncated = searchResult.getKana().substring(0, searchResult.getKana().length() - 2);
            System.out.println("String: " + searchResult.getKana() + " | Len: " + searchResult.getKana().length() + " | Trunc: " + truncated);
                //Fuck yes. It just works.

            String finalKana = searchResult.getKana();

            int max = 6;
            int diff = max - finalKana.length();
            if (diff < 0){
                finalKana = finalKana.substring(0, finalKana.length() + diff);
                finalKana += " ...";
            }
        */

            TextView tv = (TextView) convertView.findViewById(R.id.english);
            tv.setText(searchResult.getEnglish());

            Button btn = (Button) convertView.findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentActivity act = (FragmentActivity) v.getContext();
                    DialogFragment newFrag = new MoreInfoDialogFragment();
                    newFrag.show(act.getFragmentManager(), "Stuff");
                }
            });

            tv = (TextView) convertView.findViewById(R.id.romaji);
            tv.setText(searchResult.getKana());

            tv = (TextView) convertView.findViewById(R.id.kanji);
            tv.setText(searchResult.getKanji());

            return  convertView;
        }
    }//end of listadapter
}//end of class
