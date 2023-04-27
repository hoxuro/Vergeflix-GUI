/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import vergeflix.Media;
import vergeflix.Pelicula;

/**
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class ModeloListaPeliculas extends AbstractTableModel {

    private ArrayList<Pelicula> peliculasCatalogo;
    private String[] columnas = {"Título", "Calificación por edad", "Fecha de incorporación", "Disponibilidad", "Director", "Actor Principal", "Duración", "Temática", "Puntuación"};

    public ModeloListaPeliculas(ArrayList<Pelicula> peliculasCatalogo) {
        this.peliculasCatalogo = peliculasCatalogo;
    }

    public void setCatalogo(ArrayList<Pelicula> peliculasCatalogo) {
        this.peliculasCatalogo = peliculasCatalogo;
    }

    @Override
    public int getRowCount() {
        return this.peliculasCatalogo.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return peliculasCatalogo.get(rowIndex).getNombre();
            }
            case 1 -> {
                return peliculasCatalogo.get(rowIndex).getCalificacionEdad();
            }
            case 2 -> {
                return peliculasCatalogo.get(rowIndex).getFechaIncorporacionAlCatalogo();
            }
            case 3 -> {
                StringBuilder strDisp = new StringBuilder();
                if (peliculasCatalogo.get(rowIndex).getEstaDisponible()) {
                    strDisp.append("Disponible");
                } else {
                    strDisp.append("No disponible");

                }
                return strDisp;
            }
            case 4 -> {
                return peliculasCatalogo.get(rowIndex).getDirector();
            }
            case 5 -> {
                return peliculasCatalogo.get(rowIndex).getActorPrincipal();
            }
            case 6 -> {
                return peliculasCatalogo.get(rowIndex).getDuracion();
            }
            case 7 -> {
                return peliculasCatalogo.get(rowIndex).getCategoria();
            }
            case 8 -> {
                return peliculasCatalogo.get(rowIndex).calcularPuntuacion();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
