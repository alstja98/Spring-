package com.test.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dto.TestDto;

public class TestDao {
	
	public List<TestDto> selectAll(){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<TestDto> res = new ArrayList<TestDto>();
		
		try {
			pstm = con.prepareStatement("SELECT * FROM DOG");
			System.out.println("03.query 준비");
			rs=pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				TestDto dto = new TestDto(rs.getString(1), rs.getInt(2), rs.getDate(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getInt(7), rs.getString(8));
				res.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db종료");
		}
		return res;
	}
}
