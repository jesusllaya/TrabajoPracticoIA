import java.util.*;

/**
 *
 * @author Jesus Llaya
 */

public class Busqueda extends javax.swing.JPanel {

    private Matriz puzzleInicio;
    private Matriz puzzleFin;
    private Map<String, Matriz> nodosGenerados;
    private int nodosAnalizadosAnchura = 0;
    private int largoBusquedaAnchura = 0;
    private int nodosAnalizadosProfundidad = 0;
    private int largoBusquedaProfundida = 0;

    private List<String> listadoMatrices = new ArrayList<String>();
   

    public Busqueda() {
        

    }

    public Busqueda(Matriz puzzleInicio, Matriz puzzleFin) {
        this.puzzleInicio = puzzleInicio;
        this.puzzleFin = puzzleFin;
    }

    public int getNodosAnalizadosAnchura() {
        return nodosAnalizadosAnchura;
    }

    public int getLargoBusquedaAnchura() {
        return largoBusquedaAnchura;
    }

    public int getNodosAnalizadosProfundidad() {
        return nodosAnalizadosProfundidad;
    }

    public void setNodosAnalizadosProfundidad(int nodosAnalizadosProfundidad) {
        this.nodosAnalizadosProfundidad = nodosAnalizadosProfundidad;
    }

    public int getLargoBusquedaProfundida() {
        return largoBusquedaProfundida;
    }

    public void setLargoBusquedaProfundida(int largoBusquedaProfundida) {
        this.largoBusquedaProfundida = largoBusquedaProfundida;
    }
    
    

    public List<String> getListadoMatrices() {
        return listadoMatrices;
    }

    public void realizarBusquedaProfundidad() {
        nodosGenerados = new HashMap<String, Matriz>();
        LinkedList<Matriz> colaAuxiliar = new LinkedList<Matriz>();
        colaAuxiliar.add(puzzleInicio);

        largoBusquedaProfundida++;
        while (colaAuxiliar.size() != 0) {

            Matriz nodo = colaAuxiliar.poll();
           
            listadoMatrices.add(nodo.dibujar());
            nodosAnalizadosProfundidad++;
            if (nodo.generatId().equals(puzzleFin.generatId())) {
                this.puzzleFin.dibujar();
                break;
            } else {
                List<Matriz> nuevosEstados = nodo.determinaEstados();

                for (int i = nuevosEstados.size() - 1; i >= 0; i--) {
                    largoBusquedaProfundida++;
                    if (nuevosEstados.get(i).generatId().equals(puzzleFin.generatId())) {
                        
                        this.puzzleFin.dibujar();
                        listadoMatrices.add(this.puzzleFin.dibujar());
                        colaAuxiliar.clear();
                        break;
                    }
                    if (!nuevosEstados.get(i).generatId().equals(puzzleInicio.generatId()) && !nodosGenerados.containsKey(nuevosEstados.get(i).generatId())) {
                        colaAuxiliar.add(0, nuevosEstados.get(i));
                        nodosGenerados.put(nuevosEstados.get(i).generatId(), nuevosEstados.get(i));
                    }
                }
            }
        }
    }

    public void realizarBusquedaAnchura() {
        nodosGenerados = new HashMap<String, Matriz>();
        Queue<Matriz> colaAuxiliar = new LinkedList<Matriz>();
        colaAuxiliar.add(puzzleInicio);

        largoBusquedaAnchura++;
        while (colaAuxiliar.size() != 0) {

            Matriz nodo = colaAuxiliar.poll();
            listadoMatrices.add(nodo.dibujar());
            
            nodosAnalizadosAnchura++;
            if (nodo.generatId().equals(puzzleFin.generatId())) {
                this.puzzleFin.dibujar();
                listadoMatrices.add(this.puzzleFin.dibujar());
                break;
            } else {
                List<Matriz> nuevosEstados = nodo.determinaEstados();

                for (int i = nuevosEstados.size() - 1; i >= 0; i--) {
                    largoBusquedaAnchura++;
                    if (nuevosEstados.get(i).generatId().equals(puzzleFin.generatId())) {
                       
                        this.puzzleFin.dibujar();
                        listadoMatrices.add(this.puzzleFin.dibujar());
                        colaAuxiliar.clear();
                        break;
                    }
                    if (!nuevosEstados.get(i).generatId().equals(puzzleInicio.generatId()) && !nodosGenerados.containsKey(nuevosEstados.get(i).generatId())) {
                        colaAuxiliar.add(nuevosEstados.get(i));
                        nodosGenerados.put(nuevosEstados.get(i).generatId(), nuevosEstados.get(i));
                    }
                }
            }
        }
    }

}
