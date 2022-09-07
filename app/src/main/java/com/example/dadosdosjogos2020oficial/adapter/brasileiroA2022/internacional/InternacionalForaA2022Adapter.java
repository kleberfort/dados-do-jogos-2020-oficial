package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.internacional;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class InternacionalForaA2022Adapter extends RecyclerView.Adapter<InternacionalForaA2022Adapter.ViewHolder> {

    private List<Partida> internacionalFora2022;

    public InternacionalForaA2022Adapter(List<Partida> internacionalFora2022) {
        this.internacionalFora2022 = internacionalFora2022;
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

        Partida listaPartidaInternacionalFora = internacionalFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaInternacionalFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaInternacionalFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaInternacionalFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaInternacionalFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaInternacionalFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaInternacionalFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaInternacionalFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaInternacionalFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaInternacionalFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaInternacionalFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaInternacionalFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return internacionalFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}