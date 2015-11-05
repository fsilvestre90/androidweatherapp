package filipesilvestre.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import filipesilvestre.stormy.R;
import filipesilvestre.stormy.weather.Day;

/**
 * Created by filipesilvestre on 10/23/15.
 */
public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder; // view lookup cache stored in tag

        // Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            //this view is BRAND NEW
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.daily_list_item, null); //give the layout we want to inflate
            holder = new ViewHolder(); //create the container
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayNameLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            convertView.setTag(holder); //sets the tag we will use below
        } else {
            // because the holder is assoc with the view, if we call getTag we just need to cast as ViewHolder
            holder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        Day day = mDays[position]; //get the individual day to assign below
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        holder.dayNameLabel.setText(day.getDayOfTheWeek());
        // Return the completed view to render on screen
        return convertView;
    }

    private static class ViewHolder {
        //public by default
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayNameLabel;
    }
}
