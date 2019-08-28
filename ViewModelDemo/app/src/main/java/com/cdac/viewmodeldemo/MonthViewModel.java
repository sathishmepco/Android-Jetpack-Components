package com.cdac.viewmodeldemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MonthViewModel extends ViewModel {
    private MutableLiveData<List<String>> months;

    public LiveData<List<String>> getMonths(){
        if(months == null){
            months = new MutableLiveData<>();
            months.setValue(loadItems());
        }
        return months;
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