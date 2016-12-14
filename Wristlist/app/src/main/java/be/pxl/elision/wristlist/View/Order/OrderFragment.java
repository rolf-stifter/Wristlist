package be.pxl.elision.wristlist.View.Order;

import android.app.Fragment;
import android.content.Intent;
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
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.Orders.OrdersActivity;


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

        DummyProduct p1 = new DummyProduct();
        p1.setName("T-shirt");
        p1.setPrice(19.99);

        DummyProduct[] products = {p1};
        dummyOrder.setOrders( new ArrayList<DummyProduct>(Arrays.asList(products)));

        //Card
        View card = getActivity().getLayoutInflater().inflate(R.layout.card_view, null);
        title = (TextView) card.findViewById(R.id.card_title);
//        title.setText(dummyOrder.getName());
        title.setText("Order");
        ImageView icon = (ImageView) card.findViewById(R.id.card_icon);
        icon.setImageResource(R.drawable.ic_shopping_cart_white);

        //Details
        LinearLayout details = (LinearLayout) card.findViewById(R.id.card_information);
        View childDetails = getActivity().getLayoutInflater().inflate(R.layout.orders_card, null);

        //Click header card
        LinearLayout header = (LinearLayout) card.findViewById(R.id.card_header);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getActivity(), OrdersActivity.class);
                startActivity(profile);
            }
        });
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
     * @param name
     */
    public void NewData(List<DummyProduct> products, String name ) {
        mAdapter = new ProductRecyclerViewAdapter(products);
        mRecyclerView.setAdapter(mAdapter);
        title.setText(name);
    }
}
