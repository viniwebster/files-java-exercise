package entities;

public class Product {
    private String name;
    private Double price;
    private Integer qtd;

    public Product(String name, Double price, Integer qtd) {
        this.name = name;
        this.price = price;
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getTotal() {
        return qtd;
    }

    public double total() {
        return price * qtd;
    }
}
