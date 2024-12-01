package com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.laLiga;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.adapteFragment.LaLigaPagerAdapter;
import com.jogos.dadosoficialkf228920.databinding.ActivityLaLiga202425Binding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;

public class LaLiga2024_25Activity extends AppCompatActivity {

    private ActivityLaLiga202425Binding binding;
    private ArrayList<PartidaNovoModelo> listaPartidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializando a view binding
        binding = ActivityLaLiga202425Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Recupera a lista do Intent
        listaPartidas = getIntent().getParcelableArrayListExtra("lista_partidas");
        // Recupera o nome do time do Intent
        String nomeTime = getIntent().getStringExtra("nome_time");

        // Verifica se a lista não é nula ou vazia antes de passar para os Fragmentos
        if (listaPartidas != null && !listaPartidas.isEmpty()) {
            // Exemplo: Exibir no log
            for (PartidaNovoModelo partida : listaPartidas) {
                Log.d("LaLigaActivity", "Partida: " + partida.toString());
            }

            // Configura o ViewPager2 com o adaptador
            LaLigaPagerAdapter pagerAdapter;
            pagerAdapter = new LaLigaPagerAdapter(this, listaPartidas, nomeTime);

            // Configura o ViewPager2
            ViewPager2 viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(pagerAdapter);  // Configura o adaptador aqui primeiro

            // Agora, configura o TabLayout para as abas
            TabLayout tabLayout = findViewById(R.id.tabLayout);
            new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    // Define os títulos para cada aba
                    switch (position) {
                        case 0:
                            tab.setText("Jogos Casa");
                            break;
                        case 1:
                            tab.setText("Jogos Fora");
                            break;
                        case 2:
                            tab.setText("Estatística Casa");
                            break;
                        case 3:
                            tab.setText("Estatística Fora");
                            break;
                    }
                }
            }).attach();
        } else {
            Log.d("LaLigaActivity", "Lista de partidas está vazia ou nula");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberando recursos, se necessário
    }
}
