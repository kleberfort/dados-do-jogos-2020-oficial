package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityReimsBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;

public class ReimsActivity extends AppCompatActivity {

    private ActivityReimsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReimsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}