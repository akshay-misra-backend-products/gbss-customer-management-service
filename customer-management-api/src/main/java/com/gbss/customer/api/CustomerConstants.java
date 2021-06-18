package com.gbss.customer.api;

public class CustomerConstants {

    public interface Objects {
        String PRODUCT_CATALOG_MODULE = "603aab93e1d7a507c3ba595a";
    }

    public interface Attributes {
        String USE_AS_FILTER = "5ea84103fd96fbebc61418f3";
        String USE_AS_VARIANT = "6044f400a44bdf5113eae3e0";

    }

    public interface ObjectTypes {
        String CATALOG = "5f417002b04d4e2b37d435ca";
        String PRODUCT_TEMPLATE = "5ff896ed9a7d7231bad64182";
        String PRODUCT = "600310799876702f98e2b883";
    }

    public interface Catalog {

    }

    public interface ProductTemplate {
        String CHARACTERISTICS = "5ff898709a7d7231bad64183";
    }

    public interface Product {
        String PRODUCT_TEMPLATE = "600316ed9876702f98e2b884";
        String CHARACTERISTIC_VALUES = "5ff893fa9a7d7231bad64181";
    }
}
