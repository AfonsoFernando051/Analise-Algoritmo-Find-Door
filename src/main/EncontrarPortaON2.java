package main;

import java.util.HashMap;

/*
 * @Author Fernando Afonso e Esdras Correa
 * 
 * Esta classe possui o método que tenta encontrar as portas com algoritmo de complexidade O(n²),
 * com o laço while e dentro do while, dois laços "for", que percorrem os elementos da lista
 * 
 * As operações simples como atribuição de variáveias são  O(1);
 * 
 * As operações como laços, são um pouco mais complexas devido o a dependência do tamanho do maior item do laço, ou seja, O(K);    
 * */
public class EncontrarPortaON2 {

    private static final HashMap<Integer, Boolean> portas = new HashMap<>();
    
    //Método de busca de portas
    public static int encontrarPorta() {
        int posicao = 0; // Posição inicial
        int k = 1;

        while (true) {
            // Mover para a direita e verificar
            for (int i = 0; i < k; i++) {
                posicao++;
                if (verificarPorta(posicao)) { 
                    return posicao;
                }
            }

            // Retornar ao ponto inicial
            posicao = 0;

            // Mover para a esquerda e verificar
            for (int i = 0; i < k; i++) { 
                posicao--;
                if (verificarPorta(posicao)) {
                    return posicao;
                }
            }

            // Retornar ao ponto inicial
            for (int i = 0; i < k; i++) { 
                posicao++; 
            }

            // Incrementar k para expandir o alcance
            k++;
        }
    }

    // Verificar se a posição atual é uma porta
    public static boolean verificarPorta(int posicao) {
        return portas.getOrDefault(posicao, false);
    }

    public static void main(String[] args) {
        // Configura as portas em posições específicas
        portas.put(10, true);   // Porta na posição 10
        portas.put(-15, true); // Porta na posição -15
        portas.put(25, true);  // Porta na posição 25

        int porta = encontrarPorta();
        System.out.println("A porta foi encontrada na posição: " + porta);
    }
}
