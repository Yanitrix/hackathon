package com.example.btb.schoolbattle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LaderboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ListView leaderboard;
    private Spinner periodChooser;

    CustomAdapter weeklyAdapter;
    CustomAdapter monthlyAdapter;
    CustomAdapter yearlyAdapter;

    String[] CLANS_WEEKLY = {"Slowack", "Sniadek", "Sawcia"};
    String[] CLANS_MONTHLY = {"Slowack", "Sniadek", "Sawcia"};
    String[] CLANS_YEARLY = {"Slowack", "Sniadek", "Sawcia"};

    int[] POINTS_YEARLY = {1260, 540, 2};
    int[] POINTS_MONTHLY = {520, 234, 34};
    int[] POINTS_WEEKLY = {234, 123, 42};

    int[] IMGS = {R.drawable.logo_icon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laderboard);

        initializeReferences();

        ArrayAdapter ar = ArrayAdapter.createFromResource(this, R.array.period, android.R.layout.simple_spinner_item);

        periodChooser.setAdapter(ar);
        periodChooser.setOnItemSelectedListener(this);

         weeklyAdapter = new CustomAdapter(this, CLANS_WEEKLY, POINTS_WEEKLY, IMGS);
         monthlyAdapter = new CustomAdapter(this, CLANS_MONTHLY, POINTS_MONTHLY, IMGS);
         yearlyAdapter = new CustomAdapter(this, CLANS_YEARLY, POINTS_YEARLY, IMGS);

        leaderboard.setAdapter(weeklyAdapter);

    }

    private void initializeReferences() {
        leaderboard = (ListView) findViewById(R.id.leaderboard);
        periodChooser = (Spinner) findViewById(R.id.periodChooser);

    }

    private void displayWeekly(){
        leaderboard.setAdapter(weeklyAdapter);
    }

    private void displayMonthly(){
        leaderboard.setAdapter(monthlyAdapter);
    }

    private void displayYearly(){
        leaderboard.setAdapter(yearlyAdapter);
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    class CustomAdapter extends ArrayAdapter<String>
    {
        Context context;
        String clanNames[];
        int scores[];
        int[] imgs;

        CustomAdapter(Context c, String[] names, int[] scores, int[] imgs){
            super(c, R.layout.listview_layout, R.id.textView_clanname, names);
            this.context = c;
            this.imgs =  imgs;
            this.clanNames = names;
            this.scores =  scores;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater lfi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view  = lfi.inflate(R.layout.listview_layout, parent, false);
            ImageView imgs = view.findViewById(R.id.clanLogo);
            TextView clanName =  view.findViewById(R.id.textView_clanname);
            TextView score = view.findViewById(R.id.textView_score);
            imgs.setImageResource(position);
            clanName.setText(clanNames[position]);
            score.setText(scores[position]);

            return view;

        }
    }
}