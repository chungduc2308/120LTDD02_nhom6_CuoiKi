package category;

import java.util.List;

import product.Product;

public class Category {
    private String nameCategory;
    private List<Product> products;

    public Category(String nameCategory, List<Product> products) {
        this.nameCategory = nameCategory;
        this.products = products;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
