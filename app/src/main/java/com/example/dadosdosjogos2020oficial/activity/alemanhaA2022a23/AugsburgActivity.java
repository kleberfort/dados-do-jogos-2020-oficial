package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityArsenalBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityAugsburgBinding;

public class AugsburgActivity extends AppCompatActivity {

    private ActivityAugsburgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAugsburgBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}