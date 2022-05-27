<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="DataAccess.DepartmentDAO" %>
<%@ page import="TableObjects.CourseTakenObject" %>
<%@ page import="TableObjects.DepartmentObject" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.List" %>
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
    <title>User Homepage-Add, Remove, Modify Contents</title>
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
<body id = page5>
<section>

<div id = "body1">
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
                                out.print("<a href= \"department.html?id="+ departmentObjectList.get(i).getDepartment_id() + "\" target=\"_blank\" >" + departmentObjectList.get(i).getDepartment_name() + "</a>");
                                System.out.println(departmentObjectList.get(i).getDepartment_name());
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
            </ul>
            <div class="searchform">
                <br/>
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
        </nav>
        <!-- header -->
        <header style="margin-left: 20%">
            <div class="wrapper">
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
                    <h3 style="padding-left: 20%">Name: ${sessionScope.get("CurrentUser").getUser_name()}</h3>
                    <h3 style="padding-left: 20%">Email: ${sessionScope.get("CurrentUser").getEmail()}</h3>
                    <h3 style="padding-left: 20%">Institution: ${sessionScope.get("CurrentUser").getInstitution()}</h3>
                    <h3 style="padding-left: 20%">Profession: ${sessionScope.get("CurrentUser").getProfession()}</h3>
                    <h3 style="padding-left: 20%">Gender: ${sessionScope.get("CurrentUser").getGender()}</h3>
                    <h3 style="padding-left: 20%">Country: ${sessionScope.get("CurrentUser").getCountry()}</h3>
                    <h3 style="padding-left: 20%">District: ${sessionScope.get("CurrentUser").getDistrict()}</h3>
                    <h3 style="padding-left: 20%">Division: ${sessionScope.get("CurrentUser").getDivision()}</h3>
                    <h3 style="padding-left: 20%">Road No: ${sessionScope.get("CurrentUser").getRoad_no()}</h3>
                    <h3 style="padding-left: 20%">House No: ${sessionScope.get("CurrentUser").getHouse_no()}</h3>
                    <h3 style="padding-left: 20%">Contact No: ${sessionScope.get("CurrentUser").getContact_no()}</h3>
                </div>
                <!--User Profile-->
                <div class="wrapper">
                    <article class="col1">
                        <div class="pad_left1">
                            <h2>My Course List</h2>
                            <table>
                                <%
                                    List<CourseTakenObject> s = (List<CourseTakenObject>) session.getAttribute("CourseTaken");
                                    for(int i = 0; i < s.size(); i++) {
                                        out.print("<br> <h4 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + s.get(i).getCourse_id() + "\"target=\"_blank\">" + s.get(i).getCourse_id() + "</a></br>");
                                    }
                                %>
                            </table>
                        </div>
                    </article>
                </div>
            </div>
        </section>
    </div>
</div>
    </section>
</body>
</html>

