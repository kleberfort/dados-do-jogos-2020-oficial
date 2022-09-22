package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.palmeiras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class PalmeirasForaA2022Adapter extends RecyclerView.Adapter<PalmeirasForaA2022Adapter.ViewHolder> {

    private List<Partida> palmeirasFora2022;

    public PalmeirasForaA2022Adapter(List<Partida> palmeirasFora2022) {
        this.palmeirasFora2022 = palmeirasFora2022;
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

        Partida listaPartidaPalmeirasFora = palmeirasFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaPalmeirasFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaPalmeirasFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaPalmeirasFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaPalmeirasFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaPalmeirasFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaPalmeirasFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaPalmeirasFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaPalmeirasFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaPalmeirasFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaPalmeirasFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaPalmeirasFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return palmeirasFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
