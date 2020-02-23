package maquina1995.eureka.cliente.invocador.anime.info;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de cargar la informacion del microservicio para ser
 * consultada a traves de su endpoint /info enlazado al server de Eureka
 * 
 * @author MaQuiNa1995
 *
 */
@Component
public class InformacionMicroServicio implements InfoContributor {

    /**
     * Método usado para montar la informacion en formato Json del webservice
     * 
     */
    @Override
    public void contribute(Builder builder) {

	// Se pone Map<String, Object> para poder meter un mapa y una String de valor
	// para mas organización de la información
	Map<String, Object> mapainformacion = new TreeMap<>();

	mapainformacion.put("description",
		"Este microservicio es un simple ejemplo de llamada por nombre al de anime para invocar a los endpoints que este expone:");

	Map<String, Object> endPointsMapa = new TreeMap<>();
	endPointsMapa.put("/addAnime/{nombreAnime}", "Te añade un anime");
	endPointsMapa.put("/removeAnime/{nombreAnime}", "Te elimina un anime");
	endPointsMapa.put("/removeAll", "Elimina todos los animes");
	endPointsMapa.put("/getAll", "Te muestra todos los animes registrados");

	mapainformacion.put("endpoints", endPointsMapa);

	// Se crea la información en formato Json
	builder.withDetail("Detalles Microservicio", mapainformacion);

    }

}
