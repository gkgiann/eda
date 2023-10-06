package atividade01;

public class Busca implements Busca_IF {

    public boolean buscaBinaria_iterativa(int[] numeros, int k) {
        int indiceEsquerdo = 0;
        int indiceDireito = numeros.length - 1;

        while (indiceDireito >= indiceEsquerdo) {
            int indiceDoMeio = (indiceDireito + indiceEsquerdo) / 2;

            if (numeros[indiceDoMeio] == k) {
                return true;
            }

            if (k > numeros[indiceDoMeio]) {
                indiceEsquerdo = indiceDoMeio + 1;
            } else {
                indiceDireito = indiceDoMeio - 1;
            }
        }

        return false;
    }

    public boolean buscaBinaria_recursiva(int[] numeros, int k) {
        return buscaBinariaRecursiva(numeros, k, 0, numeros.length - 1);
    }

    private static boolean buscaBinariaRecursiva(int[] numeros, int k, int indiceEsquerdo, int indiceDireito) {
        if (indiceEsquerdo > indiceDireito) {
            return false;
        }

        int indiceDoMeio = (indiceEsquerdo + indiceDireito) / 2;

        if (numeros[indiceDoMeio] == k) {
            return true;
        }

        if (k > numeros[indiceDoMeio]) {
            return buscaBinariaRecursiva(numeros, k, indiceDoMeio + 1, indiceDireito);
        }

        return buscaBinariaRecursiva(numeros, k, indiceEsquerdo, indiceDoMeio - 1);
    }

    public boolean buscaLinear_iterativa(int[] numeros, int k) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == k) {
                return true;
            }
        }

        return false;
    }

    public boolean buscaLinear_recursiva(int[] numeros, int k) {
        return buscaLinearRecursiva(numeros, k, 0);
    }

    private static boolean buscaLinearRecursiva(int[] numeros, int k, int i) {
        if (i >= numeros.length) {
            return false;
        }

        if (numeros[i] == k) {
            return true;
        }

        return buscaLinearRecursiva(numeros, k, i + 1);
    }

    public int[] geraVetorNumericoOrdenado(int tamanho) {
        int[] vetorNumericoOrdenado = new int[tamanho];

        for (int i = 0; i < vetorNumericoOrdenado.length; i++) {
            vetorNumericoOrdenado[i] = i + 1;
        }

        return vetorNumericoOrdenado;
    }

    public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k) {
        for (int i = 0; i < numeros.length / 2; i++) {
            if (numeros[i] == k || numeros[numeros.length - 1 - i] == k)
                return true;
        }

        return false;
    }

}
