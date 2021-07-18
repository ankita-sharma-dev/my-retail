package com.target.mock.productinfo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.target.mock.productinfo.model.ProductInfo;
import com.target.mock.productinfo.util.FileUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoService {
    public Optional<ProductInfo> findProductInfoById(long prodId){
        TypeReference<List<ProductInfo>> prodInfoListType =
                new TypeReference<List<ProductInfo>>() {
                };

        List<ProductInfo> productInfos =  FileUtil.
                getObjectFromJsonFile("product-info.json", prodInfoListType);
        return productInfos.stream().filter(p-> p.getId() ==  prodId).findFirst();

    }



}
