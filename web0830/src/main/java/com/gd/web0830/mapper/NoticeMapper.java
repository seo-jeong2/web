package com.gd.web0830.mapper;

import java.util.List;
import java.util.Map;

import com.gd.web0830.vo.Notice;

public interface NoticeMapper {

	
	
	List<Notice> selectNoticeList(Map<String,Object> map);

}
