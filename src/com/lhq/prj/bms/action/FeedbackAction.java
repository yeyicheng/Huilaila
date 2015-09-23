package com.lhq.prj.bms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Feedback;
import com.lhq.prj.bms.po.User;

import com.lhq.prj.bms.service.IFeedbackService;

@SuppressWarnings("serial")
public class FeedbackAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IFeedbackService feedbackService;

	private Feedback feedback;

	private boolean success;

	private Page pageBean;

	private Integer page;

	private String pageS;

	private Integer feedbackId;

	private List<Feedback> feedbackst;

	private File excelFile; // 上传的文件
	private String excelFileFileName; // 保存原始文件名

	public String findAllFeedbackByUser() {
		System.out.println("FeedbackAction.findAllFeedbackByUser");
		String strCondition = getRequest().getParameter("conditions");
		List<String> conditions = new ArrayList<String>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		// utf8Conditions.add(getRequest().getParameter("userId"));
		pageBean = new Page();
		User loginUser = (User) getSession().getAttribute("user");
		if (null == loginUser) {
			return ERROR;
		}
		pageBean.setUserId(loginUser.getUserId());
		pageBean.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		pageBean.setStart(++start);
		pageBean.setLimit(limit = limit == 0 ? 20 : limit);
		pageBean = feedbackService.findByPageAndUser(pageBean);
		return SUCCESS;
	}

	/**
	 * 添加反馈
	 * 
	 * @return
	 */
	public String saveFeedback() {
		// freightid=(Integer) freightService.saveFreight(freight);
		feedbackId = (Integer) feedbackService.saveFeedback(feedback);
		if (feedbackId != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * 查找反馈信息
	 * 
	 * @return
	 */
	public String findAllFeedback() {
		System.out.println("===");
		String strCondition = getRequest().getParameter("conditions");
		List<String> conditions = new ArrayList<String>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		List<String> utf8Condition = new ArrayList<String>();
		for (String c : conditions) {
			try {
				utf8Condition
						.add(new String(c.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		pageBean = new Page();
		pageBean.setConditions(utf8Condition);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		pageBean.setStart(++start);
		pageBean.setLimit(limit = limit == 0 ? 20 : limit);
		pageBean = feedbackService.findByPage(pageBean);
		return SUCCESS;
	}

	public String findByExample() {
		User user = (User) getSession().getAttribute("user");
		pageBean = new Page();
		pageBean.setRoot(feedbackService.findByExample(user));
		return SUCCESS;
	}

	/**
	 * 删除反馈
	 * 
	 * @return
	 */
	public String deleteFeedback() {
		success = feedbackService.deleteFeedback(feedbackId);
		return SUCCESS;
	}

	/**
	 * 修改反馈信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateFeedback() throws Exception {

		if (feedback.getFeedbackId() != null) {

			success = feedbackService.updateFeedback(feedback);

		}
		return SUCCESS;
	}

	// 判断文件类型
	public Workbook createWorkBook(InputStream is) throws IOException {
		if (excelFileFileName.toLowerCase().endsWith("xls")) {
			return new HSSFWorkbook(is);
		}
		if (excelFileFileName.toLowerCase().endsWith("xlsx")) {
			return new XSSFWorkbook(is);
		}
		return null;
	}

	public String upload() {
		try {
			Workbook book = createWorkBook(new FileInputStream(excelFile));
			Sheet sheet = book.getSheetAt(0);
			System.out.println(sheet.getLastRowNum());
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				Row ros = sheet.getRow(i);
				if (ros.getCell(0) != null)
					ros.getCell(0).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(1) != null)
					ros.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(2) != null)
					ros.getCell(2).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(3) != null)
					ros.getCell(3).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(4) != null)
					ros.getCell(4).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(5) != null)
					ros.getCell(5).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(6) != null)
					ros.getCell(6).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(7) != null)
					ros.getCell(7).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(8) != null)
					ros.getCell(8).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(9) != null)
					ros.getCell(9).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(10) != null)
					ros.getCell(10).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(11) != null)
					ros.getCell(11).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(12) != null)
					ros.getCell(12).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(13) != null)
					ros.getCell(13).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(14) != null)
					ros.getCell(14).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(15) != null)
					ros.getCell(15).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(16) != null)
					ros.getCell(16).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(17) != null)
					ros.getCell(17).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(18) != null)
					ros.getCell(18).setCellType(HSSFCell.CELL_TYPE_STRING);
				if (ros.getCell(19) != null)
					ros.getCell(19).setCellType(HSSFCell.CELL_TYPE_STRING);
				// 下单日期
				if (ros.getCell(20) != null)
					ros.getCell(20).setCellType(HSSFCell.CELL_TYPE_STRING);

				Feedback bean = new Feedback();
				if (ros.getCell(0) != null)
					bean.setRemarks(ros.getCell(0).getStringCellValue());
				if (ros.getCell(1) != null)
					bean.setDanhao(ros.getCell(1).getStringCellValue());
				if (ros.getCell(2) != null)
					bean.setYunfei(ros.getCell(2).getStringCellValue());
				if (ros.getCell(3) != null)
					bean.setZhekou(ros.getCell(3).getStringCellValue());
				if (ros.getCell(4) != null)
					bean.setJinou(ros.getCell(4).getStringCellValue());
				if (ros.getCell(5) != null)
					bean.setSku(ros.getCell(5).getStringCellValue());
				if (ros.getCell(6) != null)
					bean.setSizeone(ros.getCell(6).getStringCellValue());
				if (ros.getCell(7) != null)
					bean.setSizetwo(ros.getCell(7).getStringCellValue());
				if (ros.getCell(8) != null)
					bean.setNumberl(ros.getCell(8).getStringCellValue());
				if (ros.getCell(9) != null)
					bean.setCommodity(ros.getCell(9).getStringCellValue());
				if (ros.getCell(10) != null)
					bean.setPrice(ros.getCell(10).getStringCellValue());
				if (ros.getCell(11) != null)
					bean.setMethods(ros.getCell(11).getStringCellValue());
				if (ros.getCell(12) != null)
					bean.setAddress(ros.getCell(12).getStringCellValue());
				if (ros.getCell(13) != null)
					bean.setUserName(ros.getCell(13).getStringCellValue());
				if (ros.getCell(14) != null)
					bean.setPhone(ros.getCell(14).getStringCellValue());
				if (ros.getCell(15) != null)
					bean.setZipcode(ros.getCell(15).getStringCellValue());
				if (ros.getCell(16) != null)
					bean.setChannels(ros.getCell(16).getStringCellValue());
				if (ros.getCell(17) != null)
					bean.setLeaf(ros.getCell(17).getStringCellValue());
				if (ros.getCell(18) != null)
					bean.setUserid(ros.getCell(18).getStringCellValue());
				if (ros.getCell(19) != null)
					bean.setDingdanhao(ros.getCell(19).getStringCellValue());
				if (ros.getCell(20) != null)
					bean.setSubmitTime(ros.getCell(20).getStringCellValue());

				feedbackId = (Integer) feedbackService.saveFeedback(bean);
				if (feedbackId != null) {
					success = true;
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public IFeedbackService getFeedbackService() {
		return feedbackService;
	}

	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page pageBean) {
		this.pageBean = pageBean;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getPageS() {
		return pageS;
	}

	public void setPageS(String pageS) {
		this.pageS = pageS;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public List<Feedback> getFeedbackst() {
		return feedbackst;
	}

	public void setFeedbackst(List<Feedback> feedbackst) {
		this.feedbackst = feedbackst;
	}

	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	public String getExcelFileFileName() {
		return excelFileFileName;
	}

	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}

	public static String getSuccessManager() {
		return SUCCESS_MANAGER;
	}

}
