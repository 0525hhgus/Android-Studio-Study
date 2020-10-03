package org.techtown.summary1;

public class CommentItem {
    String id;
    String time;
    String comment;
    int resId;

    public CommentItem(String id, String time, String comment, int resId) {
        this.id = id;
        this.time = time;
        this.comment = comment;
        this.resId = resId;
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
