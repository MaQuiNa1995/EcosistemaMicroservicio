package maquina1995.eureka.cliente.anime.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase usada para exponer ciertos endpoints para ser consumidos tanto por
 * navegador como por otro webservice
 * 
 * @author MaQuiNa1995
 *
 */
@RestController
public class AnimeControllerImpl implements AnimeController {

    /**
     * {@link Set} usado para el guardado de los animes que seran añadidos
     */
    private static Set<String> listaAnime;

    static {
	listaAnime = new HashSet<>();
    }

    /**
     * Método usado para la exposición de un endpoint usado para añadir un anime
     * pasado como parámetro
     * 
     * @param nombreAnime {@link String} que representa el anime a añadir
     * @return
     */
    @Override
    @RequestMapping(value = "/addAnime/{nombreAnime}", method = RequestMethod.GET)
    public Boolean annadirAnimePorNombre(@PathVariable String nombreAnime) {

	return listaAnime.add(nombreAnime);
    }

    /**
     * Método usado para la exposición de un endpoint usado para añadir un anime
     * pasado como parámetro
     * 
     * @return {@link Set} de animes añadidos
     */
    @Override
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<String> verAnimes() {

	return listaAnime;
    }

    /**
     * Método usado para la exposición de un endpoint usado para eliminar todos los
     * animes
     * 
     */
    @Override
    @RequestMapping(value = "/removeAll", method = RequestMethod.GET)
    public void eliminarTodo() {

	listaAnime.clear();
    }

    /**
     * Método usado para la exposición de un endpoint usado para eliminar un anime
     * pasado como parámetro
     * 
     * @param nombreAnime String que representa el anime a borrar
     * 
     * @return
     */
    @Override
    @RequestMapping(value = "/removeAnime/{nombreAnime}", method = RequestMethod.GET)
    public Boolean eliminarPorNombre(@PathVariable String nombreAnime) {

	return listaAnime.remove(nombreAnime);
    }
}
