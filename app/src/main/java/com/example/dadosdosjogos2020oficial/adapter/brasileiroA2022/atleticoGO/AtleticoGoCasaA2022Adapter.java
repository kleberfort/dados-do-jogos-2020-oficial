package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoGO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AtleticoGoCasaA2022Adapter extends RecyclerView.Adapter<AtleticoGoCasaA2022Adapter.ViewHolder> {

    private List<Partida> atleticoGoCasa2022;

    public AtleticoGoCasaA2022Adapter(List<Partida> atleticoGoCasa2022) {
        this.atleticoGoCasa2022 = atleticoGoCasa2022;
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

        Partida listaPartidaAtleticoGoCasa = atleticoGoCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAtleticoGoCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAtleticoGoCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaAtleticoGoCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAtleticoGoCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAtleticoGoCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAtleticoGoCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAtleticoGoCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAtleticoGoCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAtleticoGoCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAtleticoGoCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAtleticoGoCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return atleticoGoCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}


