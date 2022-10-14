package com.example.dadosdosjogos2020oficial.activity.inglesA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAstonVillaBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityLeicesterBinding;

public class LeicesterActivity extends AppCompatActivity {

    private ActivityLeicesterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeicesterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}