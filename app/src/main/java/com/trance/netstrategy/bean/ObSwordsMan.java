package com.trance.netstrategy.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.trance.netstrategy.BR;

public class ObSwordsMan extends BaseObservable {
    private String name;
    private String level;

    public ObSwordsMan(String name, String level) {
        this.name = name;
        this.level = level;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }
}
