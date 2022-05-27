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
    <title>Search</title>
</head>
<body>
<%
    List<BookListObject> blist = (List<BookListObject>) session.getAttribute("sBook");
    for(int i = 0; i < blist.size(); i++){
        out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seebook.html?id=" + blist.get(i).getBook_name() + "\"target=\"_blank\">" + blist.get(i).getBook_name() + "    " + blist.get(i).getBook_author() + "    " + blist.get(i).getBook_edition() + "</br>");
    }
%>

<%
    List<InteractiveTestObject> ilist = (List<InteractiveTestObject>) session.getAttribute("sTest");
    for(int i = 0; i< ilist.size(); i++){
        out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seeques.html?id=" + ilist.get(i).getQuestion_link() + "\"target=\"_blank\">" + ilist.get(i).getQuestion_link() + "</br>");
    }
%>

<%
    List<SlideObject> slist = (List<SlideObject>) session.getAttribute("sSlide");
    for(int i = 0; i< slist.size(); i++){
        out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seeslide.html?id=" + slist.get(i).getSlide_link() + "\"target=\"_blank\">" + slist.get(i).getSlide_title() + "</a><br>");
    }
%>
<%
    List<VideoTutorialObject> vlist = (List<VideoTutorialObject>) session.getAttribute("sVideo");
    for(int i = 0; i< vlist.size(); i++){
        out.print("<h4 style=\"padding-left: 20%\"> <a href=\"seevid.html?id=" + vlist.get(i).getLink() + "\"target=\"_blank\">" + vlist.get(i).getTitle() + "</a><br>");
    }
%>
<%
    List<DepartmentObject> dlist = (List<DepartmentObject>) session.getAttribute("sDept");
    for(int i = 0; i< dlist.size(); i++){
        out.print("<a href= \"department.html?id="+ dlist.get(i).getDepartment_id() + "\" target=\"_blank\" >" + dlist.get(i).getDepartment_name() + "</a>");
    }
%>

<%
    List<CourseObject> clists = (List<CourseObject>) session.getAttribute("sCourse");
    for(int i = 0; i< clists.size(); i++){
        out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"courses.html?id=" + clists.get(i).getCourse_id() + "\"target=\"_blank\">" + clists.get(i).getCourse_id() + " " + clists.get(i).getCourse_name()+ "</a></br>");
    }
%>

<%
    List<InstructorObject> tlist = (List<InstructorObject>) session.getAttribute("sTeacher");
    for(int i = 0; i< tlist.size(); i++){
        out.print("<br> <h3 style=\"padding-left: 20%\"> <a href=\"instructor.html?id=" + tlist.get(i).getTeacher_id() + "\"target=\"_blank\">" + tlist.get(i).getTeacher_name() + "</a></br>");
    }
%>

</body>
</html>
