package com.jogos.dadosoficialkf228920.adapter.adapteFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.EstatisticaCasaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.EstatisticaForaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.JogosCasaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.JogosForaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;

public class LaLigaPagerAdapter extends FragmentStateAdapter {

    private ArrayList<PartidaNovoModelo> listaPartidas;
    private String nomeTime;

    public LaLigaPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<PartidaNovoModelo> listaPartidas, String nomeTime) {
        super(fragmentActivity);
        this.listaPartidas = listaPartidas;
        this.nomeTime = nomeTime;
    }

    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new JogosCasaLaLiga2025Fragment();
                Bundle bundleCasa = new Bundle();
                bundleCasa.putParcelableArrayList("partidas_casa", filtrarPartidasCasa(listaPartidas));
                bundleCasa.putString("nome_time", nomeTime);
                fragment.setArguments(bundleCasa);
                break;
            case 1:
                fragment = new JogosForaLaLiga2025Fragment();
                Bundle bundleFora = new Bundle();
                bundleFora.putParcelableArrayList("partidas_fora", filtrarPartidasFora(listaPartidas));
                bundleFora.putString("nome_time", nomeTime);
                fragment.setArguments(bundleFora);
                break;
            case 2:
                // Estatísticas Casa
                fragment = new EstatisticaCasaLaLiga2025Fragment(); // Exemplo, substitua pelo fragmento correto
                Bundle estatisticaCasa = new Bundle();
                estatisticaCasa.putParcelableArrayList("partidas_casa", filtrarPartidasCasa(listaPartidas));
                estatisticaCasa.putString("nome_time", nomeTime);
                fragment.setArguments(estatisticaCasa);
                break;
            case 3:
                // Estatísticas Fora
                fragment = new EstatisticaForaLaLiga2025Fragment(); // Exemplo, substitua pelo fragmento correto
                break;
            default:
                throw new IllegalArgumentException("Posição inválida no ViewPager2: " + position);
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4; // Número de abas
    }

    // Métodos de filtragem
    private ArrayList<PartidaNovoModelo> filtrarPartidasCasa(ArrayList<PartidaNovoModelo> lista) {
        ArrayList<PartidaNovoModelo> partidasCasa = new ArrayList<>();
        for (PartidaNovoModelo partida : lista) {
            if (partida.getHomeTime().getName().equals(nomeTime)) {
                partidasCasa.add(partida);
            }
        }
        return partidasCasa;
    }

    private ArrayList<PartidaNovoModelo> filtrarPartidasFora(ArrayList<PartidaNovoModelo> lista) {
        ArrayList<PartidaNovoModelo> partidasFora = new ArrayList<>();
        for (PartidaNovoModelo partida : lista) {
            if (partida.getAwayTime().getName().equals(nomeTime)) {
                partidasFora.add(partida);
            }
        }
        return partidasFora;
    }
}
