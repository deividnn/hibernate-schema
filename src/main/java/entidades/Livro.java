package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "livro", uniqueConstraints = @UniqueConstraint(name = "uk_book_title_author", columnNames = {"titulo","author_id"}))
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @NaturalId
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "author_id",
            foreignKey = @ForeignKey(name = "fk_book_author_id")
    )
    private Autor autor;

    @ColumnDefault("0.00")
    private Double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
