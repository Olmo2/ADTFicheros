package com.olmo.principal;

import com.olmo.jugadores.FicheroRegAleat;
import com.olmo.jugadores.Jugador;
import com.olmo.libros.Libro;

public class Main {

	public static void main(String[] args) {
		Integer valor = null;

		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador.setNombre("Olmo");
		jugador.setApellido("Tamargo");
		jugador.setDorsal(73);
		jugador.setPosicion("Banquilo");

		Libro libro = new Libro();
		libro.setAutor("Miguel de Cervantes");
		libro.setTitulo("El Quijote");
		libro.setGenero("Novela");
		libro.setAnio(1605);

		// Jugadores
//		String ruta = "C:\\olmo\\jugadore.txt";
//		FicheroRegTexto fich = new FicheroRegTexto(ruta);
//	
//		fich.escribirRegistro(jugador);
//		fich.mostrarRegistros();
//		System.out.println("\nNúmero de registros: " + fich.numeroDeRegistros());

		// Jugadores
		String ruta = "C:\\olmo\\jugadores.dat";
		FicheroRegAleat fichA = new FicheroRegAleat(ruta);

		fichA.escribirRegistro(jugador);
		fichA.mostrarRegistros();
		System.out.println("\nNúmero de registros: " + fichA.numeroDeRegistros());

		// Libros
//		  String ruta = "C:\\Users\\OLMO\\libros.txt"; 
//		  FicheroRegTextoLibro fichL = new FicheroRegTextoLibro(ruta);
//		  fichL.escribirRegistro(libro); fichL.leerRegistro(libro);
//		  fichL.mostrarRegistros(); System.out.println("\nNúmero de registros: " +  fichL.numeroDeRegistros());

		// Binarios
//		String ruta = "C:\\olmo\\binarios.dat";
//		FicheroRegBinario fichB = new FicheroRegBinario(ruta);
//
//		//fichB.escribirRegistro(jugador);
//		fichB.abrirFicheroR();
//		//fichB.leerRegistro(jugador2);
//		fichB.mostrarRegistros();
//		
//		System.out.println("\nNúmero de registros: " + fichB.numeroDeRegistros());
	}

}
