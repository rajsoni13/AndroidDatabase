package com.raj.androiddatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactModel> contactModelArrayList;

    public MyBaseAdapter(Context context, ArrayList<ContactModel> contactModelArrayList) {
        this.context =context;
        this.contactModelArrayList = contactModelArrayList;
    }
    @Override
    public int getCount() {
        return contactModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



            convertView =  layoutInflater.inflate(R.layout.raw_list,null);


        TextView tvFname =(TextView)convertView.findViewById(R.id.tv_fna);
        TextView tvLname = (TextView)convertView.findViewById(R.id.Lna);

        tvFname.setText(contactModelArrayList.get(position).getFirstname());

        tvLname.setText(" "+contactModelArrayList.get(position).getLastname());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn = contactModelArrayList.get(position).getFirstname();
                String ln = contactModelArrayList.get(position).getLastname();
                String id = contactModelArrayList.get(position).getID();

                Intent i = new Intent(context, FinalActivity.class);

                i.putExtra("fnamekey",fn);
                i.putExtra("lnamekey",ln);
                i.putExtra("idkey",id);
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
