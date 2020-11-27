package com.olmo.libros;

public class Libro {

	String autor;
	String titulo;
	int anio;
	String genero;

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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void mostrarInfo() {
		System.out.println("Autor:" + getAutor());
		System.out.println("Título: " + getTitulo());
		System.out.println("Año de publicación: " + getAnio());
		System.out.println("Genero: " + getGenero());
		System.out.println("\n");
	}
}
