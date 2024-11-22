package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.brentford.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrentfordEstatisticaFora2025Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrentfordEstatisticaFora2025Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BrentfordEstatisticaFora2025Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrentfordEstatisticaFora2025Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrentfordEstatisticaFora2025Fragment newInstance(String param1, String param2) {
        BrentfordEstatisticaFora2025Fragment fragment = new BrentfordEstatisticaFora2025Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brentford_estatistica_fora2025, container, false);
    }
}