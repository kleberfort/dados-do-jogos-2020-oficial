package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBragantinoBinding;

public class BragantinoActivity extends AppCompatActivity {
    private ActivityBragantinoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBragantinoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}