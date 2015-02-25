package com.example.liuqahs15.japapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by liuqahs15 on 2/23/15.
 */
public class MoreInfoDialogFragment extends DialogFragment {
    MoreInfoTestUtils miTest;

    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View miView = inflater.inflate(R.layout.moreinfo0, null);
        miTest = new MoreInfoTestUtils(System.currentTimeMillis());
        MoreInfo info = miTest.getNewMoreInfo();
            //Now set the values
        TextView romaji = (TextView) miView.findViewById(R.id.romaji);
        romaji.setText(info.romaji);

        TextView kanji = (TextView) miView.findViewById(R.id.kanji);
        kanji.setText(info.kanji);

        TextView kana = (TextView) miView.findViewById(R.id.kana);
        kana.setText(info.kana);

            //now add definitions
        for(int i = 0; i < info.definitions.length; i++){
            TextView currDef;
            if(i == 0){
                currDef = (TextView) miView.findViewById(R.id.def0);
                currDef.setText(info.definitions[i]);
                continue;
            }

            TableLayout defTable = (TableLayout) miView.findViewById(R.id.engTable);
            TableRow fillRow = (TableRow) inflater.inflate(R.layout.info_panel_row, null);

            //currDef.setTextSize(R.dimen.medium_font);
            TextView fillText = (TextView) fillRow.findViewById(R.id.fillDef);
            fillText.setText(info.definitions[i]);
            defTable.addView(fillRow);
        }//for


        builder.setView(miView)
                // Add action buttons
                .setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton(R.string.dialog_negative, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MoreInfoDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }//onCreate
}
