/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goesta.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@XmlRootElement
public class ZalandoAPIMessageModel {

    private String id;
    private String modelId;
    private String name;
    private String color;
    private boolean available;
    private String season;
    private String activationDate;
    private String shopUrl;

    private List<String> genders;
    private List<String> ageGroups;
    private ZalandoAPIBrand brand;
    private List<String> categoryKeys;
    private List<ZalandoAPIAttributes> attributes;
    private List<ZalandoAPIUnits> units;
    private ZalandoAPIMedia media;

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public List<String> getGenders() {
        return genders;
    }

    public void setGenders(List<String> genders) {
        this.genders = genders;
    }

    public List<String> getAgeGroups() {
        return ageGroups;
    }

    public void setAgeGroups(List<String> ageGroups) {
        this.ageGroups = ageGroups;
    }

    public ZalandoAPIBrand getBrand() {
        return brand;
    }

    public void setBrand(ZalandoAPIBrand brand) {
        this.brand = brand;
    }

    public List<String> getCategoryKeys() {
        return categoryKeys;
    }

    public void setCategoryKeys(List<String> categoryKeys) {
        this.categoryKeys = categoryKeys;
    }

    public List<ZalandoAPIAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ZalandoAPIAttributes> attributes) {
        this.attributes = attributes;
    }

    public List<ZalandoAPIUnits> getUnits() {
        return units;
    }

    public void setUnits(List<ZalandoAPIUnits> units) {
        this.units = units;
    }

    public ZalandoAPIMedia getMedia() {
        return media;
    }

    public void setMedia(ZalandoAPIMedia media) {
        this.media = media;
    }

}
