package com.jogos.dadosoficialkf228920.adapter.adapteFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.EstatisticaFragment;

import java.util.ArrayList;
import java.util.List;

public class EstatisticaPagerAdapter extends FragmentStateAdapter {
    private final List<String> tiposEstatistica = new ArrayList<>();

    public EstatisticaPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public void addFragment(String tipoEstatistica) {
        tiposEstatistica.add(tipoEstatistica);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        EstatisticaFragment fragment = new EstatisticaFragment();

        // Passar o tipo de estatística como argumento
        Bundle args = new Bundle();
        args.putString("tipo_estatistica", tiposEstatistica.get(position));
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getItemCount() {
        return tiposEstatistica.size();
    }
}
