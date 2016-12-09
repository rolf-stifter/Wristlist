package be.pxl.elision.wristlist.View.Dashboard;

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

import java.util.List;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.R;

/**
 * Created by 11400081 on 8/12/2016.
 */

public class OrdersCardFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<DummyOrder> ordersList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //Card
        View card = getActivity().getLayoutInflater().inflate(R.layout.card_view, null);
        TextView title = (TextView) card.findViewById(R.id.card_title);
        title.setText("Bestellingen");
        ImageView icon = (ImageView) card.findViewById(R.id.card_icon);
        icon.setImageResource(R.drawable.ic_shopping_cart_white);

        //Details
        LinearLayout details = (LinearLayout) card.findViewById(R.id.card_information);
        View childDetails = getActivity().getLayoutInflater().inflate(R.layout.orders_card, null);

        mRecyclerView = (RecyclerView) childDetails.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[] myDataset ={"Bestelling 1", "Bestelling 2", "Bestelling 3"};

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
        DummyOrder[] orders = {x, y, z};
        mAdapter = new OrdersAdapter(orders);
        mRecyclerView.setAdapter(mAdapter);


        details.addView(childDetails);
        return card;
    }

}
