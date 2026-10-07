package br.pucrs;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Multiply m = new Multiply();

        m.testar(7, 6, 4);

        m.testar(12345, 23456, 16);

        m.testar(2_000_000_000L, 3_000_000_000L, 64);
    }
}