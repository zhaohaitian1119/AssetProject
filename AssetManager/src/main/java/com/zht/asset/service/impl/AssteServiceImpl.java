package com.zht.asset.service.impl;

import com.zht.asset.mapper.AsstesMapper;
import com.zht.asset.pojo.Asstes;
import com.zht.asset.pojo.AsstesExample;
import com.zht.asset.service.AssteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-07 17:21
 */
@Service("assteService")
public class AssteServiceImpl implements AssteService {

    @Resource
    AsstesMapper asstesMapper;

    @Override
    public List<Asstes> selByAssteId(String id) {
        AsstesExample example = new AsstesExample();
        if(id != null){
            AsstesExample.Criteria criteria = example.createCriteria();
            criteria.andAssetidLike("%"+id+"%");
        }

        List<Asstes> asstes = asstesMapper.selectByExample(example);
        return asstes;
    }

    @Override
    public int insert(Asstes asstes) {
        int i = asstesMapper.insertSelective(asstes);
        return i;
    }
}
