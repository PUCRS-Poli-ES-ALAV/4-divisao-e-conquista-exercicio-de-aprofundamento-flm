package br.pucrs;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ex exercicio = new Ex();
        System.out.println(exercicio.mergeSort(new int[]{33, 2048, 1048576}));
        System.out.println(exercicio.maxVal2(null, 0, 0));
        System.out.println(exercicio.contarIteracao(null, 0, 0));       
    
    }
    
}
