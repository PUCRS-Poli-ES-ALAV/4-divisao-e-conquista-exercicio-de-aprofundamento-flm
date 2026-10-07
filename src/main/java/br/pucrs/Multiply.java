package br.pucrs;

/*
    O algoritmo está dado abaixo:

MULTIPLY(x, y, n) 
   IF (n = 1)
      RETURN x * y.
   ELSE
      m ← ⎡ n / 2 ⎤.
      a ← ⎣ x / 2^m ⎦; b ← x mod 2^m.
      c ← ⎣ y / 2^m ⎦; d ← y mod 2^m.
      e ← MULTIPLY(a, c, m).
      f ← MULTIPLY(b, d, m).
      g ← MULTIPLY(b, c, m).
      h ← MULTIPLY(a, d, m).
      RETURN 2^(2m)*e + 2^m*(g + h) + f.
Ajuste a assinatura da sua implementação para receber tipo inteiros long (em java).
*/

public class Multiply {
    private static long iteracoes = 0;

    public static long multiply(long x, long y, int n) {
        iteracoes++;
        if (n == 1)
            return x * y;

        else {
            int m = (int) Math.ceil(n / 2.0);
            long a = x / (1L << m);
            long b = x % (1L << m);
            long c = y / (1L << m);
            long d = y % (1L << m);

            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);

            return (1L << (2 * m)) * e + (1L << m) * (g + h) + f;
        }
    }

    public void testar(long x, long y, int n) {

        iteracoes = 0;

        long inicio = System.nanoTime();

        long resultado = multiply(x, y, n);

        long fim = System.nanoTime();

        long tempo = fim - inicio;

        System.out.println("----- TESTE " + n + " BITS -----");
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Resultado: " + resultado);
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Tempo: " + tempo + " ns");
        System.out.println();
    }
}

