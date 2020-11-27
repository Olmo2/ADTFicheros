package com.olmo.parte1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroRegBinario extends FicheroRegB {

		
	FileInputStream fichLect1 ;
	DataInputStream fichLect2;
	
	FileOutputStream fos ;
	DataOutputStream dos ;
	
	File fichero;
	Integer i;

	public FicheroRegBinario() {
		this.fos = null;
		this.dos = null;
		this.fichLect1 = null;
		this.fichLect2 = null;
	}

	public FicheroRegBinario(String fich) {
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
	// Después de cerrarlos les asigna el valor null
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

	// Este método comprueba si el fichero está abierto para escritura comprobando
	// el valor de la variable fichEscr
	// Si tiene un valor igual a null devuelve false en caso contrario devuelve true
	@Override
	public boolean isOpenW() {
		if (fos != null) {
			return true;
		}
		return false;

	}

	// Este método lee tantas líneas del fichero como campos tenga nuestro registro
	// y las va almacenando
	// en el correspondiente campo del objeto recibido como parámetro. Tiene que
	// realizar la conversión de tipo
	// necesaria si algún campo no es de tipo String
	// En la lectura de cada línea comprobará que la función de leer no devolvió
	// null
	// Si alguna lectura de línea devuelve null devolveremos false en la función
	// para indicar que no se pudo leer un registro completo
	// En caso contrario devolveremos true

	public boolean leerRegistro(Integer num) {
		abrirFicheroR();
		try {
			num = fichLect2.read();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		cerrarFicheroR();

		if (num == null) {
			return false;
		}

		return true;

	}

	// Escribe cada uno de los campos del registro pasado como parámetro(objeto
	// Jugador)
	// Devuelve true si se pudo escribir todo el registro y false en caso contrario
	@Override
	public boolean escribirRegistro(int num) {
		abrirFicheroW(true);
		
		try {
			dos.writeInt(num);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cerrarFicheroW();

		if (num != 0) {
			return false;
		}

		return true;

	}

	// Este método va llamando a leerRegistro
	// En cada registro obtenido invocará al método mostrarDatos para mostrar los
	// datos leídos
	public void mostrarRegistros() {
		abrirFicheroR();
		Integer num;
			try {
				while (true) {
					
					System.out.println(fichLect2.readInt());
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(numeroDeRegistros());
			}

		cerrarFicheroR();
	}

	// Recorre el fichero de igual modo que el método anterior pero va contando el
	// número de registros leídos y al final devuelve el número de registros leídos
	public int numeroDeRegistros() {
		Integer num;
		int j = 0;
		abrirFicheroR();
		try {
			while ((num = fichLect2.readInt()) != null) {
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return j;
		}

		cerrarFicheroR();
		return j;

	}

}