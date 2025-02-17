package com.jogos.dadosoficialkf228920.adapter.adapteFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jogos.dadosoficialkf228920.fragments.EstatisticaCasaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.EstatisticaForaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.JogosCasaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.JogosForaLaLiga2025Fragment;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;

import java.util.ArrayList;

public class LaLigaPagerAdapter extends FragmentStateAdapter {

    private ArrayList<MatchNewModelDate> listaPartidas;
    private String nomeTime;

    public LaLigaPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<MatchNewModelDate> listaPartidas, String nomeTime) {
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
                Bundle estatisticaFora = new Bundle();
                estatisticaFora.putParcelableArrayList("partidas_fora", filtrarPartidasFora(listaPartidas));
                estatisticaFora.putString("nome_time", nomeTime);
                fragment.setArguments(estatisticaFora);
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
    private ArrayList<MatchNewModelDate> filtrarPartidasCasa(ArrayList<MatchNewModelDate> lista) {
        ArrayList<MatchNewModelDate> partidasCasa = new ArrayList<>();
        for (MatchNewModelDate partida : lista) {
            if (partida.getHomeTime().getName().equals(nomeTime)) {
                partidasCasa.add(partida);
            }
        }
        return partidasCasa;
    }

    private ArrayList<MatchNewModelDate> filtrarPartidasFora(ArrayList<MatchNewModelDate> lista) {
        ArrayList<MatchNewModelDate> partidasFora = new ArrayList<>();
        for (MatchNewModelDate partida : lista) {
            if (partida.getAwayTime().getName().equals(nomeTime)) {
                partidasFora.add(partida);
            }
        }
        return partidasFora;
    }
}
