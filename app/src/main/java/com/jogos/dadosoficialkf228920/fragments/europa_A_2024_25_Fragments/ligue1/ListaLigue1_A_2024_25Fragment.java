package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.ligue1;

import static com.jogos.dadosoficialkf228920.util.estatistica70and88.Estatistica70ou88NewModel.melhoresStatisticasCasa;
import static com.jogos.dadosoficialkf228920.util.estatistica70and88.Estatistica70ou88NewModel.melhoresStatisticasFora;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.activity.carregarDadosActivity.CarregarDadosFragmentsActivity;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.adapter.mais70ou90.CarregarEstatistica70_90Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaLigue1A202425Binding;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.ligue1.util.JogosLigue1_A_2024_25;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.ligue1.util.JogosLigue1_A_2024_25_Listener;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListaLigue1_A_2024_25Fragment extends Fragment implements JogosLigue1_A_2024_25_Listener {

    private FragmentListaLigue1A202425Binding binding;

    private JogosLigue1_A_2024_25 jogosLigue1A202425;
    private TimesClasificacaoBrasilA2024Adapter timesClasificacaoBrasilA2024Adapter;


    // Lista para armazenar a classificação final
    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>();
    private HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime;

    public interface ListaLigue1_2025_OnClinkInterface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaLigue1_OnClick2025Metodo(String nome);//viu que é uma string ?sim
    }

    public interface ListaLigue1_2025_LongClickInterface{
        void listaLigue1_LongClick2025metodo();
    }

    //2 etapa criamos uma variavel da interface
    ListaLigue1_2025_OnClinkInterface listaLigue1_OnClick = null;//queremos usar o metodo listaBrasilAMetodo(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim

    //2 etapa criamos uma variavel da interface
    ListaLigue1_2025_LongClickInterface listaLigue1_LongClick = null;

    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof ListaLigue1_2025_OnClinkInterface){
            listaLigue1_OnClick = (ListaLigue1_2025_OnClinkInterface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }

        if(context instanceof ListaLigue1_2025_LongClickInterface){
            listaLigue1_LongClick = (ListaLigue1_2025_LongClickInterface) context;
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaLigue1A202425Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        jogosLigue1A202425 = new JogosLigue1_A_2024_25();
        jogosLigue1A202425.setupHttpClient();
        jogosLigue1A202425.setupDadosJogos();
        jogosLigue1A202425.setListener(this);// Registra o fragmento como listener


        binding.rvLista.setHasFixedSize(true);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLista.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesClasificacaoBrasilA2024Adapter = new TimesClasificacaoBrasilA2024Adapter(listaOficial);//o adapter vai receber a variazel listaOficial, mas ela esta vazia ainda
        binding.rvLista.setAdapter(timesClasificacaoBrasilA2024Adapter);


        // Incrementar o contador de acessos
        SharedPreferences preferences = requireContext().getSharedPreferences("ContadorAcessos", Context.MODE_PRIVATE);
        int acessos = preferences.getInt("contador", 0); // Recupera o contador atual
        acessos++; // Incrementa
        preferences.edit().putInt("contador", acessos).apply(); // Salva o novo valor

        Log.d("acessos ","onCreate: "+ acessos );

        binding.rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Recuperar contador de acessos
                SharedPreferences preferences = getContext().getSharedPreferences("ContadorAcessos", Context.MODE_PRIVATE);
                int acessos = preferences.getInt("contador", 0);

                // Recupera o item clicado com base na posição
                ClassificacaoOficialNovoModelo itemSelecionado = listaOficial.get(position);
                String name = itemSelecionado.getName();

                if (acessos >= 3) {
                    listaLigue1_OnClick.listaLigue1_OnClick2025Metodo(name);
                    // Reinicia o contador para zero
                    preferences.edit().putInt("contador", 0).apply();
                }else {
                    // Incrementa o contador
                    acessos++;
                    preferences.edit().putInt("contador", acessos).apply();
                }

                Log.d("acessos", "onItemClick: " + acessos);
                // Verifica se o mapa foi carregado e acessa os jogos do time
                if (partidasPorTime != null) {
                    Map<String, List<MatchNewModelDate>> jogosTime = partidasPorTime.get(itemSelecionado.getName());

                    if (jogosTime != null) {
                        // Combina partidas em uma única lista
                        List<MatchNewModelDate> listaPartidas = new ArrayList<>();
                        if (jogosTime.get("casa") != null) {
                            listaPartidas.addAll(jogosTime.get("casa"));
                        }
                        if (jogosTime.get("fora") != null) {
                            listaPartidas.addAll(jogosTime.get("fora"));
                        }

                        // Inicia a Activity com os dados
                        Intent intent = new Intent(getContext(), CarregarDadosFragmentsActivity.class);
                        intent.putParcelableArrayListExtra("lista_partidas", new ArrayList<>(listaPartidas));
                        intent.putExtra("nome_time", itemSelecionado.getName());
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Nenhuma partida encontrada para o time selecionado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Dados das partidas não carregados", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onLongItemClick(View view, int position) {
                listaLigue1_LongClick.listaLigue1_LongClick2025metodo();
                // Recupera o item selecionado com base na posição
                ClassificacaoOficialNovoModelo itemSelecionado = listaOficial.get(position);

                // Verifica se o mapa foi carregado e acessa os jogos do time
                if (partidasPorTime != null) {
                    Map<String, List<MatchNewModelDate>> jogosTime = partidasPorTime.get(itemSelecionado.getName());

                    if (jogosTime != null) {
                        // Combina partidas em uma única lista
                        List<MatchNewModelDate> listaPartidas = new ArrayList<>();
                        if (jogosTime.get("casa") != null) {
                            listaPartidas.addAll(jogosTime.get("casa"));
                        }
                        if (jogosTime.get("fora") != null) {
                            listaPartidas.addAll(jogosTime.get("fora"));
                        }

                        // Criação do PopupWindow
                        LayoutInflater inflater = LayoutInflater.from(view.getContext());
                        LinearLayout layoutPopup = (LinearLayout) inflater.inflate(R.layout.layout_porcentagem_estatistica, null);
                        PopupWindow popupWindow = new PopupWindow(layoutPopup,
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                true);

                        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                        popupWindow.setOutsideTouchable(true);
                        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                        // Configuração do layout do PopupWindow
                        TextView textTitulo = layoutPopup.findViewById(R.id.titulo_principal);
                        RecyclerView recyclerView = layoutPopup.findViewById(R.id.recycler_view);
                        Button btnMais70Casa = layoutPopup.findViewById(R.id.btn_mais_70_casa);
                        Button btnMais88Casa = layoutPopup.findViewById(R.id.btn_mais_88_casa);
                        Button btnMais70Fora = layoutPopup.findViewById(R.id.btn_mais_70_fora);
                        Button btnMais88Fora = layoutPopup.findViewById(R.id.btn_mais_88_fora);

                        String teamName = itemSelecionado.getName();
                        textTitulo.setText("Melhores Estatísticas - " + teamName);

                        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        CarregarEstatistica70_90Adapter adapter = new CarregarEstatistica70_90Adapter(new ArrayList<>());
                        recyclerView.setAdapter(adapter);

                        // Configuração dos botões para exibir estatísticas
                        btnMais70Casa.setOnClickListener(v -> {
                            List<CharSequence> estatisticas = melhoresStatisticasCasa(listaPartidas, teamName, 70);
                            adapter.setEstatisticas(estatisticas);
                            recyclerView.setVisibility(View.VISIBLE);
                        });

                        btnMais88Casa.setOnClickListener(v -> {
                            List<CharSequence> estatisticas = melhoresStatisticasCasa(listaPartidas, teamName, 88);
                            adapter.setEstatisticas(estatisticas);
                            recyclerView.setVisibility(View.VISIBLE);
                        });

                        btnMais70Fora.setOnClickListener(v -> {
                            List<CharSequence> estatisticas = melhoresStatisticasFora(listaPartidas, teamName, 70);
                            adapter.setEstatisticas(estatisticas);
                            recyclerView.setVisibility(View.VISIBLE);
                        });

                        btnMais88Fora.setOnClickListener(v -> {
                            List<CharSequence> estatisticas = melhoresStatisticasFora(listaPartidas, teamName, 88);
                            adapter.setEstatisticas(estatisticas);
                            recyclerView.setVisibility(View.VISIBLE);
                        });
                    } else {
                        Toast.makeText(getContext(), "Nenhuma partida encontrada para o time selecionado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Dados das partidas não carregados", Toast.LENGTH_SHORT).show();
                }


            }
        }));

        return view;
    }


    @Override
    public void onJogosLigue1_A_franca(HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime) {

        this.partidasPorTime = partidasPorTime;
        // Itera sobre o HashMap para processar cada time
        for (Map.Entry<String, Map<String, List<MatchNewModelDate>>> entry : partidasPorTime.entrySet()) {
            String nomeTime = entry.getKey();
            Map<String, List<MatchNewModelDate>> jogos = entry.getValue();

            // Inicializa os valores da classificação
            String image = null;
            int pontos = 0;
            int golsPro = 0;
            int golsContra = 0;
            int saldoGols = 0;
            int jogosTotais = 0;
            int vitorias = 0;
            int empates = 0;
            int derrotas = 0;

            // Processa os jogos em casa
            List<MatchNewModelDate> jogosCasa = jogos.get("casa");
            if (jogosCasa != null) {
                for (MatchNewModelDate partida : jogosCasa) {
                    image = partida.getHomeTime().getImage();
                    int golsFeitos = partida.getHomeTime().getScore();
                    int golsSofridos = partida.getAwayTime().getScore();

                    golsPro += golsFeitos;
                    golsContra += golsSofridos;

                    if (golsFeitos > golsSofridos) {
                        vitorias++;
                    } else if (golsFeitos == golsSofridos) {
                        empates++;
                    } else {
                        derrotas++;
                    }

                    jogosTotais++;
                }
            }

            // Processa os jogos fora
            List<MatchNewModelDate> jogosFora = jogos.get("fora");
            if (jogosFora != null) {
                for (MatchNewModelDate partida : jogosFora) {
                    image = partida.getAwayTime().getImage();
                    int golsFeitos = partida.getAwayTime().getScore();
                    int golsSofridos = partida.getHomeTime().getScore();

                    golsPro += golsFeitos;
                    golsContra += golsSofridos;

                    if (golsFeitos > golsSofridos) {
                        vitorias++;
                    } else if (golsFeitos == golsSofridos) {
                        empates++;
                    } else {
                        derrotas++;
                    }

                    jogosTotais++;
                }
            }

            // Calcula pontos e saldo de gols
            pontos = (vitorias * 3) + empates;
            saldoGols = golsPro - golsContra;

            // Cria o modelo de classificação
            ClassificacaoOficialNovoModelo classifica = new ClassificacaoOficialNovoModelo(
                    nomeTime,
                    image,
                    pontos,
                    golsPro,
                    golsContra,
                    saldoGols,
                    jogosTotais,
                    vitorias,
                    empates,
                    derrotas
            );

            // Adiciona à lista de classificação
            listaOficial.add(classifica);
        }

        listaOficial.sort(new ComparatorPontosVitoriaSaldoGolsProSerieA_B());
        //Collections.sort(minhaLista);
        Collections.reverse(listaOficial);

        //Mas entenda que o código abaixo sempre vai atualizar a lista inteira
        timesClasificacaoBrasilA2024Adapter.notifyDataSetChanged();

    }





}