package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityWerderBremenBinding;

public class WerderBremenActivity extends AppCompatActivity {

    private ActivityWerderBremenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWerderBremenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}