package filipesilvestre.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import filipesilvestre.stormy.R;
import filipesilvestre.stormy.adapters.DayAdapter;
import filipesilvestre.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;
    private String mCityName;

    @Bind(R.id.locationLabel) TextView mLocationLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this); //inject all the view objects into this controller

        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
            mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);
            mCityName = intent.getStringExtra(MainActivity.CITY_NAME);
            DayAdapter adapter = new DayAdapter(this, mDays);
            setListAdapter(adapter);
            mLocationLabel.setText(mCityName + "");
        } else {
            mLocationLabel.setText("");
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String maxTemp = mDays[position].getTemperatureMax() + "";
        String message = String.format("%s has a high of %s and %s",
                dayOfWeek,
                maxTemp,
                conditions);


        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
