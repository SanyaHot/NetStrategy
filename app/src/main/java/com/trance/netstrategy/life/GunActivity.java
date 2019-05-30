package com.trance.netstrategy.life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.trance.netstrategy.R;
import com.trance.netstrategy.databinding.ActivityGunBinding;

public class GunActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGunBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gun);

        GunViewModel viewModel = ViewModelProviders.of(this).get(GunViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setGun(viewModel);

        binding.update.setOnClickListener(v -> {
            viewModel.id.setValue(i);
            viewModel.name.setValue("Ak47-series:" + i);
            viewModel.desc.setValue("gun desc:" + i * i);
            i++;
        });

        viewModel.getId().observe(this, integer ->
                Snackbar.make(binding.root, "Ak47-series:" + i, Snackbar.LENGTH_SHORT).show());
    }
}
