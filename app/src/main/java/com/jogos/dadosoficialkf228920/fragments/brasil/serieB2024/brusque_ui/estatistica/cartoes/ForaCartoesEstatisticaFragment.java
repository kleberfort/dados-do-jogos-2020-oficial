package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.brusque_ui.estatistica.cartoes;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadoPartidaSegundoTempoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasPrimeiroTempoAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaCartoesBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.util.FormatarCoresTextoCartoesMcdFora;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ForaCartoesEstatisticaFragment extends Fragment implements JogosSerieB2024Listener {

    private TelaEstatisticaCartoesBinding binding;
    private JogosSerieB2024 jogosSerieB2024;

    private ResultadosPartidasAdapter resultadosPartidasAdapter;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;
    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;

    //CARTOES AMARELO 0.5 1T
    private int cartoesAmareloPrimeiroTempoZeroCincoMarcados;
    private int cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados;

    //CARTOES AMARELO 1.5 1T
    private int cartoesAmareloPrimeiroTempoUmCincoMarcados;
    private int cartoesAmareloPrimeiroTempoUmCincoNaoMarcados;


    //CARTOES AMARELO 0.5 2T
    private int cartoesAmareloSegundoTempoZeroCincoMarcados;
    private int cartoesAmareloSegundoTempoZeroCincoNaoMarcados;

    //CARTOES AMARELO 1.5 2T
    private int cartoesAmareloSegundoTempoUmCincoMarcados;
    private int cartoesAmareloSegundoTempoUmCincoNaoMarcados;


    //CARTOES VERMELHO 0.5 1T
    private int cartoesVermelhoPrimeiroTempoZeroCincoMarcados;
    private int cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados;

    //CARTOES VERMELHO 0.5 2T
    private int cartoesVermelhoSegundoTempoZeroCincoMarcados;
    private int cartoesVermelhoSegundoTempoZeroCincoNaoMarcados;

    //CARTOES ACIMA

    private int cartoesAmareloVermelhoTotalZeroCincoMarcados;
    private int cartoesAmareloVermelhoTotalZeroCincoNaoMarcados;

    private int cartoesAmareloVermelhoTotalUmCincoMarcados;
    private int cartoesAmareloVermelhoTotalUmCincoNaoMarcados;

    private int cartoesAmareloVermelhoTotalDoisCincoMarcados;
    private int cartoesAmareloVermelhoTotalDoisCincoNaoMarcados;

    private int cartoesAmareloVermelhoTotalTresCincoMarcados;
    private int cartoesAmareloVermelhoTotalTresCincoNaoMarcados;
    private List<PartidaNovoModelo> partidas = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaCartoesBinding.inflate(inflater, container, false);


        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener




        binding.tvAmarelo1T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ SAIU ] 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(1);
            }
        });
        binding.tvAmarelo1T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ NÃO SAIU ] 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(2);
            }
        });

        binding.tvAmarelo1T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ SAIU ] 1T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(3);
            }
        });
        binding.tvAmarelo1T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ NÃO SAIU ] 1T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(4);
            }
        });

        binding.tvAmarelo2T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ SAIU ] 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(5);
            }
        });
        binding.tvAmarelo2T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ NÃO SAIU ] 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(6);
            }
        });

        binding.tvAmarelo2T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ SAIU ] 2T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(7);
            }
        });
        binding.tvAmarelo2T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO QUE [ NÃO SAIU ] 2T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(8);
            }
        });


        binding.tvVermelho1T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "VERMELHO QUE [ SAIU ] 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(9);
            }
        });
        binding.tvVermelho1T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "VERMELHO QUE [ NÃO SAIU ] 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(10);
            }
        });

        binding.tvVermelho2T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "VERMELHO QUE [ SAIU ] 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(11);
            }
        });
        binding.tvVermelho2T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "VERMELHO QUE [ NÃO SAIU ] 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(12);
            }
        });


        binding.tvAmrlVmlAcima05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ SAIU ] 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(13);
            }
        });

        binding.tvAmrlVmlAcima05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ NÃO SAIU ] 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(14);
            }
        });

        binding.tvAmrlVmlAcima15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ SAIU ] 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(15);
            }
        });

        binding.tvAmrlVmlAcima15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ NÃO SAIU ] 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(16);
            }
        });

        binding.tvAmrlVmlAcima25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ SAIU ] 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(17);
            }
        });

        binding.tvAmrlVmlAcima25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ NÃO SAIU ] 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(18);
            }
        });

        binding.tvAmrlVmlAcima35Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ SAIU ] 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(19);
            }
        });

        binding.tvAmrlVmlAcima35Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AMARELO E/OU VERMELHO QUE [ NÃO SAIU ] 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(20);
            }
        });




        return binding.getRoot();

    }



    private void handleTextViewClick(int textViewId) {
        List<PartidaNovoModelo> jogos = new ArrayList<>();

        switch (textViewId) {
            case 1:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO 0.5 1°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO MENOR 0.5 1°TEMPO
                    if((partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() == 0 ))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 3:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO  1.5 1°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 4:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO MENOR 1.5 1°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 5:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO  0.5 2°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 6:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO MENOR 0.5 2°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 7:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO  1.5 2°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 8:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO MENOR 1.5 2°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 9:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO VERMELHO 0.5 1°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 10:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO VERMELHO MENOR 0.5 1°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 11:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO VERMELHO 0.5 2°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 12:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTÃO VERMELHO MENOR 0.5 2°TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;


            case 13:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTAO ACIMA 0.5
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() +
                            partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 14:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTAO MENOR 0.5
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() +
                            partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 15:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTAO ACIMA 1.5 TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 1 )
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 16:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTAO MENOR 1.5 TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() < 2 )
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 17:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTAO ACIMA 2.5 TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 18:
                for (int i = 0; i < partidas.size(); i++) {
                    //CARTAO MENOR 2.5 TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 19:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS ACIMA 3.5 TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 20:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 3.5 TEMPO
                    if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                            + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() < 4)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

        }

    }//fim do metodo que busca os dados

    @Override
    public void onJogosSerieBReady(List<PartidaNovoModelo> amazonasCompleto, List<PartidaNovoModelo> americaMGCompleto, List<PartidaNovoModelo> avaiCompleto, List<PartidaNovoModelo> botafogoSPCompleto, List<PartidaNovoModelo> brusqueCompleto, List<PartidaNovoModelo> crbCompleto, List<PartidaNovoModelo> cearaCompleto, List<PartidaNovoModelo> chapecoenseCompleto, List<PartidaNovoModelo> coritibaCompleto, List<PartidaNovoModelo> goiasCompleto, List<PartidaNovoModelo> guaraniCompleto, List<PartidaNovoModelo> ituanoCompleto, List<PartidaNovoModelo> mirassolCompleto, List<PartidaNovoModelo> novorizontinoCompleto, List<PartidaNovoModelo> operarioCompleto, List<PartidaNovoModelo> paysanduCompleto, List<PartidaNovoModelo> pontepretaCompleto, List<PartidaNovoModelo> santosCompleto, List<PartidaNovoModelo> sportCompleto, List<PartidaNovoModelo> vilanovaCompleto) {



        PartidaNovoModelo partidaNovoModelo = new PartidaNovoModelo();

        for (PartidaNovoModelo partida : brusqueCompleto) {

            if (partida.getAwayTime().getName().equals("Brusque")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for


        for (int i = 0; i < partidas.size(); i++) {


            //CARTOES 0.5 1°TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() > 0)
                cartoesAmareloPrimeiroTempoZeroCincoMarcados += 1;
            cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - cartoesAmareloPrimeiroTempoZeroCincoMarcados;


            //CARTOES 1.5 1°TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() > 1)
                cartoesAmareloPrimeiroTempoUmCincoMarcados += 1;
            cartoesAmareloPrimeiroTempoUmCincoNaoMarcados = partidas.size() - cartoesAmareloPrimeiroTempoUmCincoMarcados;

          // ------------------- SEGUNDO TEMPO -----------------------------------------------------------------------

            //CARTOES 0.5 2°TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() > 0)
                cartoesAmareloSegundoTempoZeroCincoMarcados += 1;
            cartoesAmareloSegundoTempoZeroCincoNaoMarcados = partidas.size() - cartoesAmareloSegundoTempoZeroCincoMarcados;

            //CARTOES 1.5 2°TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() > 1)
                cartoesAmareloSegundoTempoUmCincoMarcados += 1;
            cartoesAmareloSegundoTempoUmCincoNaoMarcados = partidas.size() - cartoesAmareloSegundoTempoUmCincoMarcados;


            //   CARTOES VERMELHOS

            //CARTOES VERMELHO 0.5 1°TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() > 0)
                cartoesVermelhoPrimeiroTempoZeroCincoMarcados += 1;
            cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - cartoesVermelhoPrimeiroTempoZeroCincoMarcados;


            //CARTOES VERMELHO 0.5 2°TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 0)
                cartoesVermelhoSegundoTempoZeroCincoMarcados += 1;
            cartoesVermelhoSegundoTempoZeroCincoNaoMarcados = partidas.size() - cartoesVermelhoSegundoTempoZeroCincoMarcados;


//     CARTOES ACIMA -----------------------------------------------------------------------------


            //CARTOES ACIMA 0.5 TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 0)
                cartoesAmareloVermelhoTotalZeroCincoMarcados += 1;
            cartoesAmareloVermelhoTotalZeroCincoNaoMarcados = partidas.size() - cartoesAmareloVermelhoTotalZeroCincoMarcados;

            //CARTOES ACIMA 1.5 TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 1 )
                cartoesAmareloVermelhoTotalUmCincoMarcados += 1;
            cartoesAmareloVermelhoTotalUmCincoNaoMarcados = partidas.size() - cartoesAmareloVermelhoTotalUmCincoMarcados;


            //CARTOES ACIMA 2.5 TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 2)
                cartoesAmareloVermelhoTotalDoisCincoMarcados += 1;
            cartoesAmareloVermelhoTotalDoisCincoNaoMarcados = partidas.size() - cartoesAmareloVermelhoTotalDoisCincoMarcados;


            //CARTOES ACIMA 3.5 TEMPO
            if(partidas.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo()
                    + partidas.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 3)
                cartoesAmareloVermelhoTotalTresCincoMarcados += 1;
            cartoesAmareloVermelhoTotalTresCincoNaoMarcados = partidas.size() - cartoesAmareloVermelhoTotalTresCincoMarcados;


        }//fim do for



        //Inicio Porcentagem



        //CARTAO 1T 0.5 PORCENTAGEM

        binding.tvAmarelo1T05McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloPrimeiroTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmarelo1T05CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo1T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo1T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo1T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo1T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo1T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo1T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo1T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo1T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTAO 1T 1.5 PORCENTAGEM


        binding.tvAmarelo1T15McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloPrimeiroTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmarelo1T15CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloPrimeiroTempoUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo1T15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo1T15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo1T15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo1T15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo1T15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo1T15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo1T15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo1T15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTAO 2T 0.5 PORCENTAGEM


        binding.tvAmarelo2T05McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloSegundoTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmarelo2T05CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloSegundoTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo2T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo2T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo2T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo2T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo2T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo2T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo2T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo2T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTAO 2T 1.5 PORCENTAGEM


        binding.tvAmarelo2T15McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloSegundoTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmarelo2T15CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloSegundoTempoUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo2T15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo2T15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo2T15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo2T15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmarelo2T15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmarelo2T15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmarelo2T15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmarelo2T15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);



        //CARTAO VERMELHO 1T 0.5 PORCENTAGEM

        binding.tvVermelho1T05McdPct.setText(String.valueOf(Math.round(((double)cartoesVermelhoPrimeiroTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvVermelho1T05CtPct.setText(String.valueOf(Math.round((double)cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesVermelhoPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvVermelho1T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesVermelhoPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvVermelho1T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesVermelhoPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvVermelho1T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvVermelho1T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvVermelho1T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvVermelho1T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvVermelho1T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvVermelho1T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTAO VERMELHO 2T 0.5 PORCENTAGEM

        binding.tvVermelho2T05McdPct.setText(String.valueOf(Math.round(((double)cartoesVermelhoSegundoTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvVermelho2T05CtPct.setText(String.valueOf(Math.round((double)cartoesVermelhoSegundoTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesVermelhoSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvVermelho2T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesVermelhoSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvVermelho2T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesVermelhoSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvVermelho2T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvVermelho2T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesVermelhoSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvVermelho2T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesVermelhoSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvVermelho2T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesVermelhoSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvVermelho2T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvVermelho2T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTOES ACIMA 0.5 PORCENTAGEM

        binding.tvAmrlVmlAcima05McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloVermelhoTotalZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmrlVmlAcima05CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloVermelhoTotalZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloVermelhoTotalZeroCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalZeroCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalZeroCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloVermelhoTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        //CARTOES ACIMA 1.5 PORCENTAGEM

        binding.tvAmrlVmlAcima15McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloVermelhoTotalUmCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmrlVmlAcima15CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloVermelhoTotalUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloVermelhoTotalUmCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalUmCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalUmCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloVermelhoTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTOES ACIMA 2.5 PORCENTAGEM

        binding.tvAmrlVmlAcima25McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloVermelhoTotalDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmrlVmlAcima25CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloVermelhoTotalDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloVermelhoTotalDoisCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalDoisCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalDoisCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloVermelhoTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //CARTOES ACIMA 3.5 PORCENTAGEM


        binding.tvAmrlVmlAcima35McdPct.setText(String.valueOf(Math.round(((double)cartoesAmareloVermelhoTotalTresCincoMarcados * 100 ) / partidas.size()) + "%"));
        binding.tvAmrlVmlAcima35CtPct.setText(String.valueOf(Math.round((double)cartoesAmareloVermelhoTotalTresCincoNaoMarcados * 100 / partidas.size()) + "%"));

        if(Math.round(((double) cartoesAmareloVermelhoTotalTresCincoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalTresCincoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalTresCincoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(Math.round(((double) cartoesAmareloVermelhoTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 85)
            binding.tvAmrlVmlAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 70)
            binding.tvAmrlVmlAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
        else if(Math.round(((double) cartoesAmareloVermelhoTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 60)
            binding.tvAmrlVmlAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
        else
            binding.tvAmrlVmlAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);




        //Fim Porcentagem



        binding.tvTituloCartoes.setText("ESTATÍSTICA DE CARTÕES " + partidas.get(0).getAwayTime().getName().toUpperCase() + " FORA");



        binding.tvAmarelo1T05Mcd.setText(String.valueOf(cartoesAmareloPrimeiroTempoZeroCincoMarcados));
        binding.tvAmarelo1T05Ct.setText(String.valueOf(cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados));

        binding.tvAmarelo1T15Mcd.setText(String.valueOf(cartoesAmareloPrimeiroTempoUmCincoMarcados));
        binding.tvAmarelo1T15Ct.setText(String.valueOf(cartoesAmareloPrimeiroTempoUmCincoNaoMarcados));


        binding.tvAmarelo2T05Mcd.setText(String.valueOf(cartoesAmareloSegundoTempoZeroCincoMarcados));
        binding.tvAmarelo2T05Ct.setText(String.valueOf(cartoesAmareloSegundoTempoZeroCincoNaoMarcados));


        binding.tvAmarelo2T15Mcd.setText(String.valueOf(cartoesAmareloSegundoTempoUmCincoMarcados));
        binding.tvAmarelo2T15Ct.setText(String.valueOf(cartoesAmareloSegundoTempoUmCincoNaoMarcados));


        binding.tvVermelho1T05Mcd.setText(String.valueOf(cartoesVermelhoPrimeiroTempoZeroCincoMarcados));
        binding.tvVermelho1T05Ct.setText(String.valueOf(cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados));

        binding.tvVermelho2T05Mcd.setText(String.valueOf(cartoesVermelhoSegundoTempoZeroCincoMarcados));
        binding.tvVermelho2T05Ct.setText(String.valueOf(cartoesVermelhoSegundoTempoZeroCincoNaoMarcados));


        binding.tvAmrlVmlAcima05Mcd.setText(String.valueOf(cartoesAmareloVermelhoTotalZeroCincoMarcados));
        binding.tvAmrlVmlAcima05Ct.setText(String.valueOf(cartoesAmareloVermelhoTotalZeroCincoNaoMarcados));


        binding.tvAmrlVmlAcima15Mcd.setText(String.valueOf(cartoesAmareloVermelhoTotalUmCincoMarcados));
        binding.tvAmrlVmlAcima15Ct.setText(String.valueOf(cartoesAmareloVermelhoTotalUmCincoNaoMarcados));


        binding.tvAmrlVmlAcima25Mcd.setText(String.valueOf(cartoesAmareloVermelhoTotalDoisCincoMarcados));
        binding.tvAmrlVmlAcima25Ct.setText(String.valueOf(cartoesAmareloVermelhoTotalDoisCincoNaoMarcados));

        binding.tvAmrlVmlAcima35Mcd.setText(String.valueOf(cartoesAmareloVermelhoTotalTresCincoMarcados));
        binding.tvAmrlVmlAcima35Ct.setText(String.valueOf(cartoesAmareloVermelhoTotalTresCincoNaoMarcados));


        binding.tvTotalJogos.setText(String.valueOf(partidas.size()));

        String nome = partidas.get(0).getAwayTime().getName();
        String totalJogos = String.valueOf(partidas.size());
        String totalAmrlVmlMcd = String.valueOf(cartoesAmareloVermelhoTotalZeroCincoMarcados );
        String totalAmrlVmlMcdPct = String.valueOf(Math.round(((double)cartoesAmareloVermelhoTotalZeroCincoMarcados * 100 ) / partidas.size()));

        // Formate o texto usando a classe TextUtils
        SpannableStringBuilder builder = FormatarCoresTextoCartoesMcdFora.formatText(nome, totalJogos, totalAmrlVmlMcd, totalAmrlVmlMcdPct);

        // Defina o texto no TextView
        binding.tvRespostaEstatistica.setText(builder);


    }

    private void showPartidasDialog(List<PartidaNovoModelo> partidas) {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_partidas, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        RecyclerView recyclerViewPartidas = bottomSheetView.findViewById(R.id.recyclerViewPartidas);
        recyclerViewPartidas.setLayoutManager(new LinearLayoutManager(requireContext()));

        resultadosPartidasAdapter = new ResultadosPartidasAdapter(partidas);
        recyclerViewPartidas.setAdapter(resultadosPartidasAdapter);
        //resultadosPartidasAdapter.notifyDataSetChanged();

        bottomSheetDialog.show();
    }
    private void showPartidasPrimeiroTempo(List<PartidaNovoModelo> partidas) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_partidas, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        RecyclerView recyclerViewPartidas = bottomSheetView.findViewById(R.id.recyclerViewPartidas);
        recyclerViewPartidas.setLayoutManager(new LinearLayoutManager(requireContext()));

        resultadosPartidasPrimeiroTempoAdapter = new ResultadosPartidasPrimeiroTempoAdapter(partidas);
        recyclerViewPartidas.setAdapter(resultadosPartidasPrimeiroTempoAdapter);
        //resultadosPartidasAdapter.notifyDataSetChanged();

        bottomSheetDialog.show();
    }
    private void showPartidasSegundoTempo(List<PartidaNovoModelo> partidas) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_partidas, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        RecyclerView recyclerViewPartidas = bottomSheetView.findViewById(R.id.recyclerViewPartidas);
        recyclerViewPartidas.setLayoutManager(new LinearLayoutManager(requireContext()));

        resultadoPartidaSegundoTempoAdapter = new ResultadoPartidaSegundoTempoAdapter(partidas);
        recyclerViewPartidas.setAdapter(resultadoPartidaSegundoTempoAdapter);
        //resultadosPartidasAdapter.notifyDataSetChanged();

        bottomSheetDialog.show();
    }



}
