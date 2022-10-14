package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAtleticoMadridBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;

public class AtleticoMadridActivity extends AppCompatActivity {

    private ActivityAtleticoMadridBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoMadridBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}