<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>信快分销平台</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<LINK href="css/global.css" type=text/css rel=STYLESHEET>
		<style type="text/css">
			<!--
			.STYLE1 {
				color: #000000;
				font-weight: bold;
			}
			-->
		</style>
		<script>
			function check(){
				var frm = document.form1;
				if(frm.userName.value==""){
					alert("用户名不能为空!");
					document.form1.userName.focus();
					return false;
				}else if(frm.password.value==""){
				    alert("登录密码不能为空!");
				    frm.password.focus();
				    return false;
				}else {
					return true;
				}
			}
		</script>
	</HEAD>
	<BODY bgColor=#ffffff leftMargin=0 topMargin=0 rightMargin=0
		marginheight="0" marginwidth="0" onload="javascript:document.form1.userName.focus();">
		<CENTER>
			<DIV style="WIDTH: 100%; BACKGROUND-COLOR: #ffffff">
				<IMG height=3 src="images/spacer.gif" width=1>
				<BR>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TBODY>
						<TR>
							<TD vAlign=top align=middle>
								<TABLE id=mouseovers cellSpacing=0 cellPadding=0 width="776"
									border=0>
									<TBODY>
										<TR>
											<TD vAlign=top noWrap align=center height=60></TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD align=middle bgColor=#ffffff colSpan=4 height=3>
								<IMG height=10 src="images/spacer.gif" width=1>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
			<DIV id=content>
				<DIV class=module_darkgray>
					<DIV class=bottomedge_darkgray>
						<DIV class=topleft_darkgray></DIV>
						<DIV class=topright_darkgray></DIV>
						<DIV class=moduleborder>
							<DIV class=module_inset_darkgray>
								<DIV class=bottomedge_inset_darkgray>
									<DIV class=topleft_inset_darkgray></DIV>
									<DIV class=topright_inset_darkgray></DIV>
									<DIV style="LEFT: 735px; PADDING-TOP: 5px; POSITION: absolute">
										<IMG height=24 src="images/2681.jpg" width=28 border=0>
									</DIV>
									<DIV
										style="PADDING-LEFT: 35px; PADDING-BOTTOM: 20px; PADDING-TOP: 40px; align: left">
										<IMG height=60 src="images/2683.jpg" border=0 width=358 >
									</DIV>
									<DIV style="PADDING-RIGHT: 15px; PADDING-LEFT: 35px">
										<TABLE cellSpacing=0 cellPadding=0 width=689 border=0>
											<TBODY>
												<TR>
													<TD style="PADDING-RIGHT: 20px" width=318>
														<TABLE cellSpacing=0 cellPadding=0 border=0>
															<TBODY>
																<TR>
																	<TD style="MARGIN-BOTTOM: 10px" vAlign=top>
																		<strong>用户登录</strong>
																	</TD>
																</TR>
																<TR>
																	<TD class=content_gray_bold>
																		请输入您的用户名和密码登录系统。
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
														<!-- Begin Form -->
														<s:form method="post" action="login.do" name="form1" onsubmit="return check()" theme="simple">
															<TABLE cellSpacing=0 cellPadding=0 width=318 border=0>
																<TBODY>
																	<TR>
																		<TD height=15>
																		</TD>
																	</TR>
																	<TR>
																		<TD align=left>
																			<SPAN class=content_black_bold>用户名</SPAN>
																			<BR>
																			<FONT class=form>
																			<INPUT class=form value="admin"
																					autocomplete="off" style="WIDTH: 250px" maxLength=28 name=userName>
																			</FONT>
																			<!--<input type="checkbox" name="manager" value="true">管理员-->
																			<font color="red"><s:property value="tip" /></font>
																		</TD>
																	</TR>
																	<TR>
																		<TD height=8>
																		</TD>
																	</TR>
																	<TR>
																		<TD align=left>
																			<SPAN class=content_black_bold>密码</SPAN>
																			<BR>
																			<FONT class=form><INPUT class=form value="123456"
																					style="WIDTH: 250px" type="password" maxLength=32 name="password" minlength="6"> </FONT>
																		</TD>
																	</TR>
																	<TR>
																		<TD height=10>
																			<IMG height=10 alt=""
																				src="images/spacer.gif"
																				width=1 border=0>
																		</TD>
																	</TR>
																	<TR>
																		<TD class=content_gray vAlign=top align=left>
																			<A  href="register.jsp">还没注册?</A>
																		</TD>
																	</TR>
																	<TR>
																		<TD noWrap align=right>
																			<span style="padding-right: 20px;"><input type="submit" value="提  交"/></span>
																		</TD>
																	</TR>
																</TBODY>
															</TABLE>
														</s:form>
													</TD>
													<!-- End Form -->
													<TD vAlign=top>
														<TABLE cellSpacing=0 cellPadding=0 border=0>
															<TBODY>
																<TR>
																	<TD style="BACKGROUND-COLOR: #e3e3e3" width=2
																		height=200></TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
													<TD style="PADDING-LEFT: 30px" vAlign=top width=318>
														<!-- Message 2 -->
														<TABLE cellSpacing=0 cellPadding=0 border=0>
															<TBODY>
																<TR>
																	<TD class=content_gray vAlign=top>
																		<IMG height=180 src="images/utsing.gif" width=330>
																		<br/>
																		诚信为本                   服务至上
																		<br />
																		
																		<br />
																		<br />
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</DIV>
								</DIV>
							</DIV>
						</DIV>
					</DIV>
				</DIV>
			</DIV>
			<DIV>
				<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
					<TBODY>
						<TR>
							<TD vAlign=top align=middle width=776>
								信快分销平台
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
			<!-- END content_gray -->
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=middle>
							<FONT class=disclaimer face="Geneva, Verdana, Arial, Helvetica"
								color=#999999 size=1>&nbsp;Producer yeyicheng,liyang</FONT>
							<BR>
							<BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</CENTER>
	</BODY>
</HTML>
