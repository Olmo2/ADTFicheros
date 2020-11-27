package com.olmo.parte1;

public class Libro {
	
	String autor;
	String titulo;
	String genero;
	Integer anio;

	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
		
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public void mostrarInfo() {
		System.out.println("Autor:" + getAutor());
		System.out.println("Título: " + getTitulo());
		System.out.println("Genero: " + getGenero());
		System.out.println("Año de publicación: " + getAnio());	

		System.out.println("\n");
	}
}
