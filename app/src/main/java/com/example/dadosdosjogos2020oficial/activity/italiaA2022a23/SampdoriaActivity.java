package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivitySampdoriaBinding;

public class SampdoriaActivity extends AppCompatActivity {

    private ActivitySampdoriaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySampdoriaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}