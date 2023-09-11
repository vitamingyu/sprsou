package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository // 가독성을 위해 줌
public class SangpumImpl implements SangpumInter{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SangpumImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Driver file 로딩 실패 : " + e);
			return;
		}
	}
	@Override
	public ArrayList<SangpumDto> selectList() {
			ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
			try {
				// DB는 필요할 때 연결하고 처리가 끝나면 연결을 끊는다.
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","seoho123");
				String sql = "select * from sangdata";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					SangpumDto dto= new SangpumDto();
					dto.setCode(rs.getString("code"));
					dto.setSang(rs.getString("sang"));
					dto.setSu(rs.getString("su"));
					dto.setDan(rs.getString("dan"));
					list.add(dto);
				}
			} catch (Exception e) {
				System.out.println("getDataAll err : "+e);
			}finally {
				try{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
				}
			}
			return list;
	}
}
