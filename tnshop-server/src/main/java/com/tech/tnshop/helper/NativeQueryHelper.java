package com.tech.tnshop.helper;

public class NativeQueryHelper {
    public static String getAllProduct(int index, int limit ,String brandId, String categoryId, String sortByPrice, String sortByCreateDate) {
        StringBuilder sqlNative = new StringBuilder("SELECT * FROM product WHERE ");
        if (StringHelper.isNotEmpty(brandId)) {
            sqlNative.append("brand_id = ").append(brandId);
        }
        if (StringHelper.isNotEmpty(categoryId)) {
            sqlNative.append("category_id = ").append(categoryId);
        }
        if (StringHelper.isNotEmpty(sortByPrice)) {
            sqlNative.append("ORDER BY price_sold ").append(brandId);
        }
        if (StringHelper.isNotEmpty(sortByCreateDate)) {
            sqlNative.append("brand_id = ").append(brandId);
        }
        return "SELECT * FROM orders WHERE user_id = :userId LIMIT :limit OFFSET :index";
    }
}
