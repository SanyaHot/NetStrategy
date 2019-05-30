package com.trance.netstrategy.DataBinding;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.trance.netstrategy.R;
import com.trance.netstrategy.bean.SwordsMan;
import com.trance.netstrategy.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ActivityRecyclerViewBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<SwordsMan> swordMEN = new ArrayList<>();
        swordMEN.add(new SwordsMan("ZhaoYun", "SSS"));
        swordMEN.add(new SwordsMan("HanXin", "SSS"));
        swordMEN.add(new SwordsMan("ZhouYu", "SSS"));
        swordMEN.add(new SwordsMan("LvBu", "SS"));

        SwordManAdapter adapter = new SwordManAdapter(swordMEN);
        binding.recyclerView.setAdapter(adapter);
    }
}
