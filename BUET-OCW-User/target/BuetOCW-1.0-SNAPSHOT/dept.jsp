<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="TableObjects.CourseObject" %>
<%@ page import="TableObjects.InstructorObject" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 15/05/2017
  Time: 9:59 PM
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
                <div class="wrapper">
                    <article class="col2 pad_left2">
                        <div class="pad_left1">
                            <h2>Courses</h2>
                        </div>
                        <ul class="list1 pad_bot1">
                            <!--these will be read from database-->
                            <%
                                List<CourseObject> sh = (List<CourseObject>) session.getAttribute("CoursesDept");
                                for(int i = 0; i < sh.size(); i++) {
                                    //out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + s.get(i).getCourse_id() + "   " + s.get(i).getCourse_name() + "\">" +  "</a></br>");
                                    out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + sh.get(i).getCourse_id() + "\"target=\"_blank\">" + sh.get(i).getCourse_id() + "</a></br>");
                                }
                            %>
                        </ul>
                        <div class="pad_left1">
                            <h2>Faculty</h2>
                        </div>
                        <ul class="list1 pad_bot1">
                            <!--these will be read from database-->
                            <%
                                List<InstructorObject> t = (List<InstructorObject>) session.getAttribute("TeachersDept");
                                for(int i = 0; i < t.size(); i++) {
                                    //out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + s.get(i).getCourse_id() + "   " + s.get(i).getCourse_name() + "\">" +  "</a></br>");
                                    out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"instructor.html?id=" + t.get(i).getTeacher_id() + "\"target=\"_blank\">" + t.get(i).getTeacher_name() + "</a></br>");
                                }
                            %>
                        </ul>
                    </article>
                </div>
            </div>
        </section>
        <!--content-->
    </div>
</div>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>
