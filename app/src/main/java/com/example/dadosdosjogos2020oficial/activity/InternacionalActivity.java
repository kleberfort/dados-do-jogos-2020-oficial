package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityInternacionalBinding;

public class InternacionalActivity extends AppCompatActivity {
    private ActivityInternacionalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInternacionalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}