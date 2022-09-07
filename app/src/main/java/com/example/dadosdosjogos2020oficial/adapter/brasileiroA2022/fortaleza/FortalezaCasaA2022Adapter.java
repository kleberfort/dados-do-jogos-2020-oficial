package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fortaleza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class FortalezaCasaA2022Adapter extends RecyclerView.Adapter<FortalezaCasaA2022Adapter.ViewHolder> {

    private List<Partida> fortalezaCasa2022;

    public FortalezaCasaA2022Adapter(List<Partida> fortalezaCasa2022) {
        this.fortalezaCasa2022 = fortalezaCasa2022;
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

        Partida listaPartidaFortalezaCasa = fortalezaCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaFortalezaCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaFortalezaCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaFortalezaCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaFortalezaCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaFortalezaCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaFortalezaCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaFortalezaCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaFortalezaCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaFortalezaCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaFortalezaCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaFortalezaCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return fortalezaCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
