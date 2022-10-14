package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAugsburgBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;

public class BayerLeverkusenActivity extends AppCompatActivity {

    private ActivityBayerLeverkusenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBayerLeverkusenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}