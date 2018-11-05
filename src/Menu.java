import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Jesus Llaya
 */

public class Menu extends JFrame implements ActionListener {

    JMenuBar menubar1;
    JMenu acciones;
    Container contenpane;
    JPanel panelPrincipal;
    JMenuItem anchura, profundidad, comparacion, salir,poisson;
    JButton iniciar;
    JLabel texto;

    public Menu() {
        super("TP-IA-Busquedas No Informadas");
        setBounds(100, 100, 1200, 800);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        menubar1 = new JMenuBar();
        acciones = new JMenu("Acciones");
        anchura = new JMenuItem("Anchura");
        profundidad = new JMenuItem("Profundidad");
        comparacion = new JMenuItem("Comparacion");
        salir = new JMenuItem("Salir");

        salir.setActionCommand("clickSalir");
        salir.addActionListener(this);
        anchura.setActionCommand("clickAnchura");
        anchura.addActionListener(this);
        profundidad.setActionCommand("clickProfundidad");
        profundidad.addActionListener(this);
        comparacion.setActionCommand("clickComparacion");
        comparacion.addActionListener(this);
       
        acciones.add(anchura);
        acciones.add(profundidad);
        acciones.add(comparacion);
        acciones.add(salir);

        menubar1.add(acciones);
        menubar1.add(salir);

        this.setJMenuBar(menubar1);

        texto = new JLabel("Haga click en Acciones");

        panelPrincipal = new JPanel();
        contenpane = getContentPane();
        contenpane.add(panelPrincipal);
        panelPrincipal.add(texto);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del Sistema?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand() == "clickSalir") {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del Sistema?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (evento.getActionCommand() == "clickAnchura") {
            panelPrincipal.removeAll();
            
            Anchura a = new Anchura();
            panelPrincipal.add(a);
            //panelPrincipal.add(p);
            panelPrincipal.updateUI();
            panelPrincipal.repaint();
            //repaint();
            System.out.println("Anchura");

        } else if (evento.getActionCommand() == "clickProfundidad") {
            panelPrincipal.removeAll();
            Profundidad p = new Profundidad();
            panelPrincipal.add(p);
            panelPrincipal.updateUI();
            panelPrincipal.repaint();
            System.out.println("Profundidad");
        } else if (evento.getActionCommand() == "clickComparacion") {

            panelPrincipal.removeAll();
            Comparacion c = new Comparacion();
            panelPrincipal.add(c);
            panelPrincipal.updateUI();
            panelPrincipal.repaint();
            System.out.println("Comparacion");
        }

    }

}
