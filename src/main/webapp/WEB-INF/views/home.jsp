<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>메인페이지</title>
</head>

<body>

	<h1>메인페이지</h1>

	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm" />">로그인</a>
		</p>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="로그아웃" />
		</form:form>
		<p>
			<a href="<c:url value="/loginInfo" />">로그인 정보 확인 방법 3가지</a>
		</p>
		<p>
			principal:
			<sec:authentication property="principal" />
		</p>
		<p>
			<sec:authentication property="principal.username" /> 님, 환영합니다!
		</p>
		<p>
			권한 : <sec:authentication property="principal.authorities" />
		</p>
		<p>
			<sec:authentication property="principal.cart" />
		</p>
		
		<sec:authorize access="hasRole('ADMIN')">
			<p>관리자입니다.</p>
		</sec:authorize>
		
		<sec:authorize access="hasRole('USER')">
			<p>일반 사용자입니다.</p>
		</sec:authorize>
		
	</sec:authorize>

	<h3>
		[<a href="<c:url value="/add/addForm" />">회원가입</a>] [<a
			href="<c:url value="/user/userHome" />">유저 홈</a>] [<a
			href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
	</h3>
</body>
</html>