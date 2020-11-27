package com.olmo.jugadores;

import java.io.EOFException;
import java.io.File;

public abstract class FicheroReg {
	File fichero;
	
	
	

	FicheroReg(String fich){
		this.fichero = new File(fich);	    
	}
	
	
	FicheroReg(){		
		this.fichero=null;
	}

	boolean crearFichero(String fich) {	
		
	    this.fichero = new File( "fich" );
	    if (this.fichero==null)
	    		return false;
	    	else return true;
}
	
	boolean ficheroCreado() {
		return this.fichero!=null;
	}
	
	public abstract boolean abrirFicheroR(); //Abre el fichero en modo lectura
	public abstract boolean cerrarFicheroR(); //Cierra el fichero abierto en modo lectura
	public abstract boolean abrirFicheroW(boolean append); //Abre el fichero en modo escritura
	public abstract boolean cerrarFicheroW();  //Cierra el fichero abierto en modo lectura
	public abstract boolean isOpenR(); //Devuelve true si tenemos abierto el fichero en modo lectura y false en caso contrario
	public abstract boolean isOpenW(); //Devuelve true si tenemos abierto el fichero en modo lectura y false en caso contrario
	public abstract boolean leerRegistro(Jugador jugador); //Lee un registro y cierra el fichero
	public abstract boolean escribirRegistro(Jugador jugador); //Escribe en el fichero el registro Jugador
	public abstract void mostrarRegistros(); //Recorre el fichero leyendo los registros y mostrándolos por pantalla
	public abstract int numeroDeRegistros(); //Devuelve el número de registros que tiene el fichero

	
	
	
	
}