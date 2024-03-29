package com.jogos.dadosoficialkf228920.fragments.italiaA2022a23.fiorentina;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.AtalantaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.BolognaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.CremoneseActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.EmpoliActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.HellasVeronaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.InterMilanActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.JuventusActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.LazioActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.LecceActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.MilanActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.MonzaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.NapoliActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.RomaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SalernitanaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SampdoriaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SassuoloActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SpeziaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.TorinoActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.UdineseActivity;
import com.jogos.dadosoficialkf228920.adapter.italiaA2022a23.fiorentina.FiorentinaCasa2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.italiaA2022a23.fiorentina.FiorentinaCasaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentFiorentinaCasa2022a23Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FiorentinaCasa2022a23Fragment extends Fragment {

    private FragmentFiorentinaCasa2022a23Binding binding;
    private FiorentinaCasaA2022a23PartidaApi fiorentinaCasaA2022a23PartidaApi;
    private FiorentinaCasa2022a23Adapter fiorentinaCasa2022a23Adapter;

    public FiorentinaCasa2022a23Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFiorentinaCasa2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/italia-a-2022-23/fiorentina/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fiorentinaCasaA2022a23PartidaApi = retrofit.create(FiorentinaCasaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvFiorentiaCasa.setHasFixedSize(true);
        binding.rvFiorentiaCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFiorentiaCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        fiorentinaCasaA2022a23PartidaApi.getFiorentinaCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    fiorentinaCasa2022a23Adapter = new FiorentinaCasa2022a23Adapter(partidas);
                    binding.rvFiorentiaCasa.setAdapter(fiorentinaCasa2022a23Adapter);

                    binding.rvFiorentiaCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvFiorentiaCasa, new RecyclerItemClickListener.OnItemClickListener() {
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
                                case "Napoli":
                                    Intent napoli = new Intent(getContext(), NapoliActivity.class);
                                    startActivity(napoli);
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




