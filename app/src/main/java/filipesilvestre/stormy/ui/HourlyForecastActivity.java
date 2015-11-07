package filipesilvestre.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.Arrays;


import butterknife.Bind;
import butterknife.ButterKnife;

import filipesilvestre.stormy.R;
import filipesilvestre.stormy.adapters.HourAdapter;
import filipesilvestre.stormy.weather.Hour;

public class HourlyForecastActivity extends AppCompatActivity {

    private Hour[] mHours;
    @Bind(R.id.emptyLabel) TextView mEmptyLabel;

    @Bind(R.id.reyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
            mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);

            HourAdapter adapter = new HourAdapter(this, mHours);
            mRecyclerView.setAdapter(adapter);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(layoutManager);

            mRecyclerView.setHasFixedSize(true);
        } else {
            mEmptyLabel.setText("There is no data to display.");
        }

    }

}
