package com.alpesh1.multi_chioce_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    CardView Card_view;

    String Stream[] = {"BA", "B.com", "Bca", "Bsc", "Diploma", "IT"};

    String Choose = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Card_view = findViewById(R.id.Card_view);

        ArrayList<String> selectedStream = new ArrayList<>();

        Card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setTitle("Select Stream")
                        .setMultiChoiceItems(Stream, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if (b) {
                                    selectedStream.add(Stream[i]);
                                } else {
                                    selectedStream.remove(Stream[i]);
                                }
                            }
                        })
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                for (int i1 = 0; i1 < selectedStream.size(); i1++) {
                                    Log.e(TAG, "Onclick :" + selectedStream.get(i1));
                                }
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                dialog.show();
            }
        });
    }
}