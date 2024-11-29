import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class WindowFrame extends JFrame implements ActionListener {

    private final String URL = "src/icon.png";

    JButton button1, button2, button3, button4;

    JTextField field3;

    JLabel errorTextDivisaoPorZero = new JLabel();
    JLabel errorTextCampoNulo = new JLabel();

    JFormattedTextField fieldOneFormated, fieldTwoFormated;

    Float result;

    public WindowFrame(String title) {

        super(title);

        NumberFormat format = NumberFormat.getNumberInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        fieldOneFormated = new JFormattedTextField(formatter);
        fieldOneFormated.setBounds(20, 40, 350, 50);
        add(fieldOneFormated);

        fieldTwoFormated = new JFormattedTextField(formatter);
        fieldTwoFormated.setBounds(20, 160, 350, 50);
        add(fieldTwoFormated);

        add(errorTextDivisaoPorZero);
        add(errorTextCampoNulo);

        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        button1 = new JButton("+");
        button1.setBounds(0, 362, 100, 100);
        button1.setBackground(new Color(0xF8F6F6));
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("-");
        button2.setBounds(100, 362, 100, 100);
        button2.setBackground(new Color(0xF8F6F6));
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("*");
        button3.setBounds(200, 362, 100, 100);
        button3.setBackground(new Color(0xF8F6F6));
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("/");
        button4.setBounds(300, 362, 100, 100);
        button4.setBackground(new Color(0xF8F6F6));
        button4.addActionListener(this);
        add(button4);

//        field1 = new JTextField();
//        field1.setBounds(20, 40, 350, 50);
//        add(field1);

//        field2 = new JTextField();
//        field2.setBounds(20, 160, 350, 50);
//        add(field2);

        field3 = new JTextField();
        field3.setBounds(20, 280, 350, 50);
        field3.setEditable(false);
        add(field3);

        Image icon = new ImageIcon(URL).getImage();

        setBounds(735, 300, 415, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(icon);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Float n1 = Float.parseFloat(fieldOneFormated.getText()
                .replace(".", "")
                .replace(",", "."));
        Float n2 = Float.parseFloat(fieldTwoFormated.getText()
                .replace(".", "")
                .replace(",", "."));

        if (e.getSource() == button1) {
            result = n1 + n2;
            errorTextDivisaoPorZero.setText(" ");
        } else if (e.getSource() == button2) {
            result = n1 - n2;
            errorTextDivisaoPorZero.setText(" ");
        } else if (e.getSource() == button3) {
            result = n1 * n2;
            errorTextDivisaoPorZero.setText(" ");
        } else if (e.getSource() == button4) {
            try {
                result = n1 / n2;
            } catch (ArithmeticException error) {
                errorTextDivisaoPorZero.setBounds(20, 240, 350, 50);
                errorTextDivisaoPorZero.setText("ERRO! NÃO É POSSÍVEL DIVIDIR POR 0");
            }
        }

        String showResult = String.valueOf(result);
        field3.setText(showResult);
    }
}
