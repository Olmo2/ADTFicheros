package com.olmo.libros;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroRegBinLibro extends FicheroRegLibro {

		
	FileInputStream fichLect1 ;
	DataInputStream fichLect2;
	
	FileOutputStream fos ;
	DataOutputStream dos ;
	
	File fichero;

	public FicheroRegBinLibro() {
		this.fos = null;
		this.dos = null;
		this.fichLect1 = null;
		this.fichLect2 = null;
	}

	public FicheroRegBinLibro(String fich) {
		super(fich);
		this.fos = null;
		this.dos = null;
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
			fichLect1 = new FileInputStream(fichero);
			fichLect2 = new DataInputStream(fichLect1);
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
	@Override
	public boolean abrirFicheroW(boolean append) {

		try {
			fos = new FileOutputStream(fichero, append);
			dos = new DataOutputStream(fos);
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
			fos.close();
			dos.close();
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
		if (fos != null) {
			return true;
		}
		return false;

	}

	// Este m�todo lee tantas l�neas del fichero como campos tenga nuestro registro
	// y las va almacenando
	// en el correspondiente campo del objeto recibido como par�metro. Tiene que
	// realizar la conversi�n de tipo
	// necesaria si alg�n campo no es de tipo String
	// En la lectura de cada l�nea comprobar� que la funci�n de leer no devolvi�
	// null
	// Si alguna lectura de l�nea devuelve null devolveremos false en la funci�n
	// para indicar que no se pudo leer un registro completo
	// En caso contrario devolveremos true
@Override
	public boolean leerRegistro(Libro libro) {
	
		Boolean result  =true;
		
		try {
			libro.setAutor(fichLect2.readUTF());
			libro.setTitulo(fichLect2.readUTF());
			libro.setAnio(fichLect2.readInt());
			libro.setGenero(fichLect2.readUTF());
		} catch (EOFException e ) {
			System.out.println("Fin del fichero");
			result =false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
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
			/*Escribe en el fichero*/
			dos.writeUTF(libro.getAutor());
			dos.writeUTF(libro.getTitulo());
			dos.writeInt(libro.getAnio());
			dos.writeUTF(libro.getGenero());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
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
			while(leerRegistro(libro)) {
				/*Muestra los registros usando como control de bucle el m�todo leer*/
				libro.mostrarInfo();
			}	
	}

	// Recorre el fichero de igual modo que el m�todo anterior pero va contando el
	// n�mero de registros le�dos y al final devuelve el n�mero de registros le�dos
	public int numeroDeRegistros() {
		
		int i=0;
		Libro libro = new Libro();
		abrirFicheroR();
		while(leerRegistro(libro)) {
			/*cuenta los registros usando como control de bucle el m�todo leer*/
			i++;
		}
		
		return i;
		

	}

	

}