package com.rudy.booktify.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rudy.booktify.model.Autor;
import com.rudy.booktify.model.Libro;
import com.rudy.booktify.repository.AutorRepository;
import com.rudy.booktify.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class ApiService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public ApiService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public Libro buscarYGuardarLibro(String titulo) throws Exception {
        Optional<Libro> libroExistente = libroRepository.findByTitulo(titulo);
        if (libroExistente.isPresent()) {
            System.out.println("✔ El libro ya existe en la base de datos:");
            return libroExistente.get();
        }

        String url = "https://gutendex.com/books/?search=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode root = mapper.readTree(response.body());
        JsonNode resultado = root.get("results").get(0);

        Libro libro = new Libro();
        libro.setTitulo(resultado.get("title").asText());
        libro.setIdioma(resultado.get("languages").get(0).asText());
        libro.setDescargas(resultado.get("download_count").asInt());

        JsonNode autorNode = resultado.get("authors").get(0);
        String nombreAutor = autorNode.get("name").asText();

        Optional<Autor> autorExistente = autorRepository.findByNombre(nombreAutor);
        Autor autor = autorExistente.orElseGet(() -> {
            Autor nuevo = new Autor();
            nuevo.setNombre(nombreAutor);
            nuevo.setNacimiento(autorNode.get("birth_year").asInt());
            nuevo.setFallecimiento(autorNode.get("death_year").asInt());
            return autorRepository.save(nuevo);
        });

        libro.setAutor(autor);
        libroRepository.save(libro);

        System.out.println("✔ Libro guardado:");
        return libro;
    }
}
