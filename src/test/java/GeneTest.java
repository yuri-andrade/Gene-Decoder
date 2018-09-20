import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class GeneTest {
    Gene gene;

    @BeforeEach
    void setaTeste(){
        List<Character> basesList = Arrays.asList('G','A','T','G','A','C','A','G','G','A','C','T','G','C',
        'T','G','G','A','C','T','A','G','A','A');
        this.gene = new Gene("locusTest", 0,0, basesList);
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
}