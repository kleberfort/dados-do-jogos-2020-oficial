package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityGoiasBinding;

public class GoiasActivity extends AppCompatActivity {
    private ActivityGoiasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoiasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}