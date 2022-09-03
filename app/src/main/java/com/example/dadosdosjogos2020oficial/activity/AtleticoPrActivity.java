package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAtleticoPrBinding;

public class AtleticoPrActivity extends AppCompatActivity {
    private ActivityAtleticoPrBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoPrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}