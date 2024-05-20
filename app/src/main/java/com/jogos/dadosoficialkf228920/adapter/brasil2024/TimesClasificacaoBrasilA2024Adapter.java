package com.jogos.dadosoficialkf228920.adapter.brasil2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.TimesAlemaoA022a23Adapter;
import com.jogos.dadosoficialkf228920.databinding.TelaClassificacaoOficialBinding;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficial;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;

import java.util.List;

public class TimesClasificacaoBrasilA2024Adapter extends RecyclerView.Adapter<TimesClasificacaoBrasilA2024Adapter.ViewHolder>{

    private List<ClassificacaoOficialNovoModelo> listaTimes;


    //aqui para iniciar ele temos que passar uma lista de  ClassificacaoOficialNovoModelo//
    //nao interessa se essa lista vai estar vazia ou nao, temos que mandar uma lista de ClassificacaoOficialNovoModelo
    //ok ?sim
    public TimesClasificacaoBrasilA2024Adapter(List<ClassificacaoOficialNovoModelo> listaTimes) {
        this.listaTimes = listaTimes;
    }


    @Override
    public TimesClasificacaoBrasilA2024Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TelaClassificacaoOficialBinding binding  = TelaClassificacaoOficialBinding.inflate(layoutInflater, parent, false);

        return new TimesClasificacaoBrasilA2024Adapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        ClassificacaoOficialNovoModelo classificacaoOficial = listaTimes.get(position);

        holder.binding.tvNomeTime.setText(listaTimes.get(position).getName());
        Glide.with(context).load(classificacaoOficial.getImage()).into(holder.binding.ivTime);


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
