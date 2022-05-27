<%--@elvariable id="welcomeMessage" type="tod"--%>
<%--
  Created by IntelliJ IDEA.
  User: Akib Ahmed
  Date: 4/22/2017
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
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

    <div class="body3">

    </div>

    <div class="body2">
        <div class="main">
            <!--content-->
            <section id="content">
                <div class="box1">
                    <div class="wrapper">
                        <article class="col1">
                            <div class="pad_left1">
                                <h2>Welcome to BUET Open Courseware</h2>
                                <p class="font2">BUET Open Courseware is a free website for learning and spreading knowledge all over the nation.</p>
                                <p><strong>BUET Open Courseware</strong> is built for all Bangladesh students. This site is completely free for anyone who is willing to learn anything by him/herself.
                                You can learn anything from now from the famous and reknowned teachers of BUET in any department you wish.</p>
                            </div>

                            <div class="pad_left1">
                                <h2>Unique Approach to Learning</h2>
                                <p>Here, you will get departmentwise course lists from where you will get awesome video lectures
                                of teachers according to various topics. You will also get class lectures and text book download links.</p>
                            </div>
                        </article>
                    </div>
                </div>
            </section>
            <!--content-->
            <!--footer-->
            <footer>
                <div class="wrapper">
                    <div class = "pad_left1">
                        <div class = "wrapper">
                            <article class = "col_1">
                                <h3>Adress:</h3>
                                <p class="font3">Zahir Raihan Rd, Dhaka 1000, Bangladesh</p>
                                <!--trouble-->
                                <div id = "googleMap" style="width: 100%; height: 70%"></div>
                                    <script>
                                        function myMap() {
                                            var mapProp= {
                                                center:new google.maps.LatLng(23.726013,90.392495),
                                                zoom:15
                                            };
                                            var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
                                        }
                                    </script>
                                    <!--Google Map free API Key-->
                                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDqEkA5qMU8e2j3pg45NOaaM40wwDwOFK0&callback=myMap"></script>
                            </article>
                            <article class = "col_2 pad_left2">
                                <h3>Join Today:</h3>
                                <li><a href="signup.html">Sign Up</a></li>
                                <li><a href="login.html">Log In</a></li>
                            </article>
                        </div>
                    </div>
                </div>
            </footer>
            <!--footer-->
        </div>
    </div>
</body>
</html>
