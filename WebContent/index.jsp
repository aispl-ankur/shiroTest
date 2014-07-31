<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<stripes:layout-render name="/common.jsp" pageTitle="Layout Test">
	<html>
<head>
<title>My First Stripe</title>
<script type="text/javascript" src="/js/bootstrap.min.js" />
<script type="text/javascript" src="/js/bootstrap.js" />
<link rel="stylesheet" href="/css/bootstrap-theme.css" />
<link rel="stylesheet" href="/css/bootstrap-theme.css.map" />
<link rel="stylesheet" href="/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/bootstrap-theme.css.map" />

</head>
<body style="background-color: grey">



	<stripes:layout-component name="contents">
		<stripes:form beanclass="org.ascent.stripes.action.LoginActionBean"
			focus="">
			<stripes:errors />
			<table align="center">
				<tr>
					<td><h1>Log In</h1></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><stripes:text name="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><stripes:password name="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><stripes:submit name="login" value="Login" />
					</td>
				</tr>
				<%-- <tr>
                <td>Result:</td>
                <td>${actionBean.result}</td>
            </tr> --%>
			</table>
		</stripes:form>
	</stripes:layout-component>
</body>
	</html>
</stripes:layout-render>