package com.olmo.parte1;

public class Main {

	public static void main(String[] args) {
		Integer valor = null;
		
		Jugador jugador = new Jugador();
		jugador.setNombre("Manolo");
		jugador.setApellido("Fdez");
		jugador.setDorsal(19);
		jugador.setPosicion("Algo");

		Libro libro = new Libro();
		libro.setAutor("Miguel de Cervantes");
		libro.setTitulo("El Quijote");
		libro.setGenero("Novela");
		libro.setAnio(1605);

		// Jugadores
//		String ruta = "C:\\Users\\OLMO\\jugadores.txt";
//		FicheroRegTexto fich = new FicheroRegTexto(ruta);
//		fich.escribirRegistro(jugador);
//		fich.mostrarRegistros();
//		System.out.println("\nNúmero de registros: " + fich.numeroDeRegistros());

		// Libros
//		  String ruta = "C:\\Users\\OLMO\\libros.txt"; 
//		  FicheroRegTextoLibro fichL = new FicheroRegTextoLibro(ruta);
//		  fichL.escribirRegistro(libro); fichL.leerRegistro(libro);
//		  fichL.mostrarRegistros(); System.out.println("\nNúmero de registros: " +  fichL.numeroDeRegistros());

		// Números
		String ruta = "C:\\Users\\OLMO\\binarios.dat";
		FicheroRegBinario fichB = new FicheroRegBinario(ruta);

		fichB.escribirRegistro(12);
		//fichB.leerRegistro(valor);
		fichB.mostrarRegistros();
		//System.out.println("\nNúmero de registros: " + fichB.numeroDeRegistros());

	}

}
