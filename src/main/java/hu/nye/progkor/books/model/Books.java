package hu.nye.progkor.books.model;

import java.util.Objects;

public class Books {
    private Long id;
    private String name;
    private Kat kat;
    private Hossz hossz;

    public Books() {
    }

    public Books(Long id, String name, Kat kat, Hossz hossz) {
        this.id = id;
        this.name = name;
        this.kat = kat;
        this.hossz = hossz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kat getKat() {
        return kat;
    }

    public void setKat(Kat kat) {
        this.kat = kat;
    }

    public Hossz getHossz() {
        return hossz;
    }

    public void setHossz(Hossz hossz) {
        this.hossz = hossz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id) && Objects.equals(name, books.name) && kat == books.kat && hossz == books.hossz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kat, hossz);
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kat=" + kat +
                ", hossz=" + hossz +
                '}';
    }
}
