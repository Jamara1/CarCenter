/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.SiteModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamar
 */
public class SiteController {
    private static List<SiteModel> listSite = new ArrayList<SiteModel>();
    private SiteModel site = new SiteModel();

    public List<SiteModel> getListSite() {
        return listSite;
    }

    public void setListSite(List<SiteModel> listSite) {
        SiteController.listSite = listSite;
    }

    public SiteModel getSite() {
        return site;
    }

    public void setSite(SiteModel site) {
        this.site = site;
    }
    
    public void addSite() {
       SiteController.listSite.add(this.site);
    }
    
    public void isSite(SiteModel site) {
        SiteController.listSite.remove(site);
    }
}
