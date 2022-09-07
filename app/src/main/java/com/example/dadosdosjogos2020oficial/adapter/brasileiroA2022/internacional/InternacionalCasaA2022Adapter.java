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

public class InternacionalCasaA2022Adapter extends RecyclerView.Adapter<InternacionalCasaA2022Adapter.ViewHolder> {

    private List<Partida> internacionalCasa2022;

    public InternacionalCasaA2022Adapter(List<Partida> internacionalCasa2022) {
        this.internacionalCasa2022 = internacionalCasa2022;
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

        Partida listaPartidaInternacionalCasa = internacionalCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaInternacionalCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaInternacionalCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaInternacionalCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaInternacionalCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaInternacionalCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaInternacionalCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaInternacionalCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaInternacionalCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaInternacionalCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaInternacionalCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaInternacionalCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return internacionalCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
