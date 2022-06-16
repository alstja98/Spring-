package com.boot.jdbc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.jdbc.model.dto.MyDto;

@Mapper
public interface MyBoardMapper {
	
	@Select("SELECT MYNO,MYNAME,MYTITLE,MYCONTENT,MYDATE FROM MYBOARD ORDER BY MYNO DESC")
	List<MyDto> selectList();
	
	@Select("SELECT * FROM MYBOARD WHERE MYNO = #{myno} ")
	MyDto selectOne(int myno);
	
	@Select("insert into MYBOARD VALUES(null, #{myname},#{mytitle},#{mycontent}, NOW());")
	int insert(MyDto dto);
	
	@Select("UPDATE ")
	int update(MyDto dto);
}
