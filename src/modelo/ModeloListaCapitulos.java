/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import vergeflix.Capitulo;

/**
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class ModeloListaCapitulos extends AbstractTableModel {

    private ArrayList<Capitulo> capitulos;
    private String[] columnas = {"Nº Capitulo", "Título", "Fecha de Emisión", "Nº Votos Positivos", "Nº Votos Negativos"};

    public ModeloListaCapitulos(ArrayList<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public void setCatalogo(ArrayList<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public int getRowCount() {
        return this.capitulos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return rowIndex + 1;
            }
            case 1 -> {
                return capitulos.get(rowIndex).getTitulo();
            }
            case 2 -> {
                return capitulos.get(rowIndex).getFechaEmision();
            }
            case 3 -> {
                return capitulos.get(rowIndex).getVotosPositivos();
            }
            case 4 -> {
                return capitulos.get(rowIndex).getVotosNegativos();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
