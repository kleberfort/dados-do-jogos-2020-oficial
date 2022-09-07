package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.bragantino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class BragantinoForaA2022Adapter extends RecyclerView.Adapter<BragantinoForaA2022Adapter.ViewHolder> {

    private List<Partida> bragantinoFora2022;

    public BragantinoForaA2022Adapter(List<Partida> bragantinoFora2022) {
        this.bragantinoFora2022 = bragantinoFora2022;
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

        Partida listaPartidaBragantinoFora = bragantinoFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaBragantinoFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBragantinoFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaBragantinoFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaBragantinoFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaBragantinoFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBragantinoFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBragantinoFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBragantinoFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBragantinoFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBragantinoFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaBragantinoFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return bragantinoFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}