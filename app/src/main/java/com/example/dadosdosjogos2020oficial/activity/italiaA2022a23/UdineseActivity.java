package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityUdineseBinding;

public class UdineseActivity extends AppCompatActivity {

    private ActivityUdineseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUdineseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
    }
}