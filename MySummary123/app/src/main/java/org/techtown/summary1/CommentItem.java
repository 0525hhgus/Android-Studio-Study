package org.techtown.summary1;

public class CommentItem {
    String id;
    String time;
    String comment;
    int resId;
    float rating;

    public CommentItem(String id, String time, String comment, int resId, float rating) {
        this.id = id;
        this.time = time;
        this.comment = comment;
        this.resId = resId;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "SingerItem{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", comment='" + comment + '\'' +
                ", resId=" + resId +
                '}';
    }
}
