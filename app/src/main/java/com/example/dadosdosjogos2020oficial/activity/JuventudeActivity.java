package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityJuventudeBinding;

public class JuventudeActivity extends AppCompatActivity {
    private ActivityJuventudeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJuventudeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}