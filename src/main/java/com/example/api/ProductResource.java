package com.example.api;

import com.example.entity.Product;
import com.example.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductService productService;

    @POST
    public void create(Product product) {
        productService.createProduct(product);
    }

    @GET
    @Path("/{id}")
    public Product read(@PathParam("id") Long id) {
        return productService.getProductById(id);
    }

    @GET
    public List<Product> readAll() {
        return productService.getAllProducts();
    }

    @PUT
    public void update(Product product) {
        productService.updateProduct(product);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        productService.deleteProduct(id);
    }
}

