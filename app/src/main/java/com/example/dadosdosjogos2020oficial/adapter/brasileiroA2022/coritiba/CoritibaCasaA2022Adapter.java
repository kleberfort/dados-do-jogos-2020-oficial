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

public class CoritibaCasaA2022Adapter extends RecyclerView.Adapter<CoritibaCasaA2022Adapter.ViewHolder> {

    private List<Partida> coritibaCasa2022;

    public CoritibaCasaA2022Adapter(List<Partida> coritibaCasa2022) {
        this.coritibaCasa2022 = coritibaCasa2022;
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

        Partida listaPartidaCoritibaCasa = coritibaCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCoritibaCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCoritibaCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaCoritibaCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCoritibaCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCoritibaCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCoritibaCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCoritibaCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCoritibaCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCoritibaCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCoritibaCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCoritibaCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);


        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return coritibaCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
