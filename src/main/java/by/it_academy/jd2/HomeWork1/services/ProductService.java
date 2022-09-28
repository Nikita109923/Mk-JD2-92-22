package by.it_academy.jd2.HomeWork1.services;

import by.it_academy.jd2.HomeWork1.core.entity.Product;
import by.it_academy.jd2.HomeWork1.services.api.IProductService;
import by.it_academy.jd2.HomeWork1.storage.ProductStorage;
import by.it_academy.jd2.HomeWork1.storage.api.IProductStorage;

import java.util.List;


public class ProductService implements IProductService {
    private static final ProductService instance = new ProductService();
    private final IProductStorage storage;
    private ProductService(){
        this.storage = ProductStorage.getInstance();
    }

    @Override
    public List<Product> get() {
        return  this.storage.get();
    }

    @Override
    public Product get(int id) {
        return this.storage.get(id);
    }

    @Override
    public void validate(Product item) {
        if(item==null){
            throw new IllegalStateException("Вы не передали продукт");
        }

        if(item.getName()==null || item.getName().isBlank()){
            throw new IllegalArgumentException("Вы не передали название продукта");
        }

    }
    public static ProductService getInstance() {
        return instance; }

}
