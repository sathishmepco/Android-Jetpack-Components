package com.cdac.viewmodeldemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.cdac.viewmodeldemo.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MonthAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        initActivity();
    }

    private void initActivity(){
        adapter = new MonthAdapter();
        binding.contentView.recyclerView.setAdapter(adapter);
        /*
        The below code will shuffle the list of string in orientation change
        Without using ViewModel
         */
//        adapter.setList(loadItems());

        /*
        The below code uses ViewModel

         */
        MonthViewModel viewModel = ViewModelProviders.of(this).get(MonthViewModel.class);
        viewModel.getMonths().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                adapter.setList(strings);
            }
        });
    }

    private List<String> loadItems(){
        List<String> list = new ArrayList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");
        list.add("December");
        Collections.shuffle(list);
        return list;
    }
}