package com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.ListTimesCampeonatoPrincipalAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

public class TimesAlemaoA022a23Adapter extends RecyclerView.Adapter<TimesAlemaoA022a23Adapter.ViewHolder> {

    private List<ListaTimeCampeonatoPrincipal> listaTimes;

    public TimesAlemaoA022a23Adapter(List<ListaTimeCampeonatoPrincipal> listaTimes) {
        this.listaTimes = listaTimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListTimesCampeonatoPrincipalAdapterBinding binding  = ListTimesCampeonatoPrincipalAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        ListaTimeCampeonatoPrincipal lista = listaTimes.get(position);
        Glide.with(context).load(lista.getImage()).into(holder.binding.ivTime);
        holder.binding.tvNomeTime.setText(lista.getName());



    }

    @Override
    public int getItemCount() {
        return listaTimes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ListTimesCampeonatoPrincipalAdapterBinding binding;

        public ViewHolder(ListTimesCampeonatoPrincipalAdapterBinding binding) {
            super(binding.getRoot());
            this.binding  = binding;
        }
    }
}
