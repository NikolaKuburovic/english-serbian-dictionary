package recnikGui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class OProgramuFrame extends JFrame {

    private JTextPane text;
    private JPanel panel;

    /**
     * Konstruktor okvira u kome se prikazuju osnovne informacije o programu
     */
    public OProgramuFrame() {

        panel = new JPanel();
        panel.setBackground(Color.gray);

        setTitle("О програму");

        text = new JTextPane();
        text.setText("\nЕнглеско-српски речник\n"
                + "----------------------\n\n"
                + "Упутство:\n"
                + "Приликом додавања и уклањања енглеских речи из речника, потребно је\n"
                + "поново покренути програм, чиме ће промене у речнику постати видљиве.\n\n"
                + "Пошто постоји могућност додавања и брисања речи, самим тим, уколико се\n"
                + "обришу све постојеће енглеске речи са њиховим преводима, могуће је од\n"
                + "постојећег речника направити речник било ког језика.\n\n\n"
                + "Опис:\nОвај програм представља пројектни рад из предмета\n"
                + " CS112 Објектно-оријентисано пројектовање и методологија.\n\n"
                + "Аутор програма:\n Никола Кубуровић 1095\n"
                + "Факултет Информационих Технологија, Београд. 2013.\n");
        text.setEditable(false);
        StyledDocument dokument = text.getStyledDocument();
        SimpleAttributeSet centar = new SimpleAttributeSet();
        StyleConstants.setAlignment(centar, StyleConstants.ALIGN_CENTER);
        dokument.setParagraphAttributes(0, dokument.getLength(), centar, false);
        panel.add(text);
        add(panel);
        pack();
    }//kraj konstruktora OProgramuFrame
}//kraj OProgramuFrame
