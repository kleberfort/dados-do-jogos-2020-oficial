package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAvaiBinding;

public class AvaiActivity extends AppCompatActivity {
    private ActivityAvaiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAvaiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}