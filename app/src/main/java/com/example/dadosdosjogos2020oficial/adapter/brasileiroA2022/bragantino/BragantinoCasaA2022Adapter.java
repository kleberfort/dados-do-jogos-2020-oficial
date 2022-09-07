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

public class BragantinoCasaA2022Adapter extends RecyclerView.Adapter<BragantinoCasaA2022Adapter.ViewHolder> {

    private List<Partida> bragantinoCasa2022;

    public BragantinoCasaA2022Adapter(List<Partida> bragantinoCasa2022) {
        this.bragantinoCasa2022 = bragantinoCasa2022;
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

        Partida listaPartidaBragantinoCasa = bragantinoCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaBragantinoCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBragantinoCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaBragantinoCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaBragantinoCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaBragantinoCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBragantinoCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBragantinoCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBragantinoCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBragantinoCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBragantinoCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaBragantinoCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return bragantinoCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
