package org.techtown.summary1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView likeCountView;
    Button likeButton;
    TextView hateCountView;
    Button hateButton;

    int likeCount = 15;
    boolean likeState = false;

    int hateCount = 1;
    boolean hateState = false;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeCountView = (TextView) findViewById(R.id.likeCountView);
        likeButton = (Button) findViewById(R.id.likeButton);
        hateCountView = (TextView) findViewById(R.id.hateCountView);
        hateButton = (Button) findViewById(R.id.hateButton);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState) {
                    decrLikeCount();
                } else {
                    if (hateState) {
                        decrHateCount();
                        hateState = !hateState;
                    }
                    incrLikeCount();
                }

                likeState = !likeState;
            }
        });


        hateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hateState) {
                    decrHateCount();
                } else {
                    if (likeState) {
                        decrLikeCount();
                        likeState = !likeState;
                    }
                    incrHateCount();
                }

                hateState = !hateState;
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym71**", "10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym72**", "20분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        listView.setAdapter(adapter);

        Button write = (Button) findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "작성하기 선택", Toast.LENGTH_LONG).show();
                showCommentWriteActivity();
            }
        });

        Button showAll = (Button) findViewById(R.id.showAll);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "모두보기 선택", Toast.LENGTH_LONG).show();
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

            return view;
        }
    }

    public void incrLikeCount() {
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.thumb_up);
    }

    public void incrHateCount() {
        hateCount += 1;
        hateCountView.setText(String.valueOf(hateCount));

        hateButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrHateCount() {
        hateCount -= 1;
        hateCountView.setText(String.valueOf(hateCount));

        hateButton.setBackgroundResource(R.drawable.thumb_down);
    }

}