package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityNapoliBinding;

public class NapoliActivity extends AppCompatActivity {

    private ActivityNapoliBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNapoliBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}