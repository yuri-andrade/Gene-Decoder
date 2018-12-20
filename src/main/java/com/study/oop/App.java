package com.study.oop;

public class App {
    public static void main(String[] args) {
        Genoma genoma = new Genoma("src/sequence.txt");
        genoma.getGeneMap().keySet();
    }
}
