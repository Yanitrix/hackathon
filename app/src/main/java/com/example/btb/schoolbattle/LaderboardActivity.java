package com.example.btb.schoolbattle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class LaderboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int[] POINTS_YEARLY = {1240, 650, 200};
    int[] POINTS_MONTHLY = {520, 375, 160};
    int[] POINTS_WEEKLY = {260, 150, 40};


    private Spinner periodChooser;
    private TextView score1, score2, score3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laderboard);

        initializeReferences();

        ArrayAdapter ar = ArrayAdapter.createFromResource(this, R.array.period, R.layout.spinner_item);

        periodChooser.setAdapter(ar);
        periodChooser.setOnItemSelectedListener(this);



        displayWeekly();
    }

    private void initializeReferences() {
        periodChooser = (Spinner) findViewById(R.id.periodChooser);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView text = (TextView) view;
        String choice = text.getText().toString();

        if (choice.equals("Tydzień")) {
            displayWeekly();
        } else if (choice.equals("Miesiąc")) {
            displayMonthly();
        } else {
            displayYearly();
        }

    }

    private void displayWeekly() {
        score1.setText(Integer.toString(POINTS_WEEKLY[0]));
        score2.setText(Integer.toString(POINTS_WEEKLY[1]));
        score3.setText(Integer.toString(POINTS_WEEKLY[2]));
    }

    private void displayMonthly(){
        score1.setText(Integer.toString(POINTS_MONTHLY[0]));
        score2.setText(Integer.toString(POINTS_MONTHLY[1]));
        score3.setText(Integer.toString(POINTS_MONTHLY[2]));
    }

    private void displayYearly(){
        score1.setText(Integer.toString(POINTS_YEARLY[0]));
        score2.setText(Integer.toString(POINTS_YEARLY[1]));
        score3.setText(Integer.toString(POINTS_YEARLY[2]));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}


}