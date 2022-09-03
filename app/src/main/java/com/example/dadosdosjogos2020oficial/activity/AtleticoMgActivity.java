package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAtleticoMgBinding;

public class AtleticoMgActivity extends AppCompatActivity {
    private ActivityAtleticoMgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoMgBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}