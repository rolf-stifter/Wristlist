package be.pxl.elision.wristlist.View.Orders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import be.pxl.elision.wristlist.Model.Orders.DummyOrder;
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.Order.OrderActivity;

/**
 * @Author by Stephane Oris
 */

public class OrderCardsAdapter extends RecyclerView.Adapter<OrderCardsAdapter.CardViewHolder> {
    private DummyOrder[] mDataset;
    private RecyclerView.LayoutManager mLayoutManager;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView titleTextView;
        ImageView iconImageView;
        LinearLayout detailsCard;
        ListView productsListview;
        LinearLayout cardHeaderLinearLayout;

        /**
         * @param v
         */
        public CardViewHolder(View v) {
            super(v);
            //Card header
            cardHeaderLinearLayout = (LinearLayout) v.findViewById(R.id.card_header);
            titleTextView = (TextView) v.findViewById(R.id.card_title);
            iconImageView = (ImageView) v.findViewById(R.id.card_icon);
            iconImageView.setImageResource(R.drawable.ic_shopping_cart_white);

            //Card detail
            //inflate recyclerview for the products
            detailsCard = (LinearLayout) v.findViewById(R.id.card_information);
            LayoutInflater vi = (LayoutInflater) detailsCard.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            productsListview = new ListView(detailsCard.getContext());
            //Listview
            //layout
            //width match_parent / height wrap_content
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                    AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
            productsListview.setLayoutParams(params);
//            productsListview.setMinimumHeight(260);
            //Add listview to card
            detailsCard.addView(productsListview);
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param myDataset
     */
    public OrderCardsAdapter(DummyOrder[] myDataset) {
        mDataset = myDataset;
    }

    public OrderCardsAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new OrderCardsAdapter.CardViewHolder(itemView);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(OrderCardsAdapter.CardViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        DummyOrder order = mDataset[position];
        holder.titleTextView.setText(order.getName());

        //Go to orderview
        holder.cardHeaderLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent order = new Intent(v.getContext(), OrderActivity.class);
                order.putExtra("Orders", mDataset[position].getName());
                //Todo pass one Order
                v.getContext().startActivity(order);
            }
        });


        //List of products size
        LinearLayout.LayoutParams params;// = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        int h;
        switch (order.getOrders().size()) {
            case 1:
                h = Math.round(holder.detailsCard.getResources().getDimension(R.dimen.list_1_items));
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                break;
            case 2:
                h = Math.round(holder.detailsCard.getResources().getDimension(R.dimen.list_2_items));
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                break;
            case 3:
                h = Math.round(holder.detailsCard.getResources().getDimension(R.dimen.list_3_items));
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                break;
            case 4:
                h = Math.round(holder.detailsCard.getResources().getDimension(R.dimen.list_4_items));
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                break;
            default:          //If more then 4 products: visible products 4.5 (scroll)
                h = Math.round(holder.detailsCard.getResources().getDimension(R.dimen.list_5_items));
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                break;
        }

//
        holder.productsListview.setLayoutParams(params);
        holder.productsListview.setDivider(null);

        ProductAdapter adapter = new ProductAdapter(holder.productsListview, order.getOrders());
        holder.productsListview.setAdapter(adapter);

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
