package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityToulouseBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;

public class ToulouseActivity extends AppCompatActivity {

    private ActivityToulouseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToulouseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}