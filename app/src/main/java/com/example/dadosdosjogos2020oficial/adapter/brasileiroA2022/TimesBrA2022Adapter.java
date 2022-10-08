package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.ListTimesBrA2022AdapterBinding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

public class TimesBrA2022Adapter extends RecyclerView.Adapter<TimesBrA2022Adapter.ViewHolder> {

    private List<ListaTimeCampeonatoPrincipal> listaTimes;

    public TimesBrA2022Adapter(List<ListaTimeCampeonatoPrincipal> listaTimes) {
        this.listaTimes = listaTimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListTimesBrA2022AdapterBinding binding = ListTimesBrA2022AdapterBinding.inflate(layoutInflater, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        ListaTimeCampeonatoPrincipal listaTimeCampeonatoPrincipal = listaTimes.get(position);

        Glide.with(context).load(listaTimeCampeonatoPrincipal.getImage()).into(holder.binding.ivTime);
        holder.binding.tvDescricaoCampeonato.setText(listaTimeCampeonatoPrincipal.getName());



    }

    @Override
    public int getItemCount() {
        return listaTimes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ListTimesBrA2022AdapterBinding binding;

        public ViewHolder(ListTimesBrA2022AdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
