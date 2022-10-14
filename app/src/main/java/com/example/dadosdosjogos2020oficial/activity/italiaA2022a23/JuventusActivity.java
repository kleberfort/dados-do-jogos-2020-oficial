package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityJuventusBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;

public class JuventusActivity extends AppCompatActivity {

    private ActivityJuventusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJuventusBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}