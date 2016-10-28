package com.example.angel.moon_text.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angel.moon_text.R;
import com.example.angel.moon_text.info.PhoneInfo;

import java.util.Collection;
import java.util.List;

/**
 * Created by Angel on 2016/10/28.
 */

public class TwoRAdapter extends RecyclerView.Adapter<TwoRAdapter.ViewHolder> {
    private Context context;
    private List<PhoneInfo.ResultBean> list;
    public TwoRAdapter(Context context) {
        this.context=context;
    }
    public void addData(Collection<PhoneInfo.ResultBean> list){
        list.addAll(list);
        notifyDataSetChanged();
    }
    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }
    @Override
    public TwoRAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_recycleview_item, null);
          return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TwoRAdapter.ViewHolder holder, int position) {
         holder.citname.setText(list.get(position).getCity());
        holder.day.setText(list.get(position).getCard());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView citname,day,maxW,minW;
        public ViewHolder(View itemView) {
            super(itemView);
            citname = (TextView) itemView.findViewById(R.id.two_item_citname);
            day = (TextView) itemView.findViewById(R.id.two_item_day);
            maxW = (TextView) itemView.findViewById(R.id.two_item_maxW);
            minW = (TextView) itemView.findViewById(R.id.two_item_minW);
        }
    }
}
