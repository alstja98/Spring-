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
	public boolean insert(TestDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement("INSERT INTO TEST_DB VALUES(?,?,?)");
			pstm.setString(1, dto.getName());
			pstm.setInt(2, dto.getAge());
			pstm.setString(3, dto.getAddr());
			System.out.println("03.query준비 ");

			res = pstm.executeUpdate();
			System.out.println("04.query실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		} finally {
			close(pstm);
			System.out.println("05.db 종료");
		}

		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);
		
		return (res>0)?true:false;

	}
	
	public List<TestDto> selectAll(){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<TestDto> res = new ArrayList<TestDto>();
		
		try {
			pstm = con.prepareStatement("SELECT * FROM TEST_DB");
			System.out.println("03.query 준비");
			rs=pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				TestDto dto = new TestDto(rs.getString(1), rs.getInt(2), rs.getString(3));
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
