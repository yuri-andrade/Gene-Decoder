package com.study.oop;

import com.study.oop.controller.GenomaController;
import com.study.oop.entity.AminoacidTable;
import com.study.oop.entity.Gene;
import com.study.oop.entity.Genoma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

class GeneTest {
    private Gene gene;

    @BeforeEach
    void setaTeste() {
        List<Character> basesList = Arrays.asList('G', 'A', 'T', 'G', 'A', 'C', 'A', 'G', 'G', 'A', 'C', 'T', 'G', 'C',
                'T', 'G', 'G', 'A', 'C', 'T', 'A', 'G', 'A', 'A');
        this.gene = new Gene("locusTest", 0, 0, basesList);
    }

    @Test
    void trhowsExceptionTest() {
        FileNotFoundException testException = null;
        try {
            new Genoma("error");
        } catch (FileNotFoundException e) {
            testException = e;
        } finally {
            assertNotNull(testException);
        }
    }

    @Test
    void readFileTest() {
        FileNotFoundException testException = null;
        try {
            new Genoma("src/sequence.txt");
        } catch (FileNotFoundException e) {
            testException = e;
        } finally {
            assertNull(testException);
        }
    }

    @Test
    void getTresCincoUm() {
        assertEquals("[K, I, R, S, S, G, Q, Stop]", gene.getTresCincoUm().toString());
    }

    @Test
    void getTresCincoDois() {
        assertEquals("[R, S, G, R, Q, D, S]", gene.getTresCincoDois().toString());
    }

    @Test
    void getTresCincoTres() {
        assertEquals("[D, Q, V, V, R, T, V]", gene.getTresCincoTres().toString());
    }

    @Test
    void getCincoTresUm() {
        assertEquals("[D, D, R, T, A, G, L, E]", gene.getCincoTresUm().toString());
    }

    @Test
    void getCincoTresDois() {
        assertEquals("[Met, T, G, L, L, D, Stop]", gene.getCincoTresDois().toString());
    }

    @Test
    void getCincoTresTres() {
        assertEquals("[Stop, Q, D, C, W, T, R]", gene.getCincoTresTres().toString());
    }

    @Test
    void getRightSequence() {
        Assertions.assertEquals("[Met, T, G, L, L, D, Stop]", gene.getRightSequence().toString());
    }

    @Test
    void howManyGenes() {
        Genoma genoma = null;
        try {
            genoma = new Genoma("src/sequence.txt");
        } catch (FileNotFoundException e) {
            assertNull(e);
        }
        assertEquals(1995, Objects.requireNonNull(genoma).getGeneMap().size());
    }

    @Test
    void controllerAppTest() {
        GenomaController.main(null);
    }

    @Test
    void testAminoacidTable() {
        assertEquals(AminoacidTable.getInstance().aminoacidTableMap.size(), 64);
    }
}