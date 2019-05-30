package com.trance.netstrategy.DataBinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trance.netstrategy.R;
import com.trance.netstrategy.bean.SwordsMan;
import com.trance.netstrategy.databinding.ItemSwordManBinding;

import java.util.List;

public class SwordManAdapter extends RecyclerView.Adapter<SwordManAdapter.ViewHolder> {

    private List<SwordsMan> list;

    public SwordManAdapter(List<SwordsMan> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSwordManBinding binding;

        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = (ItemSwordManBinding) binding;
        }

        public ItemSwordManBinding getBinding() {
            return binding;
        }
    }

    @NonNull
    @Override
    public SwordManAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemSwordManBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_sword_man, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SwordManAdapter.ViewHolder holder, int i) {
        SwordsMan swordsMan = list.get(i);
        holder.getBinding().setSwordman(swordsMan);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
