package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoPR;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AtleticoPrCasaA2022Adapter extends RecyclerView.Adapter<AtleticoPrCasaA2022Adapter.ViewHolder> {
    private List<Partida> atleticoPrCasa2022;

    public AtleticoPrCasaA2022Adapter(List<Partida> atleticoMgCasa2022) {
        this.atleticoPrCasa2022 = atleticoPrCasa2022;
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

        Partida listaPartidaAtleticoMgCasa = atleticoPrCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAtleticoMgCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAtleticoMgCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaAtleticoMgCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAtleticoMgCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAtleticoMgCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAtleticoMgCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAtleticoMgCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAtleticoMgCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAtleticoMgCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAtleticoMgCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAtleticoMgCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return atleticoPrCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}