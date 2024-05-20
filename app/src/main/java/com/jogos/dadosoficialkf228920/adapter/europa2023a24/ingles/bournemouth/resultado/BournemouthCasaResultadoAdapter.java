package com.jogos.dadosoficialkf228920.adapter.europa2023a24.ingles.bournemouth.resultado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.databinding.LayoutResultadoPartidasBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class BournemouthCasaResultadoAdapter extends RecyclerView.Adapter<BournemouthCasaResultadoAdapter.ViewHolder> {

    private List<Partida> augsburgCasa;

    public BournemouthCasaResultadoAdapter(List<Partida> augsburgCasa) {
        this.augsburgCasa = augsburgCasa;
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

        Partida listaPartidaBayerLeverkusenCasa = augsburgCasa.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBayerLeverkusenCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBayerLeverkusenCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBayerLeverkusenCasa.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBayerLeverkusenCasa.getHomeTime().getNome());
        holder.binding.tvClassificacaoCasa.setText(String.valueOf(listaPartidaBayerLeverkusenCasa.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBayerLeverkusenCasa.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerLeverkusenCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBayerLeverkusenCasa.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBayerLeverkusenCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBayerLeverkusenCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerLeverkusenCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return augsburgCasa.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private LayoutResultadoPartidasBinding binding;

        public ViewHolder(LayoutResultadoPartidasBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

