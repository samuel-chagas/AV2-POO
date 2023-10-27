package q4_samuelchagas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Matrizes {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\SAMUEL\\Documents\\java\\AV2_SamuelChagas\\src\\q4_samuelchagas\\Matriz.txt"));

            double[][] MatrizA = lerMatriz(reader);
            double[][] MatrizB = lerMatriz(reader);

         
            if (MatrizA[0].length != MatrizB.length) {
                System.out.println("Não é possível multiplicar as matrizes. O número de colunas de A deve ser igual ao número de linhas de B.");
                return;
            }
            double[][] resultado = multiplicarMatrizes(MatrizA, MatrizB);
            System.out.println("Resultado da multiplicação:");
            imprimirMatriz(resultado);

         
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[][] lerMatriz(BufferedReader reader) throws IOException {
        String linha;
        StringBuilder matrizStr = new StringBuilder();

        while ((linha = reader.readLine()) != null && !linha.isEmpty()) {
            matrizStr.append(linha).append("\n");
        }
        String[] linhas = matrizStr.toString().trim().split("\n");
        int numRows = linhas.length;
        int numCols = linhas[0].split(" ").length;

        double[][] Matriz = new double[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            String[] valores = linhas[i].split(" ");
            for (int j = 0; j < numCols; j++) {
                Matriz[i][j] = Double.parseDouble(valores[j]);
            }
        }

        return Matriz;
    }

    public static double[][] multiplicarMatrizes(double[][] MatrizA, double[][] MatrizB) {
        int linhasA = MatrizA.length;
        int colunasA = MatrizA[0].length;
        int colunasB = MatrizB[0].length;

        double[][] resultado = new double[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    resultado[i][j] += MatrizA[i][k] * MatrizB[k][j];
                }
            }
        }

        return resultado;
    }

    public static void imprimirMatriz(double[][] Matriz) {
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                System.out.print(Matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
