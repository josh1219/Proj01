package ex01;


public class MemberDAO {
	
	// List.jsp 출력을 위한 select
	
	// Insert.jsp db에 insert
	public int insertWrite (MemberDTO dto) {
		int result = 0 ; 
		try {
			String query = "INSERT INTO t_member ( "
					+ " id,pwd, name, email, joinDate) "
					+ " VALUES ("
					+ " ?, ?, ?, ?, ?)"; 
			
		psmt = con.prepareStatement(query);  //PareparedStatement 객체 생성 
		
		psmt.setString(1, dto.getName());
		psmt.setString(2, dto.getTitle());
		psmt.setString(3, dto.getContent());
		psmt.setString(4, dto.getOfile());
		psmt.setString(5, dto.getSfile());
		psmt.setString(6, dto.getPass());
		
		result = psmt.executeUpdate();  //insert가 성공일때 result > 0   //DB 에 값을 저장 
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return result; 		// result : Insert 성공시 > 0 , 실패시 : 0 
	}
	
	
	// Delete.jsp db에서 delete
	public int deletePost(String idx) {
		int result = 0 ; 
		
		try {
			String query = "DELETE t_member WHERE id = ?"; 
			psmt = con.prepareStatement(query); 
			psmt.setString(1, idx);
			
			result = psmt.executeUpdate();  //result > 0 삭제 성공, result = 0 : 삭제 실패 
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete 시 예외 발생 ");
		}
				
		return result; 				
	}
}
