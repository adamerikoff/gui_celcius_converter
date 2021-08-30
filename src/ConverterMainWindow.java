import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


enum TYPES { RANKINE, ROMER, DELISLE, CELCIUS, FAHRENHEIT, KELVIN, REAMUR }

public class ConverterMainWindow {
    private JPanel RootPanel;
    private JButton button2;

    private JTextField Rankine;
    private JTextField Romer;
    private JTextField Delisle;
    private JTextField Celcius;
    private JTextField Fahrenheit;
    private JTextField Kelvin;
    private JTextField Reaumur;

    public ConverterMainWindow() {
        button2.addActionListener(e ->Celcius.setText("0"));
        Celcius.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(Celcius.getText().trim().isEmpty()) {

                }
                else {
                    changedUpdate(e);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(Celcius.getText().trim().isEmpty()) {

                }
                else {
                    changedUpdate(e);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Romer.setText(String.valueOf(celcius_converter(Double.parseDouble(Celcius.getText()), TYPES.ROMER)));
                Delisle.setText(String.valueOf(celcius_converter(Double.parseDouble(Celcius.getText()), TYPES.DELISLE)));
                Rankine.setText(String.valueOf(celcius_converter(Double.parseDouble(Celcius.getText()), TYPES.RANKINE)));
                Fahrenheit.setText(String.valueOf(celcius_converter(Double.parseDouble(Celcius.getText()), TYPES.FAHRENHEIT)));
                Kelvin.setText(String.valueOf(celcius_converter(Double.parseDouble(Celcius.getText()), TYPES.KELVIN)));
                Reaumur.setText(String.valueOf(celcius_converter(Double.parseDouble(Celcius.getText()), TYPES.REAMUR)));
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Converter");
        frame.setContentPane(new ConverterMainWindow().RootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static double celcius_converter(double value, TYPES t) {
        double result;
        switch (t) {
            case RANKINE:
                result = (value + 273.15) * 9/5;
                break;
            case DELISLE:
                result = (100 - value) * 3/2;
                break;
            case ROMER:
                result = (value * 21/40) + 7.5;
                break;
            case FAHRENHEIT:
                result = (value * 9/5) + 32;
                break;
            case KELVIN:
                result = value + 273.15;
                break;
            case REAMUR:
                result = value * 4/5;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
