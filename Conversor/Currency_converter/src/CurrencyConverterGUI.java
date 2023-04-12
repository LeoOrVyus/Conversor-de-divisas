import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI {
    private CurrencyRates currencyRates;
    private JPanel panel;
    private JLabel fromLabel, toLabel, amountLabel, resultLabel;
    private JTextField amountField;
    private JComboBox<String> fromBox, toBox;
    private JButton convertButton;

    public CurrencyConverterGUI(CurrencyRates currencyRates) {
        this.currencyRates = currencyRates;
        createGUI();
    }

    private void createGUI() {
        panel = new JPanel(new GridLayout(4, 2, 10, 10));
        fromLabel = new JLabel("From Currency:");
        toLabel = new JLabel("To Currency:");
        amountLabel = new JLabel("Amount:");
        resultLabel = new JLabel();
        amountField = new JTextField();
        fromBox = new JComboBox<>(currencyRates.getRates().keySet().toArray(new String[0]));
        toBox = new JComboBox<>(currencyRates.getRates().keySet().toArray(new String[0]));
        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertListener());

        panel.add(fromLabel);
        panel.add(fromBox);
        panel.add(toLabel);
        panel.add(toBox);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(convertButton);
        panel.add(resultLabel);
    }

    public JPanel getPanel() {
        return panel;
    }

    private class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fromCurrency = (String) fromBox.getSelectedItem();
            String toCurrency = (String) toBox.getSelectedItem();
            double amount;

            try {
                amount = Double.parseDouble(amountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double rate = currencyRates.getExchangeRate(fromCurrency, toCurrency);
            double result = amount * rate;

            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
        }
    }
}

