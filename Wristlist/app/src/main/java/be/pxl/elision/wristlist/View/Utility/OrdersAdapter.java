package be.pxl.elision.wristlist.View.Utility;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.Order.OrderActivity;


/**
 * @Author by Stephane Oris
 */
public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
    private DummyOrder[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView titleTextView, statusTextView, dateTextView;

        /**
         *
         * @param v
         */
        public ViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.row_title);
            statusTextView = (TextView) v.findViewById(R.id.row_status);
            dateTextView = (TextView) v.findViewById(R.id.row_date);
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param myDataset
     */
    public OrdersAdapter(DummyOrder[] myDataset) {
        mDataset = myDataset;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orders_row, parent, false);

        return new ViewHolder(itemView);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        DummyOrder order = mDataset[position];
        holder.titleTextView.setText(order.getName());
        holder.statusTextView.setText(order.getStatus());
        holder.dateTextView.setText(order.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent order = new Intent(v.getContext(), OrderActivity.class);
                order.putExtra("Orders", mDataset[position].getName());
                //Todo pass one Order
                v.getContext().startActivity(order);
            }
        });

    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
