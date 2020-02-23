package maquina1995.eureka.cliente.invocador.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AnimeInvocadorControllerImpl implements AnimeInvocadorController {

    /**
     * Objeto de spring usado para hacer llamadas http a un
     * endpoint{@link org.springframework.web.client.RestTemplate}
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se añade
     * el anime pasado como parametro
     * 
     * @param nombreAnime parámetro que sirve para definir el anime que será añadido
     * 
     * @return devueve un booleano con el exito de la operación
     */
    @Override
    @RequestMapping(value = "/addAnime/{nombreAnime}", method = RequestMethod.GET)
    public String annadirAnimePorNombre(@PathVariable String nombreAnime) {

	// la url se resuelve por nombre
	String response = restTemplate.exchange("http://anime-controller/addAnime/" + nombreAnime, HttpMethod.GET, null,
		new ParameterizedTypeReference<String>() {
		}, nombreAnime).getBody();

	return "Anime Añadido:" + response;
    }

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se
     * recuperan todos los animes registrados
     * 
     * @return devuelve una lista de los animes que están registrados
     */
    @Override
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String verAnimes() {

	// la url se resuelve por nombre
	String response = restTemplate.exchange("http://anime-controller/getAll", HttpMethod.GET, null,
		new ParameterizedTypeReference<String>() {
		}, "").getBody();

	return "Lista Animes" + response;
    }

    /**
     * Método usado para llamar al endpoint /addAnime/{nombreAnime} del otro
     * webservice desplegado para hacer un ejemplo de llamada en este caso se
     * limpian todos los animes registrados
     * 
     * @return devueve un booleano con el exito de la operación
     */
    @Override
    @RequestMapping(value = "/removeAll", method = RequestMethod.GET)
    public String eliminarTodo() {

	// la url se resuelve por nombre
	String response = restTemplate.exchange("http://anime-controller/removeAll", HttpMethod.GET, null,
		new ParameterizedTypeReference<String>() {
		}, "").getBody();

	return "Lista Animes Limpiada:" + response;
    }

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
    @Override
    @RequestMapping(value = "/removeAnime/{nombreAnime}", method = RequestMethod.GET)
    public String eliminarPorNombre(@PathVariable String nombreAnime) {

	// la url se resuelve por nombre
	String response = restTemplate.exchange("http://anime-controller/removeAnime" + nombreAnime, HttpMethod.GET,
		null, new ParameterizedTypeReference<String>() {
		}, nombreAnime).getBody();

	return "Anime Eliminado:" + response;
    }

    /**
     * Método usado para definir que este restcontroller use un balanceador de carga
     * 
     * @return retorna el objeto usado para que haga de balanceador de carga
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
	return new RestTemplate();
    }

}
