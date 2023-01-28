package com.desafiocartas.Desafio.Cartas.model;

public class Cartas {
    private String codigo;
    private String imagem;
    private Imagens imagens;
    private String valor;
    private String tipo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Imagens getImagens() {
        return imagens;
    }

    public void setImagens(Imagens imagens) {
        this.imagens = imagens;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static class Imagens {
        private String svg;
        private String png;

        public String getSvg() {
            return svg;
        }

        public void setSvg(String svg) {
            this.svg = svg;
        }

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }
    }

}


