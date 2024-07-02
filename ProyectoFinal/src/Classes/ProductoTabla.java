package Classes;

public class ProductoTabla {
    
    private String titulo;
    private String autor;
    private String id;
    private String categoria;

    public ProductoTabla(String t, String a, String i, String c) {
        this.titulo = t;
        this.autor = a;
        this.id = i;
        this.categoria = c;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
