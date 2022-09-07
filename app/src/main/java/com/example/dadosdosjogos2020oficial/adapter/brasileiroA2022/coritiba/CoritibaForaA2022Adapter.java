package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.coritiba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class CoritibaForaA2022Adapter extends RecyclerView.Adapter<CoritibaForaA2022Adapter.ViewHolder> {
    private List<Partida> coritibaFora2022;

    public CoritibaForaA2022Adapter(List<Partida> coritibaFora2022) {
        this.coritibaFora2022 = coritibaFora2022;
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

        Partida listaPartidaCoritibaFora = coritibaFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCoritibaFora.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCoritibaFora.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaCoritibaFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCoritibaFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCoritibaFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCoritibaFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCoritibaFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCoritibaFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCoritibaFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCoritibaFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCoritibaFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return coritibaFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}