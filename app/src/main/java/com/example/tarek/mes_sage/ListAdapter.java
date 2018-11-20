package com.example.tarek.mes_sage;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ListAdapter extends ArrayAdapter<Message> {
    private SparseBooleanArray selectedListItemsIds;
    List multipleSelectionList;

    public ListAdapter(Context context, int resource, List<Message> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_message, null);
        }

        final Message m = getItem(position);

        final ImageButton send = (ImageButton) v.findViewById(R.id.send_boolean);
        if(!m.isSend()){
            send.setColorFilter(android.R.color.darker_gray);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked ");
                if(m.isSend()){
                    m.setSend(false);
                    send.setColorFilter(android.R.color.darker_gray);
                }
                else{
                    m.setSend(true);
                    send.setColorFilter(Color.argb(255, 27, 52, 216));
                }
            }
        });

        if (m != null) {
            TextView tt1 = v.findViewById(R.id.list_name);
            TextView tt2 = v.findViewById(R.id.list_number);
            TextView tt3 = v.findViewById(R.id.list_frequency);
            TextView tt4 = v.findViewById(R.id.list_message);
            TextView tt5 = v.findViewById(R.id.list_date);
            TextView tt6 = v.findViewById(R.id.list_time);

            if (tt1 != null) {
                tt1.setText(m.getName());
            }
            if (tt2 != null) {
                tt2.setText(m.getPhoneNumber());
            }
            if (tt3 != null) {
                tt3.setText(m.getFrequency());
            }
            if (tt4 != null) {
                tt4.setText(m.getMessageText());
            }
            if (tt5 != null) {
                tt5.setText(m.getYear()+ "/" + m.getMonth()+"/"+ m.getDay());
            }
            if (tt6 != null) {
                tt6.setText(m.getHour()+":"+m.getMinute());
            }
        }
        return v;
    }
}
