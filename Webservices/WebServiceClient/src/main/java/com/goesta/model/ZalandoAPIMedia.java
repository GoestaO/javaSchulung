/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goesta.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author daniel
 */
@XmlRootElement
public class ZalandoAPIMedia {

    
    List<ZalandoAPIImages> images = new ArrayList<ZalandoAPIImages>();

    public ZalandoAPIMedia() {
    }

    public ZalandoAPIMedia( List<ZalandoAPIImages> images) {
        this.images=images;
    }

    
    public List<ZalandoAPIImages> getImages() {
        return images;
    }

    public void setImages(List<ZalandoAPIImages> images) {
        this.images = images;
    }
    

  
    
    
    
    

}
