package com.example.ncrsoft.zopac.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.activity.MyGridActivity;
import com.example.ncrsoft.zopac.fragment.LunchFragment;

import java.util.ArrayList;

/**
 * Created by NcrSoft on 23-Mar-17.
 */

public class ContactAdapter extends RecyclerView.Adapter <ContactAdapter.ContactViewHolder>{
    ArrayList<LunchFragment.Contact>contacts=new ArrayList<LunchFragment.Contact>();

    public ContactAdapter(ArrayList<LunchFragment.Contact>contacts){
        this.contacts=contacts;


    }




    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_to_mainlist,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        LunchFragment.Contact contact=contacts.get(position);
        holder.imageView.setImageResource(contact.getImage_id());
        holder.title.setText(contact.getName());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        public ContactViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.imagesssss);
            title= (TextView) view.findViewById(R.id.titlessssss);

        }
    }
}
