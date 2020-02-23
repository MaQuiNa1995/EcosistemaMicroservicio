package maquina1995.eureka.cliente.invocador.anime.controller;

public interface AnimeInvocadorController {

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se añade
     * el anime pasado como parametro
     * 
     * @param nombreAnime parámetro que sirve para definir el anime que será añadido
     * 
     * @return devueve un booleano con el exito de la operación
     */
    String annadirAnimePorNombre(String nombreAnime);

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se
     * recuperan todos los animes registrados
     * 
     * @return devuelve una lista de los animes que están registrados
     */
    String verAnimes();

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se
     * limpian todos los animes registrados
     * 
     * @return devueve un booleano con el exito de la operación
     */
    String eliminarTodo();

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se
     * elimina el anime pasado como parametro
     * 
     * @param nombreAnime parámetro que sirve para definir el anime que será
     *                    eliminado
     * 
     * @return devueve un booleano con el exito de la operación
     */
    String eliminarPorNombre(String nombreAnime);

}