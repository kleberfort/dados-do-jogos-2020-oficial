package com.jogos.dadosoficialkf228920.adapter.adapteFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.JogosCasaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util.EstatisticaCasaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util.EstatisticaForaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util.JogosForaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;

public class LaLigaPagerAdapter extends FragmentStateAdapter {

    private ArrayList<PartidaNovoModelo> listaPartidas;

    public LaLigaPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<PartidaNovoModelo> listaPartidas) {
        super(fragmentActivity);
        this.listaPartidas = listaPartidas;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        // Baseado na posição, retorna o fragment correspondente
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("lista_partidas", listaPartidas);

        switch (position) {
            case 0:
                fragment = new JogosCasaLaLiga2025Fragment();
                break;
            case 1:
                fragment = new JogosForaLaLiga2025Fragment();
                break;
            case 2:
                fragment = new EstatisticaCasaLaLiga2025Fragment();
                break;
            case 3:
                fragment = new EstatisticaForaLaLiga2025Fragment();
                break;
        }

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;  // Total de abas
    }
}
