package maquina1995.eureka.cliente.anime.controller;

import java.util.Set;

public interface AnimeController {

    /**
     * Método usado para la exposición de un endpoint usado para añadir un anime
     * pasado como parámetro
     * 
     * @param nombreAnime {@link String} que representa el anime a añadir
     * @return
     */
    Boolean annadirAnimePorNombre(String nombreAnime);

    /**
     * Método usado para la exposición de un endpoint usado para añadir un anime
     * pasado como parámetro
     * 
     * @return {@link Set} de animes añadidos
     */
    Set<String> verAnimes();

    /**
     * Método usado para la exposición de un endpoint usado para eliminar todos los
     * animes
     * 
     */
    void eliminarTodo();

    /**
     * Método usado para la exposición de un endpoint usado para eliminar un anime
     * pasado como parámetro
     * 
     * @param nombreAnime String que representa el anime a borrar
     * 
     * @return
     */
    Boolean eliminarPorNombre(String nombreAnime);

}