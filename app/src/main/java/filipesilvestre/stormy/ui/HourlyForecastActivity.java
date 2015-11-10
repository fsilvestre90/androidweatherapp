package filipesilvestre.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;


import butterknife.Bind;
import butterknife.ButterKnife;

import filipesilvestre.stormy.R;
import filipesilvestre.stormy.adapters.HourAdapter;
import filipesilvestre.stormy.weather.Hour;

public class HourlyForecastActivity extends AppCompatActivity {
    public static final String TAG = HourlyForecastActivity.class.getSimpleName();
    private Hour[] mHours;
    @Bind(R.id.reyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        try {
            Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
            if (parcelables == null) {
                return;
            } else {
                //assign mHours to the daily forecast array
                mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);
                //attach the mHours array to the adapter for the view
                HourAdapter adapter = new HourAdapter(this, mHours);
                mRecyclerView.setAdapter(adapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                mRecyclerView.setLayoutManager(layoutManager);

                mRecyclerView.setHasFixedSize(true);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception caught: ", e);
        }
    }

}
