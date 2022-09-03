package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBotafogoBinding;

public class BotafogoActivity extends AppCompatActivity {
    private ActivityBotafogoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBotafogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}