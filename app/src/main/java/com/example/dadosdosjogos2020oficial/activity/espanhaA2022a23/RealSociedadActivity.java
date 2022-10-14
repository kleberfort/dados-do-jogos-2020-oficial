package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityRealSociedadBinding;

public class RealSociedadActivity extends AppCompatActivity {

    private ActivityRealSociedadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRealSociedadBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}