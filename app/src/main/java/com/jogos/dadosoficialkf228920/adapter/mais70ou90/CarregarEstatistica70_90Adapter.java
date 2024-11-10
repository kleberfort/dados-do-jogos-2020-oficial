package com.jogos.dadosoficialkf228920.adapter.mais70ou90;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jogos.dadosoficialkf228920.R;

import java.util.List;

public class CarregarEstatistica70_90Adapter extends RecyclerView.Adapter<CarregarEstatistica70_90Adapter.ViewHolder> {
    private List<String> estatisticas;

    public CarregarEstatistica70_90Adapter(List<String> estatisticas) {
        this.estatisticas = estatisticas;
    }

    public void setEstatisticas(List<String> estatisticas) {
        this.estatisticas = estatisticas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estatistica, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewEstatistica.setText(estatisticas.get(position));
    }

    @Override
    public int getItemCount() {
        return estatisticas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewEstatistica;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewEstatistica = itemView.findViewById(R.id.text_view_estatistica);
        }
    }
}

