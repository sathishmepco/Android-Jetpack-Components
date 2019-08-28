package com.cdac.viewmodeldemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.cdac.viewmodeldemo.databinding.ListItemRowBinding;

import java.util.List;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MonthViewHolder> {

    List<String> monthList;

    @NonNull
    @Override
    public MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MonthViewHolder((ListItemRowBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MonthViewHolder holder, int position) {
        holder.bind(monthList.get(position));
    }

    @Override
    public int getItemCount() {
        return monthList.size();
    }

    public void setList(List<String> list){
        monthList = list;
        notifyDataSetChanged();
    }

    class MonthViewHolder extends RecyclerView.ViewHolder {
        ListItemRowBinding binding;

        public MonthViewHolder(ListItemRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String text) {
            binding.textView.setText(text);
        }
    }
}
