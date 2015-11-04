<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title><sitemesh:write property='title'/></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="MobileOptimized" content="320">

    <%@include file="/WEB-INF/views/layouts/admin-include-header.jsp" %>

    <sitemesh:write property='head'/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
    <!-- BEGIN HEADER INNER -->
    <div class="page-header-inner">
        <!-- BEGIN LOGO -->
        <div class="page-logo">
            <a href="index.html">
                <img src="${ctx}/assets/admin/layout/img/logo.png" alt="logo" class="logo-default"/>
            </a>

            <div class="menu-toggler sidebar-toggler hide">
                <!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
            </div>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
           data-target=".navbar-collapse">
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <!-- BEGIN NOTIFICATION DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <i class="icon-bell"></i>
					<span class="badge badge-default">
					7 </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="external">
                            <h3><span class="bold">12 pending</span> notifications</h3>
                            <a href="extra_profile.html">view all</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">just now</span>
									<span class="details">
									<span class="label label-sm label-icon label-success">
									<i class="fa fa-plus"></i>
									</span>
									New user registered. </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">3 days</span>
									<span class="details">
									<span class="label label-sm label-icon label-danger">
									<i class="fa fa-bolt"></i>
									</span>
									A user IP blocked. </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">4 days</span>
									<span class="details">
									<span class="label label-sm label-icon label-warning">
									<i class="fa fa-bell-o"></i>
									</span>
									Storage Server #4 not responding dfdfdfd. </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">5 days</span>
									<span class="details">
									<span class="label label-sm label-icon label-info">
									<i class="fa fa-bullhorn"></i>
									</span>
									System Error. </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">9 days</span>
									<span class="details">
									<span class="label label-sm label-icon label-danger">
									<i class="fa fa-bolt"></i>
									</span>
									Storage server failed. </span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- END NOTIFICATION DROPDOWN -->
                <!-- BEGIN INBOX DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-extended dropdown-inbox" id="header_inbox_bar">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <i class="icon-envelope-open"></i>
					<span class="badge badge-default">
					4 </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="external">
                            <h3>You have <span class="bold">7 New</span> Messages</h3>
                            <a href="page_inbox.html">view all</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                <%--<li>--%>
                                <%--<a href="inbox.html?a=view">--%>
                                <%--<span class="photo">--%>
                                <%--<img src="${ctx}/assets/admin/layout3/img/avatar3.jpg" class="img-circle" alt="">--%>
                                <%--</span>--%>
                                <%--<span class="subject">--%>
                                <%--<span class="from">--%>
                                <%--Richard Doe </span>--%>
                                <%--<span class="time">16 mins </span>--%>
                                <%--</span>--%>
                                <%--<span class="message">--%>
                                <%--Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>--%>
                                <%--</a>--%>
                                <%--</li>--%>

                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- END INBOX DROPDOWN -->
                <!-- BEGIN TODO DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-extended dropdown-tasks" id="header_task_bar">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <i class="icon-calendar"></i>
					<span class="badge badge-default">
					3 </span>
                    </a>
                    <ul class="dropdown-menu extended tasks">
                        <li class="external">
                            <h3>You have <span class="bold">12 pending</span> tasks</h3>
                            <a href="page_todo.html">view all</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">New release v1.2 </span>
									<span class="percent">30%</span>
									</span>
									<span class="progress">
									<span style="width: 40%;" class="progress-bar progress-bar-success"
                                          aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">40% Complete</span></span>
									</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">Application deployment</span>
									<span class="percent">65%</span>
									</span>
									<span class="progress">
									<span style="width: 65%;" class="progress-bar progress-bar-danger"
                                          aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">65% Complete</span></span>
									</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">Mobile app release</span>
									<span class="percent">98%</span>
									</span>
									<span class="progress">
									<span style="width: 98%;" class="progress-bar progress-bar-success"
                                          aria-valuenow="98" aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">98% Complete</span></span>
									</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">Database migration</span>
									<span class="percent">10%</span>
									</span>
									<span class="progress">
									<span style="width: 10%;" class="progress-bar progress-bar-warning"
                                          aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">10% Complete</span></span>
									</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">Web server upgrade</span>
									<span class="percent">58%</span>
									</span>
									<span class="progress">
									<span style="width: 58%;" class="progress-bar progress-bar-info" aria-valuenow="58"
                                          aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">58% Complete</span></span>
									</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">Mobile development</span>
									<span class="percent">85%</span>
									</span>
									<span class="progress">
									<span style="width: 85%;" class="progress-bar progress-bar-success"
                                          aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">85% Complete</span></span>
									</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
									<span class="task">
									<span class="desc">New UI release</span>
									<span class="percent">38%</span>
									</span>
									<span class="progress progress-striped">
									<span style="width: 38%;" class="progress-bar progress-bar-important"
                                          aria-valuenow="18" aria-valuemin="0" aria-valuemax="100"><span
                                            class="sr-only">38% Complete</span></span>
									</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- END TODO DROPDOWN -->
                <!-- BEGIN USER LOGIN DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <img alt="" class="img-circle" src="${ctx}/assets/admin/layout/img/avatar3_small.jpg"/>
					<span class="username username-hide-on-mobile">
					Nick </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="extra_profile.html">
                                <i class="icon-user"></i> My Profile </a>
                        </li>
                        <li>
                            <a href="page_calendar.html">
                                <i class="icon-calendar"></i> My Calendar </a>
                        </li>
                        <li>
                            <a href="inbox.html">
                                <i class="icon-envelope-open"></i> My Inbox <span class="badge badge-danger">
							3 </span>
                            </a>
                        </li>
                        <li>
                            <a href="page_todo.html">
                                <i class="icon-rocket"></i> My Tasks <span class="badge badge-success">
							7 </span>
                            </a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="extra_lock.html">
                                <i class="icon-lock"></i> Lock Screen </a>
                        </li>
                        <li>
                            <a href="login.html">
                                <i class="icon-key"></i> 退出 </a>
                        </li>
                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
                <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->


                <%--<li class="dropdown dropdown-quick-sidebar-toggler">--%>
                <%--<a href="javascript:;" class="dropdown-toggle">--%>
                <%--<i class="icon-logout"></i>--%>
                <%--</a>--%>
                <%--</li>--%>


                <!-- END QUICK SIDEBAR TOGGLER -->
            </ul>
        </div>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
            <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
            <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
            <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
            <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
            <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
            <ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                <li class="sidebar-toggler-wrapper">
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler">
                    </div>
                    <!-- END SIDEBAR TOGGLER BUTTON -->
                </li>
                <!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
                <li class="sidebar-search-wrapper">
                    <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                    <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
                    <!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
                    <form class="sidebar-search " action="extra_search.html" method="POST">
                        <a href="javascript:;" class="remove">
                            <i class="icon-close"></i>
                        </a>

                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="查询菜单...">
							<span class="input-group-btn">
							<a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
							</span>
                        </div>
                    </form>
                    <!-- END RESPONSIVE QUICK SEARCH FORM -->
                </li>
                <li class="start ">
                    <a href="javascript:;">
                        <i class="icon-home"></i>
                        <span class="title">首页</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="icon-diamond"></i>
                        <span class="title">档案管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="ui_general.html">
                                文书档案</a>
                        </li>
                    </ul>
                </li>
                <!-- BEGIN ANGULARJS LINK -->
                <%--<li class="tooltips" data-container="body" data-placement="right" data-html="true"--%>
                    <%--data-original-title="AngularJS version demo">--%>
                    <%--<a href="angularjs" target="_blank">--%>
                        <%--<i class="icon-paper-plane"></i>--%>
					<%--<span class="title">--%>
					<%--AngularJS Version </span>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <!-- END ANGULARJS LINK -->
                <li class="heading">
                    <h3 class="uppercase">系统</h3>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="icon-settings"></i>
                        <span class="title">系统设置</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="form_controls_md.html">
                                <span class="badge badge-roundless badge-danger">new</span>Material Design<br>
                                Form Controls</a>
                        </li>
                        <li>
                            <a href="form_dropzone.html">
                                Dropzone File Upload</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- BEGIN STYLE CUSTOMIZER -->
            <%--<div class="theme-panel hidden-xs hidden-sm">--%>
                <%--<div class="toggler">--%>
                <%--</div>--%>
                <%--<div class="toggler-close">--%>
                <%--</div>--%>
                <%--<div class="theme-options">--%>
                    <%--<div class="theme-option theme-colors clearfix">--%>
						<%--<span> 风格设置 </span>--%>
                        <%--<ul>--%>
                            <%--<li class="color-default current tooltips" data-style="default" data-container="body"--%>
                                <%--data-original-title="Default">--%>
                            <%--</li>--%>
                            <%--<li class="color-darkblue tooltips" data-style="darkblue" data-container="body"--%>
                                <%--data-original-title="Dark Blue">--%>
                            <%--</li>--%>
                            <%--<li class="color-blue tooltips" data-style="blue" data-container="body"--%>
                                <%--data-original-title="Blue">--%>
                            <%--</li>--%>
                            <%--<li class="color-grey tooltips" data-style="grey" data-container="body"--%>
                                <%--data-original-title="Grey">--%>
                            <%--</li>--%>
                            <%--<li class="color-light tooltips" data-style="light" data-container="body"--%>
                                <%--data-original-title="Light">--%>
                            <%--</li>--%>
                            <%--<li class="color-light2 tooltips" data-style="light2" data-container="body" data-html="true"--%>
                                <%--data-original-title="Light 2">--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Theme Style </span>--%>
                        <%--<select class="layout-style-option form-control input-sm">--%>
                            <%--<option value="square" selected="selected">Square corners</option>--%>
                            <%--<option value="rounded">Rounded corners</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Layout </span>--%>
                        <%--<select class="layout-option form-control input-sm">--%>
                            <%--<option value="fluid" selected="selected">Fluid</option>--%>
                            <%--<option value="boxed">Boxed</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Header </span>--%>
                        <%--<select class="page-header-option form-control input-sm">--%>
                            <%--<option value="fixed" selected="selected">Fixed</option>--%>
                            <%--<option value="default">Default</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Top Menu Dropdown</span>--%>
                        <%--<select class="page-header-top-dropdown-style-option form-control input-sm">--%>
                            <%--<option value="light" selected="selected">Light</option>--%>
                            <%--<option value="dark">Dark</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Sidebar Mode</span>--%>
                        <%--<select class="sidebar-option form-control input-sm">--%>
                            <%--<option value="fixed">Fixed</option>--%>
                            <%--<option value="default" selected="selected">Default</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Sidebar Menu </span>--%>
                        <%--<select class="sidebar-menu-option form-control input-sm">--%>
                            <%--<option value="accordion" selected="selected">Accordion</option>--%>
                            <%--<option value="hover">Hover</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Sidebar Style </span>--%>
                        <%--<select class="sidebar-style-option form-control input-sm">--%>
                            <%--<option value="default" selected="selected">Default</option>--%>
                            <%--<option value="light">Light</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Sidebar Position </span>--%>
                        <%--<select class="sidebar-pos-option form-control input-sm">--%>
                            <%--<option value="left" selected="selected">Left</option>--%>
                            <%--<option value="right">Right</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="theme-option">--%>
						<%--<span>--%>
						<%--Footer </span>--%>
                        <%--<select class="page-footer-option form-control input-sm">--%>
                            <%--<option value="fixed">Fixed</option>--%>
                            <%--<option value="default" selected="selected">Default</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <!-- END STYLE CUSTOMIZER -->
            <!-- BEGIN PAGE HEADER-->
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="index.html">首页</a>
                        <%--<i class="fa fa-angle-right"></i>--%>
                    </li>
                </ul>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
            <div class="row">
                <div class="col-md-12">
                    <sitemesh:write property='body'/>
                </div>
            </div>
            <!-- END PAGE CONTENT-->
        </div>
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <div class="page-footer-inner">
        2014 &copy; 中公网医疗信息技术有限公司. <a href="#" target="_blank">www.cis.com.cn</a>
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
<!-- END FOOTER -->

<%@include file="/WEB-INF/views/layouts/admin-include-footer.jsp" %>
</body>
<!-- END BODY -->
</html>
