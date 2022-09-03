package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityPalmeirasBinding;

public class PalmeirasActivity extends AppCompatActivity {
    private ActivityPalmeirasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPalmeirasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}