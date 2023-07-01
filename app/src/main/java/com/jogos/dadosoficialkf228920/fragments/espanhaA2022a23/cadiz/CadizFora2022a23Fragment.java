package com.jogos.dadosoficialkf228920.fragments.espanhaA2022a23.cadiz;

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
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.AlmeriaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.AthleticBilbaoActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.AtleticoMadridActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.BarcelonaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.CeltaVigoActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.ElcheActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.EspanyolActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.GetafeActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.GironaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.MallorcaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.OsasunaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RayoVallecanoActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealBetisActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealMadridActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealSociedadActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealValladolidActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.SevillaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.ValenciaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.VillarrealActivity;
import com.jogos.dadosoficialkf228920.adapter.espanhaA2022a23.cadiz.CadizFora2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.espanhaA2022a23.cadiz.CadizForaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentCadizFora2022a23Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CadizFora2022a23Fragment extends Fragment {


    private FragmentCadizFora2022a23Binding binding;
    private CadizForaA2022a23PartidaApi cadizForaA2022a23PartidaApi;
    private CadizFora2022a23Adapter cadizFora2022a23Adapter;


    public CadizFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCadizFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/espanhol-a-2022-23/cadiz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cadizForaA2022a23PartidaApi = retrofit.create(CadizForaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvCadizFora.setHasFixedSize(true);
        binding.rvCadizFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCadizFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        cadizForaA2022a23PartidaApi.getCadizFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    cadizFora2022a23Adapter = new CadizFora2022a23Adapter(partidas);
                    binding.rvCadizFora.setAdapter(cadizFora2022a23Adapter);

                    binding.rvCadizFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvCadizFora, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "Almería":
                                    Intent almeria = new Intent(getContext(), AlmeriaActivity.class);
                                    startActivity(almeria);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Athletic Bilbao":
                                    Intent athleticBilbao = new Intent(getContext(), AthleticBilbaoActivity.class);
                                    startActivity(athleticBilbao);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Atlético de Madrid":
                                    Intent atleticoMadrid = new Intent(getContext(), AtleticoMadridActivity.class);
                                    startActivity(atleticoMadrid);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Barcelona":
                                    Intent barcelona = new Intent(getContext(), BarcelonaActivity.class);
                                    startActivity(barcelona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Celta de Vigo":
                                    Intent celtaVigo = new Intent(getContext(), CeltaVigoActivity.class);
                                    startActivity(celtaVigo);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Elche":
                                    Intent elche = new Intent(getContext(), ElcheActivity.class);
                                    startActivity(elche);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Espanyol":
                                    Intent espanyol = new Intent(getContext(), EspanyolActivity.class);
                                    startActivity(espanyol);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Getafe":
                                    Intent getafe = new Intent(getContext(), GetafeActivity.class);
                                    startActivity(getafe);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Girona":
                                    Intent girona = new Intent(getContext(), GironaActivity.class);
                                    startActivity(girona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mallorca":
                                    Intent mallorca = new Intent(getContext(), MallorcaActivity.class);
                                    startActivity(mallorca);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Osasuna":
                                    Intent osasuna = new Intent(getContext(), OsasunaActivity.class);
                                    startActivity(osasuna);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rayo Vallecano":
                                    Intent rayoVallecano = new Intent(getContext(), RayoVallecanoActivity.class);
                                    startActivity(rayoVallecano);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Betis":
                                    Intent realBetis = new Intent(getContext(), RealBetisActivity.class);
                                    startActivity(realBetis);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Madrid":
                                    Intent realMadrid = new Intent(getContext(), RealMadridActivity.class);
                                    startActivity(realMadrid);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Sociedad":
                                    Intent realSociedad = new Intent(getContext(), RealSociedadActivity.class);
                                    startActivity(realSociedad);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Valladolid":
                                    Intent realValladolid = new Intent(getContext(), RealValladolidActivity.class);
                                    startActivity(realValladolid);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sevilla":
                                    Intent sevilla = new Intent(getContext(), SevillaActivity.class);
                                    startActivity(sevilla);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Valencia":
                                    Intent valencica = new Intent(getContext(), ValenciaActivity.class);
                                    startActivity(valencica);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Villarreal":
                                    Intent villarreal = new Intent(getContext(), VillarrealActivity.class);
                                    startActivity(villarreal);
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

