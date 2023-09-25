package pietra.barca.barca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pietra.barca.barca.BarcaTest;

public class BarcaTest {
    private Barca b = null;

    @BeforeEach 
    void setUp() {
        b = new Barca();
    }

    //assento livre e atribuído ao passageiro | assento bloqueado devido a distribuição de peso
    @Test
    public void passageiro2Fileira2() { //segundo passageiro ocupa lugar na segunda fileira
        b.ocupaLugarSemVerificacao(01, 01);
        int ocupa = b.ocupaLugar("F02A04");

        Assertions.assertEquals(3, ocupa);
    }

    @Test
    public void passageiro4Fileira41() { //quarto passageiro ocupa lugar na fileira 41
        b.ocupaLugarSemVerificacao(01,01);
        b.ocupaLugarSemVerificacao(02,02);
        b.ocupaLugarSemVerificacao(03,03);
        int ocupa = b.ocupaLugar("F41A12");

        Assertions.assertEquals(2, ocupa);
    }

    @Test
    public void passageiro3Fileira25() { //terceiro passageiro ocupa lugar na fileira 25
        b.ocupaLugarSemVerificacao(05,12);
        b.ocupaLugarSemVerificacao(10,05);

        int ocupa = b.ocupaLugar("F25A19");
        
        Assertions.assertEquals(2, ocupa);    
    }

    @Test
    public void passageiro105Fileira18() { //passageiro 105 ocupa lugar na fileira 18
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 5; j++){ //100 primeiros passageiros ocupam lugares de 1 a 5 nas fileiras 1 até 20
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        b.ocupaLugarSemVerificacao(42,15); //101
        b.ocupaLugarSemVerificacao(56,07);//102
        b.ocupaLugarSemVerificacao(48,04);//103
        b.ocupaLugarSemVerificacao(52,19);//104
        int ocupa = b.ocupaLugar("F18A16");//105
        
        Assertions.assertEquals(2, ocupa);
    }

    @Test
    public void passageiro120Fileira47() {  //passageiro 120 ocupa lugar na fileira 47
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 5; j++){ //100 primeiros passageiros ocupam lugares de 1 a 5 nas fileiras 1 até 20
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        for(int i = 39; i < 58; i++){   //do 101 ao 119 ocupam o primeiro lugar das fileiras 40 até 58
            b.ocupaLugarSemVerificacao(i, 01);
        }

        int ocupa = b.ocupaLugar("F47A12"); //passageiro 120

        Assertions.assertEquals(3, ocupa);
    }

    @Test
    public void passageiro170Fileira22() { //passageiro 170 ocupa lugar na fileira 22
        for(int i = 0; i < 20; i++) {
            for(int j = 4; j < 9; j++){ //100 primeiros passageiros ocupam lugares de 5 a 9 nas fileiras 1 até 20
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        for(int i = 39; i < 59; i++) {
            for(int j = 2; j < 5; j++){ //do 101 ao 160 ocupam lugares de 3 a 5 nas fileiras 40 a 59
                b.ocupaLugarSemVerificacao(i, j);
            }
        }

        for(int i = 39; i < 48; i++){
            b.ocupaLugarSemVerificacao(i, 10); //161 a 169 ocupam assento 10 das filas 40 a 48
        }

        //170 ocupa assento 1 na fileira 22
        int ocupa = b.ocupaLugar("F22A01");
        
        Assertions.assertEquals(2, ocupa);
    }

    @Test
    public void passageiro202Fileira19() { //passageiro 202 ocupa lugar na fileira 19
        for(int i = 0; i < 20; i++) {
            for(int j = 5; j < 10; j++){ //100 primeiros passageiros ocupam lugares de 6 a 10 nas fileiras 1 até 20
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        for(int i = 39; i < 59; i++) {
            for(int j = 6; j < 11; j++){ //101 ao 200 passageiros ocupam lugares de 7 a 11 nas fileiras 40 até 60
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        //201
        b.ocupaLugarSemVerificacao(22, 01);
        //202
        int ocupa = b.ocupaLugar("F19A15");


        Assertions.assertEquals(3, ocupa);
    }

    @Test
    public void passageiro301Fileira44() { //passageiro 301 ocupa lugar na fileira 44
        for(int i = 0; i < 20; i++) {
            for(int j = 14; j < 19; j++){ //100 primeiros passageiros ocupam lugares de 15 a 20 nas fileiras 1 até 20
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        for(int i = 39; i < 59; i++) {
            for(int j = 6; j < 11; j++){ //101 ao 200 passageiros ocupam lugares de 7 a 11 nas fileiras 40 até 60
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        for(int i = 19; i < 39; i++) {
            for(int j = 0; j < 5; j++){ //201 ao 300 passageiros ocupam lugares de 1 a 6 nas fileiras 20 até 39
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        //301
        int ocupa = b.ocupaLugar("F44A14"); 

        Assertions.assertEquals(3, ocupa);
    }

    @Test
    public void passageiro801Fileira32() { //passageiro 801 ocupa lugar na fileira 32
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++){ //400 passageiros ocupam lugares de 1 a 20 nas fileiras 1 até 20
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        for(int i = 40; i < 60; i++) {
            for(int j = 0; j < 20; j++){ //400 passageiros ocupam lugares de 1 a 20 nas fileiras 41 até 60
                b.ocupaLugarSemVerificacao(i,j); 
            }
        }

        //801
        int ocupa = b.ocupaLugar("F32A07");

        Assertions.assertEquals(3, ocupa);
    }

    
    //assento ocupado
    @Test
    public void passageiro2AssentoOcupado() { 
        b.ocupaLugarSemVerificacao(03,04);
        int ocupa = b.ocupaLugar("F03A04");

        Assertions.assertEquals(1, ocupa);
    }

    //assento inválido
    @Test
    public void passageiro1AssentoInvalido() { 
        int ocupa = b.ocupaLugar("F01A30");

        Assertions.assertEquals(0, ocupa);
    }
}
