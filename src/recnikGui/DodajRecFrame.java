package recnikGui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import recnik.Recnik;

/**
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class DodajRecFrame extends JFrame {

    private JPanel panelDodaj;
    private JPanel panelSnimi;
    private JLabel unesiRec;
    private JLabel prevediRec;
    private JTextField dodatnaRec;
    private JTextArea prevodReci;
    private JScrollPane scroll;
    private JButton buttonSnimi;
    private JButton buttonOdustani;

    /**
     * Konstruktor okvira pomocu kog se dodaju reci i prevodi u recnik
     */
    public DodajRecFrame() {

        panelDodaj = new JPanel();

        setTitle("Додавање речи");

        panelDodaj.setLayout(new BoxLayout(panelDodaj, BoxLayout.PAGE_AXIS));

        unesiRec = new JLabel("Унеси енглеску реч:");
        unesiRec.setFont(new Font("Sans serif", Font.PLAIN, 12));
        panelDodaj.add(unesiRec);

        dodatnaRec = new JTextField(20);
        panelDodaj.add(dodatnaRec);

        prevediRec = new JLabel("Унеси српски превод:");
        prevediRec.setFont(new Font("Sans serif", Font.PLAIN, 12));
        panelDodaj.add(prevediRec);

        prevodReci = new JTextArea(6, 20);
        prevodReci.setLineWrap(true);
        prevodReci.setWrapStyleWord(true);

        scroll = new JScrollPane(prevodReci);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelDodaj.add(scroll);

        panelSnimi = new JPanel();

        buttonOdustani = new JButton("Одустани");
        buttonOdustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajRecFrame.super.dispose();
            }
        });
        
        buttonSnimi = new JButton("Додај");
        buttonSnimi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recnik r = new Recnik();
                r.unesiRec(dodatnaRec.getText(), prevodReci.getText());
                r.snimiRecnik();
                dodatnaRec.setText("");
                prevodReci.setText("");
            }
        });

        panelSnimi.add(Box.createHorizontalGlue());
        panelSnimi.add(buttonOdustani);
        panelSnimi.add(buttonSnimi);

        panelSnimi.setLayout(new BoxLayout(panelSnimi, BoxLayout.LINE_AXIS));

        getContentPane().add(BorderLayout.CENTER, panelDodaj);
        getContentPane().add(BorderLayout.PAGE_END, panelSnimi);

        pack();
    }//kraj konstruktora DodajRecFrame
}//kraj DodajRecFrame
