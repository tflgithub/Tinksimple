package com.cn.tink.simpledemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<ServerData> datas;
    private Context mContext;

    //建立枚举 2个item 类型
    public enum ITEM_TYPE {
        ITEM1,
        ITEM2
    }

    public RecyclerViewAdapter(Context context, List<ServerData> list) {
        this.datas = list;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void addAll(List<ServerData> list) {
        this.datas.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载Item View的时候根据不同TYPE加载不同的布局
        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
            return new Item1ViewHolder(mLayoutInflater.inflate(R.layout.item1, parent, false));
        } else{
            return new Item2ViewHolder(mLayoutInflater.inflate(R.layout.item2, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Item1ViewHolder) {
            ((Item1ViewHolder) holder).tv_title.setText(datas.get(position).title);
            ((Item1ViewHolder) holder).tv_content.setText(datas.get(position).content);
            Picasso.with(mContext).load(datas.get(position).image_url_1).placeholder(R.mipmap.ic_launcher).into(((Item1ViewHolder) holder).iv_logo);
        } else if (holder instanceof Item2ViewHolder) {
            Picasso.with(mContext).load(datas.get(position).image_url_1).placeholder(R.mipmap.ic_launcher).into(((Item2ViewHolder) holder).iv_one);
            Picasso.with(mContext).load(datas.get(position).image_url_2).placeholder(R.mipmap.ic_launcher).into(((Item2ViewHolder) holder).iv_two);
        }
    }

    //设置ITEM类型，可以自由发挥，这里设置item position单数显示item1 偶数显示item2
    @Override
    public int getItemViewType(int position) {
        //Enum类提供了一个ordinal()方法，返回枚举类型的序数，这里ITEM_TYPE.ITEM1.ordinal()代表0， ITEM_TYPE.ITEM2.ordinal()代表1
        return datas.get(position).type == 1 ? ITEM_TYPE.ITEM1.ordinal() : ITEM_TYPE.ITEM2.ordinal();
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    //item1 的ViewHolder
    public static class Item1ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_content;
        ImageView iv_logo;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    //item2 的ViewHolder
    public static class Item2ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_one, iv_two;

        public Item2ViewHolder(View itemView) {
            super(itemView);
            iv_one = (ImageView) itemView.findViewById(R.id.iv_one);
            iv_two = (ImageView) itemView.findViewById(R.id.iv_two);
        }
    }
}
