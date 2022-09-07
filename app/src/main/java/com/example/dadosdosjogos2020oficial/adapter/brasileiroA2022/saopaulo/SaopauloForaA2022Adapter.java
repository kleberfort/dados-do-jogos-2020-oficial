package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.saopaulo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.santos.SantosForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class SaopauloForaA2022Adapter extends RecyclerView.Adapter<SaopauloForaA2022Adapter.ViewHolder> {

    private List<Partida> saopauloFora2022;

    public SaopauloForaA2022Adapter(List<Partida> saopauloFora2022) {
        this.saopauloFora2022 = saopauloFora2022;
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

        Partida listaPartidaSaopauloFora = saopauloFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaSaopauloFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaSaopauloFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaSaopauloFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaSaopauloFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaSaopauloFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaSaopauloFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaSaopauloFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaSaopauloFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaSaopauloFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaSaopauloFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaSaopauloFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return saopauloFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
