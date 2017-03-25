package com.example.ncrsoft.zopac.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.fragment.ElectronicsFragment;
import com.example.ncrsoft.zopac.utils.CharecterEncode;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by NcrSoft on 24-Mar-17.
 */

public class OtherRecycleViewAdapter extends RecyclerView.Adapter<OtherRecycleViewAdapter.RecyclerviewHolder> {


    Context context;
    LayoutInflater inflater;
    ArrayList<ElectronicsFragment.MyPojo> arrayList;
    RecyclerviewHolder recyclerviewHolder;

    public OtherRecycleViewAdapter(Context context, ArrayList<ElectronicsFragment.MyPojo> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);


    }


    @Override
    public RecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_to_mainlist_item, parent, false);
        RecyclerviewHolder recyclerviewHolder = new RecyclerviewHolder(view, viewType);
        return recyclerviewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerviewHolder holder, int position) {
        final ElectronicsFragment.MyPojo gridItem = arrayList.get(position);

        try {
            holder.title.setText(CharecterEncode.decodeChar(gridItem.getCategoryName()));
            holder.l_name.setText(CharecterEncode.decodeChar(gridItem.getCategoryId()));
       /*     Picasso.with(context).load(gridItem.getImage()).placeholder(R.drawable.placeholder)
                    .into(holder.imageView);
*/
        } catch (Exception e) {
            Log.e("image other", "-- " + e.getMessage());

        }
    }
    @Override
    public int getItemCount() {
        return 0;
    }
    public static class RecyclerviewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, l_name, l_parentt;
        int viewType;
        LinearLayout childGridLeftLayout;
        private final Context context;

        public RecyclerviewHolder(View view, int viewType) {
            super(view);
            view.setClickable(true);
            context = view.getContext();
            childGridLeftLayout = (LinearLayout) view.findViewById(R.id.gridMoreLayout);
            imageView = (ImageView) view.findViewById(R.id.imagesssss);
            title = (TextView) view.findViewById(R.id.titlessssss);
            l_name = (TextView) view.findViewById(R.id.sluggggggg);
        }
    }
}
