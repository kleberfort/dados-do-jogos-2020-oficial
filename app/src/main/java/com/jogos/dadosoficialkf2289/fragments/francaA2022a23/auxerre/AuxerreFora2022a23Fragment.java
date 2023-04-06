package com.jogos.dadosoficialkf2289.fragments.francaA2022a23.auxerre_dados_geral;

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

import com.jogos.dadosoficialkf2289.activity.francaA2022a23.AjaccioActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.AngersActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.BrestActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.ClermontActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.LensActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.LilleActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.LorientActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.LyonActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.MarseilleActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.MonacoActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.MontpellierActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.NantesActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.NiceActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.PsgActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.ReimsActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.RennesActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.StrasbourgActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.ToulouseActivity;
import com.jogos.dadosoficialkf2289.activity.francaA2022a23.TroyesActivity;
import com.jogos.dadosoficialkf2289.adapter.francaA2022a23.auxerre.AuxerreFora2022a23Adapter;
import com.jogos.dadosoficialkf2289.data.francaA2022a23.auxerre.AuxerreForaA2022a23PartidaApi;
import com.jogos.dadosoficialkf2289.databinding.FragmentAuxerreFora2022a23Binding;
import com.jogos.dadosoficialkf2289.model.Partida;
import com.jogos.dadosoficialkf2289.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AuxerreFora2022a23Fragment extends Fragment {

    private FragmentAuxerreFora2022a23Binding binding;
    private AuxerreForaA2022a23PartidaApi auxerreForaA2022a23PartidaApi;
    private AuxerreFora2022a23Adapter auxerreFora2022a23Adapter;



    public AuxerreFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAuxerreFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/franca-a-2022-23/auxerre/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        auxerreForaA2022a23PartidaApi = retrofit.create(AuxerreForaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvAuxerreFora.setHasFixedSize(true);
        binding.rvAuxerreFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAuxerreFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        auxerreForaA2022a23PartidaApi.getAuxerreFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    auxerreFora2022a23Adapter = new AuxerreFora2022a23Adapter(partidas);
                    binding.rvAuxerreFora.setAdapter(auxerreFora2022a23Adapter);

                    binding.rvAuxerreFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvAuxerreFora, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "Ajaccio":
                                    Intent ajaccio = new Intent(getContext(), AjaccioActivity.class);
                                    startActivity(ajaccio);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Angers":
                                    Intent angers = new Intent(getContext(), AngersActivity.class);
                                    startActivity(angers);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brest":
                                    Intent brest = new Intent(getContext(), BrestActivity.class);
                                    startActivity(brest);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Clermont":
                                    Intent clermont = new Intent(getContext(), ClermontActivity.class);
                                    startActivity(clermont);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lens":
                                    Intent lens = new Intent(getContext(), LensActivity.class);
                                    startActivity(lens);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lille":
                                    Intent lille = new Intent(getContext(), LilleActivity.class);
                                    startActivity(lille);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lorient":
                                    Intent lorient = new Intent(getContext(), LorientActivity.class);
                                    startActivity(lorient);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lyon":
                                    Intent lyon = new Intent(getContext(), LyonActivity.class);
                                    startActivity(lyon);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Marseille":
                                    Intent marseille = new Intent(getContext(), MarseilleActivity.class);
                                    startActivity(marseille);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monaco":
                                    Intent monaco = new Intent(getContext(), MonacoActivity.class);
                                    startActivity(monaco);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Montpellier":
                                    Intent montpellier = new Intent(getContext(), MontpellierActivity.class);
                                    startActivity(montpellier);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nantes":
                                    Intent nantes = new Intent(getContext(), NantesActivity.class);
                                    startActivity(nantes);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nice":
                                    Intent nice = new Intent(getContext(), NiceActivity.class);
                                    startActivity(nice);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "PSG":
                                    Intent psg = new Intent(getContext(), PsgActivity.class);
                                    startActivity(psg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Reims":
                                    Intent reims = new Intent(getContext(), ReimsActivity.class);
                                    startActivity(reims);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rennes":
                                    Intent rennes = new Intent(getContext(), RennesActivity.class);
                                    startActivity(rennes);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Strasbourg":
                                    Intent strasbourg = new Intent(getContext(), StrasbourgActivity.class);
                                    startActivity(strasbourg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Toulouse":
                                    Intent toulouse = new Intent(getContext(), ToulouseActivity.class);
                                    startActivity(toulouse);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Troyes":
                                    Intent troyes = new Intent(getContext(), TroyesActivity.class);
                                    startActivity(troyes);
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
