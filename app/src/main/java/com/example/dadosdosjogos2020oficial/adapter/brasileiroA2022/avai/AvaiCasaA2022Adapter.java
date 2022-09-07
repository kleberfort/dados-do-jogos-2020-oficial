package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.avai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AvaiCasaA2022Adapter extends RecyclerView.Adapter<AvaiCasaA2022Adapter.ViewHolder> {

    private List<Partida> avaiCasa2022;

    public AvaiCasaA2022Adapter(List<Partida> avaiCasa2022) {
        this.avaiCasa2022 = avaiCasa2022;
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

        Partida listaPartidaAvaiCasa = avaiCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAvaiCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAvaiCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaAvaiCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAvaiCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAvaiCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAvaiCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAvaiCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAvaiCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAvaiCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAvaiCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAvaiCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return avaiCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
