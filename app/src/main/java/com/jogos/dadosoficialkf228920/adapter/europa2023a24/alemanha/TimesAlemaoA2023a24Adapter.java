package com.jogos.dadosoficialkf228920.adapter.europa2023a24.alemanha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.databinding.TelaClassificacaoOficialBinding;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficial;

import java.util.List;

public class TimesAlemaoA2023a24Adapter extends RecyclerView.Adapter<TimesAlemaoA2023a24Adapter.ViewHolder> {

    private List<ClassificacaoOficial> listaTimes;

    public TimesAlemaoA2023a24Adapter(List<ClassificacaoOficial> listaTimes) {
        this.listaTimes = listaTimes;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TelaClassificacaoOficialBinding binding  = TelaClassificacaoOficialBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        ClassificacaoOficial classificacaoOficial = listaTimes.get(position);

        holder.binding.tvNomeTime.setText(listaTimes.get(position).getNome());
        Glide.with(context).load(classificacaoOficial.getImagem()).into(holder.binding.ivTime);


        holder.binding.tvJogos.setText(String.valueOf(classificacaoOficial.getJogos()));

        holder.binding.tvGolsPro.setText(String.valueOf(classificacaoOficial.getGolsPro()) + ":");
        holder.binding.tvGolsContra.setText(String.valueOf(classificacaoOficial.getGolsContra()));
        holder.binding.tvSaldo.setText(String.valueOf(classificacaoOficial.getSaldoGols()));

        holder.binding.tvPontos.setText(String.valueOf(classificacaoOficial.getPontos()));

        holder.binding.tvVitoria.setText(String.valueOf(classificacaoOficial.getVitoria()));
        holder.binding.tvEmpate.setText(String.valueOf(classificacaoOficial.getEmpate()));
        holder.binding.tvDerrota.setText(String.valueOf(classificacaoOficial.getDerrota()));

        holder.binding.tvOrdemClassificaO.setText(String.valueOf(position + 1));



    }

    @Override
    public int getItemCount() {
        return listaTimes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TelaClassificacaoOficialBinding binding;

        public ViewHolder(TelaClassificacaoOficialBinding binding) {
            super(binding.getRoot());
            this.binding  = binding;
        }
    }
}
