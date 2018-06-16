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

    int[] POINTS_YEARLY = {1260, 540, 2};
    int[] POINTS_MONTHLY = {520, 234, 34};
    int[] POINTS_WEEKLY = {234, 123, 42};

    int[] IMGS = {R.drawable.logo_icon, R.drawable.logo_icon, R.drawable.logo_icon};

    private Spinner periodChooser;
    private TextView score1, score2, score3;
    private ImageView logo1, logo2, logo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laderboard);

        initializeReferences();

        ArrayAdapter ar = ArrayAdapter.createFromResource(this, R.array.period, android.R.layout.simple_spinner_item);

        periodChooser.setAdapter(ar);
        periodChooser.setOnItemSelectedListener(this);

        logo1.setImageResource(R.drawable.logo_icon);
        logo2.setImageResource(R.drawable.logo_icon);
        logo3.setImageResource(R.drawable.logo_icon);


        displayWeekly();
    }

    private void initializeReferences() {
        periodChooser = (Spinner) findViewById(R.id.periodChooser);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        logo1 = (ImageView) findViewById(R.id.logo1);
        logo2 = (ImageView) findViewById(R.id.logo2);
        logo3 =  (ImageView) findViewById(R.id.logo3);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView text = (TextView) view;
        String choice = text.getText().toString();

        if (choice.equals("week")) {
            displayWeekly();
        } else if (choice.equals("month")) {
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