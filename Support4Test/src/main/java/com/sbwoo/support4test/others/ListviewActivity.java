package com.sbwoo.support4test.others;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sbwoo.support4test.R;

public class ListviewActivity extends ListActivity {
    private static final String EMPTY[] = {};
    private static final String CHEESES[] = {
            "Abbaye de Belloc",
            // ...
            "Zanetti Parmigiano Reggiano"
    };

    private CheeseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
    }

    public void onSetEmpty(View v) {
        mAdapter.changeData(EMPTY);
    }

    public void onSetData(View v) {
        mAdapter.changeData(CHEESES);
    }

    private class CheeseAdapter extends BaseAdapter {

        private String[] mData;

        public CheeseAdapter(String[] data) {
            mData = data;
        }

        public void changeData(String[] data) {
            mData = data;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mData.length;
        }

        @Override
        public String getItem(int position) {
            return mData[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.text_item, parent, false);
            }

            ((TextView) convertView).setText(getItem(position));

            return convertView;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listvew, menu);
        return true;
    }
    
}
