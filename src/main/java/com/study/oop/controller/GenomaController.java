package com.study.oop.controller;

import com.study.oop.entity.Genoma;

public class GenomaController {
    public static void main(String[] args) {
        Genoma genoma = new Genoma("src/sequence.txt");
        genoma.getGeneMap().keySet();
    }
}
