package com.study.oop.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        if (Objects.equals(null, instance)) {
            instance = new AminoacidTable();
        }
        return instance;
    }

    String getAminoacid(String codon) {
        return aminoacidTableMap.get(codon);
    }

    private void populateAminoacidTable() {
        aminoacidTableMap.put("TTT", "F"); // Phenylalanine
        aminoacidTableMap.put("TTC", "F");


        aminoacidTableMap.put("TTA", "L"); // Leucine
        aminoacidTableMap.put("TTG", "L");
        aminoacidTableMap.put("CTT", "L");
        aminoacidTableMap.put("CTC", "L");
        aminoacidTableMap.put("CTA", "L");
        aminoacidTableMap.put("CTG", "L");

        aminoacidTableMap.put("ATT", "I"); // Isoleucine
        aminoacidTableMap.put("ATC", "I");
        aminoacidTableMap.put("ATA", "I");

        aminoacidTableMap.put("ATG", "Met"); // Methionine

        aminoacidTableMap.put("GTT", "V"); // Valine
        aminoacidTableMap.put("GTC", "V");
        aminoacidTableMap.put("GTA", "V");
        aminoacidTableMap.put("GTG", "V");

        aminoacidTableMap.put("TCT", "S"); // Serine
        aminoacidTableMap.put("TCC", "S");
        aminoacidTableMap.put("TCA", "S");
        aminoacidTableMap.put("TCG", "S");
        aminoacidTableMap.put("AGT", "S");
        aminoacidTableMap.put("AGC", "S");


        aminoacidTableMap.put("CCT", "P"); // Proline
        aminoacidTableMap.put("CCC", "P");
        aminoacidTableMap.put("CCA", "P");
        aminoacidTableMap.put("CCG", "P");

        aminoacidTableMap.put("ACT", "T"); // Threonine
        aminoacidTableMap.put("ACC", "T");
        aminoacidTableMap.put("ACA", "T");
        aminoacidTableMap.put("ACG", "T");

        aminoacidTableMap.put("GCT", "A"); // Alanine
        aminoacidTableMap.put("GCC", "A");
        aminoacidTableMap.put("GCA", "A");
        aminoacidTableMap.put("GCG", "A");

        aminoacidTableMap.put("TAT", "Y"); // Tyrosine
        aminoacidTableMap.put("TAC", "Y");

        aminoacidTableMap.put("TAA", "Stop"); //Stop codons
        aminoacidTableMap.put("TAG", "Stop");
        aminoacidTableMap.put("TGA", "Stop");

        aminoacidTableMap.put("CAT", "H"); // Histidine
        aminoacidTableMap.put("CAC", "H");

        aminoacidTableMap.put("CAA", "Q"); // Glutamine
        aminoacidTableMap.put("CAG", "Q");

        aminoacidTableMap.put("AAT", "N"); // Asparagine
        aminoacidTableMap.put("AAC", "N");

        aminoacidTableMap.put("AAA", "K"); // Lysine
        aminoacidTableMap.put("AAG", "K");

        aminoacidTableMap.put("GAT", "D"); // Aspartic acid
        aminoacidTableMap.put("GAC", "D");

        aminoacidTableMap.put("GAA", "E"); // Glutamic acid
        aminoacidTableMap.put("GAG", "E");

        aminoacidTableMap.put("TGT", "C"); // Cysteine
        aminoacidTableMap.put("TGC", "C");

        aminoacidTableMap.put("TGG", "W"); // Tryptophan

        aminoacidTableMap.put("CGT", "R"); // Arginine
        aminoacidTableMap.put("CGC", "R");
        aminoacidTableMap.put("CGA", "R");
        aminoacidTableMap.put("CGG", "R");
        aminoacidTableMap.put("AGA", "R");
        aminoacidTableMap.put("AGG", "R");

        aminoacidTableMap.put("GGT", "G"); // Glycine
        aminoacidTableMap.put("GGC", "G");
        aminoacidTableMap.put("GGA", "G");
        aminoacidTableMap.put("GGG", "G");
    }
}