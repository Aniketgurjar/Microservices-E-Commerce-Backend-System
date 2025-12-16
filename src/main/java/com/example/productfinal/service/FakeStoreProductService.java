package com.example.productfinal.service;

import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.dtos.FakeStoreProductDto;
import com.example.productfinal.models.Category;
import com.example.productfinal.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override


    public Product getProductById(Long id) throws InvalidProductIdException {
        // Call the FakeStore API to get the product with given ID here.
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
if(fakeStoreProductDto==null){
    throw new InvalidProductIdException("");

}
        // Convert fakeStoreProductDto to product object.
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products/",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product updateProduct(Long id,Product p1) {



       Category c1=p1.getCategory();

        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setId(p1.getId());
        fakeStoreProductDto.setTitle(p1.getTitle());
        fakeStoreProductDto.setDescription((p1.getDescription()));
        fakeStoreProductDto.setPrice((float)p1.getPrice());
        fakeStoreProductDto.setImage(p1.getImage());
        fakeStoreProductDto.setCategory(c1.getTitle());

        restTemplate.put("https://fakestoreapi.com/products/{id}", fakeStoreProductDto, p1.getId());

return p1;



    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}

