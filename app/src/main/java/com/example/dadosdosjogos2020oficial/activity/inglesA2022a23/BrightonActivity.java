package com.example.dadosdosjogos2020oficial.activity.inglesA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBrightonBinding;

public class BrightonActivity extends AppCompatActivity {

    private ActivityBrightonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBrightonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



    }
}