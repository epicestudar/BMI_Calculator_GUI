import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javafx.event.ActionEvent;

import java.awt.*;

public class Calculadora_IMC extends JPanel {
    public Calculadora_IMC() {
        // criação dos componentes
        JLabel alturaUsuario = new JLabel("Digite sua altura (m): ");
        JLabel pesoUsuario = new JLabel("Digite seu peso (kg): ");
        JTextField campoAltura = new JTextField(10);
        JTextField campoPeso = new JTextField(10);
        JButton botaoCalcular = new JButton("Calcular");
        JLabel resultadoIMC = new JLabel("IMC: ");
        JTextField campoResultado = new JTextField(10);
        JLabel mensagemAbaixoPeso = new JLabel("Abaixo do Peso");
        mensagemAbaixoPeso.setForeground(Color.RED);
        JLabel mensagemPesoIdeal = new JLabel("Peso Ideal");
        mensagemPesoIdeal.setForeground(Color.DARK_GRAY); 
        JLabel mensagemAcimaPeso = new JLabel("Acima do Peso");
        mensagemAcimaPeso.setForeground(Color.BLUE);
        campoResultado.setEditable(false);
        mensagemAbaixoPeso.setVisible(false);
        mensagemPesoIdeal.setVisible(false);
        mensagemAcimaPeso.setVisible(false);

        // Criação dos painéis
        JPanel painelPrincipal = new JPanel(new BorderLayout()); // Border Layout
        JPanel painelBotoes = new JPanel();
        JPanel painelInputs = new JPanel(new GridLayout(2, 2));
        JPanel painelResultado = new JPanel();


        // adicionando os componentes aos painéis
        painelInputs.add(alturaUsuario);
        painelInputs.add(campoAltura);
        painelInputs.add(pesoUsuario);
        painelInputs.add(campoPeso);

        botaoCalcular.setBackground(Color.GREEN);
        painelBotoes.add(botaoCalcular);

        campoResultado.setBorder(new LineBorder(Color.BLACK));

        painelResultado.add(resultadoIMC);
        painelResultado.add(campoResultado);
        painelResultado.add(mensagemAbaixoPeso);
        painelResultado.add(mensagemPesoIdeal);
        painelResultado.add(mensagemAcimaPeso);

        // adicionando os painéis ao painel principal
        painelPrincipal.add(painelInputs, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        painelPrincipal.add(painelResultado, BorderLayout.SOUTH);

        this.add(painelPrincipal);

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double altura = Double.parseDouble(campoAltura.getText());
                    double peso = Double.parseDouble(campoPeso.getText());

                    double imc = peso / (altura * altura);

                    if (imc < 18.5) {
                        mensagemAbaixoPeso.setVisible(true);
                        mensagemPesoIdeal.setVisible(false);
                        mensagemAcimaPeso.setVisible(false);
                        campoResultado.setText(String.format("%.2f", imc, "Você está abaixo do peso"));
                      
                    }

                    else if (imc >= 18.5 && imc <= 24.9) {
                        mensagemAbaixoPeso.setVisible(false);
                        mensagemPesoIdeal.setVisible(true);
                        mensagemAcimaPeso.setVisible(false);
                        campoResultado.setText(String.format("%.2f", imc, "Você está no peso ideal"));
                    }
                    else {
                        mensagemAbaixoPeso.setVisible(false);
                        mensagemPesoIdeal.setVisible(false);
                        mensagemAcimaPeso.setVisible(true);
                        campoResultado.setText(String.format("%.2f", imc, "Você está acima do peso"));
                    }

                    
                } catch (NumberFormatException ex) {
                    campoResultado.setText("Valores inválidos");
                }

            }
        });

    }
}