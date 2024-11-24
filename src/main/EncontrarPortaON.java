package main;

import java.util.HashMap;

/*
 * @Author Fernando Afonso e Esdras Correa
 * 
 * Esta classe possui o método que tenta encontrar as portas com algoritmo de complexidade O(n). Existe um laço
 * while que permite com que o laço rode até encontrarmos a condição ideal. o passo inicial é 0, e é incrementando em
 * 1 sempre, em seguida, verifica se a porta é a correta. Caso não seja, o valor da variável passos, é trocada pela versão
 * com um sinal negativo, sem precisar percorrer tudo novamente.
 * 
 * As operações simples como atribuição de variáveias são  O(1);
 * 
 * As operações como laços, são um pouco mais complexas devido o a dependência do tamanho do maior item do laço, ou seja, O(K);    
 * */
public class EncontrarPortaON {

    // Simula um vetor infinito usando um HashMap
    private static final HashMap<Integer, Boolean> portas = new HashMap<>();

    public static int encontrarPorta() {
        int passos = 0; // Passos percorridos em cada direção

        while (true) {
            // Mover para a direita e verificar
            passos++;
            if (verificarPorta(passos)) {
                return passos; // Porta encontrada à direita
            }

            // Mover para a esquerda e verificar
            if (verificarPorta(-passos)) {
                return -passos; // Porta encontrada à esquerda
            }
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

