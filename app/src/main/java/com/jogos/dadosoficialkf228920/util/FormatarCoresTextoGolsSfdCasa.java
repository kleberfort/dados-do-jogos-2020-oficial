package com.jogos.dadosoficialkf228920.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

public class FormatarCoresTextoGolsSfdCasa {

    public static SpannableStringBuilder formatText(String nomeTime, String totalJogos, String totalGolsMcd, String totalGolsMcdPct) {
        SpannableStringBuilder builder = new SpannableStringBuilder();



        // Adiciona cor à variável nomeTime
        SpannableString nomeTimeSpannable = new SpannableString(nomeTime);
        nomeTimeSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, nomeTime.length(), 0);
        builder.append(nomeTimeSpannable);
        builder.append(" jogando em ");

        String casa = "CASA";
        // Adiciona cor à variável nomeCasa
        SpannableString CasaSpannable = new SpannableString(casa);
        CasaSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, casa.length(), 0);
        builder.append(CasaSpannable);
        builder.append(", do TOTAL de ");

        // Adiciona cor à variável totalJogos
        String totalJogosTexto = String.valueOf(totalJogos);
        SpannableString totalJogosSpannable = new SpannableString(totalJogosTexto);
        totalJogosSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, totalJogosTexto.length(), 0);
        builder.append(totalJogosSpannable);
        builder.append(" jogos realizados. Em ");

        // Adiciona cor à variável totalGolsSfd
        String totalGolsMcdTexto = String.valueOf(totalGolsMcd);
        SpannableString totalGolsMcdSpannable = new SpannableString(totalGolsMcdTexto);
        totalGolsMcdSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, totalGolsMcdTexto.length(), 0);
        builder.append(totalGolsMcdSpannable);

        String sofreu = " PARTIDAS SOFREU";
        SpannableString sofreuSpannable = new SpannableString(sofreu);
        sofreuSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, sofreu.length(), 0);
        builder.append(sofreuSpannable);

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
