package be.pxl.student.wristlist.View.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableRecyclerView;

import java.util.ArrayList;

import be.pxl.student.wristlist.R;
import be.pxl.student.wristlist.View.Main.Model.MenuItem;
import be.pxl.student.wristlist.View.Main.Utility.OffsettingHelper;

/**
 * @author Timothy Vanderaerden
 */
public class MainActivity extends WearableActivity implements MenuItemAdapter.ItemSelectedListener{
    private WearableRecyclerView wearableRecyclerView;
    private ArrayList<MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wearableRecyclerView = (WearableRecyclerView) findViewById(R.id.recycler_launcher_view);
        wearableRecyclerView.setHasFixedSize(true);

        OffsettingHelper offsettingHelper = new OffsettingHelper();

        wearableRecyclerView.setOffsettingHelper(offsettingHelper);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Profile", R.drawable.ic_person_blue, new Intent(MainActivity.this, TestActivity.class)));
        menuItems.add(new MenuItem("Orders", R.drawable.ic_shopping_cart_blue, new Intent(MainActivity.this, TestActivity.class)));
        menuItems.add(new MenuItem("Best selling!", R.drawable.ic_star_blue, new Intent(MainActivity.this, TestActivity.class)));
        menuItems.add(new MenuItem("What's new?", R.drawable.ic_whatshot_blue, new Intent(MainActivity.this, TestActivity.class)));

        MenuItemAdapter adapter = new MenuItemAdapter(MainActivity.this, menuItems);
        wearableRecyclerView.setAdapter(adapter);
        adapter.setListener(this);


    }


    @Override
    public void onItemSelected(int position) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
