package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.flamengo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class FlamengoForaA2022Adapter extends RecyclerView.Adapter<FlamengoForaA2022Adapter.ViewHolder> {
    private List<Partida> flamgengoFora2022;

    public FlamengoForaA2022Adapter(List<Partida> flamgengoFora2022) {
        this.flamgengoFora2022 = flamgengoFora2022;
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

        Partida listaPartidaFlamengoFora = flamgengoFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaFlamengoFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaFlamengoFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaFlamengoFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaFlamengoFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaFlamengoFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaFlamengoFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaFlamengoFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaFlamengoFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaFlamengoFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaFlamengoFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaFlamengoFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return flamgengoFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}