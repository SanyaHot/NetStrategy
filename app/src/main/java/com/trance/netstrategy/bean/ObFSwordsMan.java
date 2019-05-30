package com.trance.netstrategy.bean;

import android.databinding.Observable;
import android.databinding.ObservableField;

public class ObFSwordsMan {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> level = new ObservableField<>();

    public ObFSwordsMan(String name, String level) {
        this.name.set(name);
        this.level.set(level);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getLevel() {
        return level;
    }

    public void setLevel(ObservableField<String> level) {
        this.level = level;
    }
}
