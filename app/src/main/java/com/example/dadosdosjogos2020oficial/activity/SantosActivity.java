package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivitySantosBinding;

public class SantosActivity extends AppCompatActivity {
    private ActivitySantosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySantosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}