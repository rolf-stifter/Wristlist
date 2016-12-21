package be.pxl.elision.wristlist.View.Order;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.Model.Orders.DummyProduct;
import be.pxl.elision.wristlist.Model.Profile.Address;
import be.pxl.elision.wristlist.Model.Profile.Region;
import be.pxl.elision.wristlist.R;

/**
 * Created by 11400081 on 21/12/2016.
 */

public class OrderDetailFragment extends Fragment{
    View view;

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

        //Order status details

        view = inflater.inflate(R.layout.order_details, null);
        NewData(dummyOrder);

        return view;
    }

    public void NewData(DummyOrder dummyOrder) {
        if (dummyOrder.getName()!=null){
            ((TextView)view.findViewById(R.id.order_detail_title)).setText(dummyOrder.getName());
        }
        else
        {
            ((TextView)view.findViewById(R.id.order_detail_title)).setText("Order");
        }

        if(dummyOrder.getStatus()!=null){
            ((TextView)view.findViewById(R.id.order_detail_status)).setText(dummyOrder.getStatus());
        }else {
            ((TextView)view.findViewById(R.id.order_detail_status)).setText("");
        }

        if(dummyOrder.getPrice()!=null){
            ((TextView)view.findViewById(R.id.order_detail_price)).setText("€ " +dummyOrder.getPrice());
        }else {
            ((TextView)view.findViewById(R.id.order_detail_price)).setText("€ NaN");
        }

        if(dummyOrder.getDate()!=null){
            ((TextView)view.findViewById(R.id.order_detail_date)).setText(dummyOrder.getDate());
        }else {
            ((TextView)view.findViewById(R.id.order_detail_date)).setText("??/??/????");
        }

        if(dummyOrder.getAddress()!=null){
            ((TextView)view.findViewById(R.id.order_detail_street_number)).setText(dummyOrder.getAddress().getLine1());
            ((TextView)view.findViewById(R.id.order_detail_country)).setText(dummyOrder.getAddress().getRegion().getName());
            ((TextView)view.findViewById(R.id.order_detail_city)).setText(dummyOrder.getAddress().getTown());
        }else {
            ((TextView)view.findViewById(R.id.order_detail_street_number)).setText("Unknown Address");
            ((TextView)view.findViewById(R.id.order_detail_country)).setText("");
            ((TextView)view.findViewById(R.id.order_detail_city)).setText("");

        }

    }
}
