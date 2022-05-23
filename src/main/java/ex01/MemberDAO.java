package ex01;


public class MemberDAO {
	
	// List.jsp ����� ���� select
	
	// Insert.jsp db�� insert
	public int insertWrite (MemberDTO dto) {
		int result = 0 ; 
		try {
			String query = "INSERT INTO t_member ( "
					+ " id,pwd, name, email, joinDate) "
					+ " VALUES ("
					+ " ?, ?, ?, ?, ?)"; 
			
		psmt = con.prepareStatement(query);  //PareparedStatement ��ü ���� 
		
		psmt.setString(1, dto.getName());
		psmt.setString(2, dto.getTitle());
		psmt.setString(3, dto.getContent());
		psmt.setString(4, dto.getOfile());
		psmt.setString(5, dto.getSfile());
		psmt.setString(6, dto.getPass());
		
		result = psmt.executeUpdate();  //insert�� �����϶� result > 0   //DB �� ���� ���� 
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return result; 		// result : Insert ������ > 0 , ���н� : 0 
	}
	
	
	// Delete.jsp db���� delete
	public int deletePost(String idx) {
		int result = 0 ; 
		
		try {
			String query = "DELETE t_member WHERE id = ?"; 
			psmt = con.prepareStatement(query); 
			psmt.setString(1, idx);
			
			result = psmt.executeUpdate();  //result > 0 ���� ����, result = 0 : ���� ���� 
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete �� ���� �߻� ");
		}
				
		return result; 				
	}
}
