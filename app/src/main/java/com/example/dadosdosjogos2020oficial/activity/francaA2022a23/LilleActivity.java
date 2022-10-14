package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityLilleBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;

public class LilleActivity extends AppCompatActivity {

    private ActivityLilleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLilleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}