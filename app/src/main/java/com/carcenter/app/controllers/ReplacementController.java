/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.controllers;

import com.carcenter.app.models.ReplacementModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamar
 */
public class ReplacementController {
    private static List<ReplacementModel> listReplacement = new ArrayList<ReplacementModel>();
    private ReplacementModel replacement = new ReplacementModel();

    public List<ReplacementModel> getListReplacement() {
        return listReplacement;
    }

    public void setListReplacement(List<ReplacementModel> listReplacement) {
        ReplacementController.listReplacement = listReplacement;
    }

    public ReplacementModel getReplacement() {
        return replacement;
    }

    public void setReplacement(ReplacementModel replacement) {
        this.replacement = replacement;
    }
    
    public void addReplacement() {
       ReplacementController.listReplacement.add(this.replacement);
    }
    
    public void isReplacement(ReplacementModel replacement) {
        ReplacementController.listReplacement.remove(replacement);
    }
}
