package com.huilaila.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Job;
import com.huilaila.po.Tag;
import com.huilaila.po.User;
import com.huilaila.service.IUserService;
import com.huilaila.utils.MyMD5Util;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IUserService userService;

	private User user;

	private boolean success;

	private Page pageBean;

	private String tip;

	private String oldPwd;

	private Tag tag;

	private Job job;

	// 封装上传文件域的属性
	private File avatar;
	// 封装上传文件类型的属性
	private String avatarContentType;
	// 封装上传文件名的属性
	private String avatarFileName;
	// 接受依赖注入的属性
	private String savePath;

	public String uploadAvatar() {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		pageBean = new Page();
		try {
			// 建立文件输出流
			File outFile = new File(getSavePath(), getAvatarFileName() + "_"
					+ java.lang.System.currentTimeMillis());
			fos = new FileOutputStream(outFile);
			// 建立文件上传流
			System.out.println(outFile.getAbsolutePath());
//			System.out.println(getAvatar());
			fis = new FileInputStream(getAvatar());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			// 把头像地址写入数据库
			User currUser = (User) getSession().getAttribute("currUser");
			User u = new User();
			u.setUserId(currUser.getUserId());
			u.setAvatar(outFile.getAbsolutePath());
//			currUser.setAvatar(outFile.getAbsolutePath());
			userService.updateUser(u);
			pageBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println("文件上传失败");
			pageBean.setSuccess(false);
			e.printStackTrace();
		} finally {
			close(fos, fis);
		}
		return SUCCESS;
	}

	/**
	 * 返回上传文件的保存位置
	 * 
	 * @return
	 */
	public String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath("/images");
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	public String logout() {
		getSession().removeAttribute("currUser");
		success = true;
		return SUCCESS;
	}

	public String login() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		// ////////////md5
		user.setPassword(MyMD5Util.getEncryptedPwd(user.getPassword()));
		User _user = userService.login(user);
		System.out.println("===UserAction.login===" + _user);
		if (_user != null) {
			System.out.println("欢迎登陆！！！");
			if (new Integer(0).equals(_user.getType())) {
				this.setTip("admin");// 管理员
			} else {
				this.setTip("user");// 普通用户
			}
			getSession().setAttribute("currUser", _user);
			success = true;
		} else {
			this.setTip("用户名或者密码错误!");
			return INPUT;
		}
		return SUCCESS;
	}

	public String register() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		System.out.println("===UserAction.register===");
		List<User> _userInDb = userService.findByExample(user);
		if (_userInDb != null && !_userInDb.isEmpty()) {
			setTip("用户名已存在！");
			setSuccess(false);
			return SUCCESS;
		}
		user.setPassword(MyMD5Util.getEncryptedPwd(user.getPassword()));
		Long userId = (Long) userService.saveUser(user);
		success = userId != null;
		return SUCCESS;
	}

	public String saveUser() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		System.out.println("===UserAction.register===");
		List<User> _userInDb = userService.findByExample(user);
		if (_userInDb != null && !_userInDb.isEmpty()) {
			setTip("用户名已存在！");
			setSuccess(false);
			return SUCCESS;
		}
		user.setPassword(MyMD5Util.getEncryptedPwd(user.getPassword()));
		Long userId = (Long) userService.saveUser(user);
		success = userId != null;
		return SUCCESS;
	}

	public String findAllUser() {
		System.out.println("===UserAction.findAllUser===");
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
		String start = getRequest().getParameter("start");
		String limit = getRequest().getParameter("limit");
		int startInt = start != null ? Integer.valueOf(start) : 0;
		int limitInt = limit != null ? Integer.valueOf(limit) : 10;
		pageBean.setLimit(limitInt);
		pageBean.setStart(startInt);
		pageBean = userService.findByPage(pageBean);
		pageBean.setSuccess(true);
		return SUCCESS;
	}

	public String findByExample() {
		System.out.println("===UserAction.findByExample===");
		pageBean = new Page();
		List users = userService.findByExample(user);
		if (null == users) {
			success = false;
		} else {
			pageBean.setRoot(users);
			pageBean.setTotalProperty(users.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String findByTag() {
		System.out.println("===UserAction.findByTag===");
		pageBean = new Page();
		List users = userService.findByTag(tag);
		if (null == users) {
			success = false;
		} else {
			pageBean.setRoot(users);
			pageBean.setTotalProperty(users.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String findByJobApplication() {
		System.out.println("===UserAction.findByJobApplication===");
		pageBean = new Page();
		List users = userService.findByJobApplication(job);
		if (null == users) {
			success = false;
		} else {
			pageBean.setRoot(users);
			pageBean.setTotalProperty(users.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteUser() {
		System.out.println("===UserAction.deleteUser===");
		success = userService.deleteUser(user);
		return SUCCESS;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateUser() throws Exception {
		User currUser = (User) getSession().getAttribute("currUser");
		if (currUser == null) {
			setTip("请登录后操作!");
			setSuccess(false);
			return SUCCESS;
		}
		if (user != null) {
			// System.out.println(user.getPassword());
			// System.out.println(oldPwd);
			if (user.getPassword() != null && !user.getPassword().isEmpty()) {
				if (MyMD5Util.validPassword(oldPwd, currUser.getPassword())) {
					user.setPassword(MyMD5Util.getEncryptedPwd(user
							.getPassword()));
					success = userService.updateUser(user);
				} else {
					success = false;
					setTip("登录密码错误!");
				}
			} else {
				success = userService.updateUser(user);
			}
		} else {
			success = false;
		}
		return SUCCESS;
	}

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page page) {
		this.pageBean = page;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public File getAvatar() {
		return avatar;
	}

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

}
