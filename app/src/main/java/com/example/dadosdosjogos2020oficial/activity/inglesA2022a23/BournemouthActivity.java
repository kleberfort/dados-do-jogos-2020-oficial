package com.example.dadosdosjogos2020oficial.activity.inglesA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAstonVillaBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityBournemouthBinding;

public class BournemouthActivity extends AppCompatActivity {

    private ActivityBournemouthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBournemouthBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}