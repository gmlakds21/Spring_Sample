package kr.spring.sample.excel.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.sample.excel.dao.SampleDAO;

@Service("sample.Service")
public class SampleService {

	@Resource(name="sample.DAO")
	private SampleDAO sampleDAO;

	// 검색 조건 읽어오기
	public List<String> readConditionName() {
		return sampleDAO.readConditionName();
	}
	public List<String> readConditionAge() {
		return sampleDAO.readConditionAge();
	}
	public List<String> readConditionGender() {
		return sampleDAO.readConditionGender();
	}
	
	// Ajax 를 통한 정보 읽어오기
	public List<Map<String, Object>> readPerson(Map<String, Object> order) {
		return sampleDAO.readPerson(order);
	}

	public int excelUpload(List<Map<String, Object>> datas) {
		int cnt = 0;
		for(Map<String, Object> data : datas) {
			if(sampleDAO.excelUpload(data) > 0) {
				cnt++;
			};
		}
		return cnt;
	}

	
}
