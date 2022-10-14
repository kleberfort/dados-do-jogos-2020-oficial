package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.nottinghamforest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dadosdosjogos2020oficial.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NottinghamForestFora2022a23Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NottinghamForestFora2022a23Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NottinghamForestFora2022a23Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NottinghamForestFora2022a23Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NottinghamForestFora2022a23Fragment newInstance(String param1, String param2) {
        NottinghamForestFora2022a23Fragment fragment = new NottinghamForestFora2022a23Fragment();
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
        return inflater.inflate(R.layout.fragment_nottingham_forest_fora2022a23, container, false);
    }
}