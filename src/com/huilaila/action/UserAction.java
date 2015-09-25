package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
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
		List<User> _userInDb = (List<User>) userService.findByExample(user);
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
		List<User> _userInDb = (List<User>) userService.findByExample(user);
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
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		pageBean.setLimit(limit = limit == 0 ? 20 : limit);
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

}
