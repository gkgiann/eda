package atividade02;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BrincandoComOrdenacao {

    public static void main(String[] args) {
        Ordenacao ord = new Ordenacao();

        // criando map para colocar os algoritmos
        Map<String, Method> sortMethods = new HashMap<>();

        // preenchendo com os algoritmos (sem o método checaVetorOrdenado)
        for (Method method : ord.getClass().getMethods()) {
            if (method.getDeclaringClass() == Ordenacao.class) {
                if (!method.getName().equals("checaVetorOrdenado")) {
                    sortMethods.put(method.getName(), method);
                }
            }
        }

        int arraysLength = 5000;

        // loop para os 3 tamanhos (5k, 10k, 15k)
        for (int i = 1; i <= 3; i++) {

            // criando os arrays e preenchendo
            int[] arrayASC = new int[arraysLength];
            int[] arrayDESC = new int[arraysLength];
            int[] shuffledArray = new int[arraysLength];
            fillArrays(arrayASC, arrayDESC, shuffledArray, arraysLength);

            // passando em cada método
            for (String methodName : sortMethods.keySet()) {

                long sumArrayASCTime = 0;
                long sumArrayDESCTime = 0;
                long sumShuffledArrayTime = 0;

                // executando o método 50 vezes (capaz de matar o notebook)
                for (int j = 0; j < 50; j++) {
                    try {
                        Method method = sortMethods.get(methodName);

                        // chamando o método em cada tipo de array
                        long arrayASCTime = (long) method.invoke(ord, (Object) arrayASC.clone());
                        long arrayDESCTime = (long) method.invoke(ord, (Object) arrayDESC.clone());
                        long shuffledArrayTime = (long) method.invoke(ord, (Object) shuffledArray.clone());

                        sumArrayASCTime += arrayASCTime;
                        sumArrayDESCTime += arrayDESCTime;
                        sumShuffledArrayTime += shuffledArrayTime;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("\n\n==================================================");
                System.out.printf("%s - %dK\n", methodName.toUpperCase(), arraysLength / 1000);

                String sumArrayASCTimeFormatted = String.format("%,d", sumArrayASCTime / 50);
                String sumArrayDESCTimeFormatted = String.format("%,d", sumArrayDESCTime / 50);
                String sumShuffledArrayTimeFormatted = String.format("%,d", sumShuffledArrayTime / 50);

                System.out.printf("Entrada crescente (média em nano):   %10s", sumArrayASCTimeFormatted);
                System.out.printf("\nEntrada decrescente (média em nano): %10s", sumArrayDESCTimeFormatted);
                System.out.printf("\nEntrada aleatória (média em nano):   %10s", sumShuffledArrayTimeFormatted);

            }

            arraysLength += 5000;
        }

    }

    private static void fillArrays(int[] arrayASC, int[] arrayDESC, int[] shuffledArray, int length) {
        for (int i = 0; i < length; i++) {
            arrayASC[i] = i + 1;

            arrayDESC[i] = length - i;

            int randomNumber = (int) (Math.random() * length) + 1;
            shuffledArray[i] = randomNumber;
        }
    }

    // private static int[] copyOfRange(int[] arrayToCopy, int maxLength) {
    // int[] copiedArray = Arrays.copyOfRange(arrayToCopy, 0, maxLength);

    // return copiedArray;
    // }
}
