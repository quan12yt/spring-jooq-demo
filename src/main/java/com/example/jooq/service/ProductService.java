package com.example.jooq.service;

import com.example.jooq.model.Tables;
import com.example.jooq.model.tables.pojos.Product;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    DSLContext dslContext;

    public List<Product> getProducts(){
        return dslContext.selectFrom(Tables.PRODUCT).fetchInto(Product.class);
    }

    public Integer insertProduct(Product product){
        return dslContext.insertInto(Tables.PRODUCT, Tables.PRODUCT.NAME).values(product.getName()).execute();
    }

    public Integer deleteProduct(long id){
        return dslContext.deleteFrom(Tables.PRODUCT).where(Tables.PRODUCT.ID.eq(id)).execute();
    }

    public String updateProducts(Product product){
        return dslContext.update(Tables.PRODUCT)
                .set(Tables.PRODUCT.NAME, product.getName())
                .where(Tables.PRODUCT.ID.eq(product.getId()))
                .returningResult(Tables.PRODUCT.NAME)
                .fetchOne()
                .getValue(Tables.PRODUCT.NAME);
    }

}
