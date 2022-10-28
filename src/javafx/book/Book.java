package javafx.book;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private String id;
    private String name;
    private String author;
    private String nxb;
    private String type;
    private BigDecimal price;
    private int qty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Book() {
    }

    public Book(String id, String name, String author, String nxb, String type, BigDecimal price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.nxb = nxb;
        this.type = type;
        this.price = price;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return
                "name:'" + name + '\'' +
                ", author:'" + author + '\'' +
                ", nxb:'" + nxb + '\'' +
                ", type:'" + type + '\'' +
                ", price:" + price +
                ", qty:" + qty ;
    }
}
