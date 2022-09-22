package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.botafogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class BotafogoForaA2022Adapter extends RecyclerView.Adapter<BotafogoForaA2022Adapter.ViewHolder> {
    private List<Partida> botafogoFora2022;

    public BotafogoForaA2022Adapter(List<Partida> botafogoFora2022) {
        botafogoFora2022 = botafogoFora2022;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DadosPartidasAdapterBinding binding = DadosPartidasAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        Partida listaPartidaBotafogoFora = botafogoFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaBotafogoFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBotafogoFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBotafogoFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaBotafogoFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaBotafogoFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBotafogoFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBotafogoFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBotafogoFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBotafogoFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBotafogoFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaBotafogoFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return botafogoFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
