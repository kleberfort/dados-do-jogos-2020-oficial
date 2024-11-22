package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.wolves.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WolvesEstatisticaCasa2025Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WolvesEstatisticaCasa2025Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WolvesEstatisticaCasa2025Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WolvesEstatisticaCasa2025Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WolvesEstatisticaCasa2025Fragment newInstance(String param1, String param2) {
        WolvesEstatisticaCasa2025Fragment fragment = new WolvesEstatisticaCasa2025Fragment();
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
        return inflater.inflate(R.layout.fragment_wolves_estatistica_casa2025, container, false);
    }
}