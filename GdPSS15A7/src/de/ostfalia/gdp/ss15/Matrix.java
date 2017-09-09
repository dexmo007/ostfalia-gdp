package de.ostfalia.gdp.ss15;

/**
 * Created by Henrik on 4/28/2015.
 */
public class Matrix {

    public static double[][] unityMatrix(int n) {
        double[][] unityMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            unityMatrix[i][i] = 1;
        }
        return unityMatrix;
    }

    public static boolean isSymmetric(double[][] m) {
        if (m.length == 0) {
            return true;
        }
        if (m.length != m[m.length - 1].length) {
            return false;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != m[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double[][] transpose(double[][] m) {
        if (m.length == 0) {
            return new double[0][0];
        }
        double[][] transposedMatrix = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                transposedMatrix[j][i] = m[i][j];
            }
        }
        return transposedMatrix;
    }

    public static double[] mult(double[][] m, double[] v) {
        if (m.length == 0 || v.length == 0) {
            return new double[0];
        } else if (m[0].length != v.length) {
            return new double[0];
        }
        double[] product = new double[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                product[i] = product[i] + v[j] * m[i][j];
            }
        }
        return product;
    }

    public static int count(String str, char c) {
        char[] stringToCharArray = new char[str.length()];
        stringToCharArray = str.toCharArray();
        int countCs = 0;
        for (char element : stringToCharArray) {
            if (element == c) {
                countCs++;
            }
        }
        return countCs;
    }

    public static double[][] read(String input) {
        input = input.replaceAll(" ", "");
        if (input.length() < 5) {
            return new double[0][0];
        } else {
            input = input.substring(2, input.length() - 2);
        }
        String[] parts = input.split("[{,}]");
        int aLength = parts.length;
        int countSpace = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].isEmpty()) {
                aLength = i;
                break;
            }
        }
        for (String part : parts) {
            if (part.isEmpty()) {
                countSpace++;
            }
        }
        double[][] out = new double[countSpace / 2 + 1][aLength];
        int k = 0;
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                if (!parts[k].isEmpty()) {
                    out[i][j] = Double.parseDouble(parts[k]);
                    k++;
                } else {
                    j--;
                    k++;
                }
            }
        }
//        for (double[] row : out) {
//            for (double number : row) {
//                System.out.println(number);
//            }
//            System.out.println();
//        }
        return out;
    }

    public static String toString(double[][] m) {
        String out = "{";
        for (double[] row : m) {
            out = out.concat("{");
            for (double number : row) {
                out = out.concat(Double.toString(number) + ",");
            }
            if (out.length() > 1) {
                out = out.substring(0, out.length() - 1);
            }
            out = out.concat("},");
        }
        if (out.length() > 1) {
            out = out.substring(0, out.length() - 1);
        }
        out = out.concat("}");
        System.out.println(out);
        return out;
    }

    public static void main(String[] args) {
//        read("{{1,2,3},{4,5,6}}");
        toString(new double[2][2]);

    }
}
