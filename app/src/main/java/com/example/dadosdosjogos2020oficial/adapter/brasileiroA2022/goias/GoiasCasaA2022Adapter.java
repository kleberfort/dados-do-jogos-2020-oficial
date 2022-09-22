package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.goias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class GoiasCasaA2022Adapter extends RecyclerView.Adapter<GoiasCasaA2022Adapter.ViewHolder> {

    private List<Partida> goiasCasa2022;

    public GoiasCasaA2022Adapter(List<Partida> goiasCasa2022) {
        this.goiasCasa2022 = goiasCasa2022;
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

        Partida listaPartidaGoiasCasa = goiasCasa2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaGoiasCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaGoiasCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaGoiasCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaGoiasCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaGoiasCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaGoiasCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaGoiasCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaGoiasCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaGoiasCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaGoiasCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaGoiasCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return goiasCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
