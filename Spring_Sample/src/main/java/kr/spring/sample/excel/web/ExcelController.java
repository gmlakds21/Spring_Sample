package kr.spring.sample.excel.web;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.spring.sample.excel.service.ExcelService;
import kr.spring.sample.excel.util.DataUtil;
import kr.spring.sample.excel.util.ExcelUtil;

@RequestMapping(value="/excel")
@Controller
public class ExcelController {
	
	@Resource(name = "excelService")
	private ExcelService excelService;
	
	@RequestMapping("/main.do")
	public String main(Model model) {
		model.addAttribute("names", excelService.readConditionName());
		model.addAttribute("ages", excelService.readConditionAge());
		model.addAttribute("genders", excelService.readConditionGender());
		return "/excel/main";
	}
	
	// Ajax 를 통한 정보 읽어오기
	@ResponseBody
	@RequestMapping("/readPerson.do")
	public List<Map<String, Object>> readPerson(HttpServletRequest request) {
		// DataUtil 을 통해 Map 으로 변환
		Map<String, Object> param = DataUtil.getParameter(request.getParameterMap());
		List<Map<String, Object>> datas = excelService.readPerson(param);
		return datas;
	}
	
	// Excel 파일 다운로드
	@RequestMapping("/writeExcel.do")
	public void writeExcel(Map<String, Object> param, HttpServletResponse res) {
		List<Map<String, Object>> datas = excelService.readPerson(param);
		try {
			/* res.setContentType("application/json; charset=UTF-8"); */
			res.setHeader("Content-Disposition", "Attachment; Filename="+URLEncoder.encode("TestDownLoad01", "UTF-8")+".xlsx");
			ExcelUtil.writeExcel(datas, res.getOutputStream());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Excel 파일 업로드
	@RequestMapping("/readExcel.do")
	public List<Map<String, Object>> readExcel(MultipartHttpServletRequest mRequest) {
		List<Map<String, Object>> datas = ExcelUtil.readFile(mRequest);
		return datas;
	}
	
	// 신규 Excel 정보 추가
	@RequestMapping("/writePerson.do")
	public String writePerson( ) {
		List<Map<String, Object>> datas = null;
		excelService.excelUpload(datas);
		return "/excel/main";
	}
}
