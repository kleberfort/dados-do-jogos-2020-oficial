package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityFlamengoBinding;

public class FlamengoActivity extends AppCompatActivity {
    private ActivityFlamengoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlamengoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}