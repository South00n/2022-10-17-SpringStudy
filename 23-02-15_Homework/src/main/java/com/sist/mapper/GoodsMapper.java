package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface GoodsMapper {
	@Select("SELECT no, goods_name as name, goods_sub, goods_price as price, rownum FROM ${goods_tbl} WHERE rownum <= 30 and no <=30 ORDER BY no")
	public List<GoodsVO> GoodsListData(Map map);
}
