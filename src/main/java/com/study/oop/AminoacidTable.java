package com.study.oop;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Singleton que implementa um {@link AminoacidTable}
 * populado com o mapeamento de codon para aminoácido.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 07:10:00
 */
public class AminoacidTable {
    private static AminoacidTable instance;
    private Map<String, String> aminoacidTableMap;

    private AminoacidTable() {
        aminoacidTableMap = new HashMap<>();
        populateAminoacidTable();
    }

    static synchronized AminoacidTable getInstance() {
        if (instance == null) {
            instance = new AminoacidTable();
        }
        return instance;
    }

    String getAminoacid(String codon) {
        return aminoacidTableMap.get(codon);
    }

    private void populateAminoacidTable() {
        aminoacidTableMap.put("TTT", "F");// Phe
        aminoacidTableMap.put("TTC", "F");



        aminoacidTableMap.put("TTA", "L");// Leu
        aminoacidTableMap.put("TTG", "L");
        aminoacidTableMap.put("CTT", "L");
        aminoacidTableMap.put("CTC", "L");
        aminoacidTableMap.put("CTA", "L");
        aminoacidTableMap.put("CTG", "L");

        aminoacidTableMap.put("ATT", "I"); // Ile
        aminoacidTableMap.put("ATC", "I");
        aminoacidTableMap.put("ATA", "I");

        aminoacidTableMap.put("ATG", "Met");// Met

        aminoacidTableMap.put("GTT", "V");// Val
        aminoacidTableMap.put("GTC", "V");
        aminoacidTableMap.put("GTA", "V");
        aminoacidTableMap.put("GTG", "V");

        aminoacidTableMap.put("TCT", "S"); // Ser
        aminoacidTableMap.put("TCC", "S");
        aminoacidTableMap.put("TCA", "S");
        aminoacidTableMap.put("TCG", "S");

        aminoacidTableMap.put("CCT", "P"); // Pro
        aminoacidTableMap.put("CCC", "P");
        aminoacidTableMap.put("CCA", "P");
        aminoacidTableMap.put("CCG", "P");

        aminoacidTableMap.put("ACT", "T"); // Thr
        aminoacidTableMap.put("ACC", "T");
        aminoacidTableMap.put("ACA", "T");
        aminoacidTableMap.put("ACG", "T");

        aminoacidTableMap.put("GCT", "A"); // Ala
        aminoacidTableMap.put("GCC", "A");
        aminoacidTableMap.put("GCA", "A");
        aminoacidTableMap.put("GCG", "A");

        aminoacidTableMap.put("TAT", "Y"); // Tyr
        aminoacidTableMap.put("TAC", "Y");

        aminoacidTableMap.put("TAA", "Stop");//Stop
        aminoacidTableMap.put("TAG", "Stop");
        aminoacidTableMap.put("TGA", "Stop");

        aminoacidTableMap.put("CAT", "H"); // His
        aminoacidTableMap.put("CAC", "H");

        aminoacidTableMap.put("CAA", "Q"); // Gln
        aminoacidTableMap.put("CAG", "Q");

        aminoacidTableMap.put("AAT", "N");// Asn
        aminoacidTableMap.put("AAC", "N");

        aminoacidTableMap.put("AAA", "K");// Lys
        aminoacidTableMap.put("AAG", "K");

        aminoacidTableMap.put("GAT", "D");// Asp
        aminoacidTableMap.put("GAC", "D");

        aminoacidTableMap.put("GAA", "E"); // Glu
        aminoacidTableMap.put("GAG", "E");

        aminoacidTableMap.put("TGT", "C"); // Cys
        aminoacidTableMap.put("TGC", "C");

        aminoacidTableMap.put("TGG", "W"); // Trp

        aminoacidTableMap.put("CGT", "R"); // Arg
        aminoacidTableMap.put("CGC", "R");
        aminoacidTableMap.put("CGA", "R");
        aminoacidTableMap.put("CGG", "R");

        aminoacidTableMap.put("AGA", "R"); // Arg
        aminoacidTableMap.put("AGG", "R");

        aminoacidTableMap.put("AGT", "S"); // Ser
        aminoacidTableMap.put("AGC", "S");

        aminoacidTableMap.put("GGT", "G"); // Gly
        aminoacidTableMap.put("GGC", "G");
        aminoacidTableMap.put("GGA", "G");
        aminoacidTableMap.put("GGG", "G");
    }
}