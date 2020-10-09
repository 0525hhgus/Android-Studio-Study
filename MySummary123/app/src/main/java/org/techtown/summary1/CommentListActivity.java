package org.techtown.summary1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CommentListActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);

        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setTitle("한줄평 목록");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        listView = (ListView) findViewById(R.id.listView);

        final CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, 1));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, 2));
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, 3));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, 4));
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, 5));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, (float)1.5));
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, (float)2.5));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1, (float)3.5));
        listView.setAdapter(adapter);

        Button write = (Button) findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "작성하기 선택", Toast.LENGTH_LONG).show();
                showCommentWriteActivity();
            }
        });

    }

    public void showCommentWriteActivity() {
        Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
        startActivityForResult(intent, 101);
    }


    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CommentItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            CommentitemView view = null;
            if (view == null) {
                view = new CommentitemView(getApplicationContext());
            } else {
                view = (CommentitemView) view;
            }

            CommentItem item = items.get(position);
            view.setUserIdView(item.getId());
            view.setUserTimeView(item.getTime());
            view.setUserComment(item.getComment());
            view.setUserImageView(item.getResId());
            view.setUserRating(item.getRating());

            return view;
        }
    }

}