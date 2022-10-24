package com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.TimesAlemaoA022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.TimesAlemaoA2022a23Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaAlemaoA2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaAlemaoA2022a23Fragment extends Fragment {

    private FragmentListaAlemaoA2022a23Binding binding;
    private TimesAlemaoA022a23Adapter timesAlemaoA022a23Adapter;
    private TimesAlemaoA2022a23Api timesAlemaoA2022a23Api;



    public ListaAlemaoA2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaAlemaoA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();
        

        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/alemanha-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        timesAlemaoA2022a23Api = retrofit.create(TimesAlemaoA2022a23Api.class);

    }


    private void setupListaTimes() {

        binding.rvListaAlemaoA2022a23.setHasFixedSize(true);
        binding.rvListaAlemaoA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaAlemaoA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesAlemaoA2022a23Api.getTimesAlemaoA2022a2023().enqueue(new Callback<List<ListaTimeCampeonatoPrincipal>>() {
            @Override
            public void onResponse(Call<List<ListaTimeCampeonatoPrincipal>> call, Response<List<ListaTimeCampeonatoPrincipal>> response) {
                if(response.isSuccessful()){
                    List<ListaTimeCampeonatoPrincipal> listaDeTimes = response.body();
                    timesAlemaoA022a23Adapter = new TimesAlemaoA022a23Adapter(listaDeTimes);
                    binding.rvListaAlemaoA2022a23.setAdapter(timesAlemaoA022a23Adapter);
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