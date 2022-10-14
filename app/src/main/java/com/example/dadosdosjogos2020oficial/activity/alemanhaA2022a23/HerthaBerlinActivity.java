package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityHerthaBerlinBinding;

public class HerthaBerlinActivity extends AppCompatActivity {

    private ActivityHerthaBerlinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHerthaBerlinBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}