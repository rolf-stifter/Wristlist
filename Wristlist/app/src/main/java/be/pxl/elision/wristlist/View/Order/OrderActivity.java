package be.pxl.elision.wristlist.View.Order;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Arrays;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.Model.Orders.DummyProduct;
import be.pxl.elision.wristlist.Model.Profile.Address;
import be.pxl.elision.wristlist.Model.Profile.Region;
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;

/**
 * @Author by Stephane Oris
 */

public class OrderActivity extends BaseDrawerActivity {
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppBar(R.layout.app_bar_default);
        getLayoutInflater().inflate(R.layout.activity_order, (FrameLayout) findViewById(R.id.baseFrame));


//        String name = getIntent().getStringExtra("Orders");
        setToolbarTitle("Order details");

        FragmentManager manager = getFragmentManager();
        OrderFragment of = (OrderFragment) manager.findFragmentById(R.id.fragment_order);
        OrderDetailFragment odf = (OrderDetailFragment) manager.findFragmentById(R.id.fragment_order_detail);
//        data
        DummyOrder dummyOrder = new DummyOrder();
        dummyOrder.setName("Bestelling 3");
        dummyOrder.setDate("01/01/2017");
        dummyOrder.setStatus("In verwerking");
        dummyOrder.setPrice(899.99);

        Address a = new Address();
        a.setLine1("Ven 26");
        a.setTown("Maaseik");
        Region r = new Region();
        r.setName("Limburg");
        a.setRegion(r);
        dummyOrder.setAddress(a);

        DummyProduct p1 = new DummyProduct();
        p1.setName("T-shirt");
        p1.setPrice(19.99);

        DummyProduct p2 = new DummyProduct();
        p2.setName("Horloge APD789");
        p2.setPrice(99.99);

        DummyProduct p3 = new DummyProduct();
        p3.setName("Tv Samsung 158");
        p3.setPrice(559.99);

        DummyProduct p4 = new DummyProduct();
        p4.setName("Napoleon Lemon 100st");
        p4.setPrice(9.99);
        DummyProduct[] products3 = {p1,p2,p3,p4,p1,p2};
        dummyOrder.setOrders( new ArrayList<DummyProduct>(Arrays.asList(products3)));
        of.NewData(dummyOrder.getOrders());
        odf.NewData(dummyOrder);
    }

    /**
     * set selected navigation item on 2
     */
    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        this.setSelectedNavigationItem(2);
    }
}
