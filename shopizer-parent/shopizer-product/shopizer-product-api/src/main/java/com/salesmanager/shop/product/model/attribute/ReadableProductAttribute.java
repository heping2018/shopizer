package com.salesmanager.shop.product.model.attribute;

import com.salesmanager.shop.product.model.attribute.api.ProductAttributeEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadableProductAttribute extends ProductAttributeEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private String lang;
    private String code;
    private String type;

    private List<ReadableProductAttributeValue> attributeValues = new ArrayList<ReadableProductAttributeValue>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<ReadableProductAttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<ReadableProductAttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
