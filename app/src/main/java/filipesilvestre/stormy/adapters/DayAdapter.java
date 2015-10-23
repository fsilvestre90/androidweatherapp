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
        ViewHolder holder;

        if(convertView == null) {
            //this view is BRAND NEW
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.daily_list_item, null); //give the layout we want to inflate
            //create the container
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayNameLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            //sets the tag we will use below
            convertView.setTag(holder);
        } else {
            // because the holder is assoc with the view, if we call getTag we just need to cast as ViewHolder
            holder = (ViewHolder) convertView.getTag();
        }
        return null;
    }

    private static class ViewHolder {
        //public by default
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayNameLabel;
    }
}
