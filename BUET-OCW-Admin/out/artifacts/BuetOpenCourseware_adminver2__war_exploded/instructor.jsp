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
    <!--[if lt IE 9]-->
    <script type="text/javascript" src="js/html5.js"></script>
    <style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
    <!--[endif]-->
    <style type="text/css">
        label{
            display: inline;
            float: left;
            clear: left;
            margin-top: 2%;
            margin-left: 27%;
            width: 100px;
            text-align: left;
        }
        select{
            margin-top: 2%;
            float: left;
            background: #fff;
            border: 1px solid #e5e5e5;
            border-radius:6px;
            -moz-border-radius:6px;
            -webkit-border-radius:6px;
            position:relative
        }
        input {
            margin-top: 2%;
            display: inline;
            float: left;
        }
    </style>
</head>
<body id = page5>

<div id = "body1">
    <div id="main">
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
</html>
