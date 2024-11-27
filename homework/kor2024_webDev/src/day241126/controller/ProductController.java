package day241126.controller;

import day241126.model.ProductDao;
import day241126.model.ProductDto;

import java.util.ArrayList;

public class ProductController {
    ProductDao productDao = new ProductDao();

    //1. 제품 등록 함수
    public boolean productAdd(String name, int price){
        ProductDto productDto = new ProductDto(name, price);

        return productDao.productAdd(productDto);
    }// productAdd end

    //2. 제품 출력 함수
    public ArrayList<ProductDto> producPrint(){

        return productDao.productPrint();
    }// productPrint end

    //3. 제품 삭제 함수
    public boolean productDelete(int deleteIdx){

        return productDao.productDelete(deleteIdx);
    }// productDelete end

    //4. 제품 수정 함수
    public boolean productUpdate(ProductDto updateDto){

        return productDao.productUpdate(updateDto);
    } // productUpdate end
}
