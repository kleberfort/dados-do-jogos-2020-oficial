package com.jogos.dadosoficialkf228920.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

public class FormatarCoresTextoCartoesMcdCasa {

    public static SpannableStringBuilder formatText(String nomeTime, String totalJogos, String totalGolsMcd, String totalGolsMcdPct) {
        SpannableStringBuilder builder = new SpannableStringBuilder();



        // Adiciona cor à variável nomeTime
        SpannableString nomeTimeSpannable = new SpannableString(nomeTime);
        nomeTimeSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, nomeTime.length(), 0);
        builder.append(nomeTimeSpannable);
        builder.append(" jogando em ");

        String casa = "CASA";
        // Adiciona cor à variável nomeCasa
        SpannableString casaSpannable = new SpannableString(casa);
        casaSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, casa.length(), 0);
        builder.append(casaSpannable);

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
        totalGolsMcdSpannable.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, totalGolsMcdTexto.length(), 0);
        builder.append(totalGolsMcdSpannable);

        String marcou = " PARTIDAS MARCOU";
        SpannableString marcouSpannable = new SpannableString(marcou);
        marcouSpannable.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, marcou.length(), 0);
        builder.append(marcouSpannable);

        builder.append(" [GOL ACIMA 0.5], que equivale ");

        // Adiciona cor à variável totalGolsMcdPct
        String totalGolsMcdPctTexto = String.valueOf(totalGolsMcdPct + "%");
        SpannableString totalGolsMcdPctSpannable = new SpannableString(totalGolsMcdPctTexto);
        totalGolsMcdPctSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, totalGolsMcdPctTexto.length(), 0);
        builder.append(totalGolsMcdPctSpannable);

        builder.append(" do TOTAL.\n\n OBSERVAÇÃO: Dados compreende apenas o [TIME DA CASA].");

        return builder;

    }


}
