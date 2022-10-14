package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityLorientBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;

public class LorientActivity extends AppCompatActivity {

    private ActivityLorientBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLorientBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}