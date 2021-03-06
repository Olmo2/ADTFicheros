﻿package com.olmo.jugadores;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroRegTexto extends FicheroReg {

	PrintWriter fichEscr;
	FileWriter fichEscr2;
	FileReader fichLect1;
	BufferedReader fichLect2;
	File fichero = new File("C/:olmo/registro.txt");
	String str;

	public FicheroRegTexto() {
		this.fichEscr = null;
		this.fichEscr2 = null;
		this.fichLect1 = null;
		this.fichLect2 = null;
	}

	public FicheroRegTexto(String fich) {
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
	// Después de cerrarlos les asigna el valor null
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

	// Abre en modo escritura para añadir el fichero indicado en la variable de
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
	// Después de cerrarlos les asigna el valor null
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

	// Este método comprueba si el fichero está abierto para escritura comprobando
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
	 * Este método lee tantas líneas del fichero como campos tenga nuestro registro
	 * y las va almacenando en el correspondiente campo del objeto recibido como
	 * parámetro. Tiene que realizar la conversión de tipo necesaria si algún campo
	 * no es de tipo String En la lectura de cada línea comprobará que la función de
	 * leer no devolvió null Si alguna lectura de línea devuelve null devolveremos
	 * false en la función para indicar que no se pudo leer un registro completo En
	 * caso contrario devolveremos true
	 */

	public boolean leerRegistro(Jugador jugador) {
		Boolean result = true;
		String dorsal="";
		try {
			jugador.setNombre(fichLect2.readLine());
			jugador.setApellido(fichLect2.readLine());
			dorsal = (fichLect2.readLine());
			jugador.setPosicion( fichLect2.readLine());
			jugador.setDorsal(Integer.parseInt(dorsal));
			
			
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

	// Escribe cada uno de los campos del registro pasado como parámetro(objeto
	// Jugador)
	// Devuelve true si se pudo escribir todo el registro y false en caso contrario
	@Override
	public boolean escribirRegistro(Jugador jugador) {
		abrirFicheroW(true);
		Boolean result = true;
		try {
			fichEscr2.write(jugador.getNombre() + "\n");
			fichEscr2.write(jugador.getApellido() + "\n");
			fichEscr2.write(jugador.getDorsal() +"\n" );
			fichEscr2.write(jugador.getPosicion() + "\n");
		} catch (IOException e) {
			result=false;
			e.printStackTrace();
		}

		cerrarFicheroW();

		

		return result;

	}

	// Este método va llamando a leerRegistro
	// En cada registro obtenido invocará al método mostrarDatos para mostrar los
	// datos leídos
	public void mostrarRegistros() {
		abrirFicheroR();
		Jugador jugador = new Jugador();
		while (leerRegistro(jugador)) {
			jugador.mostrarInfo();
		}
		
		cerrarFicheroR();
	}

	// Recorre el fichero de igual modo que el método anterior pero va contando el
	// número de registros leídos y al final devuelve el número de registros leídos
	public int numeroDeRegistros() {
		abrirFicheroR();
		int i=0;
		Jugador jugador = new Jugador();
		while (leerRegistro(jugador)) {
			i++;
		}
		
		cerrarFicheroR();
		return i ;

	}

}