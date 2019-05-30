package com.trance.netstrategy.life;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GunViewModel extends ViewModel {
    public final MutableLiveData<Integer> id = new MutableLiveData<>();
    public final MutableLiveData<String> name = new MutableLiveData<>();
    public final MutableLiveData<String> desc = new MutableLiveData<>();

    public GunViewModel() {
    }

    public MutableLiveData<Integer> getId() {
        return id;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getDesc() {
        return desc;
    }
}
