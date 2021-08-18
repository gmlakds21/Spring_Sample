package kr.spring.sample.excel.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.sample.excel.dao.ExcelDAO;

@Service("excelService")
public class ExcelService {

	@Resource(name="excelDAO")
	private ExcelDAO excelDAO;

	// 검색 조건 읽어오기
	public List<String> readConditionName() {
		return excelDAO.readConditionName();
	}
	public List<String> readConditionAge() {
		return excelDAO.readConditionAge();
	}
	public List<String> readConditionGender() {
		return excelDAO.readConditionGender();
	}
	
	// Ajax 를 통한 정보 읽어오기
	public List<Map<String, Object>> readPerson(Map<String, Object> order) {
		return excelDAO.readPerson(order);
	}

	public int excelUpload(List<Map<String, Object>> datas) {
		int cnt = 0;
		for(Map<String, Object> data : datas) {
			if(excelDAO.excelUpload(data) > 0) {
				cnt++;
			};
		}
		return cnt;
	}

	
}
