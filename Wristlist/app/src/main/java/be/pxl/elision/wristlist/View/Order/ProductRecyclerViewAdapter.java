package be.pxl.elision.wristlist.View.Order;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import be.pxl.elision.wristlist.Model.Orders.DummyProduct;
import be.pxl.elision.wristlist.R;

/**
 * @Author by Stephane Oris
 */
public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {
    private List<DummyProduct> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView productNameTextView, productPriceTextView;

        /**
         *
         * @param v
         */
        public ViewHolder(View v) {
            super(v);
            productNameTextView = (TextView) v.findViewById(R.id.row_name);
            productPriceTextView = (TextView) v.findViewById(R.id.row_price);
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param myDataset
     */
    public ProductRecyclerViewAdapter(List<DummyProduct> myDataset) {
        mDataset = myDataset;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    public ProductRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_row, parent, false);

        return new ProductRecyclerViewAdapter.ViewHolder(itemView);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ProductRecyclerViewAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        DummyProduct p = mDataset.get(position);
        holder.productNameTextView.setText(p.getName());
        holder.productPriceTextView.setText("€ " + p.getPrice());

    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
