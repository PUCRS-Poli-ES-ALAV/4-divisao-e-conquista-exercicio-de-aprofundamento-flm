//  Desenvolver uma aplicação que resolva o problema das n-rainhas, encontrando 
//  uma solução válida para o problema. Como entrada, o programa recebe um valor para n >= 2, 
//  e retorna a disposição das rainhas no tabuleiro.

// 2. Qual a complexidade da sua solução?
// (Se não concluiu na aula passada, conclua agora)

// 3. Ajuste sua solução para que usar backtracking (se não foi o caso) e para que retorne todas as soluções, não só a primeira.

// 4. Implemente (ou recupere) uma classe de grafo dirigido e inclua um método de percorre todo o gráfico em profundidade, usando Backtracking , a partir de um determinado nó.

public class Nrainhas {
    public static void main(String[] args) {
        int n = 8; // Tamanho do tabuleiro (n x n)
        int[][] tabuleiro = new int[n][n];

        if (resolverNrainhas(tabuleiro, 0)) {
            imprimirTabuleiro(tabuleiro);
        } else {
            System.out.println("Não há solução para " + n + " rainhas.");
        }
    }

    public static boolean resolverNrainhas(int[][] tabuleiro, int coluna) {
        int n = tabuleiro.length;

        if (coluna >= n) {
            return true; // Todas as rainhas foram colocadas
        }

        for (int i = 0; i < n; i++) {
            if (ehSeguro(tabuleiro, i, coluna)) {
                tabuleiro[i][coluna] = 1; // Coloca a rainha

                if (resolverNrainhas(tabuleiro, coluna + 1)) {
                    return true; // Continua para a próxima coluna
                }

                tabuleiro[i][coluna] = 0; // Remove a rainha (backtracking)
            }
        }

        return false; // Nenhuma posição segura encontrada
    }

    public static boolean ehSeguro(int[][] tabuleiro, int linha, int coluna) {
        int n = tabuleiro.length;

        // Verifica a linha à esquerda
        for (int i = 0; i < coluna; i++) {
            if (tabuleiro[linha][i] == 1) {
                return false;
            }
        }

        // Verifica a diagonal superior à esquerda
        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        // Verifica a diagonal inferior à esquerda
        for (int i = linha, j = coluna; i < n && j >= 0; i++, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        // Verifica a diagonal superior à direita
        for (int i = linha, j = coluna; i >= 0 && j < n; i--, j++) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        // Verifica a diagonal inferior à direita
        for (int i = linha, j = coluna; i < n && j < n; i++, j++) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        return true; // Posição segura
    }

    public static void imprimirTabuleiro(int[][] tabuleiro) {
        int n = tabuleiro.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}