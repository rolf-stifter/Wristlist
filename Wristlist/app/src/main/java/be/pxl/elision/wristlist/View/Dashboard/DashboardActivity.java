package be.pxl.elision.wristlist.View.Dashboard;

import android.os.Bundle;

import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;

public class DashboardActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_dashboard, frameLayout);

        setTitle("Dashboard");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        navigationView.getMenu().getItem(0).setChecked(true);
    }

}
