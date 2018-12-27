package com.study.oop.controller;

import com.study.oop.entity.Genoma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.Objects;

public class GenomaController {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Genoma.class.getName());
        try {
            Genoma genoma = new Genoma("src/sequence.txt");
            Objects.requireNonNull(genoma).getGeneMap().keySet().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
