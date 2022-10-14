package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityRbleipzigBinding;

public class RBLeipzigActivity extends AppCompatActivity {

    private ActivityRbleipzigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRbleipzigBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}