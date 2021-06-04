package com.example.persistencedonnee_bddmysql;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidAdapter extends ArrayAdapter<User> {
    private int viewRes;
    private Context context;
    private ArrayList<User> UserList;

    public AndroidAdapter(Context context, int textViewResourceId, ArrayList<User> versions) {
        super(context,textViewResourceId, versions);
        this.UserList = versions;
        this.context = context;
        this.viewRes = textViewResourceId;
    }

    static class ViewHolder {
        TextView username;
        TextView email;
        TextView localite;
        TextView ddn;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes,parent,false);
            holder = new ViewHolder();
            holder.username = (TextView)view.findViewById(R.id.UsernameItem);
            holder.email = (TextView)view.findViewById(R.id.EmailItem);
            holder.localite = (TextView)view.findViewById(R.id.LocaliteItem);
            holder.ddn = (TextView)view.findViewById(R.id.DdnItem);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        final User User = UserList.get(position);
        if (User != null) {
            holder.username.setText(User.getUsername());
            holder.email.setText(User.getEmail());
            holder.localite.setText(User.getLocalite());
            holder.ddn.setText(User.getDdn());
        }
        return view;
    }

    public int getCount() {
        return UserList.size();
    }
}
