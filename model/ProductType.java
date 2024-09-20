package model;

import java.lang.annotation.ElementType;

public enum ProductType {
    ELECTRONIC("Electronic"),
    LIBRARY("Library"),
    OTHER("Other");

    String value;

    ProductType(String value){
        this.value = value;
    }
}
