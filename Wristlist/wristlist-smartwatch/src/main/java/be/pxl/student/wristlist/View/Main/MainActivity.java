package be.pxl.student.wristlist.View.Main;

import android.content.Context;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.drawer.WearableActionDrawer;
import android.support.wearable.view.drawer.WearableDrawerLayout;
import android.support.wearable.view.drawer.WearableNavigationDrawer;
import android.view.Gravity;
import android.view.MenuItem;

import be.pxl.student.wristlist.R;

/**
 * @author Timothy Vanderaerden
 */
public class MainActivity extends WearableActivity implements WearableActionDrawer.OnMenuItemClickListener {
    private WearableDrawerLayout mWearableDrawerLayout;
    private WearableNavigationDrawer mWearableNavigationDrawer;
    private WearableActionDrawer mWearableActionDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWearableDrawerLayout = (WearableDrawerLayout) findViewById(R.id.drawer_layout);
        mWearableDrawerLayout.peekDrawer(Gravity.BOTTOM);
        mWearableDrawerLayout.peekDrawer(Gravity.TOP);

        mWearableNavigationDrawer = (WearableNavigationDrawer) findViewById(R.id.top_navigation_drawer);

        mWearableDrawerLayout.peekDrawer(Gravity.TOP);

        // Bottom Action Drawer
        mWearableActionDrawer = (WearableActionDrawer) findViewById(R.id.bottom_action_drawer);


        mWearableActionDrawer.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
