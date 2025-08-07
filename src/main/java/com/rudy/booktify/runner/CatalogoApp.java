package com.rudy.booktify.runner;

import com.rudy.booktify.model.Libro;
import com.rudy.booktify.repository.LibroRepository;
import com.rudy.booktify.repository.AutorRepository;
import com.rudy.booktify.service.ApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CatalogoApp implements CommandLineRunner {
    private final ApiService apiService;
    private final LibroRepository libroRepo;
    private final AutorRepository autorRepo;

    public CatalogoApp(ApiService apiService, LibroRepository libroRepo, AutorRepository autorRepo) {
        this.apiService = apiService;
        this.libroRepo = libroRepo;
        this.autorRepo = autorRepo;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n📚 BIENVENIDO A BOOKTIFY 📚");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Buscar libros por idioma");
            System.out.println("4. Listar autores");
            System.out.println("5. Autores vivos en un año");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Título del libro: ");
                    String titulo = sc.nextLine();
                    try {

                        Libro libro = apiService.buscarYGuardarLibro(titulo);
                        System.out.println("✔ Libro guardado:");
                        System.out.println(libro);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 2 -> libroRepo.findAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Idioma (ej: en): ");
                    String idioma = sc.nextLine();
                    libroRepo.findByIdioma(idioma).forEach(System.out::println);
                }
                case 4 -> autorRepo.findAll().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Año: ");
                    int año = sc.nextInt(); sc.nextLine();
                    autorRepo.findByNacimientoLessThanEqualAndFallecimientoGreaterThanEqual(año, año)
                            .forEach(System.out::println);
                }
                case 0 -> System.out.println("👋 ¡Hasta luego!");
                default -> System.out.println("⚠ Opción inválida");
            }
        } while (opcion != 0);
    }
}
