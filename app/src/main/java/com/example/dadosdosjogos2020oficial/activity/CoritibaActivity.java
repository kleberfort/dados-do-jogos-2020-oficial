package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCoritibaBinding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCoritibaCasa2022Binding;

public class CoritibaActivity extends AppCompatActivity {
    private ActivityCoritibaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoritibaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}