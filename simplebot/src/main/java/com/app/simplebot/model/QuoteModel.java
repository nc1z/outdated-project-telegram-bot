package com.app.simplebot.model;

public class QuoteModel {
    private String q;
    private String a;
    private String c;
    private String h;

    public QuoteModel() {}

    public QuoteModel(String q, String a, String c, String h) {
        this.q = q;
        this.a = a;
        this.c = c;
        this.h = h;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
}
