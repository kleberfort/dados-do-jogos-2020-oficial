package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityLensBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;

public class LensActivity extends AppCompatActivity {

    private ActivityLensBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLensBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}