<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="TableObjects.*" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 7/9/2017
  Time: 10:27 AM
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
        <!--side menu-->
        <div id="lefts">
            <a href="#slides">Slides</a><br>
            <a href="#videos">Video Lecture</a><br>
            <a href="#books">Books</a><br>
            <a href="#ques">Questions</a>
        </div>
        <!--side menu-->

        <!--content-->
        <div id = rights>
        <section id="content">
            <div class="box1">
                <div class="wrapper">
                    <article class="col1">
                        <h2 id = "slides">Slides</h2>
                        <!--show list of slides in the course-->
                        <%
                            List<SlideObject> slideObjectList = (List<SlideObject>) session.getAttribute("Slide");
                            for(int i = 0; i < slideObjectList.size(); i++) {
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seeslide.html?id=" + slideObjectList.get(i).getSlide_link() + "\"target=\"_blank\">" + slideObjectList.get(i).getSlide_title() + "</a><br>");
                            }
                        %>
                    </article>
                    <article class="wrapper">
                        <h2 id = "videos">Videos</h2>
                        <!--show list of videos in the course-->
                        <%
                            List<VideoTutorialObject> videoTutorialObjectList = (List<VideoTutorialObject>) session.getAttribute("Video");
                            for(int i = 0; i < videoTutorialObjectList.size(); i++) {
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seevid.html?id=" + videoTutorialObjectList.get(i).getLink() + "\"target=\"_blank\">" + videoTutorialObjectList.get(i).getTitle() + "</a><br>");
                            }
                        %>
                    </article>
                    <article class="col1">
                        <h2 id = "books">Books</h2>
                        <!--show list of books in the course-->
                        <%
                            List<BookListObject> bookListObjectList = (List<BookListObject>) session.getAttribute("Book");
                            for(int i = 0; i < bookListObjectList.size(); i++) {
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seebook.html?id=" + bookListObjectList.get(i).getBook_name() + "\"target=\"_blank\">" + bookListObjectList.get(i).getBook_name() + "    " + bookListObjectList.get(i).getBook_author() + "    " + bookListObjectList.get(i).getBook_edition() + "</br>");
                            }
                        %>
                    </article>

                    <article class="col1">
                        <h2 id = "ques">Questions</h2>
                        <!--show list of questions in the course-->
                        <%
                            List<InteractiveTestObject> interactiveTestObjectList = (List<InteractiveTestObject>) session.getAttribute("Test");
                            for(int i = 0; i < interactiveTestObjectList.size(); i++) {
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seeques.html?id=" + interactiveTestObjectList.get(i).getQuestion_link() + "\"target=\"_blank\">" + interactiveTestObjectList.get(i).getQuestion_link() + "</br>");
                            }
                        %>
                    </article>
                    <article class="col1">
                        <h2 id = "ques">Related Courses</h2>
                        <!--show list of questions in the course-->
                        <%
                            List<RelatedCourseObject> relatedCourseObjectList = (List<RelatedCourseObject>) session.getAttribute("RCourse");
                            for(int i = 0; i < relatedCourseObjectList.size(); i++) {
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + relatedCourseObjectList.get(i).getCourse_id() + "\"target=\"_blank\">" + relatedCourseObjectList.get(i).getCourse_id() + "</a></br>");
                            }
                        %>
                    </article>
                    <article class="col1">
                        <h2 id = "ques">Related Resources</h2>
                        <!--show list of questions in the course-->
                        <%
                            List<RelatedResourceObject> relatedResourceObjectList = (List<RelatedResourceObject>) session.getAttribute("RResource");
                            for(int i = 0; i < relatedResourceObjectList.size(); i++) {
                                out.print("<h4 style=\"padding-left: 20%\"> <a href=\"resource.html?id=" + relatedResourceObjectList.get(i).getResource_link() + "\"target=\"_blank\">" + relatedResourceObjectList.get(i).getResource_title() + "</a></br>");
                            }
                        %>
                    </article>
                </div>
            </div>
        </section>
        </div>
        <!--content-->
    </div>
</div>

</body>
</html>
