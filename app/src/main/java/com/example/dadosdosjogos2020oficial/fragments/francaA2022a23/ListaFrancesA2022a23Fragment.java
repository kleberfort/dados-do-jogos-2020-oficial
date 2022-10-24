package com.example.dadosdosjogos2020oficial.fragments.francaA2022a23;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.francaA2022a23.TimesFrancesA2022a23Adpater;
import com.example.dadosdosjogos2020oficial.data.francaA2022a23.TimesFrancesA2022a23Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaFrancesA2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaFrancesA2022a23Fragment extends Fragment {

    private FragmentListaFrancesA2022a23Binding binding;
    private TimesFrancesA2022a23Adpater timesFrancesA2022a23Adpater;
    private TimesFrancesA2022a23Api timesFrancesA2022a23Api;




    public ListaFrancesA2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaFrancesA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/franca-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesFrancesA2022a23Api = retrofit.create(TimesFrancesA2022a23Api.class);


    }

    private void setupListaTimes() {

        binding.rvListaFrancesA2022a23.setHasFixedSize(true);
        binding.rvListaFrancesA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaFrancesA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesFrancesA2022a23Api.getTimesFrancesA2022a2023().enqueue(new Callback<List<ListaTimeCampeonatoPrincipal>>() {
            @Override
            public void onResponse(Call<List<ListaTimeCampeonatoPrincipal>> call, Response<List<ListaTimeCampeonatoPrincipal>> response) {
                if(response.isSuccessful()){
                    List<ListaTimeCampeonatoPrincipal> listaDeTimes = response.body();
                    timesFrancesA2022a23Adpater = new TimesFrancesA2022a23Adpater(listaDeTimes);
                    binding.rvListaFrancesA2022a23.setAdapter(timesFrancesA2022a23Adpater);
                }else{
                    errorMensagem();
                }
            }

            @Override
            public void onFailure(Call<List<ListaTimeCampeonatoPrincipal>> call, Throwable t) {
                    errorMensagem();

            }
        });

    }

    private void errorMensagem() {
        Snackbar.make(binding.getRoot(), "Verifique a conexão de Internet", Snackbar.LENGTH_LONG).show();
    }
}