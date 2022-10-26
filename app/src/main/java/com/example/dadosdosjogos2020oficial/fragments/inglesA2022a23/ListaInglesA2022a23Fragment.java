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
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.BournemouthActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.BrentfordActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.BrightonActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ChelseaActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.CrystalPalaceActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.EvertonActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.FulhamActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.LeedsUnitedActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.LeicesterActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.LiverpoolActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ManchesterCityActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ManchesterUnitedActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.NewcastleActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.NottinghamForestActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.SouthamptonActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.TottenhamActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.WesthamActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.WolverhamptonActivity;
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

    public enum TimesInglesesA{
        ARSENAL(0, "Arsenal"),
        ASTON_VILLA(1, "Aston Villa"),
        BOURNEMOUTH(2, "Bournemouth"),
        BRENTFORD(3, "Brentford"),
        BRIGHTON(4, "Brighton"),
        CHELSEA(5, "Chelsea"),
        CRYSTAL_PALACE(6, "Crystal Palace"),
        EVERTON(7,"Everton"),
        FULHAM(8,"Fulham"),
        LEEDS_UNITED(9,"Leeds United"),
        LEICESTER(10, "Leicester"),
        LIVERPOOL(11, "Liverpool"),
        MANCHESTER_CITY(12,"Manchester City"),
        MANCHESTER_UNITED(13,"Manchester United"),
        NEWCASTLE(14,"Newcastle"),
        NOTTINGHAM_FOREST(15,"Nottingham Forest"),
        SOUTHAMPTON(16,"Southampton"),
        TOTTENHAM(17,"Tottenham"),
        WEST_HAM(18,"West Ham"),
        WOLVERHAMPTON(19,"Wolverhampton");

        private final int valor;
        private final String nome;

        private TimesInglesesA(int valor, String nome){
            this.valor = valor;
            this.nome = nome;
        }

        public int getValor(){
            return this.valor;
        }

    }


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
                            case "Bournemouth":
                                Intent bournemouth = new Intent(getContext(), BournemouthActivity.class);
                                startActivity(bournemouth);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Brentford":
                                Intent brentford = new Intent(getContext(), BrentfordActivity.class);
                                startActivity(brentford);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Brighton":
                                Intent brighton = new Intent(getContext(), BrightonActivity.class);
                                startActivity(brighton);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Chelsea":
                                Intent chelsea = new Intent(getContext(), ChelseaActivity.class);
                                startActivity(chelsea);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Crystal Palace":
                                Intent crystalPalace = new Intent(getContext(), CrystalPalaceActivity.class);
                                startActivity(crystalPalace);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Everton":
                                Intent everton = new Intent(getContext(), EvertonActivity.class);
                                startActivity(everton);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Fulham":
                                Intent fulham = new Intent(getContext(), FulhamActivity.class);
                                startActivity(fulham);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Leeds United":
                                Intent leedsUnited = new Intent(getContext(), LeedsUnitedActivity.class);
                                startActivity(leedsUnited);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Leicester":
                                Intent leicester = new Intent(getContext(), LeicesterActivity.class);
                                startActivity(leicester);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Liverpool":
                                Intent liverpool = new Intent(getContext(), LiverpoolActivity.class);
                                startActivity(liverpool);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Manchester City":
                                Intent manchesterCity = new Intent(getContext(), ManchesterCityActivity.class);
                                startActivity(manchesterCity);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Manchester United":
                                Intent manchesterUnited = new Intent(getContext(), ManchesterUnitedActivity.class);
                                startActivity(manchesterUnited);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Newcastle":
                                Intent newcastle = new Intent(getContext(), NewcastleActivity.class);
                                startActivity(newcastle);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Nottingham Forestla":
                                Intent nottingham = new Intent(getContext(), NottinghamForestActivity.class);
                                startActivity(nottingham);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Southampton":
                                Intent southampton = new Intent(getContext(), SouthamptonActivity.class);
                                startActivity(southampton);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Tottenham":
                                Intent tottenham = new Intent(getContext(), TottenhamActivity.class);
                                startActivity(tottenham);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "West Ham":
                                Intent westHam = new Intent(getContext(), WesthamActivity.class);
                                startActivity(westHam);
                                Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                break;
                            case "Wolverhampton":
                                Intent wolverhampton = new Intent(getContext(), WolverhamptonActivity.class);
                                startActivity(wolverhampton);
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