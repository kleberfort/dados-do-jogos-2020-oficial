package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ArsenalActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.AstonVillaActivity;
import com.example.dadosdosjogos2020oficial.adapter.inglesA2022a2023.TimesInglesA2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.inglesA2022a23.TimesInglesA2022a23Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaInglesA2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaInglesA2022a23Fragment extends Fragment {
    private FragmentListaInglesA2022a23Binding binding;
    private TimesInglesA2022a23Api timesInglesA2022a23Api;
    private TimesInglesA2022a23Adapter timesInglesA2022a23Adapter;


    public ListaInglesA2022a23Fragment() {



        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        binding = FragmentListaInglesA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();


        
       
        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesInglesA2022a23Api = retrofit.create(TimesInglesA2022a23Api.class);



    }

    private void setupListaTimes() {

        binding.rvListaInglesA2022a23.setHasFixedSize(true);
        binding.rvListaInglesA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaInglesA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesInglesA2022a23Api.getTimesInglesA2022a2023().enqueue(new Callback<List<ListaTimeCampeonatoPrincipal>>() {
            @Override
            public void onResponse(Call<List<ListaTimeCampeonatoPrincipal>> call, Response<List<ListaTimeCampeonatoPrincipal>> response) {
                if(response.isSuccessful()){
                    List<ListaTimeCampeonatoPrincipal> listaDeTimes = response.body();
                    timesInglesA2022a23Adapter = new TimesInglesA2022a23Adapter(listaDeTimes);
                    binding.rvListaInglesA2022a23.setAdapter(timesInglesA2022a23Adapter);

                    binding.rvListaInglesA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaInglesA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                        ListaTimeCampeonatoPrincipal lista = listaDeTimes.get(position);

                        switch (lista.getName()){
                            case "Arsenal":
                                Intent arsenal = new Intent(getContext(), ArsenalActivity.class);
                                startActivity(arsenal);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Aston Villa":
                                Intent astonVilla = new Intent(getContext(), AstonVillaActivity.class);
                                startActivity(astonVilla);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                        }

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

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