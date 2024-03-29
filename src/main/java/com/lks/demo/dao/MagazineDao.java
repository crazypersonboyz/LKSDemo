/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lks.demo.dao;

import com.lks.demo.model.Magazine;
import com.lks.demo.model.SearchGenre;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Neeraj
 */
public interface MagazineDao {
    public Optional <Magazine> addNewMagazine(Magazine magazine);
    public Optional <Magazine> updateMagazine(Magazine magazine);
    public void deleteMagazine(int magazineId);
    public List<Magazine> getAllMagazines();
    public Optional <Magazine> getMagazineById(int magazineId);
    public List<Magazine> findAllGenre(SearchGenre genre);
   
}
