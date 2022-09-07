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

public class PalmeirasCasaA2022Adapter extends RecyclerView.Adapter<PalmeirasCasaA2022Adapter.ViewHolder> {

    private List<Partida> palmeirasCasa2022;

    public PalmeirasCasaA2022Adapter(List<Partida> palmeirasCasa2022) {
        this.palmeirasCasa2022 = palmeirasCasa2022;
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

        Partida listaPartidaPalmeirasCasa = palmeirasCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaPalmeirasCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaPalmeirasCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaPalmeirasCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaPalmeirasCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaPalmeirasCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaPalmeirasCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaPalmeirasCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaPalmeirasCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaPalmeirasCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaPalmeirasCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaPalmeirasCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return palmeirasCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
