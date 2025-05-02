package com.jogos.dadosoficialkf228920.adapter.partidas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.partidas.RoundPartida;

import java.util.List;
import java.util.Map;

public class PartidaAdapter extends RecyclerView.Adapter<PartidaAdapter.ViewHolder> {
    private List<RoundPartida> partidas;
    private Map<String, String> placares;
    private Context context;

    public PartidaAdapter(Context context, List<RoundPartida> partidas, Map<String, String> placares) {
        this.context = context;
        this.partidas = partidas;
        this.placares = placares;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_partidas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RoundPartida partida = partidas.get(position);

        // Dados dos times
        String mandante = partida.getMandante().getNomeTime();
        String visitante = partida.getVisitante().getNomeTime();
        String chavePartida = mandante + "_" + visitante;

        // Busca placar no HashMap
        String placar = placares.getOrDefault(chavePartida, "Aguardando");

        // Exibir os dados na ViewHolder
        holder.tvDate.setText(partida.getDataJogo());
        holder.tvHomeTeam.setText(mandante);
        holder.tvAwayTeam.setText(visitante);
        holder.tvScore.setText(placar);

        // Carregar imagens dos times usando Glide
        Glide.with(context).load(partida.getMandante().getImageTime()).into(holder.ivHomeTeamLogo);
        Glide.with(context).load(partida.getVisitante().getImageTime()).into(holder.ivAwayTeamLogo);

        // Oculta ou exibe o status da partida
        if (placar.equals("Aguardando")) {
            holder.tvMatchStatus.setVisibility(View.VISIBLE);
            holder.tvMatchStatus.setText("Aguardando");
        } else {
            holder.tvMatchStatus.setVisibility(View.GONE);
        }

        // Configuração do botão de sugestão (apenas exemplo)
        holder.btnSuggestion.setOnClickListener(v -> {
            // Implementação para sugestão de jogo
        });
    }

    @Override
    public int getItemCount() {
        return partidas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvMatchStatus, tvHomeTeam, tvAwayTeam, tvScore;
        ImageView ivHomeTeamLogo, ivAwayTeamLogo;
        Button btnSuggestion;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvMatchStatus = itemView.findViewById(R.id.tv_match_status);
            tvHomeTeam = itemView.findViewById(R.id.tv_home_team_name);
            tvAwayTeam = itemView.findViewById(R.id.tv_away_team_name);
            tvScore = itemView.findViewById(R.id.tv_score);
            ivHomeTeamLogo = itemView.findViewById(R.id.iv_home_team_logo);
            ivAwayTeamLogo = itemView.findViewById(R.id.iv_away_team_logo);
            btnSuggestion = itemView.findViewById(R.id.btn_suggestion);
        }
    }
}