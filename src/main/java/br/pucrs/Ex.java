package br.pucrs;

public class Ex {
    /*
    1. Vamos começar com um algorítmo já estudado e conhecido (em AEDI). O Merge Sort é um algorítmo de ordenação baseado nos seguintes passos:

    * recursivamente ordene a metade esquerda do vetor
    * recursivamente ordene a metade direita do vetor
    * mescle (faça o merge) das duas metades para ter o vetor ordenado. 
    
    Assim:
    
    * implemente o algortimo abaixo;
    * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;  
    
   ```java
   MERGE-SORT(L: List with n elements) : Ordered list with n elements
       IF (list L has one element)
           RETURN L.
       Divide the list into two halves A and B.
       A ← MERGE-SORT(A).
       B ← MERGE-SORT(B).
       L ← MERGE(A, B).
       RETURN L.  */

       public int[] mergeSort(int[] vetor) {
        if (vetor.length <= 1) {
            return vetor;
        }

        int meio = vetor.length / 2;
        int[] esquerda = new int[meio];
        int[] direita = new int[vetor.length - meio];

        System.arraycopy(vetor, 0, esquerda, 0, meio);
        System.arraycopy(vetor, meio, direita, 0, vetor.length - meio);

        esquerda = mergeSort(esquerda);
        direita = mergeSort(direita);

        return merge(esquerda, direita);
    }

    public int[] merge(int[] esquerda, int[] direita) {
        int[] resultado = new int[esquerda.length + direita.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                resultado[k++] = esquerda[i++];
            } else {
                resultado[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            resultado[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            resultado[k++] = direita[j++];
        }

        return resultado;
    }

    /*
    3. O algoritmo a seguir (que utiliza divisão-e-conquista) encontra o maior valor em um vetor.

    Assim, novamente:
   
    * implemente o algortimo abaixo;
    * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576.
    * Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
    
   long maxVal2(long A[], int init, int end) {  
       if (end - init <= 1)
           return max(A[init], A[end]);  
       else {
             int m = (init + end)/2;
             long v1 = maxVal2(A,init,m);   
             long v2 = maxVal2(A,m+1,end);  
             return max(v1,v2);
            }
   }
   */

   public long maxVal2(long[] A, int init, int end) {
    if (end - init <= 1) {
        return Math.max(A[init], A[end]);
    }
        else {
            int m = (init + end) / 2;
        long v1 = maxVal2(A, init, m);
        long v2 = maxVal2(A, m + 1, end);
        return Math.max(v1, v2);
    }
    }

    public long contarIteracao(long[] A, int init, int end) {
        if (end - init <= 1) {
            return 1; // Contabiliza a iteração para o caso base
        } else {
            int m = (init + end) / 2;
            long v1 = contarIteracao(A, init, m);
            long v2 = contarIteracao(A, m + 1, end);
            return v1 + v2 + 1; // Contabiliza a iteração para a chamada recursiva
        }

    }
}
