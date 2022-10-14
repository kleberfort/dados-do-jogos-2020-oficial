package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityEmpoliBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;

public class EmpoliActivity extends AppCompatActivity {

    private ActivityEmpoliBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmpoliBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}