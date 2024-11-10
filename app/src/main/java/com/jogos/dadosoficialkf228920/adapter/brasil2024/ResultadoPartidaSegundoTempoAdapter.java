package com.jogos.dadosoficialkf228920.adapter.brasil2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.databinding.LayoutResultadoPartidasBinding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.List;

public class ResultadoPartidaSegundoTempoAdapter extends RecyclerView.Adapter<ResultadoPartidaSegundoTempoAdapter.ViewHolder> {

    private List<PartidaNovoModelo> lista;

    public ResultadoPartidaSegundoTempoAdapter(List<PartidaNovoModelo> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ResultadoPartidaSegundoTempoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutResultadoPartidasBinding binding = LayoutResultadoPartidasBinding.inflate(layoutInflater, parent, false);

        return new ResultadoPartidaSegundoTempoAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoPartidaSegundoTempoAdapter.ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();
        PartidaNovoModelo result = lista.get(position);



        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(result.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(result.getRound()));
        holder.binding.tvDataJogo.setText(result.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(result.getHomeTime().getNome());
        holder.binding.tvClassificacaoCasa.setText(String.valueOf(result.getHomeTime().getClassificacao()));
        Glide.with(context).load(result.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(result.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(result.getAwayTime().getClassificacao()));
        Glide.with(context).load(result.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);


        // RESULTADO PRIMEIRO TEMPO
        holder.binding.tvPlacarCasa.setText(String.valueOf(result.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvPlacarFora.setText(String.valueOf(result.getAwayEstatisticaJogo().getGolsSegundoTempo()));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private LayoutResultadoPartidasBinding binding;

        public ViewHolder(LayoutResultadoPartidasBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
