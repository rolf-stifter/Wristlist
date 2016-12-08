package be.pxl.elision.wristlist.View.Dashboard;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import be.pxl.elision.wristlist.R;

/**
 * Created by 11400081 on 8/12/2016.
 */

public class OrdersCardFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //Card
        View card = getActivity().getLayoutInflater().inflate(R.layout.card_view, null);
        TextView title = (TextView) card.findViewById(R.id.card_title);
        title.setText("Bestellingen");
        ImageView icon = (ImageView) card.findViewById(R.id.card_icon);
        icon.setImageResource(R.drawable.ic_shopping_cart_white);

        //Details
        LinearLayout details = (LinearLayout) card.findViewById(R.id.card_information);
        View childDetails = getActivity().getLayoutInflater().inflate(R.layout.profile_card, null);


        details.addView(childDetails);
        return card;
//        return inflater.inflate(R.layout.card_view, container, false);
    }

}
