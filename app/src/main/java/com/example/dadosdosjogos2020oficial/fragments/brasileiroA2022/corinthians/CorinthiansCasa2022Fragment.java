package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.corinthians;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dadosdosjogos2020oficial.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CorinthiansCasa2022Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CorinthiansCasa2022Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CorinthiansCasa2022Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CorinthiansCasa2022Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CorinthiansCasa2022Fragment newInstance(String param1, String param2) {
        CorinthiansCasa2022Fragment fragment = new CorinthiansCasa2022Fragment();
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
        return inflater.inflate(R.layout.fragment_corinthians_casa2022, container, false);
    }
}