package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBarcelonaBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;

public class BarcelonaActivity extends AppCompatActivity {

    private ActivityBarcelonaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBarcelonaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}