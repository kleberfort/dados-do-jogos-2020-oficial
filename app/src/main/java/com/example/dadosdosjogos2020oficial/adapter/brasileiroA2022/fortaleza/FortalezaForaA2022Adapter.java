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

public class FortalezaForaA2022Adapter extends RecyclerView.Adapter<FortalezaForaA2022Adapter.ViewHolder> {

    private List<Partida> fortalezaFora2022;

    public FortalezaForaA2022Adapter(List<Partida> fortalezaFora022) {
        this.fortalezaFora2022 = fortalezaFora022;
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

        Partida listaPartidaFortalezaFora = fortalezaFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaFortalezaFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaFortalezaFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaFortalezaFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaFortalezaFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaFortalezaFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaFortalezaFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaFortalezaFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaFortalezaFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaFortalezaFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaFortalezaFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaFortalezaFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return fortalezaFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
