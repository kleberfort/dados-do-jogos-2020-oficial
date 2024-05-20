package com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaBrasilSerieA2024TesteBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieA2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieAListener;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaBrasilSerieA_2024_TesteFragment extends Fragment implements JogosSerieAListener {

    private FragmentListaBrasilSerieA2024TesteBinding binding;
    private JogosSerieA2024 jogosSerieA2024;
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

    private List<PartidaNovoModelo> atleticoPRCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> atleticoGOCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> atleticoMGCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> bahiaCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> botafogoCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> bragantinoCompleto= new ArrayList<>();
    private List<PartidaNovoModelo> corinthiansCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> criciumaCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> cruzeiroCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> cuiabaCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> flamengoCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> fluminenseCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> fortalezaCompleto= new ArrayList<>();
    private List<PartidaNovoModelo> gremioCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> internacionalCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> juventudeCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> palmeirasCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> saoPauloCompleto= new ArrayList<>();
    private List<PartidaNovoModelo> vascoCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> vitoriaCompleto = new ArrayList<>();


    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>(); ;//estamos iniciando nossa lista vazia


    public interface ListaBrasilA2024Interface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaBrasilAMetodo(String nome);//viu que é uma string ?sim
    }


    //2 etapa criamos uma variavel da interface
    ListaBrasilA2024Interface listaBrasilA2024 = null;//queremos usar o metodo listaInglesa(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim



    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof ListaBrasilA2024Interface){
            listaBrasilA2024 = (ListaBrasilA2024Interface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaBrasilSerieA2024TesteBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        jogosSerieA2024 = new JogosSerieA2024();
        jogosSerieA2024.setupHttpClient();
        jogosSerieA2024.setupDadosJogos();
        jogosSerieA2024.setListener(this);// Registra o fragmento como listener

        binding.rvLista.setHasFixedSize(true);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLista.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        //aqui esta certo, estamos iniciando o adaptador. Sempre temos que fazer isso
        timesClasificacaoBrasilA2024Adapter = new TimesClasificacaoBrasilA2024Adapter(listaOficial);//o adapter vai receber a variazel listaOficial, mas ela esta vazia ainda
        //entendeu essa parte ?sim
        //
        binding.rvLista.setAdapter(timesClasificacaoBrasilA2024Adapter);


        //o adaptador faz a parte bruta de pegar os dados e exibir na tela
        //pra ele funcionar temos que passar quais informacoes ele deve exibir
        //essa é a primeira perte que voce deve enteder
        // esse é o primeiro conceito ok?sim en
        //podemos passar a informacao para o adapter de várias formas vou mostrar uma pra voce


        binding.rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClassificacaoOficialNovoModelo lista = listaOficial.get(position);

                switch (lista.getName()){
                    case "Atlético-PR":
                        listaBrasilA2024.listaBrasilAMetodo("Atlético-PR");
                       // Intent intent = new Intent(getContext(), AtleticoPR2024Activity.class);
                       // startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Atlético-GO":
                        listaBrasilA2024.listaBrasilAMetodo("Atlético-GO");
//                       Intent intent = new Intent(getContext(), AtleticoGO2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Atlético-MG":
                        listaBrasilA2024.listaBrasilAMetodo("Atlético-MG");
//                        intent = new Intent(getContext(), AtleticoMG2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Bahia":
                        listaBrasilA2024.listaBrasilAMetodo("Bahia");
//                        intent = new Intent(getContext(), Bahia2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Botafogo":
                        listaBrasilA2024.listaBrasilAMetodo("Botafogo");
//                        intent = new Intent(getContext(), Botafogo2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Bragantino":
                        listaBrasilA2024.listaBrasilAMetodo("Bragantino");
//                        intent = new Intent(getContext(), Bragantino2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Corinthians":
                        listaBrasilA2024.listaBrasilAMetodo("Corinthians");
//                        intent = new Intent(getContext(), Corinthians2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Criciúma":
                        listaBrasilA2024.listaBrasilAMetodo("Criciúma");
//                        intent = new Intent(getContext(), Criciuma2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Cruzeiro":
                        listaBrasilA2024.listaBrasilAMetodo("Cruzeiro");
//                        intent = new Intent(getContext(), Cruzeiro2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Cuiabá":
                        listaBrasilA2024.listaBrasilAMetodo("Cuiabá");
//                        intent = new Intent(getContext(), Cuiaba2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Flamengo":
                        listaBrasilA2024.listaBrasilAMetodo("Flamengo");
//                        intent = new Intent(getContext(), Flamengo2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Fluminense":
                        listaBrasilA2024.listaBrasilAMetodo("Fluminense");
//                        intent = new Intent(getContext(), Fluminense2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Fortaleza":
                        listaBrasilA2024.listaBrasilAMetodo("Fortaleza");
//                        intent = new Intent(getContext(), Fortaleza2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Grêmio":
                        listaBrasilA2024.listaBrasilAMetodo("Grêmio");
//                        intent = new Intent(getContext(), Gremio2024Activity.class);
//                        startActivity(intent);
                        Log.d("Gremio", "executou");
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Internacional":
                        listaBrasilA2024.listaBrasilAMetodo("Internacional");
//                        intent = new Intent(getContext(), Internacional2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Juventude":
                        listaBrasilA2024.listaBrasilAMetodo("Juventude");
//                        intent = new Intent(getContext(), Juventude2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Palmeiras":
                        listaBrasilA2024.listaBrasilAMetodo("Palmeiras");
//                        intent = new Intent(getContext(), Palmeiras2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "São-Paulo":
                        listaBrasilA2024.listaBrasilAMetodo("São-Paulo");
//                        intent = new Intent(getContext(), SaoPaulo2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Vasco":
                        listaBrasilA2024.listaBrasilAMetodo("Vasco");
//                        intent = new Intent(getContext(), Vasco2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Vitória":
                        listaBrasilA2024.listaBrasilAMetodo("Vitória");
//                        intent = new Intent(getContext(), Vitoria2024Activity.class);
//                        startActivity(intent);

                        Log.d("Vítoria", "abriu activity");
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;


                }//fim do switch

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));



        return view;


    }

    //onde o metodo onJogosSerieAReady é chamado ?
    //Os dados dentro do meotod onJogosSerieAReady vao ser usados nesse Fragment ?Sim, porque aqui que nest frament que irei exibir a classificação, passando a lista

    //pelo que entendi, esse meotodo vai fazer a parte de organizar as informacoes de cada time correto ?sim, pego cas
    // mas para organizar as informacoes de cada time , tenho que primeiro obter as informacoes de cada time
    //em qual parte do código estamos fazendo essa primeira parte. Onde temos o código que estamos obtendo essas informcoes da internet ?
    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> atleticoPRCompleto, List<PartidaNovoModelo> atleticoGOCompleto, List<PartidaNovoModelo> atleticoMGCompleto , List<PartidaNovoModelo> bahiaCompleto , List<PartidaNovoModelo> botafogoCompleto , List<PartidaNovoModelo>  bragantinoCompleto, List<PartidaNovoModelo> corinthiansCompleto , List<PartidaNovoModelo> criciumaCompleto , List<PartidaNovoModelo>  cruzeiroCompleto, List<PartidaNovoModelo>cuiabaCompleto
            , List<PartidaNovoModelo> flamengoCompleto, List<PartidaNovoModelo> fluminenseCompleto , List<PartidaNovoModelo> fortalezaCompleto ,
                                   List<PartidaNovoModelo> gremioCompleto , List<PartidaNovoModelo> internacionalCompleto ,
                                   List<PartidaNovoModelo> juventudeCompleto , List<PartidaNovoModelo> palmeirasCompleto,
                                   List<PartidaNovoModelo> saoPauloCompleto , List<PartidaNovoModelo> vascoCompleto , List<PartidaNovoModelo> vitoriaCompleto) {

        //pronto kkkkkk
        //entendeu ?na verdade, mais ou menos embaraçou, tenho que criar esses fragments pra ver na verdade, kkk é mais   ffaaz ai qualquer cosia avisa...ja esta no caminho certo

        // o que temos na variavel  vitoriaCompleto ?todos os jogos do time, seja em casa e fora
        //isso, entao esses dados voce ja tem

        //só precisa pegar essa variavel e separar de novo/
        //em um fragment voce pega essa varivel e fica apenas com os dados de fora e no outra fragment pega os dados apenas do jogo dentro de casa
        //la na JogosSeriaA2024 voce nao precisa fazer nada, apenas aqui dentro do meotod onJogosSerieAReady
        //compreendeu ?tenho que fazer essa divisão, criando outro método?
        //nao faz aqui dentro mesmo,, o metodo  onJogosSerieAReady vai ser usado pelo 2 fragment, mas o codigo que vai aqui dentro desse metodo vai
        //ser diferente para cada fragment
        //entendeu ?sim, é
        //pra ficar mais facil pra voce da pra fazer o seguinte

        this.atleticoPRCompleto = atleticoPRCompleto;
        this.atleticoGOCompleto = atleticoGOCompleto;
        this.atleticoMGCompleto = atleticoMGCompleto;
        this.bahiaCompleto = bahiaCompleto;
        this.botafogoCompleto = botafogoCompleto;
        this.bragantinoCompleto = bragantinoCompleto;
        this.corinthiansCompleto = corinthiansCompleto;
        this.criciumaCompleto = criciumaCompleto;
        this.cruzeiroCompleto = cruzeiroCompleto;
        this.cuiabaCompleto = cuiabaCompleto;
        this.flamengoCompleto = flamengoCompleto;
        this.fluminenseCompleto = fluminenseCompleto;
        this.fortalezaCompleto = fortalezaCompleto;
        this.gremioCompleto = gremioCompleto;
        this.internacionalCompleto = internacionalCompleto;
        this.juventudeCompleto = juventudeCompleto;
        this.palmeirasCompleto = palmeirasCompleto;
        this.saoPauloCompleto = saoPauloCompleto;
        this.vascoCompleto = vascoCompleto;
        this.vitoriaCompleto = vitoriaCompleto;

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


        for (int i = 0; i < atleticoPRCompleto.size(); i++) {
            if (atleticoPRCompleto.get(i).getHomeTime().getName().equals("Atlético-PR")) {
                // ClassificaTeste classificaTeste = new ClassificaTeste();
                name = atleticoPRCompleto.get(i).getHomeTime().getName();
                image = atleticoPRCompleto.get(i).getHomeTime().getImage();
                if (atleticoPRCompleto.get(i).getHomeTime().getScore() > atleticoPRCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoPRCompleto.get(i).getHomeTime().getScore() == atleticoPRCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoPRCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += atleticoPRCompleto.get(i).getHomeTime().getScore();
                if (atleticoPRCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += atleticoPRCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (atleticoPRCompleto.get(i).getAwayTime().getName().equals("Atlético-PR")) {
                //ClassificaTeste classificaTeste = new ClassificaTeste();
                name = atleticoPRCompleto.get(i).getAwayTime().getName();
                image = atleticoPRCompleto.get(i).getAwayTime().getImage();
                if (atleticoPRCompleto.get(i).getAwayTime().getScore() > atleticoPRCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoPRCompleto.get(i).getAwayTime().getScore() == atleticoPRCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoPRCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += atleticoPRCompleto.get(i).getAwayTime().getScore();
                if (atleticoPRCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += atleticoPRCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < atleticoGOCompleto.size(); i++) {
            if (atleticoGOCompleto.get(i).getHomeTime().getName().equals("Atlético-GO")) {
                name = atleticoGOCompleto.get(i).getHomeTime().getName();
                image = atleticoGOCompleto.get(i).getHomeTime().getImage();
                if (atleticoGOCompleto.get(i).getHomeTime().getScore() > atleticoGOCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoGOCompleto.get(i).getHomeTime().getScore() == atleticoGOCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoGOCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += atleticoGOCompleto.get(i).getHomeTime().getScore();
                if (atleticoGOCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra +=  atleticoGOCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (atleticoGOCompleto.get(i).getAwayTime().getName().equals("Atlético-GO")) {
                name = atleticoGOCompleto.get(i).getAwayTime().getName();
                image = atleticoGOCompleto.get(i).getAwayTime().getImage();
                if (atleticoGOCompleto.get(i).getAwayTime().getScore() > atleticoGOCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoGOCompleto.get(i).getAwayTime().getScore() == atleticoGOCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoGOCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += atleticoGOCompleto.get(i).getAwayTime().getScore();
                if (atleticoGOCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += atleticoGOCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < atleticoMGCompleto.size(); i++) {
            if (atleticoMGCompleto.get(i).getHomeTime().getName().equals("Atlético-MG")) {
                name = atleticoMGCompleto.get(i).getHomeTime().getName();
                image = atleticoMGCompleto.get(i).getHomeTime().getImage();
                if (atleticoMGCompleto.get(i).getHomeTime().getScore() > atleticoMGCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoMGCompleto.get(i).getHomeTime().getScore() == atleticoMGCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoMGCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += atleticoMGCompleto.get(i).getHomeTime().getScore();
                if (atleticoMGCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += atleticoMGCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (atleticoMGCompleto.get(i).getAwayTime().getName().equals("Atlético-MG")) {
                name = atleticoMGCompleto.get(i).getAwayTime().getName();
                image = atleticoMGCompleto.get(i).getAwayTime().getImage();
                if (atleticoMGCompleto.get(i).getAwayTime().getScore() > atleticoMGCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (atleticoMGCompleto.get(i).getAwayTime().getScore() == atleticoMGCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atleticoMGCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += atleticoMGCompleto.get(i).getAwayTime().getScore();
                if (atleticoMGCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += atleticoMGCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < bahiaCompleto.size(); i++) {
            if (bahiaCompleto.get(i).getHomeTime().getName().equals("Bahia")) {
                name = bahiaCompleto.get(i).getHomeTime().getName();
                image = bahiaCompleto.get(i).getHomeTime().getImage();
                if (bahiaCompleto.get(i).getHomeTime().getScore() > bahiaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (bahiaCompleto.get(i).getHomeTime().getScore() == bahiaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bahiaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += bahiaCompleto.get(i).getHomeTime().getScore();
                if (bahiaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += bahiaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (bahiaCompleto.get(i).getAwayTime().getName().equals("Bahia")) {
                name = bahiaCompleto.get(i).getAwayTime().getName();
                image = bahiaCompleto.get(i).getAwayTime().getImage();
                if (bahiaCompleto.get(i).getAwayTime().getScore() > bahiaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (bahiaCompleto.get(i).getAwayTime().getScore() == bahiaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bahiaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += bahiaCompleto.get(i).getAwayTime().getScore();
                if (bahiaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += bahiaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < botafogoCompleto.size(); i++) {
            if (botafogoCompleto.get(i).getHomeTime().getName().equals("Botafogo")) {
                name = botafogoCompleto.get(i).getHomeTime().getName();
                image = botafogoCompleto.get(i).getHomeTime().getImage();
                if (botafogoCompleto.get(i).getHomeTime().getScore() > botafogoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (botafogoCompleto.get(i).getHomeTime().getScore() == botafogoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (botafogoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += botafogoCompleto.get(i).getHomeTime().getScore();
                if (botafogoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += botafogoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (botafogoCompleto.get(i).getAwayTime().getName().equals("Botafogo")) {
                name = botafogoCompleto.get(i).getAwayTime().getName();
                image = botafogoCompleto.get(i).getAwayTime().getImage();
                if (botafogoCompleto.get(i).getAwayTime().getScore() > botafogoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (botafogoCompleto.get(i).getAwayTime().getScore() == botafogoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (botafogoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += botafogoCompleto.get(i).getAwayTime().getScore();
                if (botafogoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += botafogoCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < bragantinoCompleto.size(); i++) {
            if (bragantinoCompleto.get(i).getHomeTime().getName().equals("Bragantino")) {
                name = bragantinoCompleto.get(i).getHomeTime().getName();
                image = bragantinoCompleto.get(i).getHomeTime().getImage();
                if (bragantinoCompleto.get(i).getHomeTime().getScore() > bragantinoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (bragantinoCompleto.get(i).getHomeTime().getScore() == bragantinoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bragantinoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += bragantinoCompleto.get(i).getHomeTime().getScore();
                if (bragantinoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += bragantinoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (bragantinoCompleto.get(i).getAwayTime().getName().equals("Bragantino")) {
                name = bragantinoCompleto.get(i).getAwayTime().getName();
                image = bragantinoCompleto.get(i).getAwayTime().getImage();
                if (bragantinoCompleto.get(i).getAwayTime().getScore() > bragantinoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (bragantinoCompleto.get(i).getAwayTime().getScore() == bragantinoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bragantinoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += bragantinoCompleto.get(i).getAwayTime().getScore();
                if (bragantinoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += bragantinoCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < corinthiansCompleto.size(); i++) {
            if (corinthiansCompleto.get(i).getHomeTime().getName().equals("Corinthians")) {
                name = corinthiansCompleto.get(i).getHomeTime().getName();
                image = corinthiansCompleto.get(i).getHomeTime().getImage();
                if (corinthiansCompleto.get(i).getHomeTime().getScore() > corinthiansCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (corinthiansCompleto.get(i).getHomeTime().getScore() == corinthiansCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (corinthiansCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += corinthiansCompleto.get(i).getHomeTime().getScore();
                if (corinthiansCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += corinthiansCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (corinthiansCompleto.get(i).getAwayTime().getName().equals("Corinthians")) {
                name = corinthiansCompleto.get(i).getAwayTime().getName();
                image = corinthiansCompleto.get(i).getAwayTime().getImage();
                if (corinthiansCompleto.get(i).getAwayTime().getScore() > corinthiansCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (corinthiansCompleto.get(i).getAwayTime().getScore() == corinthiansCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (corinthiansCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += corinthiansCompleto.get(i).getAwayTime().getScore();
                if (corinthiansCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += corinthiansCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < criciumaCompleto.size(); i++) {
            if (criciumaCompleto.get(i).getHomeTime().getName().equals("Criciúma")) {
                name = criciumaCompleto.get(i).getHomeTime().getName();
                image = criciumaCompleto.get(i).getHomeTime().getImage();
                if (criciumaCompleto.get(i).getHomeTime().getScore() > criciumaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (criciumaCompleto.get(i).getHomeTime().getScore() == criciumaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (criciumaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += criciumaCompleto.get(i).getHomeTime().getScore();
                if (criciumaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += criciumaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (criciumaCompleto.get(i).getAwayTime().getName().equals("Criciúma")) {
                name = criciumaCompleto.get(i).getAwayTime().getName();
                image = criciumaCompleto.get(i).getAwayTime().getImage();
                if (criciumaCompleto.get(i).getAwayTime().getScore() > criciumaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (criciumaCompleto.get(i).getAwayTime().getScore() == criciumaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (criciumaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += criciumaCompleto.get(i).getAwayTime().getScore();
                if (criciumaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += criciumaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < cruzeiroCompleto.size(); i++) {
            if (cruzeiroCompleto.get(i).getHomeTime().getName().equals("Cruzeiro")) {
                name = cruzeiroCompleto.get(i).getHomeTime().getName();
                image = cruzeiroCompleto.get(i).getHomeTime().getImage();
                if (cruzeiroCompleto.get(i).getHomeTime().getScore() > cruzeiroCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (cruzeiroCompleto.get(i).getHomeTime().getScore() == cruzeiroCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (cruzeiroCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += cruzeiroCompleto.get(i).getHomeTime().getScore();
                if (cruzeiroCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += cruzeiroCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (cruzeiroCompleto.get(i).getAwayTime().getName().equals("Cruzeiro")) {
                name = cruzeiroCompleto.get(i).getAwayTime().getName();
                image = cruzeiroCompleto.get(i).getAwayTime().getImage();
                if (cruzeiroCompleto.get(i).getAwayTime().getScore() > cruzeiroCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (cruzeiroCompleto.get(i).getAwayTime().getScore() == cruzeiroCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (cruzeiroCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += cruzeiroCompleto.get(i).getAwayTime().getScore();
                if (cruzeiroCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += cruzeiroCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < cuiabaCompleto.size(); i++) {
            if (cuiabaCompleto.get(i).getHomeTime().getName().equals("Cuiabá")) {
                name = cuiabaCompleto.get(i).getHomeTime().getName();
                image = cuiabaCompleto.get(i).getHomeTime().getImage();
                if (cuiabaCompleto.get(i).getHomeTime().getScore() > cuiabaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (cuiabaCompleto.get(i).getHomeTime().getScore() == cuiabaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (cuiabaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += cuiabaCompleto.get(i).getHomeTime().getScore();
                if (cuiabaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += cuiabaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (cuiabaCompleto.get(i).getAwayTime().getName().equals("Cuiabá")) {
                name = cuiabaCompleto.get(i).getAwayTime().getName();
                image = cuiabaCompleto.get(i).getAwayTime().getImage();
                if (cuiabaCompleto.get(i).getAwayTime().getScore() > cuiabaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (cuiabaCompleto.get(i).getAwayTime().getScore() == cuiabaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (cuiabaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += cuiabaCompleto.get(i).getAwayTime().getScore();
                if (cuiabaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += cuiabaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < flamengoCompleto.size(); i++) {
            if (flamengoCompleto.get(i).getHomeTime().getName().equals("Flamengo")) {
                name = flamengoCompleto.get(i).getHomeTime().getName();
                image = flamengoCompleto.get(i).getHomeTime().getImage();
                if (flamengoCompleto.get(i).getHomeTime().getScore() > flamengoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (flamengoCompleto.get(i).getHomeTime().getScore() == flamengoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (flamengoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += flamengoCompleto.get(i).getHomeTime().getScore();
                if (flamengoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += flamengoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (flamengoCompleto.get(i).getAwayTime().getName().equals("Flamengo")) {
                name = flamengoCompleto.get(i).getAwayTime().getName();
                image = flamengoCompleto.get(i).getAwayTime().getImage();
                if (flamengoCompleto.get(i).getAwayTime().getScore() > flamengoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (flamengoCompleto.get(i).getAwayTime().getScore() == flamengoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (flamengoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += flamengoCompleto.get(i).getAwayTime().getScore();
                if (flamengoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += flamengoCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < fluminenseCompleto.size(); i++) {
            if (fluminenseCompleto.get(i).getHomeTime().getName().equals("Fluminense")) {
                name = fluminenseCompleto.get(i).getHomeTime().getName();
                image = fluminenseCompleto.get(i).getHomeTime().getImage();
                if (fluminenseCompleto.get(i).getHomeTime().getScore() > fluminenseCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (fluminenseCompleto.get(i).getHomeTime().getScore() == fluminenseCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (fluminenseCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += fluminenseCompleto.get(i).getHomeTime().getScore();
                if (fluminenseCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += fluminenseCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (fluminenseCompleto.get(i).getAwayTime().getName().equals("Fluminense")) {
                name = fluminenseCompleto.get(i).getAwayTime().getName();
                image = fluminenseCompleto.get(i).getAwayTime().getImage();
                if (fluminenseCompleto.get(i).getAwayTime().getScore() > fluminenseCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (fluminenseCompleto.get(i).getAwayTime().getScore() == fluminenseCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (fluminenseCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += fluminenseCompleto.get(i).getAwayTime().getScore();
                if (fluminenseCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += fluminenseCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < fortalezaCompleto.size(); i++) {
            if (fortalezaCompleto.get(i).getHomeTime().getName().equals("Fortaleza")) {
                name = fortalezaCompleto.get(i).getHomeTime().getName();
                image = fortalezaCompleto.get(i).getHomeTime().getImage();
                if (fortalezaCompleto.get(i).getHomeTime().getScore() > fortalezaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (fortalezaCompleto.get(i).getHomeTime().getScore() == fortalezaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (fortalezaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += fortalezaCompleto.get(i).getHomeTime().getScore();
                if (fortalezaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += fortalezaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (fortalezaCompleto.get(i).getAwayTime().getName().equals("Fortaleza")) {
                name = fortalezaCompleto.get(i).getAwayTime().getName();
                image = fortalezaCompleto.get(i).getAwayTime().getImage();
                if (fortalezaCompleto.get(i).getAwayTime().getScore() > fortalezaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (fortalezaCompleto.get(i).getAwayTime().getScore() == fortalezaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (fortalezaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += fortalezaCompleto.get(i).getAwayTime().getScore();
                if (fortalezaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += fortalezaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < gremioCompleto.size(); i++) {
            if (gremioCompleto.get(i).getHomeTime().getName().equals("Grêmio")) {
                name = gremioCompleto.get(i).getHomeTime().getName();
                image = gremioCompleto.get(i).getHomeTime().getImage();
                if (gremioCompleto.get(i).getHomeTime().getScore() > gremioCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (gremioCompleto.get(i).getHomeTime().getScore() == gremioCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (gremioCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += gremioCompleto.get(i).getHomeTime().getScore();
                if (gremioCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += gremioCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (gremioCompleto.get(i).getAwayTime().getName().equals("Grêmio")) {
                name = gremioCompleto.get(i).getAwayTime().getName();
                image = gremioCompleto.get(i).getAwayTime().getImage();
                if (gremioCompleto.get(i).getAwayTime().getScore() > gremioCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (gremioCompleto.get(i).getAwayTime().getScore() == gremioCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (gremioCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += gremioCompleto.get(i).getAwayTime().getScore();
                if (gremioCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += gremioCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < internacionalCompleto.size(); i++) {
            if (internacionalCompleto.get(i).getHomeTime().getName().equals("Internacional")) {
                name = internacionalCompleto.get(i).getHomeTime().getName();
                image = internacionalCompleto.get(i).getHomeTime().getImage();
                if (internacionalCompleto.get(i).getHomeTime().getScore() > internacionalCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (internacionalCompleto.get(i).getHomeTime().getScore() == internacionalCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (internacionalCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += internacionalCompleto.get(i).getHomeTime().getScore();
                if (internacionalCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += internacionalCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (internacionalCompleto.get(i).getAwayTime().getName().equals("Internacional")) {
                name = internacionalCompleto.get(i).getAwayTime().getName();
                image = internacionalCompleto.get(i).getAwayTime().getImage();
                if (internacionalCompleto.get(i).getAwayTime().getScore() > internacionalCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (internacionalCompleto.get(i).getAwayTime().getScore() == internacionalCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (internacionalCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += internacionalCompleto.get(i).getAwayTime().getScore();
                if (internacionalCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += internacionalCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < juventudeCompleto.size(); i++) {
            if (juventudeCompleto.get(i).getHomeTime().getName().equals("Juventude")) {
                name = juventudeCompleto.get(i).getHomeTime().getName();
                image = juventudeCompleto.get(i).getHomeTime().getImage();
                if (juventudeCompleto.get(i).getHomeTime().getScore() > juventudeCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (juventudeCompleto.get(i).getHomeTime().getScore() == juventudeCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (juventudeCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += juventudeCompleto.get(i).getHomeTime().getScore();
                if (juventudeCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += juventudeCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (juventudeCompleto.get(i).getAwayTime().getName().equals("Juventude")) {
                name = juventudeCompleto.get(i).getAwayTime().getName();
                image = juventudeCompleto.get(i).getAwayTime().getImage();
                if (juventudeCompleto.get(i).getAwayTime().getScore() > juventudeCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (juventudeCompleto.get(i).getAwayTime().getScore() == juventudeCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (juventudeCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += juventudeCompleto.get(i).getAwayTime().getScore();
                if (juventudeCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += juventudeCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < palmeirasCompleto.size(); i++) {
            if (palmeirasCompleto.get(i).getHomeTime().getName().equals("Palmeiras")) {
                name = palmeirasCompleto.get(i).getHomeTime().getName();
                image = palmeirasCompleto.get(i).getHomeTime().getImage();
                if (palmeirasCompleto.get(i).getHomeTime().getScore() > palmeirasCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (palmeirasCompleto.get(i).getHomeTime().getScore() == palmeirasCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (palmeirasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += palmeirasCompleto.get(i).getHomeTime().getScore();
                if (palmeirasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += palmeirasCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (palmeirasCompleto.get(i).getAwayTime().getName().equals("Palmeiras")) {
                name = palmeirasCompleto.get(i).getAwayTime().getName();
                image = palmeirasCompleto.get(i).getAwayTime().getImage();
                if (palmeirasCompleto.get(i).getAwayTime().getScore() > palmeirasCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (palmeirasCompleto.get(i).getAwayTime().getScore() == palmeirasCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (palmeirasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += palmeirasCompleto.get(i).getAwayTime().getScore();
                if (palmeirasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += palmeirasCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < saoPauloCompleto.size(); i++) {
            if (saoPauloCompleto.get(i).getHomeTime().getName().equals("São-Paulo")) {
                name = saoPauloCompleto.get(i).getHomeTime().getName();
                image = saoPauloCompleto.get(i).getHomeTime().getImage();
                if (saoPauloCompleto.get(i).getHomeTime().getScore() > saoPauloCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (saoPauloCompleto.get(i).getHomeTime().getScore() == saoPauloCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (saoPauloCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += saoPauloCompleto.get(i).getHomeTime().getScore();
                if (saoPauloCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += saoPauloCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (saoPauloCompleto.get(i).getAwayTime().getName().equals("São-Paulo")) {
                name = saoPauloCompleto.get(i).getAwayTime().getName();
                image = saoPauloCompleto.get(i).getAwayTime().getImage();
                if (saoPauloCompleto.get(i).getAwayTime().getScore() > saoPauloCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (saoPauloCompleto.get(i).getAwayTime().getScore() == saoPauloCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (saoPauloCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += saoPauloCompleto.get(i).getAwayTime().getScore();
                if (saoPauloCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += saoPauloCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < vascoCompleto.size(); i++) {
            if (vascoCompleto.get(i).getHomeTime().getName().equals("Vasco")) {
                name = vascoCompleto.get(i).getHomeTime().getName();
                image = vascoCompleto.get(i).getHomeTime().getImage();
                if (vascoCompleto.get(i).getHomeTime().getScore() > vascoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (vascoCompleto.get(i).getHomeTime().getScore() == vascoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (vascoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += vascoCompleto.get(i).getHomeTime().getScore();
                if (vascoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += vascoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (vascoCompleto.get(i).getAwayTime().getName().equals("Vasco")) {
                name = vascoCompleto.get(i).getAwayTime().getName();
                image = vascoCompleto.get(i).getAwayTime().getImage();
                if (vascoCompleto.get(i).getAwayTime().getScore() > vascoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (vascoCompleto.get(i).getAwayTime().getScore() == vascoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (vascoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += vascoCompleto.get(i).getAwayTime().getScore();
                if (vascoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += vascoCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < vitoriaCompleto.size(); i++) {
            if (vitoriaCompleto.get(i).getHomeTime().getName().equals("Vitória")) {
                name = vitoriaCompleto.get(i).getHomeTime().getName();
                image = vitoriaCompleto.get(i).getHomeTime().getImage();
                if (vitoriaCompleto.get(i).getHomeTime().getScore() > vitoriaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (vitoriaCompleto.get(i).getHomeTime().getScore() == vitoriaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (vitoriaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += vitoriaCompleto.get(i).getHomeTime().getScore();
                if (vitoriaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += vitoriaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (vitoriaCompleto.get(i).getAwayTime().getName().equals("Vitória")) {
                name = vitoriaCompleto.get(i).getAwayTime().getName();
                image = vitoriaCompleto.get(i).getAwayTime().getImage();
                if (vitoriaCompleto.get(i).getAwayTime().getScore() > vitoriaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (vitoriaCompleto.get(i).getAwayTime().getScore() == vitoriaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (vitoriaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += vitoriaCompleto.get(i).getAwayTime().getScore();
                if (vitoriaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += vitoriaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for wolves

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modificamos a variavel listaOficial.. Essa variuavel nao esta vazia mais.// Só que pro adapter ela ainda esta vazia

        listaOficial.sort(new ComparatorPontosVitoriaSaldoGolsProSerieA_B());
        //Collections.sort(minhaLista);
        Collections.reverse(listaOficial);


        //Mas entenda que o código abaixo sempre vai atualizar a lista inteira
        timesClasificacaoBrasilA2024Adapter.notifyDataSetChanged();







    }//fim do método da Interface




}//fim da classe