package be.pxl.elision.wristlist.View.Dashboard;

import android.os.Bundle;
import android.widget.FrameLayout;

import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        this.setSelectedNavigationItem(0);
    }

}
