/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.interfaces;

import com.carcenter.app.models.Element;
import java.util.List;
import javax.ws.rs.client.Client;

/**
 *
 * @author jamar
 */
public interface TransactionDB {
    
    // CRUD
    public List<Element> all();
    public Element get(int id);
    public void create(Element data);
    public void update(Element data);
    public void delete(int id);
    
}
