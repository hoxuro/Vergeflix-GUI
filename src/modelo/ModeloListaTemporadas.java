/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import vergeflix.Temporada;

/**
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class ModeloListaTemporadas extends AbstractTableModel {

    private ArrayList<Temporada> temporadas;
    private String[] columnas = {"Nº Temporada", "Fecha de Estreno", "Capítulos"};

    public ModeloListaTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public void setCatalogo(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public int getRowCount() {
        return this.temporadas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return rowIndex + 1;
            }
            case 1 -> {
                return temporadas.get(rowIndex).getFechaEstreno();
            }
            case 2 -> {
                return temporadas.get(rowIndex).getNumeroCapitulos();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
