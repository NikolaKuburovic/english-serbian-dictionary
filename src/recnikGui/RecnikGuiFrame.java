package recnikGui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class RecnikGuiFrame extends JFrame {

    private JMenuBar meni;
    private JMenu datoteka, pomoc;
    private JMenuItem unesi, ukloni, zatvori, oProgramu;

    /**
     * Konstruktor okvira recnika
     */
    public RecnikGuiFrame() {
        setTitle("Енглеско-српски речник");
        meni = new JMenuBar();

        datoteka = new JMenu("Датотека");
        unesi = new JMenuItem("Додај нову реч");
        unesi.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.ALT_MASK));
        unesi.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        unesi.addActionListener(new ActionListener() {
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
        });
        ukloni = new JMenuItem("Уклони постојећу реч");
        ukloni.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_U, ActionEvent.ALT_MASK));
        ukloni.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        ukloni.addActionListener(new ActionListener() {
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
        });
        zatvori = new JMenuItem("Затвори");
        zatvori.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, ActionEvent.ALT_MASK));
        zatvori.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        zatvori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        datoteka.add(unesi);
        datoteka.add(ukloni);
        datoteka.add(zatvori);
        meni.add(datoteka);


        pomoc = new JMenu("Помоћ");
        oProgramu = new JMenuItem("О програму");
        oProgramu.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F1, ActionEvent.ALT_MASK));
        oProgramu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final OProgramuFrame oProgramu = new OProgramuFrame();
                oProgramu.setVisible(true);
                oProgramu.setResizable(false);
                oProgramu.setLocationRelativeTo(null);
                oProgramu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
                Action escapeAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        oProgramu.dispose();
                    }
                };
                oProgramu.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
                oProgramu.getRootPane().getActionMap().put("ESCAPE", escapeAction);
            }
        });
        oProgramu.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        pomoc.add(oProgramu);
        meni.add(pomoc);

        setJMenuBar(meni);

        RecnikGuiPanel panel = new RecnikGuiPanel();
        getContentPane().add(BorderLayout.CENTER, panel);
        pack();
    }//kraj konstruktora RecnikGuiFrame
}//kraj RecnikGuiFrame
