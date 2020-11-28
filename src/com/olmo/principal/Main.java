package com.olmo.principal;

import com.olmo.jugadores.FicheroRegAleat;
import com.olmo.jugadores.FicheroRegBin;
import com.olmo.jugadores.FicheroRegTexto;
import com.olmo.jugadores.Jugador;
import com.olmo.libros.FicheroRegAleatLibro;
import com.olmo.libros.FicheroRegBinLibro;
import com.olmo.libros.FicheroRegTextoLibro;
import com.olmo.libros.Libro;

public class Main {

	public static void main(String[] args) {
		
		Jugador jugador = new Jugador();
		
		jugador.setNombre("Andrés");
		jugador.setApellido("Iniesta Luján");
		jugador.setDorsal(8);
		jugador.setPosicion("Centrocampista");

		Libro libro = new Libro();
		
		libro.setAutor("Miguel de Cervantes");
		libro.setTitulo("El Quijote");
		libro.setGenero("Novela");
		libro.setAnio(1605);
		
		String ruta = "C:\\Users\\OLMO\\ADTEjercicios\\jugadores.txt";
		

		// Jugadores Texto
		FicheroRegTexto fich = new FicheroRegTexto(ruta);
		fich.escribirRegistro(jugador);
		fich.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fich.numeroDeRegistros());
		
		
		// Jugadores Binarios
		FicheroRegBin fichB = new FicheroRegBin(ruta);

		fichB.escribirRegistro(jugador);
		fichB.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fichB.numeroDeRegistros());

		
		// Jugadores Aleatorio
		FicheroRegAleat fichA = new FicheroRegAleat(ruta);
		fichA.escribirRegistro(jugador);
		fichA.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fichA.numeroDeRegistros());
		

		
		// Libros Texto
		FicheroRegTextoLibro fichL = new FicheroRegTextoLibro(ruta);
		fichL.escribirRegistro(libro);
		fichL.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fichL.numeroDeRegistros());

		// Libros Binarios
		FicheroRegBinLibro fichBL = new FicheroRegBinLibro(ruta);

		fichBL.escribirRegistro(libro);
		fichBL.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fichBL.numeroDeRegistros());
		
		// libros Aleatorio
		FicheroRegAleatLibro fichAL = new FicheroRegAleatLibro(ruta);
		fichAL.escribirRegistro(libro);
		fichAL.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fichAL.numeroDeRegistros());

		
	}

}
