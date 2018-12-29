package com.study.oop.controller;

import com.study.oop.entity.Genoma;
import java.io.FileNotFoundException;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GenomaController {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Genoma.class.getName());
        try {
            Genoma genoma = new Genoma("src/sequence.txt");
            Objects.requireNonNull(genoma).getGeneMap().keySet().forEach(logger::info);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
