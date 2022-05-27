<%@ page import="TableObjects.CourseObject" %>
<%@ page import="TableObjects.InstructorObject" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 7/07/2017
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Homepage-Add, Remove, Modify Contents</title>
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
</head>
<body id = "page5">
    <div id="body1">
        <div id = "main">
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
    <div class = "main">
        <!-- content -->
        <section id="content">
            <div class="box1">
                <div class="wrapper">
                    <article class="col1">
                        <div class="pad_left1">
                            <h2>List of Courses</h2>
                            <!--show database list here-->
                            <%
                                List<CourseObject> sh = (List<CourseObject>) session.getAttribute("CoursesDept");
                                for(int i = 0; i < sh.size(); i++) {
                                    //out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + s.get(i).getCourse_id() + "   " + s.get(i).getCourse_name() + "\">" +  "</a></br>");
                                    out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + sh.get(i).getCourse_id() + "\"target=\"_blank\">" + sh.get(i).getCourse_name()+ "</a></br>");
                                    System.out.println(sh.get(i).getCourse_name());
                                }
                            %>
                            <form action="${pageContext.request.contextPath}/courses.html" method="post" enctype="multipart/form-data">
                            <label><strong>Add New Course: </strong></label>
                            <input name="ncrs" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                            <input name="icrs" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                            <input name="acrs" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                            <input name="tcrs" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                            <label>&nbsp;</label><input type="submit" value="Course" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                        </form>
                        </div>

                        <div class="pad_left1">
                                <h2>List of Faculty</h2>
                                <%
                                    List<InstructorObject> t = (List<InstructorObject>) session.getAttribute("TeachersDept");
                                    for(int i = 0; i < t.size(); i++) {
                                        //out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + s.get(i).getCourse_id() + "   " + s.get(i).getCourse_name() + "\">" +  "</a></br>");
                                        out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"instructor.html?id=" + t.get(i).getTeacher_id() + "\"target=\"_blank\">" + t.get(i).getTeacher_name() + "</a></br>");
                                    }
                                %>
                                <!--show database list here-->
                            <form action="${pageContext.request.contextPath}/instructor.html" method="post" enctype="multipart/form-data">
                                <label><strong>Add New Teacher: </strong></label><br>
                                <label><strong>Name: </strong></label><input name="ntchr" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                <label><strong>ID:  </strong></label><input name="itchr" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                <label><strong>Designation: </strong></label><input name="dtchr" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                <label><strong>Profile Link: </strong></label><input name="prftchr" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                <label><strong>About:  </strong></label><input name="atchr" type="text" class="input" style="background: #fff; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                <label>&nbsp;</label><input type="submit" value="Instructor" style="cursor: pointer; border: 1px solid #e5e5e5; border-radius:6px; -moz-border-radius:6px; -webkit-border-radius:6px; position:relative">
                                </form>
                        </div>
                    </article>
                </div>
            </div>
        </section>
        <!-- content -->
    </div>
</div>
</body>
</html>
