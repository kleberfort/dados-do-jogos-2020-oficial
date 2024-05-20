package com.jogos.dadosoficialkf228920.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

public class FormatarCoresTextoFora {

    public static SpannableStringBuilder formatText(String nomeTime, String totalJogos, String totalGolsMcd, String totalGolsMcdPct) {
        SpannableStringBuilder builder = new SpannableStringBuilder();



        // Adiciona cor à variável nomeTime
        SpannableString nomeTimeSpannable = new SpannableString(nomeTime);
        nomeTimeSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, nomeTime.length(), 0);
        builder.append(nomeTimeSpannable);
        builder.append(" jogando ");

        String fora = "FORA";
        // Adiciona cor à variável nomeFora
        SpannableString foraSpannable = new SpannableString(fora);
        foraSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, fora.length(), 0);
        builder.append(foraSpannable);

        builder.append(", do TOTAL de ");

        // Adiciona cor à variável totalJogos
        String totalJogosTexto = String.valueOf(totalJogos);
        SpannableString totalJogosSpannable = new SpannableString(totalJogosTexto);
        totalJogosSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, totalJogosTexto.length(), 0);
        builder.append(totalJogosSpannable);

        builder.append(" jogos realizados. Em ");

        // Adiciona cor à variável totalGolsMcd
        String totalGolsMcdTexto = String.valueOf(totalGolsMcd);
        SpannableString totalGolsMcdSpannable = new SpannableString(totalGolsMcdTexto);
        totalGolsMcdSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, totalGolsMcdTexto.length(), 0);
        builder.append(totalGolsMcdSpannable);

        builder.append(" partidas saíram [GOL ACIMA 0.5], que equivale ");

        // Adiciona cor à variável totalGolsMcdPct
        String totalGolsMcdPctTexto = String.valueOf(totalGolsMcdPct + "%");
        SpannableString totalGolsMcdPctSpannable = new SpannableString(totalGolsMcdPctTexto);
        totalGolsMcdPctSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, totalGolsMcdPctTexto.length(), 0);
        builder.append(totalGolsMcdPctSpannable);

        builder.append(" do TOTAL.\n\n OBSERVAÇÃO: Dados compreende [Times da Casa] e [Time Fora].");

        return builder;

    }

}
