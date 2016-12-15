package be.pxl.elision.wristlist.View.Orders;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import be.pxl.elision.wristlist.Model.Orders.DummyProduct;
import be.pxl.elision.wristlist.R;

/**
 * @Author by Stephane Oris
 */
public class ProductAdapter extends ArrayAdapter<DummyProduct> {


    private final List<DummyProduct> products;
    private final Activity context;

    /**
     *
     * @param listView
     * @param products
     */
    public ProductAdapter(ListView listView, List<DummyProduct> products) {
        super(listView.getContext(), R.layout.product_row, products);

        this.context = (Activity) listView.getContext();
        this.products = products;
    }

    /**
     *
     * @param position
     * @param view
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.product_row, null, true);

        TextView productNameTextView = (TextView) rowView.findViewById(R.id.row_name);
        TextView productPriceTextView = (TextView) rowView.findViewById(R.id.row_price);

        productNameTextView.setText(products.get(position).getName());
        productPriceTextView.setText("€ " + products.get(position).getPrice());
        return rowView;

    }

    ;
}