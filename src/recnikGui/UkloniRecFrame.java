package recnikGui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import recnik.Recnik;

/**
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class UkloniRecFrame extends JFrame {

    private JPanel panelRec;
    private JPanel panelButton;
    private JLabel ukloniRec;
    private JTextField ukloniField;
    private JButton buttonUkloni;
    private JButton buttonOdustani;

    /**
     * Konstruktor okvira pomocu kog se uklanjaju reci iz recnika
     */
    public UkloniRecFrame() {

        panelRec = new JPanel();

        setTitle("Уклањање речи");

        panelRec.setLayout(new BoxLayout(panelRec, BoxLayout.PAGE_AXIS));

        ukloniRec = new JLabel("Унеси енглеску реч:");
        ukloniRec.setFont(new Font("Sans serif", Font.PLAIN, 12));
	Border paddingBorder = BorderFactory.createEmptyBorder(0,15,0,0);
	ukloniRec.setBorder(BorderFactory.createCompoundBorder(null, paddingBorder));
        panelRec.add(ukloniRec);

        ukloniField = new JTextField(20);
        panelRec.add(ukloniField);

        panelButton = new JPanel();

        buttonOdustani = new JButton("Одустани");
        buttonOdustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UkloniRecFrame.super.dispose();
            }
        });

        buttonUkloni = new JButton("Уклони");
        buttonUkloni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rec = ukloniField.getText();
                Recnik r = new Recnik();
                r.ukloniRec(rec);
                r.snimiRecnik();
                ukloniField.setText("");
            }
        });

        panelButton.add(Box.createHorizontalGlue());
        panelButton.add(buttonOdustani);
        panelButton.add(buttonUkloni);

        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.LINE_AXIS));

        getContentPane().add(BorderLayout.CENTER, panelRec);
        getContentPane().add(BorderLayout.PAGE_END, panelButton);

        pack();
    }//kraj konstruktora UkloniRecFrame
}//kraj UkloniRecFrame
