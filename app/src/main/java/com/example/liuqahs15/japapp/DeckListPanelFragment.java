package com.example.liuqahs15.japapp;

/**
 * Created by liuqahs15 on 3/3/15.
 */

import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
public class DeckListPanelFragment extends ListFragment {

    private static final String ARGUMENT_KEY_SEARCH_RESULTS = "search results";
    private static boolean grayBack = false;

    public static DeckListPanelFragment newInstance(ArrayList<DeckListPanel> deckListPanels){
        final Bundle args = new Bundle();
        args.putParcelableArrayList(ARGUMENT_KEY_SEARCH_RESULTS, deckListPanels);

        final DeckListPanelFragment frag = new DeckListPanelFragment();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final List<DeckListPanel> DeckListPanels = getArguments().getParcelableArrayList(ARGUMENT_KEY_SEARCH_RESULTS);
        setListAdapter(new DeckListPanelListAdapter(getActivity(), DeckListPanels));
    }

    private static class DeckListPanelListAdapter extends ArrayAdapter<DeckListPanel> {
        private final LayoutInflater srInflater;

        public DeckListPanelListAdapter(Context context, List<DeckListPanel> objects){
            super(context, -1, objects);
            srInflater = LayoutInflater.from(context);
            final Resources res = context.getResources();
        }

        final int smallFont = 16;
        final int medFont = 18;
        final int largeFont = 22;
        final int maxWidth = 150;

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            final DeckListPanel deckListPanel = getItem(position);

            if(convertView == null){
                convertView = srInflater.inflate(R.layout.deck_list_panel, parent, false);
            }

            TextView description = (TextView) convertView.findViewById(R.id.deckDescription);
            description.setText(deckListPanel.description);

            TextView nextReview = (TextView) convertView.findViewById(R.id.nrVal);
            nextReview.setText(deckListPanel.nextReview);

            TextView lastReview = (TextView) convertView.findViewById(R.id.lrVal);
            lastReview.setText(deckListPanel.lastReview);

            TextView numCards = (TextView) convertView.findViewById(R.id.ncVal);
            numCards.setText(deckListPanel.numCards);

            TextView deckName = (TextView) convertView.findViewById(R.id.deckName);
            deckName.setText(deckListPanel.deckName);


            return  convertView;
        }
    }//end of listadapter
}//end of class