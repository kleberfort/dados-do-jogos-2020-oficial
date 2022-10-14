package com.example.dadosdosjogos2020oficial.activity.inglesA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAstonVillaBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityFulhamBinding;

public class FulhamActivity extends AppCompatActivity {

    private ActivityFulhamBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFulhamBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}