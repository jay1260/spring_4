package com.it.gb4.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.it.gb4.member.memberFile.MemberFileDAO.";
	
	// setInsert
	public int setInsert(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", memberFileDTO);
	}
	
	public MemberFileDTO getOne(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getOne",memberFileDTO);
	}

}
