package be.pxl.elision.wristlist.View.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;

import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;
import be.pxl.elision.wristlist.View.Utility.NotificationHelper;

/**
 * @author Timothy Vander
 */
public class DashboardActivity extends BaseDrawerActivity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppBar(R.layout.app_bar_default);
        getLayoutInflater().inflate(R.layout.activity_dashboard, (FrameLayout) findViewById(R.id.baseFrame));

        setToolbarTitle("Dashboard");

        ((Button) findViewById(R.id.button_notification)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationHelper.showNotification(view.getContext(), R.drawable.logo, null, new Random().nextInt(), "Product in stock", "Product bbbbbb is in stock", new Intent(view.getContext(), DashboardActivity.class), new long[]{100,100,100,100,100}, new NotificationCompat.Action[]{});
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        this.setSelectedNavigationItem(0);
    }

}
