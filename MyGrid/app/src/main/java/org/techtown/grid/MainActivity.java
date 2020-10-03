package org.techtown.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById((R.id.gridView));


        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대", "010-1000-1000", R.drawable.ic_launcher_foreground));
        adapter.addItem(new SingerItem("걸스데이", "010-2000-2000", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("여자친구", "010-3000-2000", R.drawable.ic_launcher_foreground));
        adapter.addItem(new SingerItem("티아라", "010-4000-3000", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("애프터스쿨", "010-5000-4000", R.drawable.ic_launcher_foreground));
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            SingerItemView view2 = null;
            if (view == null) {
                view2 = new SingerItemView(getApplicationContext());
            } else {
                view2 = (SingerItemView) view;
            }

            SingerItem item = items.get(i);
            view2.setName(item.getName());
            view2.setMobile(item.getMobile());
            view2.setImage(item.getResId());

            return view2;
        }
    }
}