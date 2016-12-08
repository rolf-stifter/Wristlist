package be.pxl.elision.wristlist.View.Dashboard;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import be.pxl.elision.wristlist.Model.Profile.Address;
import be.pxl.elision.wristlist.Model.Profile.User;
import be.pxl.elision.wristlist.R;

/**
 * Created by 11400081 on 8/12/2016.
 */

public class ProfileCardFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        User u = new User();
        u.setFirstName("Stephane");
        u.setLastName("Oris");

        //address
        Address a = new Address();
        a.setTown("Maaseik");
        a.setPhone("+32 470 69 55 15");
        a.setLine1("Ven 26");
        u.setDefaultAddress(a);
        //Card
        View card = getActivity().getLayoutInflater().inflate(R.layout.card_view, null);
        TextView title = (TextView) card.findViewById(R.id.card_title);
        title.setText("Uw gegevens");
        ImageView icon = (ImageView) card.findViewById(R.id.card_icon);
        icon.setImageResource(R.drawable.ic_person_white);

        //Details
        LinearLayout details = (LinearLayout) card.findViewById(R.id.card_information);
        View childDetails = getActivity().getLayoutInflater().inflate(R.layout.profile_card, null);
        TextView name = (TextView) childDetails.findViewById(R.id.card_profile_name);
        TextView city = (TextView) childDetails.findViewById(R.id.card_profile_address);
        TextView phone = (TextView) childDetails.findViewById(R.id.card_profile_phone);

        String username = u.getFirstName() + " " + u.getLastName();
        name.setText(username);
        String location = u.getDefaultAddress().getLine1() + ", " + u.getDefaultAddress().getTown();
        city.setText(location);
        phone.setText(u.getDefaultAddress().getPhone());

        details.addView(childDetails);
        return card;
//        return inflater.inflate(R.layout.card_view, container, false);
    }
}
