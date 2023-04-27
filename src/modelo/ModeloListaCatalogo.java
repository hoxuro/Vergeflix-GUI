/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import vergeflix.Media;
import vergeflix.Pelicula;
import vergeflix.Serie;

/**
 *
 * @author amezc
 */
public class ModeloListaCatalogo extends AbstractTableModel {

    private ArrayList<Media> catalogo;
    private String[] columnas = {"Título", "Calificación por edad", "Fecha de incorporación", "Disponibilidad", "Puntuación"};

    public ModeloListaCatalogo(ArrayList<Media> catalogo) {
        this.catalogo = catalogo;
    }

    public void setCatalogo(ArrayList<Media> catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public int getRowCount() {
        return this.catalogo.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return catalogo.get(rowIndex).getNombre();
            }
            case 1 -> {
                return catalogo.get(rowIndex).getCalificacionEdad();
            }
            case 2 -> {
                return catalogo.get(rowIndex).getFechaIncorporacionAlCatalogo();
            }
            case 3 -> {
                StringBuilder strDisp = new StringBuilder();
                if (catalogo.get(rowIndex).getEstaDisponible()) {
                    strDisp.append("Disponible");
                } else {
                    strDisp.append("No disponible");

                }
                return strDisp;
            }
            case 4->{
                return catalogo.get(rowIndex).calcularPuntuacion();
            }
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
