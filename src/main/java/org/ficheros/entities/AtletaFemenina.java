package org.ficheros.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Getter
@JacksonXmlRootElement(localName = "Atleta")
public class AtletaFemenina {
    @JacksonXmlProperty(isAttribute = true)
    private String nombre;
    @JacksonXmlElementWrapper(localName = "pruebas")
    @JacksonXmlProperty(localName = "prueba")
    private List<String> prueba;
    private int edad;
    private String pais;

    public AtletaFemenina() {
    }

    public AtletaFemenina(String nombre, List<String> prueba, int edad, String pais) {
        this.nombre = nombre;
        this.prueba = prueba;
        this.edad = edad;
        this.pais = pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrueba(List<String> prueba) {
        this.prueba = prueba;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public static void escribirListaObjetosXml(List<AtletaFemenina> atletaFemenina, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), atletaFemenina);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
    public static List<AtletaFemenina> leerObjetoXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "AtletaFemenina{" +
                "nombre='" + nombre + '\'' +
                ", prueba=" + prueba +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                '}';
    }
}
