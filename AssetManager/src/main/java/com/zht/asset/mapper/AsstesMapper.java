package com.zht.asset.mapper;

import com.zht.asset.pojo.Asstes;
import com.zht.asset.pojo.AsstesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AsstesMapper {
    int countByExample(AsstesExample example);

    int deleteByExample(AsstesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Asstes record);

    int insertSelective(Asstes record);

    List<Asstes> selectByExample(AsstesExample example);

    Asstes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Asstes record, @Param("example") AsstesExample example);

    int updateByExample(@Param("record") Asstes record, @Param("example") AsstesExample example);

    int updateByPrimaryKeySelective(Asstes record);

    int updateByPrimaryKey(Asstes record);
}