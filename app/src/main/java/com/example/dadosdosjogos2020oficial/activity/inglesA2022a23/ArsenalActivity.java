package com.example.dadosdosjogos2020oficial.activity.inglesA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityArsenalBinding;

public class ArsenalActivity extends AppCompatActivity {

    private ActivityArsenalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityArsenalBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}