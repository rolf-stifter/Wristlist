package be.pxl.elision.wristlist.View.Dashboard;

import android.os.Bundle;
import android.widget.FrameLayout;

import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;

public class DashboardActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppBar(R.layout.app_bar_default);
        getLayoutInflater().inflate(R.layout.activity_dashboard, (FrameLayout) findViewById(R.id.baseFrame));

        setToolbarTitle("Dashboard");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        this.setSelectedNavigationItem(0);
    }

}
