package recnikGui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import recnik.Recnik;

/**
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class RecnikGuiPanel extends JPanel {

    private Recnik r;
    private JLabel label;
    private JTextField rec;
    private JButton dodajButton, obrisiButton;
    private JTextArea prevodArea;
    private JList lista;
    private DefaultListModel dlm;
    private JScrollPane scrollLista;

    /**
     * Konstruktor panela recnika
     */
    public RecnikGuiPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        label = new JLabel("Унеси енглеску реч:");
        label.setFont(new Font("Sans serif", Font.PLAIN, 12));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 0, 5);
        add(label, gbc);

        rec = new JTextField(14);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(rec, gbc);
        rec.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String trazenaRec = rec.getText();
                int velicina = lista.getModel().getSize();
                String listaSredina = (String) lista.getModel().getElementAt(velicina / 2);

                if (trazenaRec.compareTo(listaSredina) <= 0) {
                    for (int i = 0; i <= velicina / 2; i++) {
                        String recLista = (String) lista.getModel().getElementAt(i);
                        if (trazenaRec.compareTo(recLista) == 0) {

                            prikazPrevoda(recLista);
                            prikazListe(i, velicina);
                        }
                    }
                } else if (trazenaRec.compareTo(listaSredina) > 0) {
                    for (int i = velicina / 2 + 1; i < velicina; i++) {
                        String recLista = (String) lista.getModel().getElementAt(i);
                        if (trazenaRec.compareTo(recLista) == 0) {

                            prikazPrevoda(recLista);
                            prikazListe(i, velicina);

                        }
                    }
                }
            }//kraj metode insertUpdate

            @Override
            public void removeUpdate(DocumentEvent e) {
                String trazenaRec = rec.getText();
                int velicina = lista.getModel().getSize();
                String listaSredina = (String) lista.getModel().getElementAt(velicina / 2);

                if (trazenaRec.compareTo(listaSredina) <= 0) {
                    for (int i = 0; i <= velicina / 2; i++) {
                        String recLista = (String) lista.getModel().getElementAt(i);
                        if (trazenaRec.compareTo(recLista) == 0) {

                            prikazPrevoda(recLista);
                            prikazListe(i, velicina);

                        }
                    }
                } else if (trazenaRec.compareTo(listaSredina) > 0) {
                    for (int i = velicina / 2 + 1; i < velicina; i++) {
                        String recLista = (String) lista.getModel().getElementAt(i);
                        if (trazenaRec.compareTo(recLista) == 0) {

                            prikazPrevoda(recLista);
                            prikazListe(i, velicina);

                        }
                    }
                }
            }//kraj metode removeUpdate

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });//kraj DocumentListener

        dlm = new DefaultListModel();
        r = new Recnik();
        Iterator iter = r.getRecnik().keySet().iterator();
        while (iter.hasNext()) {
            dlm.addElement(iter.next());
        }
        lista = new JList(dlm);

        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String prevod = (String) lista.getSelectedValue();
                prikazPrevoda(prevod);
            }
        });//kraj ListSelectionListener

        scrollLista = new JScrollPane(lista);
        scrollLista.setPreferredSize(new Dimension(158, 170));
        scrollLista.setBorder(BorderFactory.createEtchedBorder());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(scrollLista, gbc);

        dodajButton = new JButton("Додај");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final DodajRecFrame dodajFrame = new DodajRecFrame();
                dodajFrame.setVisible(true);
                dodajFrame.setResizable(false);
                dodajFrame.setLocationRelativeTo(null);
                dodajFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
                Action escapeAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dodajFrame.dispose();
                    }
                };
                dodajFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
                dodajFrame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
            }
        });//kraj dodajButton ActionListener
        dodajButton.setMargin(new Insets(2, 7, 2, 7));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 28, 5, 0);
        add(dodajButton, gbc);

        obrisiButton = new JButton("Уклони");
        obrisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final UkloniRecFrame ukloniFrame = new UkloniRecFrame();
                ukloniFrame.setVisible(true);
                ukloniFrame.setResizable(false);
                ukloniFrame.setLocationRelativeTo(null);
                ukloniFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
                Action escapeAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ukloniFrame.dispose();
                    }
                };
                ukloniFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
                ukloniFrame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
            }
        });//kraj obrisiButton ActionListener
        obrisiButton.setMargin(new Insets(2, 7, 2, 7));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 5, 10);
        gbc.anchor = GridBagConstraints.EAST;
        add(obrisiButton, gbc);

        prevodArea = new JTextArea();
        prevodArea.setEditable(false);
        prevodArea.setLineWrap(true);
        prevodArea.setWrapStyleWord(true);
        gbc.anchor = GridBagConstraints.EAST;
        prevodArea.setBorder(BorderFactory.createEtchedBorder());
        prevodArea.setPreferredSize(new Dimension(158, 170));
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(prevodArea, gbc);

    }//kraj konstruktora RecnikGuiPanel

    /**
     * Metoda koja postavlja prevod reci u gui
     *
     * @param prevod
     */
    public void prikazPrevoda(String prevod) {

        StringBuilder sb = new StringBuilder();
        ArrayList<String> al = (ArrayList<String>) r.getRecnik().get(prevod);
        for (Object o : al) {
            sb.append(o.toString());
            sb.append("\n");
        }
        String prevodReci = sb.toString();
        prevodArea.setText(prevodReci);
    }

    /**
     * Metoda koja, na osnovu reci koja se trazi, prikazuje listu u
     * grafickom korisnickom interfejsu, pri cemu je pronadjena rec i
     * selektovana u listi.
     *
     * @param index
     * @param velicina
     */
    public void prikazListe(int index, int velicina) {

        lista.setSelectedIndex(index);
        if (index >= velicina - 5) {
            lista.ensureIndexIsVisible(velicina - 1);
        } else if (index <= 4) {
            lista.ensureIndexIsVisible(0);
        } else {
            lista.ensureIndexIsVisible(index + 5);
            lista.ensureIndexIsVisible(index - 4);
        }
    }
}//kraj RecnikGuiPanel
