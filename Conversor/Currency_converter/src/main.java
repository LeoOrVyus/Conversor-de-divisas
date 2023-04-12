import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Se crea una instancia de CurrencyRates y se le pasa la clave API y la moneda base
        CurrencyRates currencyRates = new CurrencyRates("API_KEY", "MXN");

        // Se crea una instancia de CurrencyConverterGUI y se le pasa la instancia de CurrencyRates
        CurrencyConverterGUI gui = new CurrencyConverterGUI(currencyRates);

        // Se configura la ventana
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gui.getPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
