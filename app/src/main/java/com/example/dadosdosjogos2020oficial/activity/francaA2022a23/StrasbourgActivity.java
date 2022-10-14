package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityStrasbourgBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;

public class StrasbourgActivity extends AppCompatActivity {

    private ActivityStrasbourgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStrasbourgBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}