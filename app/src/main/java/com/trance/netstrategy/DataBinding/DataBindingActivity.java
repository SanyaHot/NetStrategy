package com.trance.netstrategy.DataBinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.trance.netstrategy.R;
import com.trance.netstrategy.bean.ObFSwordsMan;
import com.trance.netstrategy.bean.ObSwordsMan;
import com.trance.netstrategy.bean.SwordsMan;
import com.trance.netstrategy.databinding.ActivityDataBindingBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        SwordsMan swordsMan = new SwordsMan("Soft", "S");
        binding.setSwordsman(swordsMan);

        binding.first.setText("Hello World!");
        swordsMan.setName("Kang Kang");
        binding.setSwordsman(swordsMan);

        binding.setName("Winter");
        binding.setAge(2000);
        binding.setMan(true);

//        ArrayList list = new ArrayList();
//        list.add("0");
//        list.add("1");
//        binding.setList(list);

        Map map = new HashMap();
        map.put("age", "30");
        binding.setMap(map);

        String[] array = {"Hello", "World"};
        binding.setArrays(array);

        binding.setTime(new Date());

        //继承自BaseObservable实现动态更新
        ObSwordsMan oman = new ObSwordsMan("ObSwordMan", "SSS");
        binding.setOman(oman);

        //使用ObservableField实现动态更新
        ObFSwordsMan of_man = new ObFSwordsMan("ObFSwordMan", "A");
        binding.setOfMan(of_man);

        //使用ObservableCollection实现动态更新
        ObservableArrayList<String> obList = new ObservableArrayList<>();
        obList.add("Spring");
        obList.add("Summer");
        binding.setList(obList);

//        binding.bt1.setOnClickListener(v ->
//                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_SHORT).show());

        binding.setOnClickListener(v -> {
            oman.setName("Confused");
            of_man.name.set("ObservableField");
            obList.add(1, "Fall");
        });
    }
}
