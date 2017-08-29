package com.qxf.archer.cookman.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qxf.archer.cookman.R;
import com.qxf.archer.cookman.entity.CookLableEntity;

import java.util.ArrayList;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/29 0029 11:48
 * 邮箱：377289596@qq.com
 */

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {

    private static final String TAG = "TypeAdapter";

    private ArrayList<CookLableEntity.ResultBean.ListBean> datas;

    private Context context;

    public TypeAdapter(Context context, ArrayList<CookLableEntity.ResultBean.ListBean> listBeen) {
        this.context = context;
        this.datas = listBeen;
    }

    public TypeAdapter() {
        super();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public TypeAdapter(Context context) {
        this.context = context;
    }

    public void add(CookLableEntity.ResultBean.ListBean listBean) {
        if (datas != null) {
            datas.add(listBean);
        }
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<CookLableEntity.ResultBean.ListBean> listBeen, boolean isClear) {
        if (isClear) {
            clear();
        }
        if (datas != null) {
            datas.addAll(listBeen);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (datas != null) {
            datas.clear();
        }
        notifyDataSetChanged();
    }

    public void setDatas(ArrayList<CookLableEntity.ResultBean.ListBean> listBeen) {
        this.datas = listBeen;
        notifyDataSetChanged();
    }

    public void replace(ArrayList<CookLableEntity.ResultBean.ListBean> listBeen) {
        addAll(listBeen, true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.type_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CookLableEntity.ResultBean.ListBean bean = datas.get(position);

        String url = datas.get(position).getRecipe().getImg();

        Glide.with(context)
                .load(url)
                .into(holder.img);

        holder.text.setText(bean.getName());

        Log.e(TAG, "onBindViewHolder: " + bean.getName());


    }

    @Override
    public int getItemCount() {
        if (datas != null) {
            return datas.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            img = itemView.findViewById(R.id.img);
        }
    }

}
