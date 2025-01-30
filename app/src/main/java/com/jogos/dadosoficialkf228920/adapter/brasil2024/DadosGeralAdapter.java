package com.jogos.dadosoficialkf228920.adapter.brasil2024;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.EstatisticaTempoBinding;
import com.jogos.dadosoficialkf228920.databinding.NovoLayoutDadosPartidasAdapterBinding;
import com.jogos.dadosoficialkf228920.databinding.StatItemBinding;
import com.jogos.dadosoficialkf228920.model.EstatisticaCartoes;
import com.jogos.dadosoficialkf228920.model.EstatisticaGeral;
import com.jogos.dadosoficialkf228920.model.EstatisticaJogo;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PlayedNameGols;

import java.util.List;

public class DadosGeralAdapter extends RecyclerView.Adapter<DadosGeralAdapter.ViewHolder> {

    private List<MatchNewModelDate> lista;

    public DadosGeralAdapter(List<MatchNewModelDate> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NovoLayoutDadosPartidasAdapterBinding binding = NovoLayoutDadosPartidasAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        MatchNewModelDate partida= lista.get(position);


        //DADOS DO JOGO
        holder.binding.matchDescription.setText(partida.getDescription());
        holder.binding.matchRound.setText("Rodada: " + String.valueOf(partida.getRound()));
        holder.binding.matchDate.setText(partida.getDate());

//        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(partida.getHomeTime().getName());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(partida.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(partida.getHomeTime().getPlacar()));
        Glide.with(context).load(partida.getHomeTime().getImage()).into(holder.binding.ivTimeCasa);

//        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(partida.getAwayTime().getName());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(partida.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(partida.getAwayTime().getPlacar()));
        Glide.with(context).load(partida.getAwayTime().getImage()).into(holder.binding.ivTimeFora);


        LinearLayout goalsLayout = holder.binding.goalsLayout;
        LinearLayout homeGoalsContainer = holder.binding.homeGoalsContainer;
        LinearLayout awayGoalsContainer = holder.binding.awayGoalsContainer;

        // Verifica se há gols no time da casa ou visitante
        boolean hasHomeGoals = partida.getHomeTime().getGoals() != null && !partida.getHomeTime().getGoals().isEmpty();
        boolean hasAwayGoals = partida.getAwayTime().getGoals() != null && !partida.getAwayTime().getGoals().isEmpty();

        if (hasHomeGoals || hasAwayGoals) {
            goalsLayout.setVisibility(View.VISIBLE); // Exibe o layout pai

            // Adiciona gols do time da casa
            homeGoalsContainer.removeAllViews();
            if (hasHomeGoals) {
                for (PlayedNameGols gol : partida.getHomeTime().getGoals()) {
                    TextView textView = new TextView(context);
                    textView.setText(gol.getJogador() + " " + gol.getTempo() + "'");
                    textView.setTextSize(14);
                    textView.setTextColor(ContextCompat.getColor(context, R.color.black));
                    textView.setGravity(Gravity.END);
                    textView.setPadding(0, 0, 0, 8);
                    homeGoalsContainer.addView(textView);
                }
            }

            // Adiciona gols do time visitante
            awayGoalsContainer.removeAllViews();
            if (hasAwayGoals) {
                for (PlayedNameGols gol : partida.getAwayTime().getGoals()) {
                    TextView textView = new TextView(context);
                    textView.setText(gol.getJogador() + " " + gol.getTempo() + "'");
                    textView.setTextSize(14);
                    textView.setTextColor(ContextCompat.getColor(context, R.color.black));
                    textView.setPadding(0, 0, 0, 8);
                    awayGoalsContainer.addView(textView);
                }
            }
        } else {
            goalsLayout.setVisibility(View.GONE); // Oculta o layout pai
        }


        // Dados de posse de bola
        EstatisticaGeral estatisticaGeralHome = partida.getEstatisticaGeralHome();
        EstatisticaGeral estatisticaGeralAway = partida.getEstatisticaGeralAway();

// Verifique se os objetos de estatísticas não são nulos
        if (estatisticaGeralHome != null && estatisticaGeralAway != null) {
            // Dados de posse de bola
            int posseBolaHome = estatisticaGeralHome.getPosseBola();
            int posseBolaAway = estatisticaGeralAway.getPosseBola();

            // Recupera o layout incluído (stat_item) para posse de bola
            StatItemBinding statPosseBolaView = holder.binding.statPosseBola;
            TextView homeValue = statPosseBolaView.statHomeValue;
            TextView awayValue = statPosseBolaView.statAwayValue;
            TextView categoryName = statPosseBolaView.statCategoryName;
            ProgressBar progressBar = statPosseBolaView.statProgress;

            // Define os valores e adiciona o símbolo de porcentagem
            homeValue.setText(String.valueOf(posseBolaHome) + "%");
            awayValue.setText(String.valueOf(posseBolaAway) + "%");
            categoryName.setText("Posse de Bola");

            // Calcula e configura a barra de progresso (percentual do time da casa)
            int progress = Math.round((float) posseBolaHome / (posseBolaHome + posseBolaAway) * 100);
            progressBar.setProgress(progress);

            // Dados de finalizações
            int finalizacoesHome = estatisticaGeralHome.getFinalizacao();
            int finalizacoesAway = estatisticaGeralAway.getFinalizacao();
            StatItemBinding statFinalizacoesView = holder.binding.statFinalizacoes;
            TextView homeFinalizacoes = statFinalizacoesView.statHomeValue;
            TextView awayFinalizacoes = statFinalizacoesView.statAwayValue;
            homeFinalizacoes.setText(String.valueOf(finalizacoesHome));
            awayFinalizacoes.setText(String.valueOf(finalizacoesAway));
            statFinalizacoesView.statCategoryName.setText("Finalizações");

            // Dados de finalizações no gol
            int finalizacoesGolHome = estatisticaGeralHome.getFinalizacaoGol();
            int finalizacoesGolAway = estatisticaGeralAway.getFinalizacaoGol();
            StatItemBinding statFinalizacoesGolView = holder.binding.statFinalizacoesGol;
            TextView homeFinalizacoesGol = statFinalizacoesGolView.statHomeValue;
            TextView awayFinalizacoesGol = statFinalizacoesGolView.statAwayValue;
            homeFinalizacoesGol.setText(String.valueOf(finalizacoesGolHome));
            awayFinalizacoesGol.setText(String.valueOf(finalizacoesGolAway));
            statFinalizacoesGolView.statCategoryName.setText("Finalizações no Gol");

            // Dados de tiros de meta
            int tirosDeMetaHome = estatisticaGeralHome.getTiroMeta();
            int tirosDeMetaAway = estatisticaGeralAway.getTiroMeta();
            StatItemBinding statTirosDeMetaView = holder.binding.statTirosDeMeta;
            TextView homeTirosDeMeta = statTirosDeMetaView.statHomeValue;
            TextView awayTirosDeMeta = statTirosDeMetaView.statAwayValue;
            homeTirosDeMeta.setText(String.valueOf(tirosDeMetaHome));
            awayTirosDeMeta.setText(String.valueOf(tirosDeMetaAway));
            statTirosDeMetaView.statCategoryName.setText("Tiros de Meta");

            // Dados de faltas
            int faltasHome = estatisticaGeralHome.getFalta();
            int faltasAway = estatisticaGeralAway.getFalta();
            StatItemBinding statFaltasView = holder.binding.statFaltas;
            TextView homeFaltas = statFaltasView.statHomeValue;
            TextView awayFaltas = statFaltasView.statAwayValue;
            homeFaltas.setText(String.valueOf(faltasHome));
            awayFaltas.setText(String.valueOf(faltasAway));
            statFaltasView.statCategoryName.setText("Faltas");

            // Dados de laterais
            int lateraisHome = estatisticaGeralHome.getLaterais();
            int lateraisAway = estatisticaGeralAway.getLaterais();
            StatItemBinding statLateraisView = holder.binding.statLaterais;
            TextView homeLaterais = statLateraisView.statHomeValue;
            TextView awayLaterais = statLateraisView.statAwayValue;
            homeLaterais.setText(String.valueOf(lateraisHome));
            awayLaterais.setText(String.valueOf(lateraisAway));
            statLateraisView.statCategoryName.setText("Laterais");

            // Dados de passes
            int passesHome = estatisticaGeralHome.getPasses();
            int passesAway = estatisticaGeralAway.getPasses();
            StatItemBinding statPassesView = holder.binding.statPasses;
            TextView homePasses = statPassesView.statHomeValue;
            TextView awayPasses = statPassesView.statAwayValue;
            homePasses.setText(String.valueOf(passesHome));
            awayPasses.setText(String.valueOf(passesAway));
            statPassesView.statCategoryName.setText("Passes");

            // Dados de desarmes
            int desarmesHome = estatisticaGeralHome.getDesarmes();
            int desarmesAway = estatisticaGeralAway.getDesarmes();
            StatItemBinding statDesarmesView = holder.binding.statDesarmes;
            TextView homeDesarmes = statDesarmesView.statHomeValue;
            TextView awayDesarmes = statDesarmesView.statAwayValue;
            homeDesarmes.setText(String.valueOf(desarmesHome));
            awayDesarmes.setText(String.valueOf(desarmesAway));
            statDesarmesView.statCategoryName.setText("Desarmes");

            // Dados de impedimentos
            int impedimentosHome = estatisticaGeralHome.getImpedimentos();
            int impedimentosAway = estatisticaGeralAway.getImpedimentos();
            StatItemBinding statImpedimentosView = holder.binding.statImpedimentos;
            TextView homeImpedimentos = statImpedimentosView.statHomeValue;
            TextView awayImpedimentos = statImpedimentosView.statAwayValue;
            homeImpedimentos.setText(String.valueOf(impedimentosHome));
            awayImpedimentos.setText(String.valueOf(impedimentosAway));
            statImpedimentosView.statCategoryName.setText("Impedimentos");
        }

        // Dados de posse de bola
        EstatisticaJogo estatisticaJogoHome = partida.getHomeEstatisticaJogo();
        EstatisticaJogo estatisticaJogoAway = partida.getAwayEstatisticaJogo();


        EstatisticaCartoes estatisticaCartoesHome = partida.getHomeCartoes();
        EstatisticaCartoes estatisticaCartoesAway = partida.getAwayCartoes();

        // Verifique se os objetos de estatísticas não são nulos
        if (estatisticaJogoHome != null && estatisticaJogoAway != null && estatisticaCartoesHome != null && estatisticaCartoesAway != null) {
            // Dados de gols
            int golsHome = estatisticaJogoHome.getGolsPrimeiroTempo() + estatisticaJogoHome.getGolsSegundoTempo();
            int golsAway = estatisticaJogoAway.getGolsPrimeiroTempo() + estatisticaJogoAway.getGolsSegundoTempo();

            // Recupera o layout incluído (stat_item) para gols
            StatItemBinding statGolsView = holder.binding.statGols;
            TextView homeGols = statGolsView.statHomeValue;
            TextView awayGols = statGolsView.statAwayValue;
            homeGols.setText(String.valueOf(golsHome));
            awayGols.setText(String.valueOf(golsAway));
            statGolsView.statCategoryName.setText("Gols");

            // Dados de escanteios
            int escanteiosHome = estatisticaJogoHome.getEscanteiosPrimeiroTempo() + estatisticaJogoHome.getEscanteioSegundoTempo();
            int escanteiosAway = estatisticaJogoAway.getEscanteiosPrimeiroTempo() + estatisticaJogoAway.getEscanteioSegundoTempo();

            // Recupera o layout incluído (stat_item) para escanteios
            StatItemBinding statEscanteiosView = holder.binding.statEscanteios;
            TextView homeEscanteios = statEscanteiosView.statHomeValue;
            TextView awayEscanteios = statEscanteiosView.statAwayValue;
            homeEscanteios.setText(String.valueOf(escanteiosHome));
            awayEscanteios.setText(String.valueOf(escanteiosAway));
            statEscanteiosView.statCategoryName.setText("Escanteios");

            // Dados de cartões amarelos
            int amareloHome = estatisticaCartoesHome.getCartaoAmareloPrimeiroTempo() + estatisticaCartoesHome.getCartaoAmareloSegundoTempo();
            int amareloAway = estatisticaCartoesAway.getCartaoAmareloPrimeiroTempo() + estatisticaCartoesAway.getCartaoAmareloSegundoTempo();

            // Recupera o layout incluído (stat_item) para cartões amarelos
            StatItemBinding statAmareloView = holder.binding.statAmarelo;
            TextView homeAmarelo = statAmareloView.statHomeValue;
            TextView awayAmarelo = statAmareloView.statAwayValue;
            homeAmarelo.setText(String.valueOf(amareloHome));
            awayAmarelo.setText(String.valueOf(amareloAway));
            statAmareloView.statCategoryName.setText("Cartões Amarelos");

            // Dados de cartões vermelhos
            int vermelhoHome = estatisticaCartoesHome.getCartaoVermelhoPrimeiroTempo() + estatisticaCartoesHome.getCartaoVermelhoSegundoTempo();
            int vermelhoAway = estatisticaCartoesAway.getCartaoVermelhoPrimeiroTempo() + estatisticaCartoesAway.getCartaoVermelhoSegundoTempo();

            // Recupera o layout incluído (stat_item) para cartões vermelhos
            StatItemBinding statVermelhoView = holder.binding.statVermelho;
            TextView homeVermelho = statVermelhoView.statHomeValue;
            TextView awayVermelho = statVermelhoView.statAwayValue;
            homeVermelho.setText(String.valueOf(vermelhoHome));
            awayVermelho.setText(String.valueOf(vermelhoAway));
            statVermelhoView.statCategoryName.setText("Cartões Vermelhos");
        }

        if (estatisticaJogoHome != null && estatisticaJogoAway != null && estatisticaCartoesHome != null && estatisticaCartoesAway != null) {
            // Dados de gols (apenas do primeiro tempo)
            int golsHome = estatisticaJogoHome.getGolsPrimeiroTempo();
            int golsAway = estatisticaJogoAway.getGolsPrimeiroTempo();

            // Recupera o layout incluído (estatistica_tempo) para gols
            EstatisticaTempoBinding estatisticaTempoView = holder.binding.estatisticaPrimeiroTempo;
            if (estatisticaTempoView != null) {
                TextView homeGols = estatisticaTempoView.statHomeValueGoals;
                TextView awayGols = estatisticaTempoView.statAwayValueGoals;
                homeGols.setText(String.valueOf(golsHome));
                awayGols.setText(String.valueOf(golsAway));
                estatisticaTempoView.statCategoryNameGoals.setText("Gols");

                // Barra de progresso para Gols
                ProgressBar progressGols = estatisticaTempoView.statProgressGoals;
                int totalGols = golsHome + golsAway;
                progressGols.setProgress(totalGols > 0 ? (int) ((golsHome / (float) totalGols) * 100) : 0);

                // Dados de escanteios (apenas do primeiro tempo)
                int escanteiosHome = estatisticaJogoHome.getEscanteiosPrimeiroTempo();
                int escanteiosAway = estatisticaJogoAway.getEscanteiosPrimeiroTempo();

                // Recupera o layout incluído (estatistica_tempo) para escanteios
                TextView homeEscanteios = estatisticaTempoView.statHomeValueCorners;
                TextView awayEscanteios = estatisticaTempoView.statAwayValueCorners;
                homeEscanteios.setText(String.valueOf(escanteiosHome));
                awayEscanteios.setText(String.valueOf(escanteiosAway));
                estatisticaTempoView.statCategoryNameCorners.setText("Escanteios");

                // Barra de progresso para Escanteios
                ProgressBar progressEscanteios = estatisticaTempoView.statProgressCorners;
                int totalEscanteios = escanteiosHome + escanteiosAway;
                progressEscanteios.setProgress(totalEscanteios > 0 ? (int) ((escanteiosHome / (float) totalEscanteios) * 100) : 0);

                // Dados de cartões amarelos (apenas do primeiro tempo)
                int amareloHome = estatisticaCartoesHome.getCartaoAmareloPrimeiroTempo();
                int amareloAway = estatisticaCartoesAway.getCartaoAmareloPrimeiroTempo();

                // Recupera o layout incluído (estatistica_tempo) para cartões amarelos
                TextView homeAmarelo = estatisticaTempoView.statHomeValueAmarelo;
                TextView awayAmarelo = estatisticaTempoView.statAwayValueAmarelo;
                homeAmarelo.setText(String.valueOf(amareloHome));
                awayAmarelo.setText(String.valueOf(amareloAway));
                estatisticaTempoView.statCategoryNameAmarelos.setText("Cartões Amarelos");

                // Barra de progresso para Cartões Amarelos
                ProgressBar progressAmarelo = estatisticaTempoView.statProgressAmarelo;
                int totalAmarelos = amareloHome + amareloAway;
                progressAmarelo.setProgress(totalAmarelos > 0 ? (int) ((amareloHome / (float) totalAmarelos) * 100) : 0);

                // Dados de cartões vermelhos (apenas do primeiro tempo)
                int vermelhoHome = estatisticaCartoesHome.getCartaoVermelhoPrimeiroTempo();
                int vermelhoAway = estatisticaCartoesAway.getCartaoVermelhoPrimeiroTempo();

                // Recupera o layout incluído (estatistica_tempo) para cartões vermelhos
                TextView homeVermelho = estatisticaTempoView.statHomeValueVermelho;
                TextView awayVermelho = estatisticaTempoView.statAwayValueVermelho;
                homeVermelho.setText(String.valueOf(vermelhoHome));
                awayVermelho.setText(String.valueOf(vermelhoAway));
                estatisticaTempoView.statCategoryNameVermelho.setText("Cartões Vermelhos");

                // Barra de progresso para Cartões Vermelhos
                ProgressBar progressVermelho = estatisticaTempoView.statProgressVermelho;
                int totalVermelhos = vermelhoHome + vermelhoAway;
                progressVermelho.setProgress(totalVermelhos > 0 ? (int) ((vermelhoHome / (float) totalVermelhos) * 100) : 0);
            }
        }
        

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private NovoLayoutDadosPartidasAdapterBinding binding;


        public ViewHolder(@NonNull NovoLayoutDadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
