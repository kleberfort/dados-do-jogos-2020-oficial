package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAtleticoGoBinding;

public class AtleticoGoActivity extends AppCompatActivity {

    private ActivityAtleticoGoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoGoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}