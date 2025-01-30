package com.jogos.dadosoficialkf228920.adapter.brasil2024;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.EstatisticaApostaBinding;
import com.jogos.dadosoficialkf228920.databinding.NovoLayoutDadosPartidasAdapterBinding;
import com.jogos.dadosoficialkf228920.model.EstatisticaGeral;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PlayedNameGols;

import java.util.List;

public class CarregarFinalizacaoFaltaImpedimentoAdapter extends RecyclerView.Adapter<CarregarFinalizacaoFaltaImpedimentoAdapter.ViewHolder> {

    private List<MatchNewModelDate> lista;
    private String status;

    public CarregarFinalizacaoFaltaImpedimentoAdapter(List<MatchNewModelDate> lista, String status) {
        this.lista = lista;
        this.status = status;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        EstatisticaApostaBinding binding = EstatisticaApostaBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        MatchNewModelDate partida= lista.get(position);

        //        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(partida.getHomeTime().getName());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(partida.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(partida.getHomeTime().getPlacar()));
        Glide.with(context).load(partida.getHomeTime().getImage()).into(holder.binding.ivTimeCasa);

        if(status.equals("casa")){
            // Estatísticas do time da casa
            EstatisticaGeral estatisticaGeralHome = partida.getEstatisticaGeralHome();
            if (estatisticaGeralHome != null) {
                holder.binding.tvPorcentagem.setText(estatisticaGeralHome.getPosseBola() + "%");
                holder.binding.tvFinalizacao.setText(String.valueOf(estatisticaGeralHome.getFinalizacao()));
                holder.binding.tvFinalizacaoGol.setText(String.valueOf(estatisticaGeralHome.getFinalizacaoGol()));
                holder.binding.tvFalta.setText(String.valueOf(estatisticaGeralHome.getFalta()));
                holder.binding.tvImpedimentos.setText(String.valueOf(estatisticaGeralHome.getImpedimentos()));
            } else {
                // Caso as estatísticas sejam nulas, preencha com valores padrão
                holder.binding.tvPorcentagem.setText("-");
                holder.binding.tvFinalizacao.setText("-");
                holder.binding.tvFinalizacaoGol.setText("-");
                holder.binding.tvFalta.setText("-");
                holder.binding.tvImpedimentos.setText("-");
            }
        }else if(status.equals("fora")){
            // Estatísticas do time visitante
            EstatisticaGeral estatisticaGeralAway = partida.getEstatisticaGeralAway();
            if (estatisticaGeralAway != null) {
                holder.binding.tvPorcentagem.setText(estatisticaGeralAway.getPosseBola() + "%");
                holder.binding.tvFinalizacao.setText(String.valueOf(estatisticaGeralAway.getFinalizacao()));
                holder.binding.tvFinalizacaoGol.setText(String.valueOf(estatisticaGeralAway.getFinalizacaoGol()));
                holder.binding.tvFalta.setText(String.valueOf(estatisticaGeralAway.getFalta()));
                holder.binding.tvImpedimentos.setText(String.valueOf(estatisticaGeralAway.getImpedimentos()));
            } else {
                holder.binding.tvPorcentagem.setText("-");
                holder.binding.tvFinalizacao.setText("-");
                holder.binding.tvFinalizacaoGol.setText("-");
                holder.binding.tvFalta.setText("-");
                holder.binding.tvImpedimentos.setText("-");
            }
        }



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
                    textView.setTextSize(10);
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
                    textView.setTextSize(10);
                    textView.setTextColor(ContextCompat.getColor(context, R.color.black));
                    textView.setPadding(0, 0, 0, 8);
                    awayGoalsContainer.addView(textView);
                }
            }
        } else {
            goalsLayout.setVisibility(View.GONE); // Oculta o layout pai
        }


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private EstatisticaApostaBinding binding;


        public ViewHolder(@NonNull EstatisticaApostaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
