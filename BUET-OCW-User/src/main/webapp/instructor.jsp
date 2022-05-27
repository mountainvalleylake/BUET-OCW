<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="DataAccess.DepartmentDAO" %>
<%@ page import="TableObjects.DepartmentObject" %>
<%@ page import="java.util.List" %>
<%@ page import="TableObjects.CourseObject" %><%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 7/9/2017
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <script type="text/javascript" src="js/jquery-1.5.2.js" ></script>
    <script type="text/javascript" src="js/cufon-yui.js"></script>
    <script type="text/javascript" src="js/cufon-replace.js"></script>
    <script type="text/javascript" src="js/Molengo_400.font.js"></script>
    <script type="text/javascript" src="js/Expletus_Sans_400.font.js"></script>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5.js"></script>
    <style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
    <![endif]-->
</head>
<body id = "page1">
<div id="body1">
    <div id="main">
        <nav>
            <ul id="menu">
                <div class = "dropdown">
                    <button class="dropbtn">Departments</button>
                    <div class="dropdown_content">
                        <%
                            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
                            DepartmentDAO departmentDAO = (DepartmentDAO) applicationContext.getBean("departmentDAO");
                            List<DepartmentObject> departmentObjectList = departmentDAO.GetAllDepartments();
                            for(int i = 0; i < departmentObjectList.size(); i++){
                                out.print("<a href=\"department.html?id="+ departmentObjectList.get(i).getDepartment_name() + "\"> " + departmentObjectList.get(i).getDepartment_name() + "</a>");
                            }
                        %>
                    </div>
                </div>
                <div class = "dropdown">
                    <button class="dropbtn">About</button>
                    <div class="dropdown_content">
                        <a href="#">About Us</a>
                        <a href="#">About BUET</a>
                    </div>
                </div>
                <form:form method="post" action="/search.html">
                    <input type="text" placeholder="Search.." id="searchValue" name="searchValue" style="margin-left: 90%; width: 130px; height: 32px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background: white url('/images/searchbar2.png') no-repeat 0 0;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;"/>
                </form:form>
            </ul>
        </nav>
        <!-- header -->
        <header style="margin-left: 10%">
            <div class="wrapper">
                <div class="wrapper">
                    <h1 id = "logo"></h1>
                    <h1 style="font-family: Lucida Bright,serif; color: white; font-size: 40px">${sessionScope.get("Teacher").getTeacher_name()}</h1>
                    <div id="slogan"></div>
                </div>
            </div>
        </header>
        <!-- header -->
    </div>
</div>
<div class="body2">
    <div class="main">
        <!--content-->
        <section id="content">
            <div class="box1">
                <!--User Profile-->
                <div class="wrapper">
                    <h2 style="text-align: center">Teacher Profile</h2>
                    <h3 style="padding-left: 20%">Designation: ${sessionScope.get("Teacher").getDesignation()}</h3>
                    <h3 style="padding-left: 20%">Website: ${sessionScope.get("Teacher").getProfile_link()}</h3>
                </div>
                <!--User Profile-->
                <div class="wrapper">
                    <article class="col1">
                        <div class="pad_left1">
                            <h2>Courses</h2>
                            <table>
                                <!--show list of courses under this teacher-->
                                <%
                                    List<CourseObject> courseObjectList = (List<CourseObject>) session.getAttribute("TeacherCourse");
                                    for(int i = 0; i < courseObjectList.size(); i++) {
                                        out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + courseObjectList.get(i).getCourse_id() + "\"target=\"_blank\">" + courseObjectList.get(i).getCourse_name() + "</a></br>");
                                    }
                                %>
                            </table>
                        </div>
                    </article>
                </div>
            </div>
        </section>
    </div>
    <!--content-->
    </div>
</body>
<form action="${pageContext.request.contextPath}/logout.html" method="post">
    <input type="submit" value="Logout" />
</form>
</html>
