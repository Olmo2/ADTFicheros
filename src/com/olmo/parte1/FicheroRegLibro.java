package com.olmo.parte1;

import java.io.File;

public abstract class FicheroRegLibro {
	File fichero;
	
	
	

	FicheroRegLibro(String fich){
		this.fichero = new File(fich);	    
	}
	
	
	FicheroRegLibro(){		
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
	public abstract boolean leerRegistro(Libro libro); //Lee un registro y cierra el fichero
	public abstract boolean escribirRegistro(Libro libro); //Escribe en el fichero el registro Jugador
	public abstract void mostrarRegistros(); //Recorre el fichero leyendo los registros y mostrándolos por pantalla
	public abstract int numeroDeRegistros(); //Devuelve el número de registros que tiene el fichero

	
	
	
	
}