package be.pxl.elision.wristlist.View.Order;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.Model.Orders.DummyProduct;
import be.pxl.elision.wristlist.Model.Profile.Address;
import be.pxl.elision.wristlist.Model.Profile.Region;
import be.pxl.elision.wristlist.R;


/**
 * @Author by Stephane Oris
 */
public class OrderFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView title;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


//        //data
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

        DummyProduct[] products = {p1};
        dummyOrder.setOrders( new ArrayList<DummyProduct>(Arrays.asList(products)));

        //Card
        View card = getActivity().getLayoutInflater().inflate(R.layout.card_view, null);
        title = (TextView) card.findViewById(R.id.card_title);
//        title.setText(dummyOrder.getName());
        title.setText("Products");
        ImageView icon = (ImageView) card.findViewById(R.id.card_icon);
        icon.setImageResource(R.drawable.ic_shopping_cart_white);

        //Details
        LinearLayout details = (LinearLayout) card.findViewById(R.id.card_information);
        View childDetails = getActivity().getLayoutInflater().inflate(R.layout.orders_card, null);

        //Click header card
        LinearLayout header = (LinearLayout) card.findViewById(R.id.card_header);

        //Order status details
        View childOrderDetails = getActivity().getLayoutInflater().inflate(R.layout.order_details, null);
        ((TextView)childOrderDetails.findViewById(R.id.order_detail_status)).setText(dummyOrder.getStatus());
        ((TextView)childOrderDetails.findViewById(R.id.order_detail_price)).setText("€ " +dummyOrder.getPrice());
        ((TextView)childOrderDetails.findViewById(R.id.order_detail_date)).setText(dummyOrder.getDate());
        ((TextView)childOrderDetails.findViewById(R.id.order_detail_street_number)).setText(dummyOrder.getAddress().getLine1());
        ((TextView)childOrderDetails.findViewById(R.id.order_detail_city)).setText(dummyOrder.getAddress().getTown());
        ((TextView)childOrderDetails.findViewById(R.id.order_detail_country)).setText(dummyOrder.getAddress().getRegion().getName());

        //Products
        mRecyclerView = (RecyclerView) childDetails.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ProductRecyclerViewAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        details.addView(childDetails);
        return card;
    }

    /**
     * Set Adapter with products and set card title with name
     * @param products
     */
    public void NewData(List<DummyProduct> products) {
        mAdapter = new ProductRecyclerViewAdapter(products);
        mRecyclerView.setAdapter(mAdapter);
    }
}
