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

public class AvaiForaA2022Adapter extends RecyclerView.Adapter<AvaiForaA2022Adapter.ViewHolder> {
    private List<Partida> avaiFora2022;

    public AvaiForaA2022Adapter(List<Partida> avaiFora2022) {
        this.avaiFora2022 = avaiFora2022;
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

        Partida listaPartidaAvaiFora = avaiFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAvaiFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAvaiFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaAvaiFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAvaiFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAvaiFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAvaiFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAvaiFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAvaiFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAvaiFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAvaiFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAvaiFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return avaiFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
