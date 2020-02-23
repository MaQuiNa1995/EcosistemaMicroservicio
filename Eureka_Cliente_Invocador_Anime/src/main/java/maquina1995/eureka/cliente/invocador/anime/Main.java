package maquina1995.eureka.cliente.invocador.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Clase encargada del inicio de la aplicación a traves de springboot y la
 * configuracion necesaria para usar el servidor de discovery
 * 
 * @author MaQuiNa1995
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Main {

    public static void main(String[] args) {
	SpringApplication.run(Main.class, args);
    }
}
