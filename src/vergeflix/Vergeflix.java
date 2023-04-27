/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vergeflix;

import java.util.ArrayList;
import java.util.Scanner;
import funciones.*;
import comparator.*;
import java.io.Serializable;
import java.util.Collections;

/**
 * Permite realizar distintas funciones con películas y series de un catálogo.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class Vergeflix implements Serializable {

    /**
     * Devuelve un ArrayList de peliculas que contiene copias de referencias de
     * las peliculas del catalogo.
     *
     * @param catalogo el catalogo del que vamos a copiar las referencias de las
     * peliculas
     * @param numPeliculas el numero total de peliculas del catalogo
     * @return un ArrayList de tipo Pelicula con copias de referencias de
     * peliculas
     */
    public static ArrayList<Pelicula> peliculasCatalogo(ArrayList<Media> catalogo, int numPeliculas) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        //lo lógico creo que sería copiar las referencias porque no quiero realizar funciones 
        //con copias de peliculas sino con las peliculas del catalogo en si
        for (int indice = 0, contador = 0; indice < catalogo.size() && contador != numPeliculas; indice++) {
            if (catalogo.get(indice) instanceof Pelicula pelicula) {
                listaPeliculas.add(pelicula);
                contador++;
            }
        }
        return listaPeliculas;
    }

    /**
     * Devuelve true si el nombre de una pelicula ya se encuentra en la lista de
     * películas del catálogo.
     *
     * @param listaPeliculas la lista de todas las películas del catálogo
     * @param nombrePelicula el nombre de la pelicula que quermos encontrar
     * @return true si encuentra el nombre
     */
    public static boolean encuentraPelicula(ArrayList<Pelicula> listaPeliculas, String nombrePelicula) {
        boolean laEncuentra = false;

        if (ValidarDatos.validarTitulo(nombrePelicula)) {
            for (int indice = 0; indice < listaPeliculas.size() && !laEncuentra; indice++) {
                laEncuentra = (listaPeliculas.get(indice).getNombre().equalsIgnoreCase(nombrePelicula));
            }
        }

        return laEncuentra;
    }

    /**
     * Devuelve un ArrayList de series que contiene copias de referencias de las
     * series del catalogo.
     *
     * @param catalogo el catalogo del que vamos a copiar las referencias de las
     * series
     * @param numSeries el numero total de series del catalogo
     * @return un ArrayList de tipo Serie con copias de referencias de series
     */
    public static ArrayList<Serie> seriesCatalogo(ArrayList<Media> catalogo, int numSeries) {
        ArrayList<Serie> listaSeries = new ArrayList<>();

        //lo lógico creo que sería copiar las referencias porque no quiero realizar funciones 
        //con copias de series sino con las series del catalogo en si
        for (int indice = 0, contador = 0; indice < catalogo.size() && contador != numSeries; indice++) {
            if (catalogo.get(indice) instanceof Serie serie) {
                listaSeries.add(serie);
                contador++;
            }
        }
        return listaSeries;
    }

    /**
     * Devuelve true si el nombre de una serie ya se encuentra en la lista de
     * series del catálogo.
     *
     * @param listaSeries la lista de todas las series del catálogo
     * @param nombreSerie el nombre de la serie que quermos encontrar
     * @return true si encuentra el nombre
     */
    public static boolean encuentraSerie(ArrayList<Serie> listaSeries, String nombreSerie) {
        boolean laEncuentra = false;

        if (ValidarDatos.validarTitulo(nombreSerie)) {
            for (int indice = 0; indice < listaSeries.size() && !laEncuentra; indice++) {
                laEncuentra = (listaSeries.get(indice).getNombre().equalsIgnoreCase(nombreSerie));
            }
        }

        return laEncuentra;
    }

}
