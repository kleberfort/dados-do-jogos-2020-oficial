package com.jogos.dadosoficialkf2289.adapter.espanhaA2022a23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf2289.databinding.ListTimesCampeonatoPrincipalAdapterBinding;
import com.jogos.dadosoficialkf2289.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

public class TimesEspanholA2022a23Adapter extends RecyclerView.Adapter<TimesEspanholA2022a23Adapter.ViewHolder> {

    private List<ListaTimeCampeonatoPrincipal> listaTimes;

    public TimesEspanholA2022a23Adapter(List<ListaTimeCampeonatoPrincipal> listaTimes) {
        this.listaTimes = listaTimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListTimesCampeonatoPrincipalAdapterBinding binding = ListTimesCampeonatoPrincipalAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        ListaTimeCampeonatoPrincipal listaTimeCampeonatoPrincipal = listaTimes.get(position);

        Glide.with(context).load(listaTimeCampeonatoPrincipal.getImage()).into(holder.binding.ivTime);
        holder.binding.tvNomeTime.setText(listaTimeCampeonatoPrincipal.getName());

    }


    @Override
    public int getItemCount() {
        return listaTimes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ListTimesCampeonatoPrincipalAdapterBinding binding;

        public ViewHolder(ListTimesCampeonatoPrincipalAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
