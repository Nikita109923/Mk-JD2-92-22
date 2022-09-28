package by.it_academy.jd2.HomeWork1.storage;


import by.it_academy.jd2.HomeWork1.core.entity.Product;
import by.it_academy.jd2.HomeWork1.core.entity.ProductBuilder;
import by.it_academy.jd2.HomeWork1.storage.api.IProductStorage;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage implements IProductStorage  {
    private static ProductStorage instance = new ProductStorage();

    private List<Product> data = new ArrayList<>();

    private ProductStorage(){
        this.data.add(ProductBuilder.create()
                .setId(1)
                .setName("Хлеб")
                .setPrice(2)
                .setDiscount(0)
                .setDescription("Пшеничный хлеб")
                .build());

        this.data.add(ProductBuilder.create()
                .setId(2)
                .setName("Сливочное Масло")
                .setPrice(3)
                .setDiscount(0)
                .setDescription("Жирность 72%")
                .build());

        this.data.add(ProductBuilder.create()
                .setId(3)
                .setName("Крассная рыба")
                .setPrice(12)
                .setDiscount(3)
                .setDescription("Лосось соленый")
                .build());

        this.data.add(ProductBuilder.create()
                .setId(4)
                .setName("Сок яблочный")
                .setPrice(4)
                .setDiscount(1)
                .setDescription("Из отборных яблок")
                .build());

        this.data.add(ProductBuilder.create()
                .setId(5)
                .setName("Шоколад")
                .setPrice(3)
                .setDiscount(0)
                .setDescription("Молочный шоколад")
                .build());

    }

    @Override
    public void save(Product item) {
        this.data.add(item);

    }
    @Override
    public List<Product> get() {
        return this.data;
    }

    @Override
    public Product get(int id) {
        return this.data.stream()
                .filter(g -> g.getId() ==id)
                .findFirst()
                .orElse(null);
    }
    public static ProductStorage getInstance(){
        return instance;
    }
}
