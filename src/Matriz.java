import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Llaya
 */

public class Matriz {

    private int matriz[][] = new int[3][3];

    public Matriz() {
    }

    public Matriz(String ficha) {
        String[] numeroficha = ficha.split(",");
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                int col = columna;
                if (fila == 1) {
                    col = columna + 3;
                }
                if (fila == 2) {
                    col = columna + 6;
                }

                this.matriz[fila][columna] = Integer.parseInt(numeroficha[col]);
                this.matriz[fila][columna] = Integer.parseInt(numeroficha[col]);
                this.matriz[fila][columna] = Integer.parseInt(numeroficha[col]);
            }
        }
    }

    public int[][] leeFichas() {
        return matriz;
    }

    public void mueveDerecha(int fila, int col) {
        int ficha = this.matriz[fila][col];
        this.matriz[fila][col] = this.matriz[fila][col + 1];
        this.matriz[fila][col + 1] = ficha;
    }

    public void mueveIzquierda(int fila, int col) {
        int ficha = this.matriz[fila][col];
        this.matriz[fila][col] = this.matriz[fila][col - 1];
        this.matriz[fila][col - 1] = ficha;
    }

    public void mueveArriba(int fila, int col) {
        int ficha = this.matriz[fila][col];
        this.matriz[fila][col] = this.matriz[fila - 1][col];
        this.matriz[fila - 1][col] = ficha;
    }

    public void mueveAbajo(int fila, int col) {
        int ficha = this.matriz[fila][col];
        this.matriz[fila][col] = this.matriz[fila + 1][col];
        this.matriz[fila + 1][col] = ficha;
    }

    public String generatId() {
        StringBuffer salida = new StringBuffer();
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                salida.append(matriz[fila][col]);
                if (!(fila == 2 && col == 2)) {
                    salida.append(",");
                }
            }
        }

        return salida.toString();

    }

    public Integer ubicaFila() {
        Integer posicion = -1;
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                if (matriz[fila][col] == 0) {
                    posicion = fila;
                }
            }
        }
        return posicion;
    }

    public Integer ubicaColumna() {
        Integer posicion = -1;
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                if (matriz[fila][col] == 0) {
                    posicion = col;
                }
            }
        }
        return posicion;
    }

    public List<Matriz> determinaEstados() {
        List<Matriz> estados = new ArrayList<Matriz>();
        Integer filaMatriz = ubicaFila();
        Integer columnaMatriz = ubicaColumna();
  
        Matriz pEst;
        if (filaMatriz == 0) {
            pEst = new Matriz(generatId());
            pEst.mueveAbajo(filaMatriz, columnaMatriz);
            estados.add(pEst);
        }
        if (filaMatriz == 1) {
            pEst = new Matriz(generatId());
            pEst.mueveAbajo(filaMatriz, columnaMatriz);
            estados.add(pEst);
        }
        if (filaMatriz == 1) {
            pEst = new Matriz(generatId());
            pEst.mueveArriba(filaMatriz, columnaMatriz);
            estados.add(pEst);
        }
        if (filaMatriz == 2) {
            pEst = new Matriz(generatId());
            pEst.mueveArriba(filaMatriz, columnaMatriz);
            estados.add(pEst);
        }
        if (columnaMatriz == 0) {
            pEst = new Matriz(generatId());
            pEst.mueveDerecha(filaMatriz, columnaMatriz);
            estados.add(pEst);

        }
        if (columnaMatriz == 1) {
            pEst = new Matriz(generatId());
            pEst.mueveDerecha(filaMatriz, columnaMatriz);
            estados.add(pEst);

        }
        if (columnaMatriz == 2) {
            pEst = new Matriz(generatId());
            pEst.mueveIzquierda(filaMatriz, columnaMatriz);
            estados.add(pEst);
        }
        if (columnaMatriz == 1) {
            pEst = new Matriz(generatId());
            pEst.mueveIzquierda(filaMatriz, columnaMatriz);
            estados.add(pEst);
        }

        return estados;
    }

    public String dibujar() {
        StringBuffer salida = new StringBuffer();
        
        salida.append("\n[" + matriz[0][0] + "] [" + matriz[0][1] + "] ["
                + matriz[0][2] + "]");
        salida.append("\n[" + matriz[1][0] + "] [" + matriz[1][1] + "] ["
                + matriz[1][2] + "]");
        salida.append("\n|" + matriz[2][0] + "] [" + matriz[2][1] + "] ["
                + matriz[2][2] + "]"+"\n");
        
        return salida.toString();
    }

}
