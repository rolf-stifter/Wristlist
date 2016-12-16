package be.pxl.student.wristlist.View.Main.Model;

import android.content.Intent;

/**
 * Created by 11400081 on 15/12/2016.
 */

public class MenuItem {

    public String title;
    public Intent activity;
    public int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Intent getActivity() {
        return activity;
    }

    public void setActivity(Intent activity) {
        this.activity = activity;
    }

    public MenuItem(String title, int image, Intent activity) {
        this.title = title;
        this.image = image;
        this.activity = activity;
    }
}
