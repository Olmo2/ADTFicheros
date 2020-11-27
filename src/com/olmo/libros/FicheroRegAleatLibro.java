package com.olmo.libros;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FicheroRegAleatLibro extends FicheroRegLibro {

	RandomAccessFile raf;

	File fichero;

	public FicheroRegAleatLibro() {
		this.raf = null;
	}

	public FicheroRegAleatLibro(String fich) {
		super(fich);
		this.raf = null;
		this.fichero = new File(fich);

	}

	// Abre en modo lectura el fichero indicado en la variable fichero
	// Inicializa para ello tanto fichLect1 como fichLect2
	// Devuelve true si se pudieron inicializar los dos correctamente y false en
	// caso contrario
	@Override
	public boolean abrirFicheroR() {
		try {
			raf = new RandomAccessFile(fichero, "r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (raf != null) {
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
			raf.close();
			raf = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	// Abre en modo escritura para a�adir el fichero indicado en la variable de
	// clase fichero
	// Devuelve true si se pudo abrir correctamente y false en caso contrario
	@Override
	public boolean abrirFicheroW(boolean append) {

		try {
			raf = new RandomAccessFile(fichero, "rw");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		if (append) {
			/* Append */
			try {
				raf.seek(fichero.length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;

	}

	// Cierra los objetos de escritura tanto fichEscr1 como fichEscr2
	// Antes de cerrarlos comprueba que no tienen valor null
	// Despu�s de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroW() {

		try {
			raf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean isOpenR() {
		if (raf != null) {
			return true;
		}
		return false;

	}

	// Este m�todo comprueba si el fichero est� abierto para escritura comprobando
	// el valor de la variable fichEscr
	// Si tiene un valor igual a null devuelve false en caso contrario devuelve true
	@Override
	public boolean isOpenW() {
		if (raf != null) {
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

		Boolean result = true;

		try {
			libro.setAutor(raf.readUTF());
			libro.setTitulo(raf.readUTF());
			libro.setAnio(raf.readInt());
			libro.setGenero(raf.readUTF());

		} catch (EOFException e) {
			System.out.println("Fin del fichero");
			result = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block

			result = false;
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

			/* Escribe en el fichero */
			raf.writeUTF(libro.getAutor());
			raf.writeUTF(libro.getTitulo());
			raf.writeInt(libro.getAnio());
			raf.writeUTF(libro.getGenero());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
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
			/* Muestra los registros usando como control de bucle el m�todo leer */
			libro.mostrarInfo();
		}
	}

	// Recorre el fichero de igual modo que el m�todo anterior pero va contando el
	// n�mero de registros le�dos y al final devuelve el n�mero de registros le�dos
	public int numeroDeRegistros() {

		int i = 0;
		Libro libro = new Libro();
		abrirFicheroR();
		while (leerRegistro(libro)) {
			/* cuenta los registros usando como control de bucle el m�todo leer */
			i++;
		}

		return i;

	}

}
