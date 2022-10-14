package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCeltaVigoBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;

public class CeltaVigoActivity extends AppCompatActivity {

    private ActivityCeltaVigoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCeltaVigoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}