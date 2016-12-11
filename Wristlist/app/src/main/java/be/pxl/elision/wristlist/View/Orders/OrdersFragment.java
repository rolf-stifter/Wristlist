package be.pxl.elision.wristlist.View.Orders;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.Model.Orders.DummyProduct;
import be.pxl.elision.wristlist.R;

/**
 * Created by 11400081 on 9/12/2016.
 */

public class OrdersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<DummyOrder> ordersList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.recyclerview_order, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.order_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[] myDataset = {"Bestelling 1", "Bestelling 2", "Bestelling 3"};

        DummyOrder x = new DummyOrder();
        x.setName("Bestelling 1");
        x.setDate("24/12/2016");
        x.setStatus("Verzonden");

        DummyOrder y = new DummyOrder();
        y.setName("Bestelling 2");
        y.setDate("30/12/2016");
        y.setStatus("In verwerking");

        DummyOrder z = new DummyOrder();
        z.setName("Bestelling 3");
        z.setDate("01/01/2017");
        z.setStatus("In verwerking");

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

        DummyProduct[] products1 = {p1,p2};
        DummyProduct[] products2 = {p1, p2, p3};
        DummyProduct[] products3 = {p1,p2,p3,p4,p1,p2};

        x.setOrders( new ArrayList<DummyProduct>(Arrays.asList(products1)));
        y.setOrders( new ArrayList<DummyProduct>(Arrays.asList(products2)));
        z.setOrders( new ArrayList<DummyProduct>(Arrays.asList(products3)));
        DummyOrder[] orders = {x, y, z, x,y,z,x,x};
        mAdapter = new OrderCardsAdapter(orders);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
