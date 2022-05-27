<%@ page import="DataAccess.DepartmentDAO" %>
<%@ page import="TableObjects.CourseAdminObject" %>
<%@ page import="TableObjects.DepartmentObject" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.List" %>
<%@ page import="TableObjects.AdminPanelObject" %>
<%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 5/18/2017
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BUET Open Courseware</title>
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
<div id = "body1">
    <div id = "main">
        <!-- header -->
        <header style="margin-left: 20%">
            <div class="wrapper">
                <nav>
                    <ul id="menu">
                        <li><a href="#">About</a></li>
                        <li><a href="#">Departments</a></li>
                        <li><a href="#">Programs</a></li>
                        <li><a href="#">Teachers</a></li>
                        <li><a href="#">Admissions</a></li>
                        <li class="end"><a href="#">Contacts</a></li>
                    </ul>
                </nav>
                <div class="wrapper">
                    <h1 id = "logo">BUET OPEN COURSEWARE</h1>
                    <div id="slogan">We Will Open The World<span>of knowledge for you!</span></div>
                </div>
            </div>
        </header>
        <!-- / header -->
    </div>
</div>
<div class="body2">
    <div class="main">
        <!-- content -->
        <section id = "content">
            <div class="box1">
                <!--User Profile-->
                <div class="wrapper">
                    <h2 style="text-align: center">User Profile</h2>
                    <h3 style="padding-left: 20%">Name: ${sessionScope.get("Admin").getAdmin_name()}</h3>
                    </div>
                <!--User Profile-->
                <div class="wrapper">
                    <article class="col1">
                        <div class="pad_left1">
                            <h2>My Course List</h2>
                            <table>
                                <%
                                    List<CourseAdminObject> s = (List<CourseAdminObject>) session.getAttribute("CoursesAdmin");
                                        System.out.println("size is "+s.size());
                                        for (int i = 0; i < s.size(); i++) {
                                            out.print("<a href=\"courses.html?id=" + s.get(i).getCourse_id() + "\">" + s.get(i).getCourse_id() + "</a><br>");
                                            System.out.println(s.get(i).getCourse_id());

                                        }

                                %>
                            </table>
                            <div class="pad_left1">
                                <h2>List of Departments</h2>
                                <!--show database list here-->
                                <%

                                    List<DepartmentObject> d = (List<DepartmentObject>) session.getAttribute("AllDept");
                                    for (int i = 0; i< d.size();i++) {
                                        out.print("<a href= \"department.html?id="+ d.get(i).getDepartment_id() + "\" target=\"_blank\" >" + d.get(i).getDepartment_name() + "</a><br>");
                                        System.out.println(d.get(i).getDepartment_name());
                                    }


                                %>
                                <form action="${pageContext.request.contextPath}/department.html" method="post" enctype="multipart/form-data">
                                <label><strong>Add New Department: </strong></label><br>
                                <label><strong>Name: </strong></label><input name="ndept" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative"><br>
                                <label><strong>Id: </strong></label><input name="idept" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative"><br>
                                <label><strong>About Department: </strong></label><input name="abtdept" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative; height: 200px; width: 300px"><br>
                                <label>&nbsp;</label><input type="submit" value="Add Department" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                            </form>
                            </div>
                            </div>
                    </article>
                </div>
            </div>
        </section>
    </div>
</div>
</body>
</html>

