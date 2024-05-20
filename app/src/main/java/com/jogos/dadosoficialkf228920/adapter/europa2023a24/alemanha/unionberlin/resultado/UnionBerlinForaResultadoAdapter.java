package com.jogos.dadosoficialkf228920.adapter.europa2023a24.alemanha.unionberlin.resultado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.databinding.LayoutResultadoPartidasBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class UnionBerlinForaResultadoAdapter extends RecyclerView.Adapter<UnionBerlinForaResultadoAdapter.ViewHolder> {

    private List<Partida> augsburgFora;

    public UnionBerlinForaResultadoAdapter(List<Partida> augsburgFora) {
        this.augsburgFora = augsburgFora;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutResultadoPartidasBinding binding = LayoutResultadoPartidasBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        Partida listaPartidaBayerLeverkusenFora = augsburgFora.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBayerLeverkusenFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBayerLeverkusenFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBayerLeverkusenFora.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBayerLeverkusenFora.getHomeTime().getNome());
        holder.binding.tvClassificacaoCasa.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerLeverkusenFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBayerLeverkusenFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerLeverkusenFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return augsburgFora.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private LayoutResultadoPartidasBinding binding;

        public ViewHolder(LayoutResultadoPartidasBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

