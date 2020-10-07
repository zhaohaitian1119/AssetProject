package com.zht.asset.service;

import com.zht.asset.pojo.Asstes;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-07 17:20
 */

public interface AssteService {
    List<Asstes> selByAssteId(String id);
    int insert(Asstes asstes);
}
