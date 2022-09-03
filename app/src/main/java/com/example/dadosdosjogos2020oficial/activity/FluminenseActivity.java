package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityFluminenseBinding;

public class FluminenseActivity extends AppCompatActivity {
    private ActivityFluminenseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFluminenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}