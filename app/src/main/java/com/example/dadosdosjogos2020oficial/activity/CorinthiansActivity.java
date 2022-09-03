package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCorinthiansBinding;

public class CorinthiansActivity extends AppCompatActivity {
    private ActivityCorinthiansBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCorinthiansBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}