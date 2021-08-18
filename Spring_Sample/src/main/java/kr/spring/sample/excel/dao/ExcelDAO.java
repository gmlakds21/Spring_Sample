package kr.spring.sample.excel.dao;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("excelDAO")
public class ExcelDAO extends EgovAbstractMapper{

	@Resource(name="sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}	
	
	// 검색 조건 읽어오기
	public List<String> readConditionName() {
		return selectList("excelMapper.readConditionName");
	}
	public List<String> readConditionAge() {
		return selectList("excelMapper.readConditionAge");
	}
	public List<String> readConditionGender() {
		return selectList("excelMapper.readConditionGender");
	}

	// Ajax 를 통한 정보 읽어오기
	public List<Map<String, Object>> readPerson(Map<String, Object> order) {
		return selectList("excelMapper.readPerson", order);
	}
	
	
	public int excelUpload(Map<String, Object> data) {
		return insert("excelMapper.excelUpload", data);
	}

}
