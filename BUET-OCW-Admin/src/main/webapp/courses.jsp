<%@ page import="TableObjects.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 5/4/2017
  Time: 9:52 PM
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
        <!--side menu-->
        <div id="lefts">
            <a href="#slides">Slides</a><br>
            <a href="#videos">Video Lecture</a><br>
            <a href="#books">Books</a><br>
            <a href="#ques">Questions</a>
        </div>
        <!--side menu-->
        <!-- content -->
        <div id="rights">
        <section id = "content">
            <div class="box1">
                <div class="wrapper">
                    <article class="col1">
                        <div class="pad_left1">
                            <h2>${sessionScope.get("CourseNow").getCourse_name()}</h2>
                            <h2 id = "slides">Slides</h2>
                            <%
                                List<SlideObject> slideObjectList = (List<SlideObject>) session.getAttribute("Slide");
                                for(int i = 0; i < slideObjectList.size(); i++) {
                                    out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"seeslide.html?id=" + slideObjectList.get(i).getSlide_link() + "\"target=\"_blank\">" + slideObjectList.get(i).getSlide_title() + "</a></br>");
                                }
                            %>
                            <form action="${pageContext.request.contextPath}/slides.html" method="post" enctype="multipart/form-data">
                                <div>
                                    <div class="wrapper">
                                        <label><strong>Department: </strong></label>
                                        <select name = "dept">
                                            <option value="arch">Arch</option>
                                            <option value="bme">BME</option>
                                            <option value="ce">CE</option>
                                            <option value="chem">CHEM</option>
                                            <option value="cse">CSE</option>
                                            <option value="eee">EEE</option>
                                            <option value="ipe">IPE</option>
                                            <option value="me">ME</option>
                                            <option value="mme">MME</option>
                                            <option value="name">NAME</option>
                                            <option value="urp">URP</option>
                                            <option value="wre">WRE</option>
                                        </select>

                                        <label><Strong>Course No: </Strong></label>
                                        <input name="cname" type="text" class="input" value="CSE101" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">

                                        <label><Strong>Slide Name: </Strong></label>
                                        <input name="tname" type="text" class="input" value="Khamchi" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">

                                        <label><Strong>Slide Number: </Strong></label>
                                        <input name="sno" type="number" class="input" style="width: 35px; background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">

                                        <label><strong>Select File:</strong></label>
                                        <input type="file" name="file"/>
                                    </div>
                                    <label>&nbsp;</label><input type="submit" value="Slide" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                </div>
                            </form>
                        </div>
                    </article>
                    <article class="wrapper">
                        <h2 id = "videos">Videos</h2>
                        <%
                            List<VideoTutorialObject> videoTutorialObjectList = (List<VideoTutorialObject>) session.getAttribute("Video");
                            for(int i = 0; i < videoTutorialObjectList.size(); i++) {
                                out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"seevid.html?id=" + videoTutorialObjectList.get(i).getLink() + "\"target=\"_blank\">" + videoTutorialObjectList.get(i).getTitle() + "</a></br>");
                            }
                        %>
                        <form action="${pageContext.request.contextPath}/video.html" method="post" enctype="multipart/form-data">
                            <div>
                                <div class="wrapper">
                                    <label><strong>Department: </strong></label>
                                    <select name = "dept">
                                        <option value="arch">Arch</option>
                                        <option value="bme">BME</option>
                                        <option value="ce">CE</option>
                                        <option value="chem">CHEM</option>
                                        <option value="cse">CSE</option>
                                        <option value="eee">EEE</option>
                                        <option value="ipe">IPE</option>
                                        <option value="me">ME</option>
                                        <option value="mme">MME</option>
                                        <option value="name">NAME</option>
                                        <option value="urp">URP</option>
                                        <option value="wre">WRE</option>
                                    </select>

                                    <label><Strong>Course No: </Strong></label>
                                    <input name="cname" type="text" class="input" value="CSE101" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">

                                    <label><Strong>Topic Name: </Strong></label>
                                    <input name="tname" type="text" class="input" value="Khamchi" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">

                                    <label><Strong>Topic Number: </Strong></label>
                                    <input name="sno" type="number" class="input" style="width: 35px; background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">

                                    <label><Strong>YouTube Link: </Strong></label>
                                    <input name="yLink" type="url" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                </div>
                                <label>&nbsp;</label><input type="submit" value="Video" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                            </div>
                        </form>
                    </article>
                    <article class="col1">
                        <h2 id = "books">Books</h2>
                        <%
                            List<BookListObject> bookListObjectList = (List<BookListObject>) session.getAttribute("Book");
                            for(int i = 0; i < bookListObjectList.size(); i++) {
                                out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"seebook.html?id=" + bookListObjectList.get(i).getBook_name() + "\"target=\"_blank\">"  + bookListObjectList.get(i).getBook_name() + " "   + bookListObjectList.get(i).getBook_author() + "    " + bookListObjectList.get(i).getBook_edition() + "</br>");
                            }
                        %>
                            <form action="${pageContext.request.contextPath}/book.html" method="post" enctype="multipart/form-data">
                                <div>
                                    <div class="wrapper">
                                        <label><Strong>Book Name: </Strong></label>
                                        <input name="bname" type="text" class="input" value="Introduction to Algorithms" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                        <label><Strong>Author: </Strong></label>
                                        <input name="aname" type="text" class="input" value="Thomas H Coremen" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                        <label><Strong>Edition: </Strong></label>
                                        <input name="ed" type="text" class="input" value="2" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                        <div class="wrapper">
                                            <label><strong>Select File:</strong></label>
                                            <input type="file" name="file"/>
                                        </div>
                                        <label>&nbsp;</label><input type="submit" value="Book" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                    </div>
                                </div>
                            </form>
                    </article>

                    <article class="col1">
                        <h2 id = "ques">Questions</h2>
                        <%
                            List<InteractiveTestObject> interactiveTestObjectList = (List<InteractiveTestObject>) session.getAttribute("Test");
                            for(int i = 0; i < interactiveTestObjectList.size(); i++) {
                                out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"seeques.html?id=" + interactiveTestObjectList.get(i).getQuestion_link() + "\"target=\"_blank\">" + interactiveTestObjectList.get(i).getQuestion_link() + "</br>");
                            }
                        %>
                        <form action="${pageContext.request.contextPath}/question.html" method="post" enctype="multipart/form-data">
                            <div>
                                <div class="wrapper">
                                    <label><Strong>Question Link: </Strong></label>
                                    <input name="qlink" type="text" class="input" value="CSE101_Test1" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                    <label><Strong>Answer Link: </Strong></label>
                                    <input name="alink" type="text" class="input" value="CSE101_Solved1" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                    <div class="wrapper">
                                        <label><strong>Select File:</strong></label>
                                        <input type="file" name="file"/>
                                    </div>
                                    <label>&nbsp;</label><input type="submit" value="Question" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                </div>
                            </div>
                        </form>
                    </article>
                    <article class="col1">
                        <h2 id = "ques">Related Courses</h2>
                        <!--show list of questions in the course-->
                        <%
                            List<RelatedCourseObject> relatedCourseObjectList = (List<RelatedCourseObject>) session.getAttribute("RCourse");
                            for(int i = 0; i < relatedCourseObjectList.size(); i++) {
                                out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + relatedCourseObjectList.get(i).getCourse_id() + "\"target=\"_blank\">" + relatedCourseObjectList.get(i).getCourse_id() + "</a></br>");
                            }
                        %>
                        <form action="${pageContext.request.contextPath}/rcourse.html" method="post" enctype="multipart/form-data">
                            <div>
                                <div class="wrapper">
                                    <label><Strong>Related Course: </Strong></label>
                                    <input name="clink" type="text" class="input" value="CSE101_Solved1" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                    <label>&nbsp;</label><input type="submit" value="RelatedCourses" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                </div>
                            </div>
                        </form>
                    </article>
                    <article class="col1">
                        <h2 id = "ques">Related Resources</h2>
                        <!--show list of questions in the course-->
                        <%
                            List<RelatedResourceObject> relatedResourceObjectList = (List<RelatedResourceObject>) session.getAttribute("RResource");
                            for(int i = 0; i < relatedResourceObjectList.size(); i++) {
                                out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"resource.html?id=" + relatedResourceObjectList.get(i).getResource_link() + "\"target=\"_blank\">" + relatedResourceObjectList.get(i).getResource_title() + "</a></br>");
                            }
                        %>
                        <form action="${pageContext.request.contextPath}/rresource.html" method="post" enctype="multipart/form-data">
                            <div>
                                <div class="wrapper">
                                    <label><Strong>Title: </Strong></label>
                                    <input name="title" type="text" class="input" value="Handbook" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                    <label><Strong>Link: </Strong></label>
                                    <input name="link" type="text" class="input" value="Hand Book Link" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                    <label>&nbsp;</label><input type="submit" value="RelatedResources" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                </div>
                            </div>
                        </form>
                    </article>
                </div>
            </div>
        </section>
    </div>
    </div>
</div>
</body>
</html>
