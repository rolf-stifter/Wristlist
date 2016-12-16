package be.pxl.student.wristlist.View.Main;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import be.pxl.student.wristlist.R;
import be.pxl.student.wristlist.View.Main.Model.MenuItem;

/**
 * Created by 11400081 on 15/12/2016.
 */
public class MenuItemAdapter extends WearableRecyclerView.Adapter<MenuItemAdapter.ViewHolder> {

    private ArrayList<MenuItem> data;
    private Context context;
    private ItemSelectedListener itemSelectedListener;

    public MenuItemAdapter(Context context, ArrayList<MenuItem> data) {
        this.context = context;
        this.data = data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text_item);
            imageView = (ImageView) view.findViewById(R.id.item_image);

        }

        void bind(final int position, final ItemSelectedListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemSelected(position);;
                    }
                }
            });
        }
    }

    public void setListener(ItemSelectedListener itemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener;
    }

    @Override
    public MenuItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_curved_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MenuItemAdapter.ViewHolder holder, final int position) {
        if (data != null && !data.isEmpty()) {
//            holder.textView.setText(data.get(position).getTitle());
//            holder.imageView.setImageResource(data.get(position).getImage());
            holder.textView.setText(data.get(position).getTitle());
            holder.imageView.setImageResource(data.get(position).getImage());
            holder.imageView.setBackgroundTintList(
                    new ColorStateList(new int[][]{new int[]{0}}, new int[]{ContextCompat.getColor(holder.itemView.getContext(), R.color.blue)}));
            holder.bind(position, itemSelectedListener);
        }
    }

    @Override
    public int getItemCount() {
        if (data != null && !data.isEmpty()) {
            return data.size();
        }
        return 0;
    }

    public interface ItemSelectedListener {
        void onItemSelected(int position);
    }
}
