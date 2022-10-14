package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityMilanBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;

public class MilanActivity extends AppCompatActivity {

    private ActivityMilanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMilanBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}