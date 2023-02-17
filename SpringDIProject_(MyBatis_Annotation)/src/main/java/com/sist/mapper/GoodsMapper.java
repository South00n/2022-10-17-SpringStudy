package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface GoodsMapper {
	@Select("SELECT no, name, price, rownum "
			+ "FROM (SELECT no, goods_name as name, goods_price as price FROM goods_all ORDER BY no ASC) "
			+ "WHERE rownum <=30")
	public List<GoodsVO> goodsListData();
}
