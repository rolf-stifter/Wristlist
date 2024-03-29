package be.pxl.elision.wristlist.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.Dashboard.DashboardActivity;
import be.pxl.elision.wristlist.View.Login.LoginActivity;
import be.pxl.elision.wristlist.View.Orders.OrdersActivity;
import be.pxl.elision.wristlist.View.Profile.ProfileActivity;

/**
 * @author Timothy Vanderaerden
 */

public abstract class BaseDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout appBarFrameLayout;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_drawer);

        appBarFrameLayout = (FrameLayout) findViewById(R.id.appBarFrame);
    }

    /**
     * Set the appbar layout
     * @param layout
     */
    protected void setAppBar(int layout){
        getLayoutInflater().inflate(layout, appBarFrameLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * Set the toolbar title
     * @param title
     */
    protected void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    /**
     * Highlight  menu item
     * @param item
     */
    protected void setSelectedNavigationItem(int item) {
        navigationView.getMenu().getItem(item).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (item.isChecked()){
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }

        switch (id) {
            case R.id.nav_dashboard:
                Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(dashboard);
                break;
            case R.id.nav_profile:
                Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(profile);
                break;
            case R.id.nav_orders:
                Intent orders = new Intent(getApplicationContext(), OrdersActivity.class);
                startActivity(orders);
                break;
            case R.id.nav_sign_off:
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
        }
        this.overridePendingTransition(0, 0);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
