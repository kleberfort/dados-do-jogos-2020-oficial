package com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.sampaiocorrea;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AbcActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AtleticoGoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AvaiActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.CearaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.ChapecoenseActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.CrbActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.CriciumaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.GuaraniActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.ItuanoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.JuventudeActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.LondrinaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.MirassolActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.NovorizontinoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.PontePretaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.SampaioCorreiaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.SportActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.TombenseActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.VilaNovaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.VitoriaActivity;
import com.jogos.dadosoficialkf228920.adapter.brasileriroB2023.sampaiocorrea.SampaioCorreaForaB2023Adapter;
import com.jogos.dadosoficialkf228920.data.brasileiroB2023.sampaiocorrea.SampaioCorreaForaB2023PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentSampaiocorreaForaB2023Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SampaioCorreaFora2023Fragment extends Fragment {

    private FragmentSampaiocorreaForaB2023Binding binding;
    private SampaioCorreaForaB2023Adapter sampaioCorreaForaB2023Adapter;
    private SampaioCorreaForaB2023PartidaApi sampaioCorreaForaB2023PartidaApi;




    public SampaioCorreaFora2023Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSampaiocorreaForaB2023Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-b-2023/sampaiocorreia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sampaioCorreaForaB2023PartidaApi = retrofit.create(SampaioCorreaForaB2023PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvSampaioCorreaFora.setHasFixedSize(true);
        binding.rvSampaioCorreaFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvSampaioCorreaFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        sampaioCorreaForaB2023PartidaApi.getSampaioCorreaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    sampaioCorreaForaB2023Adapter = new SampaioCorreaForaB2023Adapter(partidas);
                    binding.rvSampaioCorreaFora.setAdapter(sampaioCorreaForaB2023Adapter);

                    binding.rvSampaioCorreaFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvSampaioCorreaFora, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "ABC":
                                    Intent abc = new Intent(getContext(), AbcActivity.class);
                                    startActivity(abc);
                                    break;

                                case "CRB":
                                    Intent crb = new Intent(getContext(), CrbActivity.class);
                                    startActivity(crb);
                                    break;
                                case "Atlético-GO":
                                    Intent atleticoGo = new Intent(getContext(), AtleticoGoActivity.class);
                                    startActivity(atleticoGo);
                                    break;
                                case "Avaí":
                                    Intent avai = new Intent(getContext(), AvaiActivity.class);
                                    startActivity(avai);
                                    break;
                                case "Chapecoense":
                                    Intent chapecoense = new Intent(getContext(), ChapecoenseActivity.class);
                                    startActivity(chapecoense);
                                    break;
                                case "Criciúma":
                                    Intent criciuma = new Intent(getContext(), CriciumaActivity.class);
                                    startActivity(criciuma);
                                    break;
                                case "Ceará":
                                    Intent ceara = new Intent(getContext(), CearaActivity.class);
                                    startActivity(ceara);
                                    break;
                                case "Guarani":
                                    Intent guarani = new Intent(getContext(), GuaraniActivity.class);
                                    startActivity(guarani);
                                    break;
                                case "Ituano":
                                    Intent ituano = new Intent(getContext(), ItuanoActivity.class);
                                    startActivity(ituano);
                                    break;
                                case "Juventude":
                                    Intent juventude = new Intent(getContext(), JuventudeActivity.class);
                                    startActivity(juventude);
                                    break;
                                case "Londrina":
                                    Intent londrina = new Intent(getContext(), LondrinaActivity.class);
                                    startActivity(londrina);
                                    break;
                                case "Mirassol":
                                    Intent mirassol = new Intent(getContext(), MirassolActivity.class);
                                    startActivity(mirassol);
                                    break;
                                case "Novorizontino":
                                    Intent novorizontino = new Intent(getContext(), NovorizontinoActivity.class);
                                    startActivity(novorizontino);
                                    break;
                                case "Ponte Preta":
                                    Intent pontePreta = new Intent(getContext(), PontePretaActivity.class);
                                    startActivity(pontePreta);
                                    break;
                                case "Sampaio Corrêa":
                                    Intent sampaioCorrea = new Intent(getContext(), SampaioCorreiaActivity.class);
                                    startActivity(sampaioCorrea);
                                    break;
                                case "Sport":
                                    Intent sport = new Intent(getContext(), SportActivity.class);
                                    startActivity(sport);
                                    break;
                                case "Tombense":
                                    Intent tombense = new Intent(getContext(), TombenseActivity.class);
                                    startActivity(tombense);
                                    break;
                                case "Vila Nova":
                                    Intent vilaNova = new Intent(getContext(), VilaNovaActivity.class);
                                    startActivity(vilaNova);
                                    break;
                                case "Vitória":
                                    Intent vitoria = new Intent(getContext(), VitoriaActivity.class);
                                    startActivity(vitoria);
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