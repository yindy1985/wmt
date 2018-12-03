package com.wmt.attendance;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wmt.attendance.dao.HolidayDao;
import com.wmt.attendance.dao.ResultDao;
import com.wmt.attendance.dao.WorkDao;
import com.wmt.attendance.model.Holiday;
import com.wmt.attendance.model.WorkModel;

@Controller
@RequestMapping(value = "/wmt")    
public class WmtController {
	
	@Autowired
	private WorkDao workDao;
	
	@Autowired
	private HolidayDao holidayDao;
	
	@Autowired
	private ResultDao resultDao;
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
    public ModelAndView test(ModelAndView mv) {
		mv.setViewName("/index");
		mv.addObject("title","欢迎使用Thymeleaf!");
		return mv;
    }
	
	/**
	 * 导入加班统计
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/importWork",method = RequestMethod.POST)
    public ModelAndView importWork(ModelAndView mv) {
		try {
			InputStream is = new FileInputStream("/media/yindy/data/wmt/9月研发加班数据.xlsx");
			List inList = new ArrayList();
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
			int totalRows = xssfSheet.getLastRowNum();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE");
			if(totalRows>0) {
				for(int i=1;i<=totalRows;i++) {
					if(i==1)continue;
					WorkModel wm = new WorkModel();
					Row row = xssfSheet.getRow(i);
					String approveId = row.getCell(0).getStringCellValue();
					String commitTime = row.getCell(1).getStringCellValue();
					String empName = row.getCell(2).getStringCellValue();
					String empOrgName = row.getCell(3).getStringCellValue();
					String startTime = row.getCell(6).getStringCellValue();
					String endTime = row.getCell(7).getStringCellValue();
					String workTime = row.getCell(8).getStringCellValue();
					//String workTimeDay[] = workTime.split("天");
					String workTimeDay = StringUtils.substringBefore(workTime, "天"); 
					float workTimeDouble = 0;
					if(null!=workTimeDay&&!"".equals(workTimeDay)&&!workTimeDay.equals(workTime)) {
						workTimeDouble = Float.valueOf(workTimeDay)*24;
						String workTimeHour = StringUtils.substringAfter(workTime, "天"); 
//						String workTimeHour[] = workTimeDay[0].split("小时");
						workTimeHour = StringUtils.substringBefore(workTimeHour, "小时"); 
						if(null!=workTimeHour&&!"".equals(workTimeHour)) {
							workTimeDouble = workTimeDouble+Float.valueOf(workTimeHour);
						}
					}else {
						String workTimeHour = StringUtils.substringBefore(workTime, "小时"); 
						if(null!=workTimeHour&&!"".equals(workTimeHour)) {
							workTimeDouble = Float.valueOf(workTimeHour);
						}
					}
					// 判断工作日 非工作日
/*					Date startTimeDate = sdf.parse(startTime);
					Date endTimeDate = sdf.parse(endTime);
					String currSun = sdfDay.format(startTimeDate);
					if(currSun.indexOf("六")>0||currSun.indexOf("日")>0) {
						long betweenHour = endTimeDate.getTime()-startTimeDate.getTime();
//						long days = betweenHour / (1000 * 60 * 60 * 24);  
//					    long hours = (betweenHour-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
//					    long minutes = (betweenHour-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
						long hours = betweenHour/1000/60/60;
						
					}*/
					
					wm.setApproveId(approveId);
					wm.setCommitTime(sdf.parse(commitTime));
					wm.setEmpName(empName);
					wm.setEmpOrgName(empOrgName);
					wm.setStartTime(sdf.parse(startTime));
					wm.setEndTime(sdf.parse(endTime));
					wm.setWorkTime(workTimeDouble);
					inList.add(wm);
				}
			}
			
			workDao.workBatch(inList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
	
	/**
	 * 导入请假
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/importHoliday",method = RequestMethod.POST)
    public ModelAndView importHoliday(ModelAndView mv) {
		try {
			InputStream is = new FileInputStream("/media/yindy/data/wmt/9月请假数据.xlsx");
			List inList = new ArrayList();
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
			int totalRows = xssfSheet.getLastRowNum();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			SimpleDateFormat sdfA = new SimpleDateFormat("yyyy/MM/dd a");
			SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE");
			if(totalRows>0) {
				for(int i=1;i<=totalRows;i++) {
					if(i==1)continue;
					Holiday wm = new Holiday();
					Row row = xssfSheet.getRow(i);
					String approveId = row.getCell(0).getStringCellValue();
					String commitTime = row.getCell(1).getStringCellValue();
					String empName = row.getCell(2).getStringCellValue();
					String empOrgName = row.getCell(3).getStringCellValue();
					String holidayType = row.getCell(5).getStringCellValue();
					String startTime = row.getCell(6).getStringCellValue();
					String endTime = row.getCell(7).getStringCellValue();
					String holidayTime = row.getCell(8).getStringCellValue();
					String holidayTimeDay = StringUtils.substringBefore(holidayTime, "天"); 
					
					
					wm.setApproveId(approveId);
					wm.setCommitTime(sdf.parse(commitTime));
					wm.setEmpName(empName);
					wm.setEmpOrgName(empOrgName);
					wm.setStartTime(sdfA.parse(startTime));
					wm.setEndTime(sdfA.parse(endTime));
					wm.setHolidayTime(holidayTimeDay);
					wm.setHolidayType(holidayType);
					inList.add(wm);
				}
			}
			holidayDao.delHoliday();
			holidayDao.holidayBatch(inList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
    }
	
	
	/**
	 *  汇总计算
	 */
	@RequestMapping(value = "/generateResult",method = RequestMethod.POST)
	public void generateResult() {
		// 初始化人员名单
		resultDao.deleInitEmpName();
		int initEmpNameCount = resultDao.initEmpName();
		if(initEmpNameCount>0) {
			List<WorkModel> workList = workDao.selectAll();
			if(null!=workList&& workList.size()>0) {
				for(WorkModel workModel:workList) {
					
				}
			}
		}
	}

	
}
