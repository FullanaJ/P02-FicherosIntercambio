package org.ficheros;

import org.ficheros.entities.AtletaFemenina;
import org.ficheros.entities.AtletasFemeninas;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {

        Path path = Path.of(".", "src", "main", "resources", "atletas.xml");

        List<AtletaFemenina> atletas = new ArrayList<>();
        atletas.add(new AtletaFemenina("Ana", List.of("100m", "200m"), 20, "España"));
        atletas.add(new AtletaFemenina("María", List.of("100m", "200m"), 21, "España"));
        atletas.add(new AtletaFemenina("Laura", List.of("100m", "200m"), 22, "España"));
        atletas.add(new AtletaFemenina("Sara", List.of("100m", "200m"), 23, "España"));
        AtletasFemeninas atletasFemeninas = new AtletasFemeninas(atletas);
        AtletasFemeninas.escribirListaObjetosXml(atletasFemeninas, path);
        AtletasFemeninas.leerObjetoXml(path).foreach(System.out::println);
    }
}
