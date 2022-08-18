package com.example.dadosdosjogos2020oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCearaBinding;

public class CearaActivity extends AppCompatActivity {
    private ActivityCearaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCearaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}