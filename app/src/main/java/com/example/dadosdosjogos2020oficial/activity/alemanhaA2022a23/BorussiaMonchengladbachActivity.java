package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityBorussiaMonchengladbachBinding;

public class BorussiaMonchengladbachActivity extends AppCompatActivity {

    private ActivityBorussiaMonchengladbachBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBorussiaMonchengladbachBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}