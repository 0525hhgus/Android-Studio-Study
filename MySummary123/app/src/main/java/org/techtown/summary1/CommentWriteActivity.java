package org.techtown.summary1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.ArrayList;

public class CommentWriteActivity extends AppCompatActivity {
    RatingBar ratingBar;
    EditText contentsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        contentsInput = (EditText) findViewById(R.id.contentsInput);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                returnToMain(intent);
            }
        });

        Button cancleButton = (Button) findViewById(R.id.cancleButton);
        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent intent = getIntent();
        processIntent(intent);
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

    private void processIntent(Intent intent) {
        if (intent != null) {
            float rating = intent.getFloatExtra("rating", 0.0f);
            ratingBar.setRating(rating);
        }
    }

    public void returnToMain(Intent ratingIntent) {
        String contents = contentsInput.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("contents", contents);
        intent.putExtra("rating", ratingBar.getRating());

        setResult(RESULT_OK, intent);

        finish();
    }
}