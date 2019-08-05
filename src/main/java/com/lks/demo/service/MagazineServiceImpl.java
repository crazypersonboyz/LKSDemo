/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.demo.service;

import com.lks.demo.dao.MagazineDao;
import com.lks.demo.model.Magazine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Neeraj
 */
@Service("MagazineService")
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    MagazineDao magazineDao;

    @Override
    public Magazine addNewMagazine(Magazine magazine) {
        return magazineDao.addNewMagazine(magazine);
    }

    @Override
    public Magazine updateMagazine(Magazine magazine) {
        return magazineDao.updateMagazine(magazine);
    }

    @Override
    public void deleteMagazine(int magazineId) {
        magazineDao.deleteMagazine(magazineId);
    }

    @Override
    public List<Magazine> getAllMagazines() {
        return magazineDao.getAllMagazines();
    }

    @Override
    public Magazine getMagazineById(int magazineId) {
        return magazineDao.getMagazineById(magazineId);
    }

}
