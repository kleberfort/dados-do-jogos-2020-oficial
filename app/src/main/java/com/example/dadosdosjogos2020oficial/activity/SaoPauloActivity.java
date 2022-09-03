package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivitySaoPauloBinding;

public class SaoPauloActivity extends AppCompatActivity {
    private ActivitySaoPauloBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaoPauloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}