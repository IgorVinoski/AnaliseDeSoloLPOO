package view;

import igor.sistemaanalisedesololpoo.Parcela;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class TelaGraficoParcela extends JFrame {

    public TelaGraficoParcela(Parcela parcela) {
        setTitle("Gráfico da Parcela");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criar o dataset do gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(parcela.getPh(), "Parâmetros", "pH");
        dataset.addValue(parcela.getUmidade(), "Parâmetros", "Umidade");

        // Criar o gráfico
        JFreeChart grafico = ChartFactory.createBarChart(
                "Informações da Parcela",          // Título do gráfico
                "Parâmetros",                      // Rótulo do eixo X
                "Valores",                         // Rótulo do eixo Y
                dataset,                           // Dados do gráfico
                PlotOrientation.VERTICAL,          // Orientação do gráfico
                true,                              // Incluir legenda
                true,                              // Tooltips habilitados
                false                              // URLs desabilitados
        );

        // Adicionar o gráfico à janela
        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setMouseWheelEnabled(true);
        setContentPane(chartPanel);
    }
}
