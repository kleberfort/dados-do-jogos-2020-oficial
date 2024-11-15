package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina;

import static com.jogos.dadosoficialkf228920.util.estatistica70and88.Estatistica70ou88.melhoresStatisticasCasa;
import static com.jogos.dadosoficialkf228920.util.estatistica70and88.Estatistica70ou88.melhoresStatisticasFora;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.ArgentinoJuniors2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.AtleticoTucuman2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Banfield2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.BarracasCentral2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Belgrano2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.BocaJuniors2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.CentralCordoba2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.DefensaJusticia2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.DeportivoRiestra2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.EstudiantesLaPrata2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Gimnasia2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.GodoyCruz2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Huracan2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Independiente2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.IndependienteRivadavia2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Instituto2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Lanus2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.NewellOldBoys2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Platense2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Racing2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.RiverPlate2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.RosarioCentral2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.SanLorenzo2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Sarmiento2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Talleres2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Tigre2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.UnionSanteFe2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.VelezSarsfield2024Activity;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.adapter.mais70ou90.CarregarEstatistica70_90Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaLigaProfissionalA2024Binding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A2024;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A_2024_Listener;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.ListaBrasilSerieA_2024_TesteFragment;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaLigaProfissional_A_2024Fragment extends Fragment implements JogosLigaProfissional_A_2024_Listener {

    private FragmentListaLigaProfissionalA2024Binding binding;
    private JogosLigaProfissional_A2024 jogosLigaProfissionalA2024;
    private TimesClasificacaoBrasilA2024Adapter timesClasificacaoBrasilA2024Adapter;

    String nome = null;
    String imagem = null;


    Integer totalGolsPro = 0;
    Integer totalGolsContra = 0;
    Integer totalsaldoGols = 0;

    Integer totalJogos = 0;

    Integer totalVitoria = 0;
    Integer totalEmpate = 0;
    Integer totalDerrota = 0;
    Integer totalPontos = 0;

    List<PartidaNovoModelo> argentinoJuniorsCompleto = new ArrayList<>();
    List<PartidaNovoModelo> atleticoTucumanCompleto = new ArrayList<>();
    List<PartidaNovoModelo> banfieldCompleto = new ArrayList<>();
    List<PartidaNovoModelo> barracasCentralCompleto = new ArrayList<>();
    List<PartidaNovoModelo> belgranoCompleto = new ArrayList<>();
    List<PartidaNovoModelo> bocaJuniorsCompleto = new ArrayList<>();
    List<PartidaNovoModelo> centralCordobaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> defensaJusticiaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> deportivoRiestraCompleto = new ArrayList<>();
    List<PartidaNovoModelo> estudiantesLaPrataCompleto = new ArrayList<>();
    List<PartidaNovoModelo> gimnasiaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> godoyCruzCompleto = new ArrayList<>();
    List<PartidaNovoModelo> huracanCompleto = new ArrayList<>();
    List<PartidaNovoModelo> independienteCompleto = new ArrayList<>();
    List<PartidaNovoModelo> independienteRivadaviaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> institutoCompleto = new ArrayList<>();
    List<PartidaNovoModelo> lanusCompleto = new ArrayList<>();
    List<PartidaNovoModelo> newellOldBoysCompleto = new ArrayList<>();
    List<PartidaNovoModelo> platenseCompleto = new ArrayList<>();
    List<PartidaNovoModelo> racingCompleto = new ArrayList<>();
    List<PartidaNovoModelo> riverPlateCompleto = new ArrayList<>();
    List<PartidaNovoModelo> rosarioCentralCompleto = new ArrayList<>();
    List<PartidaNovoModelo> sanLorenzoCompleto = new ArrayList<>();
    List<PartidaNovoModelo> sarmientoCompleto = new ArrayList<>();
    List<PartidaNovoModelo> talleresCompleto = new ArrayList<>();
    List<PartidaNovoModelo> tigreCompleto = new ArrayList<>();
    List<PartidaNovoModelo> unionSantaFeCompleto = new ArrayList<>();
    List<PartidaNovoModelo> velezSarsfieldCompleto = new ArrayList<>();

    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>(); ;//estamos iniciando nossa lista vazia



    public interface ListaArgentinaA2024Interface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaArgentinaAMetodo(String nome);//viu que é uma string ?sim
    }

    public interface ListaArgentinaA2024ClickLongInterface{
        void listaArgentinaAClickLong();
    }


    //2 etapa criamos uma variavel da interface
    ListaArgentinaA2024Interface listaArgentinaA2024 = null;//queremos usar o metodo listaInglesa(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim

    ListaArgentinaA2024ClickLongInterface listaArgentinaA2024ClickLong = null;

    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof ListaArgentinaA2024Interface){
            listaArgentinaA2024 = (ListaArgentinaA2024Interface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }

        if(context instanceof  ListaArgentinaA2024ClickLongInterface){
            listaArgentinaA2024ClickLong = (ListaArgentinaA2024ClickLongInterface) context;

        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaLigaProfissionalA2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        jogosLigaProfissionalA2024 = new JogosLigaProfissional_A2024();
        jogosLigaProfissionalA2024.setupHttpClient();
        jogosLigaProfissionalA2024.setupDadosJogos();
        jogosLigaProfissionalA2024.setListener(this);// Registra o fragmento como listener

        binding.rvLista.setHasFixedSize(true);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLista.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesClasificacaoBrasilA2024Adapter = new TimesClasificacaoBrasilA2024Adapter(listaOficial);//o adapter vai receber a variazel listaOficial, mas ela esta vazia ainda
        binding.rvLista.setAdapter(timesClasificacaoBrasilA2024Adapter);



        binding.rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClassificacaoOficialNovoModelo lista = listaOficial.get(position);

                switch (lista.getName()){
                    case "Argentinos Jrs":
                        listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
//                         Intent intent = new Intent(getContext(), ArgentinoJuniors2024Activity.class);
//                         startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Atl. Tucuman":
                        listaArgentinaA2024.listaArgentinaAMetodo("Atl. Tucuman");
//                         intent = new Intent(getContext(), AtleticoTucuman2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Banfield":
                        listaArgentinaA2024.listaArgentinaAMetodo("Banfield");
//                         intent = new Intent(getContext(), Banfield2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Barracas Central":
                        listaArgentinaA2024.listaArgentinaAMetodo("Barracas Central");
//                         intent = new Intent(getContext(), BarracasCentral2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Belgrano":
                        listaArgentinaA2024.listaArgentinaAMetodo("Belgrano");
//                         intent = new Intent(getContext(), Belgrano2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Boca Juniors":
                        listaArgentinaA2024.listaArgentinaAMetodo("Boca Juniors");
//                         intent = new Intent(getContext(), BocaJuniors2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Central Córdoba":
                        listaArgentinaA2024.listaArgentinaAMetodo("Central Córdoba");
//                         intent = new Intent(getContext(), CentralCordoba2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Def. Justicia":
                        listaArgentinaA2024.listaArgentinaAMetodo("Def. Justicia");
//                         intent = new Intent(getContext(), DefensaJusticia2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Deportivo Riestra":
                        listaArgentinaA2024.listaArgentinaAMetodo("Deportivo Riestra");
//                         intent = new Intent(getContext(), DeportivoRiestra2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Estudiantes":
                        listaArgentinaA2024.listaArgentinaAMetodo("Estudiantes");
//                         intent = new Intent(getContext(), EstudiantesLaPrata2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Gimnasia":
                        listaArgentinaA2024.listaArgentinaAMetodo("Gimnasia");
//                        intent = new Intent(getContext(), Gimnasia2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Godoy Cruz":
                        listaArgentinaA2024.listaArgentinaAMetodo("Godoy Cruz");
//                        intent = new Intent(getContext(), GodoyCruz2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Huracán":
                        listaArgentinaA2024.listaArgentinaAMetodo("Huracán");
//                        intent = new Intent(getContext(), Huracan2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Independiente":
                        listaArgentinaA2024.listaArgentinaAMetodo("Independiente");
//                        intent = new Intent(getContext(), Independiente2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Ind. Rivadavia":
                        listaArgentinaA2024.listaArgentinaAMetodo("Ind. Rivadavia");
//                        intent = new Intent(getContext(), IndependienteRivadavia2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Instituto":
                        listaArgentinaA2024.listaArgentinaAMetodo("Instituto");
//                        intent = new Intent(getContext(), Instituto2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Lanús":
                        listaArgentinaA2024.listaArgentinaAMetodo("Lanús");
//                        intent = new Intent(getContext(), Lanus2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Newell Old Boys":
                        listaArgentinaA2024.listaArgentinaAMetodo("Newell Old Boys");
//                        intent = new Intent(getContext(), NewellOldBoys2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Platense":
                        listaArgentinaA2024.listaArgentinaAMetodo("Platense");
//                        intent = new Intent(getContext(), Platense2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Racing":
                        listaArgentinaA2024.listaArgentinaAMetodo("Racing");
//                        intent = new Intent(getContext(), Racing2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "River Plate":
                        listaArgentinaA2024.listaArgentinaAMetodo("River Plate");
//                        intent = new Intent(getContext(), RiverPlate2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Rosario":
                        listaArgentinaA2024.listaArgentinaAMetodo("Rosario");
//                        intent = new Intent(getContext(), RosarioCentral2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "San Lorenzo":
                        listaArgentinaA2024.listaArgentinaAMetodo("San Lorenzo");
//                        intent = new Intent(getContext(), SanLorenzo2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Sarmiento":
                        listaArgentinaA2024.listaArgentinaAMetodo("Sarmiento");
//                        intent = new Intent(getContext(), Sarmiento2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Talleres":
                        listaArgentinaA2024.listaArgentinaAMetodo("Talleres");
//                        intent = new Intent(getContext(), Talleres2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Tigre":
                        listaArgentinaA2024.listaArgentinaAMetodo("Tigre");
//                        intent = new Intent(getContext(), Tigre2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Union Santa Fe":
                        listaArgentinaA2024.listaArgentinaAMetodo("Union Santa Fe");
//                        intent = new Intent(getContext(), UnionSanteFe2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Vélez Sársfield":
                        listaArgentinaA2024.listaArgentinaAMetodo("Vélez Sársfield");
//                        intent = new Intent(getContext(), VelezSarsfield2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                }

            }

            @Override
            public void onLongItemClick(View view, int position) {
                listaArgentinaA2024ClickLong.listaArgentinaAClickLong();

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

                TextView textTitulo = layoutPopup.findViewById(R.id.titulo_principal);
                RecyclerView recyclerView = layoutPopup.findViewById(R.id.recycler_view);
                Button btnMais70Casa = layoutPopup.findViewById(R.id.btn_mais_70_casa);
                Button btnMais88Casa = layoutPopup.findViewById(R.id.btn_mais_88_casa);
                Button btnMais70Fora = layoutPopup.findViewById(R.id.btn_mais_70_fora);
                Button btnMais88Fora = layoutPopup.findViewById(R.id.btn_mais_88_fora);

                String teamName = listaOficial.get(position).getName();
                textTitulo.setText("Melhores Estatísticas - " + teamName);

                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                CarregarEstatistica70_90Adapter adapter = new CarregarEstatistica70_90Adapter(new ArrayList<>());
                recyclerView.setAdapter(adapter);

                // Seleciona a lista correta com base no time
                List<PartidaNovoModelo> listaSelecionada;
                switch (teamName) {
                    case "Argentinos Jrs":
                        listaSelecionada = argentinoJuniorsCompleto;
                        break;
                    case "Atl. Tucuman":
                        listaSelecionada = atleticoTucumanCompleto;
                        break;
                    case "Banfield":
                        listaSelecionada = banfieldCompleto;
                        break;
                    case "Barracas Central":
                        listaSelecionada = barracasCentralCompleto;
                        break;
                    case "Belgrano":
                        listaSelecionada = belgranoCompleto;
                        break;
                    case "Boca Juniors":
                        listaSelecionada = bocaJuniorsCompleto;
                        break;
                    case "Central Córdoba":
                        listaSelecionada = centralCordobaCompleto;
                        break;
                    case "Def. Justicia":
                        listaSelecionada = defensaJusticiaCompleto;
                        break;
                    case "Deportivo Riestra":
                        listaSelecionada = deportivoRiestraCompleto;
                        break;
                    case "Estudiantes":
                        listaSelecionada = estudiantesLaPrataCompleto;
                        break;
                    case "Gimnasia":
                        listaSelecionada = gimnasiaCompleto;
                        break;
                    case "Godoy Cruz":
                        listaSelecionada = godoyCruzCompleto;
                        break;
                    case "Huracán":
                        listaSelecionada = huracanCompleto;
                        break;
                    case "Independiente":
                        listaSelecionada = independienteCompleto;
                        break;
                    case "Ind. Rivadavia":
                        listaSelecionada = independienteRivadaviaCompleto;
                        break;
                    case "Instituto":
                        listaSelecionada = institutoCompleto;
                        break;
                    case "Lanús":
                        listaSelecionada = lanusCompleto;
                        break;
                    case "Newell Old Boys":
                        listaSelecionada = newellOldBoysCompleto;
                        break;
                    case "Platense":
                        listaSelecionada = platenseCompleto;
                        break;
                    case "Racing":
                        listaSelecionada = racingCompleto;
                        break;
                    case "River Plate":
                        listaSelecionada = riverPlateCompleto;
                        break;
                    case "Rosario":
                        listaSelecionada = rosarioCentralCompleto;
                        break;
                    case "San Lorenzo":
                        listaSelecionada = sanLorenzoCompleto;
                        break;
                    case "Sarmiento":
                        listaSelecionada = sarmientoCompleto;
                        break;
                    case "Talleres":
                        listaSelecionada = talleresCompleto;
                        break;
                    case "Tigre":
                        listaSelecionada = tigreCompleto;
                        break;
                    case "Union Santa Fe":
                        listaSelecionada = unionSantaFeCompleto;
                        break;
                    case "Vélez Sársfield":
                        listaSelecionada = velezSarsfieldCompleto;
                        break;
                    // Adicione outros times aqui
                    default:
                        listaSelecionada = new ArrayList<>(); // Caso o time não seja encontrado
                        break;
                }

                // Configuração dos botões para exibir os dados correspondentes
                btnMais70Casa.setOnClickListener(v -> {
                    List<CharSequence> estatisticas = melhoresStatisticasCasa(listaSelecionada, teamName, 70);
                    adapter.setEstatisticas(estatisticas);
                    recyclerView.setVisibility(View.VISIBLE);
                });

                btnMais88Casa.setOnClickListener(v -> {
                    List<CharSequence> estatisticas = melhoresStatisticasCasa(listaSelecionada, teamName, 88);
                    adapter.setEstatisticas(estatisticas);
                    recyclerView.setVisibility(View.VISIBLE);
                });

                btnMais70Fora.setOnClickListener(v -> {
                    List<CharSequence> estatisticas = melhoresStatisticasFora(listaSelecionada, teamName, 70);
                    adapter.setEstatisticas(estatisticas);
                    recyclerView.setVisibility(View.VISIBLE);
                });

                btnMais88Fora.setOnClickListener(v -> {
                    List<CharSequence> estatisticas = melhoresStatisticasFora(listaSelecionada, teamName, 88);
                    adapter.setEstatisticas(estatisticas);
                    recyclerView.setVisibility(View.VISIBLE);
                });
            }
        }));


        return view;
    }

    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> argentinoJuniorsCompleto, List<PartidaNovoModelo> atleticoTucumanCompleto, List<PartidaNovoModelo> banfieldCompleto, List<PartidaNovoModelo> barracasCentralCompleto, List<PartidaNovoModelo> belgranoCompleto, List<PartidaNovoModelo> bocaJuniorsCompleto, List<PartidaNovoModelo> centralCordobaCompleto, List<PartidaNovoModelo> defensaJusticiaCompleto, List<PartidaNovoModelo> deportivoRiestraCompleto, List<PartidaNovoModelo> estudiantesLaPrataCompleto, List<PartidaNovoModelo> gimnasiaCompleto, List<PartidaNovoModelo> godoyCruzCompleto, List<PartidaNovoModelo> huracanCompleto, List<PartidaNovoModelo> independienteCompleto, List<PartidaNovoModelo> independienteRivadaviaCompleto, List<PartidaNovoModelo> institutoCompleto, List<PartidaNovoModelo> lanusCompleto, List<PartidaNovoModelo> newellOldBoysCompleto, List<PartidaNovoModelo> platenseCompleto, List<PartidaNovoModelo> racingCompleto, List<PartidaNovoModelo> riverPlateCompleto, List<PartidaNovoModelo> rosarioCentralCompleto, List<PartidaNovoModelo> sanLorenzoCompleto, List<PartidaNovoModelo> sarmientoCompleto, List<PartidaNovoModelo> talleresCompleto, List<PartidaNovoModelo> tigreCompleto, List<PartidaNovoModelo> unionSantaFeCompleto, List<PartidaNovoModelo> velezSarsfieldCompleto) {

         this.argentinoJuniorsCompleto = argentinoJuniorsCompleto;
         this.atleticoTucumanCompleto = atleticoTucumanCompleto;
         this.banfieldCompleto =  banfieldCompleto;
         this.barracasCentralCompleto = barracasCentralCompleto;
        this.belgranoCompleto = belgranoCompleto;
        this.bocaJuniorsCompleto = bocaJuniorsCompleto;
        this.centralCordobaCompleto = centralCordobaCompleto;
        this.defensaJusticiaCompleto = defensaJusticiaCompleto;
        this. deportivoRiestraCompleto = deportivoRiestraCompleto;
        this.estudiantesLaPrataCompleto = estudiantesLaPrataCompleto;
        this.gimnasiaCompleto = gimnasiaCompleto;
         this.godoyCruzCompleto = godoyCruzCompleto;
         this.huracanCompleto = huracanCompleto;
         this.independienteCompleto = independienteCompleto;
        this.independienteRivadaviaCompleto = independienteRivadaviaCompleto;
         this.institutoCompleto = institutoCompleto;
         this.lanusCompleto = lanusCompleto;
         this.newellOldBoysCompleto = newellOldBoysCompleto;
         this.platenseCompleto = platenseCompleto;
         this.racingCompleto = racingCompleto;
         this.riverPlateCompleto = riverPlateCompleto;
         this.rosarioCentralCompleto = rosarioCentralCompleto;
         this.sanLorenzoCompleto = sanLorenzoCompleto;
         this.sarmientoCompleto = sarmientoCompleto;
         this.talleresCompleto = talleresCompleto;
         this.tigreCompleto = tigreCompleto;
         this.unionSantaFeCompleto = unionSantaFeCompleto;
         this.velezSarsfieldCompleto = velezSarsfieldCompleto;

        //ClassificaTeste classificaTeste = new ClassificaTeste();

        ClassificacaoOficialNovoModelo classificacaoOficialNovoModelo = new ClassificacaoOficialNovoModelo();


        String name = null;
        String image = null;
        Integer pontos = 0;
        Integer golsPro = 0;
        Integer golsContra = 0;
        Integer saldoGols = 0;
        Integer jogos = 0;
        Integer vitoria = 0;
        Integer empate = 0;
        Integer derrota = 0;


        for (int i = 0; i < argentinoJuniorsCompleto.size(); i++) {
            if (argentinoJuniorsCompleto.get(i).getHomeTime().getName().equals("Argentinos Jrs")) {
                // ClassificaTeste classificaTeste = new ClassificaTeste();
                name = argentinoJuniorsCompleto.get(i).getHomeTime().getName();
                image = argentinoJuniorsCompleto.get(i).getHomeTime().getImage();
                if (argentinoJuniorsCompleto.get(i).getHomeTime().getScore() > argentinoJuniorsCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (argentinoJuniorsCompleto.get(i).getHomeTime().getScore() == argentinoJuniorsCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (argentinoJuniorsCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += argentinoJuniorsCompleto.get(i).getHomeTime().getScore();
                if (argentinoJuniorsCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += argentinoJuniorsCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (argentinoJuniorsCompleto.get(i).getAwayTime().getName().equals("Argentinos Jrs")) {
                //ClassificaTeste classificaTeste = new ClassificaTeste();
                name = argentinoJuniorsCompleto.get(i).getAwayTime().getName();
                image = argentinoJuniorsCompleto.get(i).getAwayTime().getImage();
                if (argentinoJuniorsCompleto.get(i).getAwayTime().getScore() > argentinoJuniorsCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (argentinoJuniorsCompleto.get(i).getAwayTime().getScore() == argentinoJuniorsCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (argentinoJuniorsCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += argentinoJuniorsCompleto.get(i).getAwayTime().getScore();
                if (argentinoJuniorsCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += argentinoJuniorsCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;

            }//fim do segundo if arsenal

        }//fim do for arsenal

        ClassificacaoOficialNovoModelo classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);

        listaOficial.add(classifica);//adicionamos as informacoes na nossa variavel que foi passada para o adapter na linha 110.
        //essa variavel listaOficial esta associada ao nosso adapter, pois fizemos isso na linha 110
        //entendeu essa parte ?sim


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < atleticoTucumanCompleto.size(); i++) {
            if (atleticoTucumanCompleto.get(i).getHomeTime().getName().equals("Atl. Tucuman")) {
                name = atleticoTucumanCompleto.get(i).getHomeTime().getName();
                image = atleticoTucumanCompleto.get(i).getHomeTime().getImage();
                if (atleticoTucumanCompleto.get(i).getHomeTime().getScore() > atleticoTucumanCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoTucumanCompleto.get(i).getHomeTime().getScore() == atleticoTucumanCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoTucumanCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += atleticoTucumanCompleto.get(i).getHomeTime().getScore();
                if (atleticoTucumanCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra +=  atleticoTucumanCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (atleticoTucumanCompleto.get(i).getAwayTime().getName().equals("Atl. Tucuman")) {
                name = atleticoTucumanCompleto.get(i).getAwayTime().getName();
                image = atleticoTucumanCompleto.get(i).getAwayTime().getImage();
                if (atleticoTucumanCompleto.get(i).getAwayTime().getScore() > atleticoTucumanCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoTucumanCompleto.get(i).getAwayTime().getScore() == atleticoTucumanCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoTucumanCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += atleticoTucumanCompleto.get(i).getAwayTime().getScore();
                if (atleticoTucumanCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += atleticoTucumanCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for astonVilla

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < banfieldCompleto.size(); i++) {
            if (banfieldCompleto.get(i).getHomeTime().getName().equals("Banfield")) {
                name = banfieldCompleto.get(i).getHomeTime().getName();
                image = banfieldCompleto.get(i).getHomeTime().getImage();
                if (banfieldCompleto.get(i).getHomeTime().getScore() > banfieldCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (banfieldCompleto.get(i).getHomeTime().getScore() == banfieldCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (banfieldCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += banfieldCompleto.get(i).getHomeTime().getScore();
                if (banfieldCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += banfieldCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (banfieldCompleto.get(i).getAwayTime().getName().equals("Banfield")) {
                name = banfieldCompleto.get(i).getAwayTime().getName();
                image = banfieldCompleto.get(i).getAwayTime().getImage();
                if (banfieldCompleto.get(i).getAwayTime().getScore() > banfieldCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (banfieldCompleto.get(i).getAwayTime().getScore() == banfieldCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (banfieldCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += banfieldCompleto.get(i).getAwayTime().getScore();
                if (banfieldCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += banfieldCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for bournemouth

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < barracasCentralCompleto.size(); i++) {
            if (barracasCentralCompleto.get(i).getHomeTime().getName().equals("Barracas Central")) {
                name = barracasCentralCompleto.get(i).getHomeTime().getName();
                image = barracasCentralCompleto.get(i).getHomeTime().getImage();
                if (barracasCentralCompleto.get(i).getHomeTime().getScore() > barracasCentralCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (barracasCentralCompleto.get(i).getHomeTime().getScore() == barracasCentralCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (barracasCentralCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += barracasCentralCompleto.get(i).getHomeTime().getScore();
                if (barracasCentralCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += barracasCentralCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (barracasCentralCompleto.get(i).getAwayTime().getName().equals("Barracas Central")) {
                name = barracasCentralCompleto.get(i).getAwayTime().getName();
                image = barracasCentralCompleto.get(i).getAwayTime().getImage();
                if (barracasCentralCompleto.get(i).getAwayTime().getScore() > barracasCentralCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (barracasCentralCompleto.get(i).getAwayTime().getScore() == barracasCentralCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (barracasCentralCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += barracasCentralCompleto.get(i).getAwayTime().getScore();
                if (barracasCentralCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += barracasCentralCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for brentford

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < belgranoCompleto.size(); i++) {
            if (belgranoCompleto.get(i).getHomeTime().getName().equals("Belgrano")) {
                name = belgranoCompleto.get(i).getHomeTime().getName();
                image = belgranoCompleto.get(i).getHomeTime().getImage();
                if (belgranoCompleto.get(i).getHomeTime().getScore() > belgranoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (belgranoCompleto.get(i).getHomeTime().getScore() == belgranoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (belgranoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += belgranoCompleto.get(i).getHomeTime().getScore();
                if (belgranoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += belgranoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (belgranoCompleto.get(i).getAwayTime().getName().equals("Belgrano")) {
                name = belgranoCompleto.get(i).getAwayTime().getName();
                image = belgranoCompleto.get(i).getAwayTime().getImage();
                if (belgranoCompleto.get(i).getAwayTime().getScore() > belgranoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (belgranoCompleto.get(i).getAwayTime().getScore() == belgranoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (belgranoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += belgranoCompleto.get(i).getAwayTime().getScore();
                if (belgranoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += belgranoCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for brighton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < bocaJuniorsCompleto.size(); i++) {
            if (bocaJuniorsCompleto.get(i).getHomeTime().getName().equals("Boca Juniors")) {
                name = bocaJuniorsCompleto.get(i).getHomeTime().getName();
                image = bocaJuniorsCompleto.get(i).getHomeTime().getImage();
                if (bocaJuniorsCompleto.get(i).getHomeTime().getScore() > bocaJuniorsCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (bocaJuniorsCompleto.get(i).getHomeTime().getScore() == bocaJuniorsCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bocaJuniorsCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += bocaJuniorsCompleto.get(i).getHomeTime().getScore();
                if (bocaJuniorsCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += bocaJuniorsCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (bocaJuniorsCompleto.get(i).getAwayTime().getName().equals("Boca Juniors")) {
                name = bocaJuniorsCompleto.get(i).getAwayTime().getName();
                image = bocaJuniorsCompleto.get(i).getAwayTime().getImage();
                if (bocaJuniorsCompleto.get(i).getAwayTime().getScore() > bocaJuniorsCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (bocaJuniorsCompleto.get(i).getAwayTime().getScore() == bocaJuniorsCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bocaJuniorsCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += bocaJuniorsCompleto.get(i).getAwayTime().getScore();
                if (bocaJuniorsCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += bocaJuniorsCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for burnley

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < centralCordobaCompleto.size(); i++) {
            if (centralCordobaCompleto.get(i).getHomeTime().getName().equals("Central Córdoba")) {
                name = centralCordobaCompleto.get(i).getHomeTime().getName();
                image = centralCordobaCompleto.get(i).getHomeTime().getImage();
                if (centralCordobaCompleto.get(i).getHomeTime().getScore() > centralCordobaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (centralCordobaCompleto.get(i).getHomeTime().getScore() == centralCordobaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (centralCordobaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += centralCordobaCompleto.get(i).getHomeTime().getScore();
                if (centralCordobaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += centralCordobaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (centralCordobaCompleto.get(i).getAwayTime().getName().equals("Central Córdoba")) {
                name = centralCordobaCompleto.get(i).getAwayTime().getName();
                image = centralCordobaCompleto.get(i).getAwayTime().getImage();
                if (centralCordobaCompleto.get(i).getAwayTime().getScore() > centralCordobaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (centralCordobaCompleto.get(i).getAwayTime().getScore() == centralCordobaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (centralCordobaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += centralCordobaCompleto.get(i).getAwayTime().getScore();
                if (centralCordobaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += centralCordobaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for chelsea

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < defensaJusticiaCompleto.size(); i++) {
            if (defensaJusticiaCompleto.get(i).getHomeTime().getName().equals("Def. Justicia")) {
                name = defensaJusticiaCompleto.get(i).getHomeTime().getName();
                image = defensaJusticiaCompleto.get(i).getHomeTime().getImage();
                if (defensaJusticiaCompleto.get(i).getHomeTime().getScore() > defensaJusticiaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (defensaJusticiaCompleto.get(i).getHomeTime().getScore() == defensaJusticiaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (defensaJusticiaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += defensaJusticiaCompleto.get(i).getHomeTime().getScore();
                if (defensaJusticiaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += defensaJusticiaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (defensaJusticiaCompleto.get(i).getAwayTime().getName().equals("Def. Justicia")) {
                name = defensaJusticiaCompleto.get(i).getAwayTime().getName();
                image = defensaJusticiaCompleto.get(i).getAwayTime().getImage();
                if (defensaJusticiaCompleto.get(i).getAwayTime().getScore() > defensaJusticiaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (defensaJusticiaCompleto.get(i).getAwayTime().getScore() == defensaJusticiaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (defensaJusticiaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += defensaJusticiaCompleto.get(i).getAwayTime().getScore();
                if (defensaJusticiaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += defensaJusticiaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for crystalPalace

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < deportivoRiestraCompleto.size(); i++) {
            if (deportivoRiestraCompleto.get(i).getHomeTime().getName().equals("Deportivo Riestra")) {
                name = deportivoRiestraCompleto.get(i).getHomeTime().getName();
                image = deportivoRiestraCompleto.get(i).getHomeTime().getImage();
                if (deportivoRiestraCompleto.get(i).getHomeTime().getScore() > deportivoRiestraCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (deportivoRiestraCompleto.get(i).getHomeTime().getScore() == deportivoRiestraCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (deportivoRiestraCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += deportivoRiestraCompleto.get(i).getHomeTime().getScore();
                if (deportivoRiestraCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += deportivoRiestraCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (deportivoRiestraCompleto.get(i).getAwayTime().getName().equals("Deportivo Riestra")) {
                name = deportivoRiestraCompleto.get(i).getAwayTime().getName();
                image = deportivoRiestraCompleto.get(i).getAwayTime().getImage();
                if (deportivoRiestraCompleto.get(i).getAwayTime().getScore() > deportivoRiestraCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (deportivoRiestraCompleto.get(i).getAwayTime().getScore() == deportivoRiestraCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (deportivoRiestraCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += deportivoRiestraCompleto.get(i).getAwayTime().getScore();
                if (deportivoRiestraCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += deportivoRiestraCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for everton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < estudiantesLaPrataCompleto.size(); i++) {
            if (estudiantesLaPrataCompleto.get(i).getHomeTime().getName().equals("Estudiantes")) {
                name = estudiantesLaPrataCompleto.get(i).getHomeTime().getName();
                image = estudiantesLaPrataCompleto.get(i).getHomeTime().getImage();
                if (estudiantesLaPrataCompleto.get(i).getHomeTime().getScore() > estudiantesLaPrataCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (estudiantesLaPrataCompleto.get(i).getHomeTime().getScore() == estudiantesLaPrataCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (estudiantesLaPrataCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += estudiantesLaPrataCompleto.get(i).getHomeTime().getScore();
                if (estudiantesLaPrataCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += estudiantesLaPrataCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (estudiantesLaPrataCompleto.get(i).getAwayTime().getName().equals("Estudiantes")) {
                name = estudiantesLaPrataCompleto.get(i).getAwayTime().getName();
                image = estudiantesLaPrataCompleto.get(i).getAwayTime().getImage();
                if (estudiantesLaPrataCompleto.get(i).getAwayTime().getScore() > estudiantesLaPrataCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (estudiantesLaPrataCompleto.get(i).getAwayTime().getScore() == estudiantesLaPrataCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (estudiantesLaPrataCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += estudiantesLaPrataCompleto.get(i).getAwayTime().getScore();
                if (estudiantesLaPrataCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += estudiantesLaPrataCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for fulham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < gimnasiaCompleto.size(); i++) {
            if (gimnasiaCompleto.get(i).getHomeTime().getName().equals("Gimnasia")) {
                name = gimnasiaCompleto.get(i).getHomeTime().getName();
                image = gimnasiaCompleto.get(i).getHomeTime().getImage();
                if (gimnasiaCompleto.get(i).getHomeTime().getScore() > gimnasiaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (gimnasiaCompleto.get(i).getHomeTime().getScore() == gimnasiaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (gimnasiaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += gimnasiaCompleto.get(i).getHomeTime().getScore();
                if (gimnasiaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += gimnasiaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (gimnasiaCompleto.get(i).getAwayTime().getName().equals("Gimnasia")) {
                name = gimnasiaCompleto.get(i).getAwayTime().getName();
                image = gimnasiaCompleto.get(i).getAwayTime().getImage();
                if (gimnasiaCompleto.get(i).getAwayTime().getScore() > gimnasiaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (gimnasiaCompleto.get(i).getAwayTime().getScore() == gimnasiaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (gimnasiaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += gimnasiaCompleto.get(i).getAwayTime().getScore();
                if (gimnasiaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += gimnasiaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for liverpool

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < godoyCruzCompleto.size(); i++) {
            if (godoyCruzCompleto.get(i).getHomeTime().getName().equals("Godoy Cruz")) {
                name = godoyCruzCompleto.get(i).getHomeTime().getName();
                image = godoyCruzCompleto.get(i).getHomeTime().getImage();
                if (godoyCruzCompleto.get(i).getHomeTime().getScore() > godoyCruzCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (godoyCruzCompleto.get(i).getHomeTime().getScore() == godoyCruzCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (godoyCruzCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += godoyCruzCompleto.get(i).getHomeTime().getScore();
                if (godoyCruzCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += godoyCruzCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (godoyCruzCompleto.get(i).getAwayTime().getName().equals("Godoy Cruz")) {
                name = godoyCruzCompleto.get(i).getAwayTime().getName();
                image = godoyCruzCompleto.get(i).getAwayTime().getImage();
                if (godoyCruzCompleto.get(i).getAwayTime().getScore() > godoyCruzCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (godoyCruzCompleto.get(i).getAwayTime().getScore() == godoyCruzCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (godoyCruzCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += godoyCruzCompleto.get(i).getAwayTime().getScore();
                if (godoyCruzCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += godoyCruzCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for luton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < huracanCompleto.size(); i++) {
            if (huracanCompleto.get(i).getHomeTime().getName().equals("Huracán")) {
                name = huracanCompleto.get(i).getHomeTime().getName();
                image = huracanCompleto.get(i).getHomeTime().getImage();
                if (huracanCompleto.get(i).getHomeTime().getScore() > huracanCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (huracanCompleto.get(i).getHomeTime().getScore() == huracanCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (huracanCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += huracanCompleto.get(i).getHomeTime().getScore();
                if (huracanCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += huracanCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (huracanCompleto.get(i).getAwayTime().getName().equals("Huracán")) {
                name = huracanCompleto.get(i).getAwayTime().getName();
                image = huracanCompleto.get(i).getAwayTime().getImage();
                if (huracanCompleto.get(i).getAwayTime().getScore() > huracanCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (huracanCompleto.get(i).getAwayTime().getScore() == huracanCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (huracanCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += huracanCompleto.get(i).getAwayTime().getScore();
                if (huracanCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += huracanCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for city

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < independienteCompleto.size(); i++) {
            if (independienteCompleto.get(i).getHomeTime().getName().equals("Independiente")) {
                name = independienteCompleto.get(i).getHomeTime().getName();
                image = independienteCompleto.get(i).getHomeTime().getImage();
                if (independienteCompleto.get(i).getHomeTime().getScore() > independienteCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (independienteCompleto.get(i).getHomeTime().getScore() == independienteCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (independienteCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += independienteCompleto.get(i).getHomeTime().getScore();
                if (independienteCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += independienteCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (independienteCompleto.get(i).getAwayTime().getName().equals("Independiente")) {
                name = independienteCompleto.get(i).getAwayTime().getName();
                image = independienteCompleto.get(i).getAwayTime().getImage();
                if (independienteCompleto.get(i).getAwayTime().getScore() > independienteCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (independienteCompleto.get(i).getAwayTime().getScore() == independienteCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (independienteCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += independienteCompleto.get(i).getAwayTime().getScore();
                if (independienteCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += independienteCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for unitede

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < independienteRivadaviaCompleto.size(); i++) {
            if (independienteRivadaviaCompleto.get(i).getHomeTime().getName().equals("Ind. Rivadavia")) {
                name = independienteRivadaviaCompleto.get(i).getHomeTime().getName();
                image = independienteRivadaviaCompleto.get(i).getHomeTime().getImage();
                if (independienteRivadaviaCompleto.get(i).getHomeTime().getScore() > independienteRivadaviaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (independienteRivadaviaCompleto.get(i).getHomeTime().getScore() == independienteRivadaviaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (independienteRivadaviaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += independienteRivadaviaCompleto.get(i).getHomeTime().getScore();
                if (independienteRivadaviaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += independienteRivadaviaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (independienteRivadaviaCompleto.get(i).getAwayTime().getName().equals("Ind. Rivadavia")) {
                name = independienteRivadaviaCompleto.get(i).getAwayTime().getName();
                image = independienteRivadaviaCompleto.get(i).getAwayTime().getImage();
                if (independienteRivadaviaCompleto.get(i).getAwayTime().getScore() > independienteRivadaviaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (independienteRivadaviaCompleto.get(i).getAwayTime().getScore() == independienteRivadaviaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (independienteRivadaviaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += independienteRivadaviaCompleto.get(i).getAwayTime().getScore();
                if (independienteRivadaviaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += independienteRivadaviaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for newcastle

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < institutoCompleto.size(); i++) {
            if (institutoCompleto.get(i).getHomeTime().getName().equals("Instituto")) {
                name = institutoCompleto.get(i).getHomeTime().getName();
                image = institutoCompleto.get(i).getHomeTime().getImage();
                if (institutoCompleto.get(i).getHomeTime().getScore() > institutoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (institutoCompleto.get(i).getHomeTime().getScore() == institutoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (institutoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += institutoCompleto.get(i).getHomeTime().getScore();
                if (institutoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += institutoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (institutoCompleto.get(i).getAwayTime().getName().equals("Instituto")) {
                name = institutoCompleto.get(i).getAwayTime().getName();
                image = institutoCompleto.get(i).getAwayTime().getImage();
                if (institutoCompleto.get(i).getAwayTime().getScore() > institutoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (institutoCompleto.get(i).getAwayTime().getScore() == institutoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (institutoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += institutoCompleto.get(i).getAwayTime().getScore();
                if (institutoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += institutoCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for nottingham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < lanusCompleto.size(); i++) {
            if (lanusCompleto.get(i).getHomeTime().getName().equals("Lanús")) {
                name = lanusCompleto.get(i).getHomeTime().getName();
                image = lanusCompleto.get(i).getHomeTime().getImage();
                if (lanusCompleto.get(i).getHomeTime().getScore() > lanusCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (lanusCompleto.get(i).getHomeTime().getScore() == lanusCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (lanusCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += lanusCompleto.get(i).getHomeTime().getScore();
                if (lanusCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += lanusCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (lanusCompleto.get(i).getAwayTime().getName().equals("Lanús")) {
                name = lanusCompleto.get(i).getAwayTime().getName();
                image = lanusCompleto.get(i).getAwayTime().getImage();
                if (lanusCompleto.get(i).getAwayTime().getScore() > lanusCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (lanusCompleto.get(i).getAwayTime().getScore() == lanusCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (lanusCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += lanusCompleto.get(i).getAwayTime().getScore();
                if (lanusCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += lanusCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for sheffield

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < newellOldBoysCompleto.size(); i++) {
            if (newellOldBoysCompleto.get(i).getHomeTime().getName().equals("Newell Old Boys")) {
                name = newellOldBoysCompleto.get(i).getHomeTime().getName();
                image = newellOldBoysCompleto.get(i).getHomeTime().getImage();
                if (newellOldBoysCompleto.get(i).getHomeTime().getScore() > newellOldBoysCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (newellOldBoysCompleto.get(i).getHomeTime().getScore() == newellOldBoysCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (newellOldBoysCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += newellOldBoysCompleto.get(i).getHomeTime().getScore();
                if (newellOldBoysCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += newellOldBoysCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (newellOldBoysCompleto.get(i).getAwayTime().getName().equals("Newell Old Boys")) {
                name = newellOldBoysCompleto.get(i).getAwayTime().getName();
                image = newellOldBoysCompleto.get(i).getAwayTime().getImage();
                if (newellOldBoysCompleto.get(i).getAwayTime().getScore() > newellOldBoysCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (newellOldBoysCompleto.get(i).getAwayTime().getScore() == newellOldBoysCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (newellOldBoysCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += newellOldBoysCompleto.get(i).getAwayTime().getScore();
                if (newellOldBoysCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += newellOldBoysCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for tottenham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < platenseCompleto.size(); i++) {
            if (platenseCompleto.get(i).getHomeTime().getName().equals("Platense")) {
                name = platenseCompleto.get(i).getHomeTime().getName();
                image = platenseCompleto.get(i).getHomeTime().getImage();
                if (platenseCompleto.get(i).getHomeTime().getScore() > platenseCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (platenseCompleto.get(i).getHomeTime().getScore() == platenseCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (platenseCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += platenseCompleto.get(i).getHomeTime().getScore();
                if (platenseCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += platenseCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (platenseCompleto.get(i).getAwayTime().getName().equals("Platense")) {
                name = platenseCompleto.get(i).getAwayTime().getName();
                image = platenseCompleto.get(i).getAwayTime().getImage();
                if (platenseCompleto.get(i).getAwayTime().getScore() > platenseCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (platenseCompleto.get(i).getAwayTime().getScore() == platenseCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (platenseCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += platenseCompleto.get(i).getAwayTime().getScore();
                if (platenseCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += platenseCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for westHam

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel


        //isso que fiz vai funcionar tambem.. masss podemos ter um problema de travar.. POis quando a lista é grande
        //e fico pedindo para o adapter atualizar para o usuario ele pode demorar e isso pode até fazer o app travar
        //entendeu ?sim, e agora?
        //por isso que nós fazemos o controle e avisamos o adapter para ele atualizar.. POis se toda vez que voce for modificar a variavel listaficial e o adapter
        //atualizar automaticamente pode acontecer esses problemas de travar o app.. entendeu ?sim, e qual seria outra melhor abordagem neste contexto?
        //fazer isso que 'nós fizemos ..pedir para o adapter atualizat a lista somente depois que inserimos tudo dentro da variavel listaOFICIAL
        //ENTENDEU ?pois é, aqui e adicionado a cada laço for percorrido e la no final e adicionado o útimo objeto.. ISSO


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < racingCompleto.size(); i++) { //inicio do for
            if (racingCompleto.get(i).getHomeTime().getName().equals("Racing")) {
                name = racingCompleto.get(i).getHomeTime().getName();
                image = racingCompleto.get(i).getHomeTime().getImage();
                if (racingCompleto.get(i).getHomeTime().getScore() > racingCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (racingCompleto.get(i).getHomeTime().getScore() == racingCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (racingCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += racingCompleto.get(i).getHomeTime().getScore();
                if (racingCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += racingCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (racingCompleto.get(i).getAwayTime().getName().equals("Racing")) {
                name = racingCompleto.get(i).getAwayTime().getName();
                image = racingCompleto.get(i).getAwayTime().getImage();
                if (racingCompleto.get(i).getAwayTime().getScore() > racingCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (racingCompleto.get(i).getAwayTime().getScore() == racingCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (racingCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += racingCompleto.get(i).getAwayTime().getScore();
                if (racingCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += racingCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < riverPlateCompleto.size(); i++) { //inicio do for
            if (riverPlateCompleto.get(i).getHomeTime().getName().equals("River Plate")) {
                name = riverPlateCompleto.get(i).getHomeTime().getName();
                image = riverPlateCompleto.get(i).getHomeTime().getImage();
                if (riverPlateCompleto.get(i).getHomeTime().getScore() > riverPlateCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (riverPlateCompleto.get(i).getHomeTime().getScore() == riverPlateCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (riverPlateCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += riverPlateCompleto.get(i).getHomeTime().getScore();
                if (riverPlateCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += riverPlateCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (riverPlateCompleto.get(i).getAwayTime().getName().equals("River Plate")) {
                name = riverPlateCompleto.get(i).getAwayTime().getName();
                image = riverPlateCompleto.get(i).getAwayTime().getImage();
                if (riverPlateCompleto.get(i).getAwayTime().getScore() > riverPlateCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (riverPlateCompleto.get(i).getAwayTime().getScore() == riverPlateCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (riverPlateCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += riverPlateCompleto.get(i).getAwayTime().getScore();
                if (riverPlateCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += riverPlateCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < rosarioCentralCompleto.size(); i++) { //inicio do for
            if (rosarioCentralCompleto.get(i).getHomeTime().getName().equals("Rosario")) {
                name = rosarioCentralCompleto.get(i).getHomeTime().getName();
                image = rosarioCentralCompleto.get(i).getHomeTime().getImage();
                if (rosarioCentralCompleto.get(i).getHomeTime().getScore() > rosarioCentralCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (rosarioCentralCompleto.get(i).getHomeTime().getScore() == rosarioCentralCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (rosarioCentralCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += rosarioCentralCompleto.get(i).getHomeTime().getScore();
                if (rosarioCentralCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += rosarioCentralCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (rosarioCentralCompleto.get(i).getAwayTime().getName().equals("Rosario")) {
                name = rosarioCentralCompleto.get(i).getAwayTime().getName();
                image = rosarioCentralCompleto.get(i).getAwayTime().getImage();
                if (rosarioCentralCompleto.get(i).getAwayTime().getScore() > rosarioCentralCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (rosarioCentralCompleto.get(i).getAwayTime().getScore() == rosarioCentralCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (rosarioCentralCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += rosarioCentralCompleto.get(i).getAwayTime().getScore();
                if (rosarioCentralCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += rosarioCentralCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for


        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < sanLorenzoCompleto.size(); i++) { //inicio do for
            if (sanLorenzoCompleto.get(i).getHomeTime().getName().equals("San Lorenzo")) {
                name = sanLorenzoCompleto.get(i).getHomeTime().getName();
                image = sanLorenzoCompleto.get(i).getHomeTime().getImage();
                if (sanLorenzoCompleto.get(i).getHomeTime().getScore() > sanLorenzoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (sanLorenzoCompleto.get(i).getHomeTime().getScore() == sanLorenzoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sanLorenzoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += sanLorenzoCompleto.get(i).getHomeTime().getScore();
                if (sanLorenzoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += sanLorenzoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (sanLorenzoCompleto.get(i).getAwayTime().getName().equals("San Lorenzo")) {
                name = sanLorenzoCompleto.get(i).getAwayTime().getName();
                image = sanLorenzoCompleto.get(i).getAwayTime().getImage();
                if (sanLorenzoCompleto.get(i).getAwayTime().getScore() > sanLorenzoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (sanLorenzoCompleto.get(i).getAwayTime().getScore() == sanLorenzoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sanLorenzoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += sanLorenzoCompleto.get(i).getAwayTime().getScore();
                if (sanLorenzoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += sanLorenzoCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for


        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < sarmientoCompleto.size(); i++) { //inicio do for
            if (sarmientoCompleto.get(i).getHomeTime().getName().equals("Sarmiento")) {
                name = sarmientoCompleto.get(i).getHomeTime().getName();
                image = sarmientoCompleto.get(i).getHomeTime().getImage();
                if (sarmientoCompleto.get(i).getHomeTime().getScore() > sarmientoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (sarmientoCompleto.get(i).getHomeTime().getScore() == sarmientoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sarmientoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += sarmientoCompleto.get(i).getHomeTime().getScore();
                if (sarmientoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += sarmientoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (sarmientoCompleto.get(i).getAwayTime().getName().equals("Sarmiento")) {
                name = sarmientoCompleto.get(i).getAwayTime().getName();
                image = sarmientoCompleto.get(i).getAwayTime().getImage();
                if (sarmientoCompleto.get(i).getAwayTime().getScore() > sarmientoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (sarmientoCompleto.get(i).getAwayTime().getScore() == sarmientoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sarmientoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += sarmientoCompleto.get(i).getAwayTime().getScore();
                if (sarmientoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += sarmientoCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for


        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < talleresCompleto.size(); i++) { //inicio do for
            if (talleresCompleto.get(i).getHomeTime().getName().equals("Talleres")) {
                name = talleresCompleto.get(i).getHomeTime().getName();
                image = talleresCompleto.get(i).getHomeTime().getImage();
                if (talleresCompleto.get(i).getHomeTime().getScore() > talleresCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (talleresCompleto.get(i).getHomeTime().getScore() == talleresCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (talleresCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += talleresCompleto.get(i).getHomeTime().getScore();
                if (talleresCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += talleresCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (talleresCompleto.get(i).getAwayTime().getName().equals("Talleres")) {
                name = talleresCompleto.get(i).getAwayTime().getName();
                image = talleresCompleto.get(i).getAwayTime().getImage();
                if (talleresCompleto.get(i).getAwayTime().getScore() > talleresCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (talleresCompleto.get(i).getAwayTime().getScore() == talleresCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (talleresCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += talleresCompleto.get(i).getAwayTime().getScore();
                if (talleresCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += talleresCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for


        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < tigreCompleto.size(); i++) { //inicio do for
            if (tigreCompleto.get(i).getHomeTime().getName().equals("Tigre")) {
                name = tigreCompleto.get(i).getHomeTime().getName();
                image = tigreCompleto.get(i).getHomeTime().getImage();
                if (tigreCompleto.get(i).getHomeTime().getScore() > tigreCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (tigreCompleto.get(i).getHomeTime().getScore() == tigreCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (tigreCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += tigreCompleto.get(i).getHomeTime().getScore();
                if (tigreCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += tigreCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (tigreCompleto.get(i).getAwayTime().getName().equals("Tigre")) {
                name = tigreCompleto.get(i).getAwayTime().getName();
                image = tigreCompleto.get(i).getAwayTime().getImage();
                if (tigreCompleto.get(i).getAwayTime().getScore() > tigreCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (tigreCompleto.get(i).getAwayTime().getScore() == tigreCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (tigreCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += tigreCompleto.get(i).getAwayTime().getScore();
                if (tigreCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += tigreCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < unionSantaFeCompleto.size(); i++) { //inicio do for
            if (unionSantaFeCompleto.get(i).getHomeTime().getName().equals("Union Santa Fe")) {
                name = unionSantaFeCompleto.get(i).getHomeTime().getName();
                image = unionSantaFeCompleto.get(i).getHomeTime().getImage();
                if (unionSantaFeCompleto.get(i).getHomeTime().getScore() > unionSantaFeCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (unionSantaFeCompleto.get(i).getHomeTime().getScore() == unionSantaFeCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (unionSantaFeCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += unionSantaFeCompleto.get(i).getHomeTime().getScore();
                if (unionSantaFeCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += unionSantaFeCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (unionSantaFeCompleto.get(i).getAwayTime().getName().equals("Union Santa Fe")) {
                name = unionSantaFeCompleto.get(i).getAwayTime().getName();
                image = unionSantaFeCompleto.get(i).getAwayTime().getImage();
                if (unionSantaFeCompleto.get(i).getAwayTime().getScore() > unionSantaFeCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (unionSantaFeCompleto.get(i).getAwayTime().getScore() == unionSantaFeCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (unionSantaFeCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += unionSantaFeCompleto.get(i).getAwayTime().getScore();
                if (unionSantaFeCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += unionSantaFeCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < velezSarsfieldCompleto.size(); i++) { //inicio do for
            if (velezSarsfieldCompleto.get(i).getHomeTime().getName().equals("Vélez Sársfield")) {
                name = velezSarsfieldCompleto.get(i).getHomeTime().getName();
                image = velezSarsfieldCompleto.get(i).getHomeTime().getImage();
                if (velezSarsfieldCompleto.get(i).getHomeTime().getScore() > velezSarsfieldCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (velezSarsfieldCompleto.get(i).getHomeTime().getScore() == velezSarsfieldCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (velezSarsfieldCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += velezSarsfieldCompleto.get(i).getHomeTime().getScore();
                if (velezSarsfieldCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += velezSarsfieldCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (velezSarsfieldCompleto.get(i).getAwayTime().getName().equals("Vélez Sársfield")) {
                name = velezSarsfieldCompleto.get(i).getAwayTime().getName();
                image = velezSarsfieldCompleto.get(i).getAwayTime().getImage();
                if (velezSarsfieldCompleto.get(i).getAwayTime().getScore() > velezSarsfieldCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (velezSarsfieldCompleto.get(i).getAwayTime().getScore() == velezSarsfieldCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (velezSarsfieldCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += velezSarsfieldCompleto.get(i).getAwayTime().getScore();
                if (velezSarsfieldCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += velezSarsfieldCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modificamos a variavel listaOficial.. Essa variuavel nao esta vazia mais.// Só que pro adapter ela ainda esta vazia

        listaOficial.sort(new ComparatorPontosVitoriaSaldoGolsProSerieA_B());
        //Collections.sort(minhaLista);
        Collections.reverse(listaOficial);


        //Mas entenda que o código abaixo sempre vai atualizar a lista inteira
        timesClasificacaoBrasilA2024Adapter.notifyDataSetChanged();



    }//fim da interface
}