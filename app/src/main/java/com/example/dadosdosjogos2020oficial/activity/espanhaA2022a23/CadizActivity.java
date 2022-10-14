package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCadizBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;

public class CadizActivity extends AppCompatActivity {

    private ActivityCadizBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadizBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}