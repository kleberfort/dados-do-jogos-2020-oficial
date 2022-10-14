package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivitySpeziaBinding;

public class SpeziaActivity extends AppCompatActivity {

    private ActivitySpeziaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpeziaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}