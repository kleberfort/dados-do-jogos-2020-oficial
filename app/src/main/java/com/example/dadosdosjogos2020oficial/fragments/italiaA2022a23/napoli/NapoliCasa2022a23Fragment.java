package com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23.napoli;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.AtalantaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.BolognaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.CremoneseActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.EmpoliActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.FiorentinaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.HellasVeronaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.InterMilanActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.JuventusActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.LazioActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.LecceActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.MilanActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.MonzaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.NapoliActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.RomaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SalernitanaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SampdoriaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SassuoloActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SpeziaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.TorinoActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.UdineseActivity;
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.adapter.italiaA2022a23.napoli.NapoliCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.italiaA2022a23.napoli.NapoliCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentNapoliCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NapoliCasa2022a23Fragment extends Fragment {

    private FragmentNapoliCasa2022a23Binding binding;
    private NapoliCasaA2022a23PartidaApi napoliCasaA2022a23PartidaApi;
    private NapoliCasa2022a23Adapter napoliCasa2022a23Adapter;

    public NapoliCasa2022a23Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNapoliCasa2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/italia-a-2022-23/napoli/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        napoliCasaA2022a23PartidaApi = retrofit.create(NapoliCasaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvNapoliCasa.setHasFixedSize(true);
        binding.rvNapoliCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvNapoliCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        napoliCasaA2022a23PartidaApi.getNapoliCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    napoliCasa2022a23Adapter = new NapoliCasa2022a23Adapter(partidas);
                    binding.rvNapoliCasa.setAdapter(napoliCasa2022a23Adapter);

                    binding.rvNapoliCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvNapoliCasa, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){
                                case "Atalanta":
                                    Intent atalanta = new Intent(getContext(), AtalantaActivity.class);
                                    startActivity(atalanta);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bologna":
                                    Intent bologna = new Intent(getContext(), BolognaActivity.class);
                                    startActivity(bologna);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cremonese":
                                    Intent cremonese = new Intent(getContext(), CremoneseActivity.class);
                                    startActivity(cremonese);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Empoli":
                                    Intent empoli = new Intent(getContext(), EmpoliActivity.class);
                                    startActivity(empoli);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fiorentina":
                                    Intent fiorentina = new Intent(getContext(), FiorentinaActivity.class);
                                    startActivity(fiorentina);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hellas Verona":
                                    Intent hellasVerona = new Intent(getContext(), HellasVeronaActivity.class);
                                    startActivity(hellasVerona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Inter Milan":
                                    Intent interMilao = new Intent(getContext(), InterMilanActivity.class);
                                    startActivity(interMilao);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Juventus":
                                    Intent juventus = new Intent(getContext(), JuventusActivity.class);
                                    startActivity(juventus);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lazio":
                                    Intent lazio = new Intent(getContext(), LazioActivity.class);
                                    startActivity(lazio);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lecce":
                                    Intent lecce = new Intent(getContext(), LecceActivity.class);
                                    startActivity(lecce);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Milan":
                                    Intent milan = new Intent(getContext(), MilanActivity.class);
                                    startActivity(milan);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monza":
                                    Intent monza = new Intent(getContext(), MonzaActivity.class);
                                    startActivity(monza);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Roma":
                                    Intent roma = new Intent(getContext(), RomaActivity.class);
                                    startActivity(roma);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Salernitana":
                                    Intent salernitanaa = new Intent(getContext(), SalernitanaActivity.class);
                                    startActivity(salernitanaa);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sampdoria":
                                    Intent sampdoria = new Intent(getContext(), SampdoriaActivity.class);
                                    startActivity(sampdoria);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sassuolo":
                                    Intent sassuolo = new Intent(getContext(), SassuoloActivity.class);
                                    startActivity(sassuolo);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Spezia":
                                    Intent spezia = new Intent(getContext(), SpeziaActivity.class);
                                    startActivity(spezia);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Torino":
                                    Intent torino = new Intent(getContext(), TorinoActivity.class);
                                    startActivity(torino);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Udinese":
                                    Intent udinese = new Intent(getContext(), UdineseActivity.class);
                                    startActivity(udinese);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                            }

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

                }else {
                    errorBuscarDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                errorBuscarDados();

            }
        });
    }
    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}



