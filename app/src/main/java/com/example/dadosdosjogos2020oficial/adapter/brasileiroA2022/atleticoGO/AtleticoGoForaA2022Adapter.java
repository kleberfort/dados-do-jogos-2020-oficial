package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoGO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AtleticoGoForaA2022Adapter extends RecyclerView.Adapter<AtleticoGoForaA2022Adapter.ViewHolder> {

    private List<Partida> atleticoGoFora2022;

    public AtleticoGoForaA2022Adapter(List<Partida> atleticoGoFora2022) {
        this.atleticoGoFora2022 = atleticoGoFora2022;
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

        Partida listaPartidaAtleticoGoFora = atleticoGoFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAtleticoGoFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAtleticoGoFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaAtleticoGoFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAtleticoGoFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAtleticoGoFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAtleticoGoFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAtleticoGoFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAtleticoGoFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAtleticoGoFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAtleticoGoFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAtleticoGoFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return atleticoGoFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
