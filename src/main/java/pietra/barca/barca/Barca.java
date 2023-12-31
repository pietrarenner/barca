package pietra.barca.barca;

import java.util.regex.Pattern;

public class Barca { 
    public static final int ASSENTOS_POR_FILA = 20;
    public static final int FILAS = 60;
    private boolean[][] assentos;
    private int qtdadeAssentosOcupados;

    public Barca(){
        assentos = new boolean[FILAS][]; 
        for(int i=0;i<FILAS;i++){
            assentos[i] = new boolean[ASSENTOS_POR_FILA];
            for(int j=0;j<ASSENTOS_POR_FILA;j++){
                assentos[i][j] = false;
            }
        }
        qtdadeAssentosOcupados = 0;
    } 
    
    // Método auxiliar projetado para facilitar testes (montagem de cenário) 
    // Ocupa o lugar sem verificação: simplesmente ocupa o lugar sem validar nenhuma das 
    // regras de ocupação 
    public void ocupaLugarSemVerificacao(int fila, int assento){ 
        assentos[fila][assento] = true;
        qtdadeAssentosOcupados++;
    } 
    /* 
    * Retorna: 
    * 0 – Identificador de assento inválido 
    * 1 – Assento ocupado 
    * 2 – Assento bloqueado devido a distribuição de peso 
    * 3 – Ok, assento atribuído ao passageiro. 
    */ 
    
    public int ocupaLugar(String assentoInformado){ 
        // Verifica se é um assento valido
        if (Pattern.matches("[F][0-9]{2}[A][0-9]{2}", assentoInformado) == false){
            return 0; 
        }
        int fila = Integer.parseInt(assentoInformado.substring(1,3));
        fila = fila - 1;
        int assento = Integer.parseInt(assentoInformado.substring(4,6));
        assento = assento - 1;
        if (fila<0 || fila > 60){
            return 0;
        }
        if (assento < 0 || assento > 20){
            return 0;
        }
        // Verifica se o assento já está ocupado
        if (assentos[fila][assento] == true){
            return 1;
        }
        // Se tem até 100 passageiros, verifica se fila <= 20
        if (qtdadeAssentosOcupados < 100 && fila > 19){
            return 2;
        }
        // Se tem mais de 100 e até de 200 passageiros, verifica se fila >= 40
        if (qtdadeAssentosOcupados >= 100 && qtdadeAssentosOcupados <= 200 && fila < 39){
            return 2;
        }
        // Ocupa o assento
        assentos[fila][assento] = true;
        qtdadeAssentosOcupados++;
        return 3;
    }
}

