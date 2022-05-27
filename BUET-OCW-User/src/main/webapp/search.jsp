<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="TableObjects.*" %><%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 7/12/2017
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
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
                    <article class="col1">
                        <h2>Faculty</h2>
                        <%
                            List<InstructorObject> tlist = (List<InstructorObject>) session.getAttribute("sTeacher");
                            for(int i = 0; i< tlist.size(); i++){
                                out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"instructor.html?id=" + tlist.get(i).getTeacher_id() + "\"target=\"_blank\">" + tlist.get(i).getTeacher_name() + "</a></br>");
                            }
                        %>
                    </article>
                    <article class="col1">
                        <h2>Books</h2>
                        <%
                            List<BookListObject> blist = (List<BookListObject>) session.getAttribute("sBook");
                            for(int i = 0; i < blist.size(); i++){
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seebook.html?id=" + blist.get(i).getBook_name() + "\"target=\"_blank\">" + blist.get(i).getBook_name() + "    " + blist.get(i).getBook_author() + "    " + blist.get(i).getBook_edition() + "</br>");
                            }
                        %>
                    </article>

                    <article class="col1">
                        <h2>Department</h2>
                        <%
                            List<DepartmentObject> dlist = (List<DepartmentObject>) session.getAttribute("sDept");
                            for(int i = 0; i< dlist.size(); i++){
                                out.print("<a href= \"department.html?id="+ dlist.get(i).getDepartment_id() + "\" target=\"_blank\" >" + dlist.get(i).getDepartment_name() + "</a>");
                            }
                        %>
                    </article>
                    <article class="col1">
                        <h2>Courses</h2>
                        <%
                            List<CourseObject> clists = (List<CourseObject>) session.getAttribute("sCourse");
                            for(int i = 0; i< clists.size(); i++){
                                out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + clists.get(i).getCourse_id() + "\"target=\"_blank\">" + clists.get(i).getCourse_id() + " " + clists.get(i).getCourse_name()+ "</a></br>");
                            }
                        %>
                    </article>
                    <article class="col1">
                    <h2>Slides</h2>
                    <%
                        List<SlideObject> slist = (List<SlideObject>) session.getAttribute("sSlide");
                        for(int i = 0; i< slist.size(); i++){
                            out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seeslide.html?id=" + slist.get(i).getSlide_link() + "\"target=\"_blank\">" + slist.get(i).getSlide_title() + "</a><br>");
                        }
                    %>
                    </article>
                    <article class="col1">
                        <h2>Video Lectures</h2>
                        <%
                            List<VideoTutorialObject> vlist = (List<VideoTutorialObject>) session.getAttribute("sVideo");
                            for(int i = 0; i< vlist.size(); i++){
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seevid.html?id=" + vlist.get(i).getLink() + "\"target=\"_blank\">" + vlist.get(i).getTitle() + "</a><br>");
                            }
                        %>
                    </article>
                    <article class="col1">
                        <h2>Questions</h2>
                        <%
                            List<InteractiveTestObject> ilist = (List<InteractiveTestObject>) session.getAttribute("sTest");
                            for(int i = 0; i< ilist.size(); i++){
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seeques.html?id=" + ilist.get(i).getQuestion_link() + "\"target=\"_blank\">" + ilist.get(i).getQuestion_link() + "</br>");
                            }
                        %>
                    </article>
                </div>
            </div>
        </section>
        <!--content-->
    </div>
</div>
</body>
</html>
