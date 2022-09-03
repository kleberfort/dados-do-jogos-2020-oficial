package com.example.dadosdosjogos2020oficial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAmericaMgBinding;

public class AmericaMgActivity extends AppCompatActivity {

    private ActivityAmericaMgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAmericaMgBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}