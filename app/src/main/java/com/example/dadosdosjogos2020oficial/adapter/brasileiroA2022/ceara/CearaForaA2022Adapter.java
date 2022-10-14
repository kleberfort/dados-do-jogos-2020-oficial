package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.ceara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class CearaForaA2022Adapter extends RecyclerView.Adapter<CearaForaA2022Adapter.ViewHolder> {

    List<Partida> listCearaFora;

    public CearaForaA2022Adapter(List<Partida> listCearaFora) {
        this.listCearaFora = listCearaFora;
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

        Partida listaPartidaCearaFora = listCearaFora.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCearaFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCearaFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaCearaFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCearaFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCearaFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCearaFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCearaFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCearaFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCearaFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCearaFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCearaFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return listCearaFora.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
