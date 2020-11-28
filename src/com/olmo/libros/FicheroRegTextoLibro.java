package com.olmo.libros;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroRegTextoLibro extends FicheroRegLibro {

	PrintWriter fichEscr;
	FileWriter fichEscr2;
	FileReader fichLect1;
	BufferedReader fichLect2;
	File fichero = new File("C/:olmo/registro.txt");
	String str;

	public FicheroRegTextoLibro() {
		this.fichEscr = null;
		this.fichEscr2 = null;
		this.fichLect1 = null;
		this.fichLect2 = null;
	}

	public FicheroRegTextoLibro(String fich) {
		super(fich);
		this.fichEscr = null;
		this.fichEscr2 = null;
		this.fichLect1 = null;
		this.fichLect2 = null;
		this.fichero = new File(fich);
	}

	// Abre en modo lectura el fichero indicado en la variable fichero
	// Inicializa para ello tanto fichLect1 como fichLect2
	// Devuelve true si se pudieron inicializar los dos correctamente y false en
	// caso contrario
	@Override
	public boolean abrirFicheroR() {
		try {
			fichLect1 = new FileReader(fichero);
			fichLect2 = new BufferedReader(fichLect1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (fichLect1 != null && fichLect2 != null) {
			return true;
		}
		return false;

	}

	// Cierra los objetos de lectura tanto fichLect1 como fichLect2
	// Antes de cerrarlos comprueba que no tienen valor null
	// Despu�s de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroR() {
		try {
			fichLect1.close();
			fichLect2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fichLect1 = null;
		fichLect2 = null;

		return true;

	}

	// Abre en modo escritura para a�adir el fichero indicado en la variable de
	// clase fichero
	// Devuelve true si se pudo abrir correctamente y false en caso contrario
	public boolean abrirFicheroW(boolean append) {

		try {
			fichEscr2 = new FileWriter(fichero, append);
			fichEscr = new PrintWriter(fichEscr2, append);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// Cierra los objetos de escritura tanto fichEscr1 como fichEscr2
	// Antes de cerrarlos comprueba que no tienen valor null
	// Despu�s de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroW() {

		try {
			fichEscr.close();
			fichEscr2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean isOpenR() {
		if (fichLect1 != null) {
			return true;
		}
		return false;

	}

	// Este m�todo comprueba si el fichero est� abierto para escritura comprobando
	// el valor de la variable fichEscr
	// Si tiene un valor igual a null devuelve false en caso contrario devuelve true
	@Override
	public boolean isOpenW() {
		if (fichEscr != null) {
			return true;
		}
		return false;

	}

	/*
	 * Este m�todo lee tantas l�neas del fichero como campos tenga nuestro registro
	 * y las va almacenando en el correspondiente campo del objeto recibido como
	 * par�metro. Tiene que realizar la conversi�n de tipo necesaria si alg�n campo
	 * no es de tipo String En la lectura de cada l�nea comprobar� que la funci�n de
	 * leer no devolvi� null Si alguna lectura de l�nea devuelve null devolveremos
	 * false en la funci�n para indicar que no se pudo leer un registro completo En
	 * caso contrario devolveremos true
	 */

	public boolean leerRegistro(Libro libro) {
		Boolean result = true;
		String anio="";
		try {
			libro.setAutor(fichLect2.readLine());
			libro.setTitulo(fichLect2.readLine());
			//anio = (fichLect2.readLine());
			libro.setAnio(Integer.parseInt(fichLect2.readLine()));
			libro.setGenero( fichLect2.readLine());
			
			
			
		} catch (EOFException e) {
			// TODO Auto-generated catch block
		
			System.out.println("Fin de archivo");
			result= false;
		} catch(IOException e) {
			e.printStackTrace();
			result= false;
		} catch(NumberFormatException e) {
			result =false;
			
		}
	
		
		return result;

	}

	// Escribe cada uno de los campos del registro pasado como par�metro(objeto
	// Jugador)
	// Devuelve true si se pudo escribir todo el registro y false en caso contrario
	@Override
	public boolean escribirRegistro(Libro libro) {
		abrirFicheroW(true);
		Boolean result = true;
		try {
			fichEscr2.write(libro.getAutor() + "\n");
			fichEscr2.write(libro.getTitulo() + "\n");
			fichEscr2.write(libro.getAnio() +"\n" );
			fichEscr2.write(libro.getGenero() + "\n");
		} catch (IOException e) {
			result=false;
			e.printStackTrace();
		}

		cerrarFicheroW();

		

		return result;

	}

	// Este m�todo va llamando a leerRegistro
	// En cada registro obtenido invocar� al m�todo mostrarDatos para mostrar los
	// datos le�dos
	public void mostrarRegistros() {
		abrirFicheroR();
		Libro libro = new Libro();
		while (leerRegistro(libro)) {
			libro.mostrarInfo();
		}
		
		cerrarFicheroR();
	}

	// Recorre el fichero de igual modo que el m�todo anterior pero va contando el
	// n�mero de registros le�dos y al final devuelve el n�mero de registros le�dos
	public int numeroDeRegistros() {
		abrirFicheroR();
		int i=0;
		Libro libro = new Libro();
		while (leerRegistro(libro)) {
			i++;
		}
		
		cerrarFicheroR();
		return i ;

	}

}