package org.ficheros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Root")
public class AtletasFemeninas {
    @JacksonXmlElementWrapper(localName = "atletasFemeninas")
    @JacksonXmlProperty(localName = "atleta")
    private List<AtletaFemenina> atletasFemeninas;
    public AtletasFemeninas() {
    }
    public AtletasFemeninas(List<AtletaFemenina> atletasFemeninas) {
        this.atletasFemeninas = atletasFemeninas;
    }
    public AtletaFemenina getAtletaFemenina(int i) {
        return atletasFemeninas.get(i);
    }
    public AtletaFemenina setAtletaFemenina(int i, AtletaFemenina atletaFemenina) {
        return atletasFemeninas.set(i, atletaFemenina);
    }
    public void addAtletaFemenina(AtletaFemenina atletaFemenina) {
        atletasFemeninas.add(atletaFemenina);
    }
    public static void escribirListaObjetosXml(AtletasFemeninas atletaFemenina, Path ruta) {

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
    public static AtletasFemeninas leerObjetoXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void foreach(Consumer<? super AtletaFemenina> action) {
        atletasFemeninas.forEach(action);
    }
}
