/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import vergeflix.Pelicula;
import vergeflix.Serie;

/**
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class ModeloListaSeries extends AbstractTableModel {

    private ArrayList<Serie> seriesCatalogo;
    private String[] columnas = {"Título", "Calificación por edad", "Fecha de incorporación", "Disponibilidad", "Fecha de Estreno", "Temporadas", "Puntuación"};

    public ModeloListaSeries(ArrayList<Serie> seriesCatalogo) {
        this.seriesCatalogo = seriesCatalogo;
    }

    public void setCatalogo(ArrayList<Serie> seriesCatalogo) {
        this.seriesCatalogo = seriesCatalogo;
    }

    @Override
    public int getRowCount() {
        return this.seriesCatalogo.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return seriesCatalogo.get(rowIndex).getNombre();
            }
            case 1 -> {
                return seriesCatalogo.get(rowIndex).getCalificacionEdad();
            }
            case 2 -> {
                return seriesCatalogo.get(rowIndex).getFechaIncorporacionAlCatalogo();
            }
            case 3 -> {
                StringBuilder strDisp = new StringBuilder();
                if (seriesCatalogo.get(rowIndex).getEstaDisponible()) {
                    strDisp.append("Disponible");
                } else {
                    strDisp.append("No disponible");

                }
                return strDisp;
            }
            case 4 -> {
                return seriesCatalogo.get(rowIndex).getFechaEstreno();
            }
            case 5 -> {
                return seriesCatalogo.get(rowIndex).getNumTemporadas();
            }
            case 6 -> {
                return seriesCatalogo.get(rowIndex).calcularPuntuacion();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
