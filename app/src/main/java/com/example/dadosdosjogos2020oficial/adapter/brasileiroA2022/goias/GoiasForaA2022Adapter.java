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

public class GoiasForaA2022Adapter extends RecyclerView.Adapter<GoiasForaA2022Adapter.ViewHolder> {

    private List<Partida> goiasFora2022;

    public GoiasForaA2022Adapter(List<Partida> goiasFora2022) {
        this.goiasFora2022 = goiasFora2022;
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

        Partida listaPartidaGoiasFora = goiasFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaGoiasFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaGoiasFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaGoiasFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaGoiasFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaGoiasFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaGoiasFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaGoiasFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaGoiasFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaGoiasFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaGoiasFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaGoiasFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return goiasFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
