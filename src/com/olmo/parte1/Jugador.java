package com.olmo.parte1;

public class Jugador {
	
	
	String nombre;
	String apellido;
	int dorsal;
	String posicion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	public void mostrarInfo() {
		System.out.println("Nombre:" + getNombre());
		System.out.println("Apellido: " + getApellido());
		System.out.println("Dorsal: " + getDorsal());
		System.out.println("Posición: " + getPosicion());	
		System.out.println("\n");
	}
	
	

}
