package org.techtown.summary1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentitemView extends LinearLayout {

    TextView userIdView;
    TextView userTimeView;
    TextView userComment;
    ImageView userImageView;
    RatingBar userRatingView;

    public CommentitemView(Context context) {
        super(context);

        init(context);
    }

    public CommentitemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        userIdView = (TextView) findViewById(R.id.userIdView);
        userTimeView = (TextView) findViewById(R.id.userTimeView);
        userComment = (TextView) findViewById(R.id.userComment);
        userImageView = (ImageView) findViewById(R.id.userImageView);
        userRatingView = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void setUserIdView(String userId) {
        userIdView.setText(userId);
    }

    public void setUserTimeView(String time) {
        userTimeView.setText(time);
    }

    public void setUserComment(String comment) {
        userComment.setText(comment);
    }

    public void setUserImageView(int resId) { userImageView.setImageResource(resId); }

    public void setUserRating(float userRating) {userRatingView.setRating(userRating); }
}
