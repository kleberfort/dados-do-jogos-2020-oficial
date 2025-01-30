package com.jogos.dadosoficialkf228920.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class EstatisticaGeral implements Parcelable {


    @SerializedName("posseBola")
    private Integer posseBola;
    @SerializedName("finalizacoes")
    private Integer finalizacao;
    @SerializedName("finalizacoesGol")
    private Integer finalizacaoGol;
    @SerializedName("faltas")
    private Integer falta;
    @SerializedName("passes")
    private Integer passes;
    @SerializedName("desarmes")
    private Integer desarmes;
    @SerializedName("impedimentos")
    private Integer impedimentos;
    @SerializedName("laterais")
    private Integer laterais;
    @SerializedName("tiroDeMeta")
    private Integer tiroMeta;

    // Constructors
    public EstatisticaGeral() {}

    public EstatisticaGeral(Integer posseBola, Integer finalizacao, Integer finalizacaoGol, Integer falta,
                            Integer passes, Integer desarmes, Integer impedimentos, Integer laterais, Integer tiroMeta) {
        this.posseBola = posseBola;
        this.finalizacao = finalizacao;
        this.finalizacaoGol = finalizacaoGol;
        this.falta = falta;
        this.passes = passes;
        this.desarmes = desarmes;
        this.impedimentos = impedimentos;
        this.laterais = laterais;
        this.tiroMeta = tiroMeta;
    }

    // Getters and Setters
    public Integer getPosseBola() {
        return posseBola;
    }

    public void setPosseBola(Integer posseBola) {
        this.posseBola = posseBola;
    }

    public Integer getFinalizacao() {
        return finalizacao;
    }

    public void setFinalizacao(Integer finalizacao) {
        this.finalizacao = finalizacao;
    }

    public Integer getFinalizacaoGol() {
        return finalizacaoGol;
    }

    public void setFinalizacaoGol(Integer finalizacaoGol) {
        this.finalizacaoGol = finalizacaoGol;
    }

    public Integer getFalta() {
        return falta;
    }

    public void setFalta(Integer falta) {
        this.falta = falta;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public Integer getDesarmes() {
        return desarmes;
    }

    public void setDesarmes(Integer desarmes) {
        this.desarmes = desarmes;
    }

    public Integer getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(Integer impedimentos) {
        this.impedimentos = impedimentos;
    }

    public Integer getLaterais() {
        return laterais;
    }

    public void setLaterais(Integer laterais) {
        this.laterais = laterais;
    }

    public Integer getTiroMeta() {
        return tiroMeta;
    }

    public void setTiroMeta(Integer tiroMeta) {
        this.tiroMeta = tiroMeta;
    }

    // toString Method
    @Override
    public String toString() {
        return "EstatisticaGeral{" +
                "posseBola=" + posseBola +
                ", finalizacao=" + finalizacao +
                ", finalizacaoGol=" + finalizacaoGol +
                ", falta=" + falta +
                ", passes=" + passes +
                ", desarmes=" + desarmes +
                ", impedimentos=" + impedimentos +
                ", laterais=" + laterais +
                ", tiroMeta=" + tiroMeta +
                '}';
    }

    // Parcelable Implementation
    protected EstatisticaGeral(Parcel in) {
        if (in.readByte() == 0) {
            posseBola = null;
        } else {
            posseBola = in.readInt();
        }
        if (in.readByte() == 0) {
            finalizacao = null;
        } else {
            finalizacao = in.readInt();
        }
        if (in.readByte() == 0) {
            finalizacaoGol = null;
        } else {
            finalizacaoGol = in.readInt();
        }
        if (in.readByte() == 0) {
            falta = null;
        } else {
            falta = in.readInt();
        }
        if (in.readByte() == 0) {
            passes = null;
        } else {
            passes = in.readInt();
        }
        if (in.readByte() == 0) {
            desarmes = null;
        } else {
            desarmes = in.readInt();
        }
        if (in.readByte() == 0) {
            impedimentos = null;
        } else {
            impedimentos = in.readInt();
        }
        if (in.readByte() == 0) {
            laterais = null;
        } else {
            laterais = in.readInt();
        }
        if (in.readByte() == 0) {
            tiroMeta = null;
        } else {
            tiroMeta = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (posseBola == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(posseBola);
        }
        if (finalizacao == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(finalizacao);
        }
        if (finalizacaoGol == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(finalizacaoGol);
        }
        if (falta == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(falta);
        }
        if (passes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(passes);
        }
        if (desarmes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(desarmes);
        }
        if (impedimentos == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(impedimentos);
        }
        if (laterais == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(laterais);
        }
        if (tiroMeta == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(tiroMeta);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EstatisticaGeral> CREATOR = new Creator<EstatisticaGeral>() {
        @Override
        public EstatisticaGeral createFromParcel(Parcel in) {
            return new EstatisticaGeral(in);
        }

        @Override
        public EstatisticaGeral[] newArray(int size) {
            return new EstatisticaGeral[size];
        }
    };
}

