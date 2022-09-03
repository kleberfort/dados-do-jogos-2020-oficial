package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCuiabaBinding;

public class CuiabaActivity extends AppCompatActivity {
    private ActivityCuiabaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCuiabaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}