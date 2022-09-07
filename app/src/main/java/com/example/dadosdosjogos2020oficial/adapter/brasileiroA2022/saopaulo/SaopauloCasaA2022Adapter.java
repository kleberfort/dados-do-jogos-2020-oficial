package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.saopaulo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class SaopauloCasaA2022Adapter extends RecyclerView.Adapter<SaopauloCasaA2022Adapter.ViewHolder> {

    private List<Partida> saopauloCasa2022;

    public SaopauloCasaA2022Adapter(List<Partida> saopauloCasa2022) {
        this.saopauloCasa2022 = saopauloCasa2022;
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

        Partida listaPartidaSaopauloCasa = saopauloCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaSaopauloCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaSaopauloCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaSaopauloCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaSaopauloCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaSaopauloCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaSaopauloCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaSaopauloCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaSaopauloCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaSaopauloCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaSaopauloCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaSaopauloCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return saopauloCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
