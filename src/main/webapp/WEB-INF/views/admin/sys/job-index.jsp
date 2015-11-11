<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>区域管理</title>
</head>
<body>
<!-- BEGIN PAGE CONTENT-->
<div class="row">
  <div class="col-md-12">
    <%--<div class="note note-success">--%>
      <%--<p>--%>
        <%--GTreeTable is extension of Tweeter Bootstrap 3 framework, which allows to use tree structure inside HTML table. Full documentation is available <a href="https://github.com/gilek/bootstrap-gtreetable" target="_blank">here</a>--%>
      <%--</p>--%>
    <%--</div>--%>
    <!-- BEGIN PORTLET-->
    <div class="portlet light bordered">
      <div class="portlet-title">
        <div class="caption font-purple-plum">
          <i class="icon-speech font-purple-plum"></i>
          <span class="caption-subject bold uppercase"> Demo 2</span>
          <span class="caption-helper">right click inside the box</span>
        </div>
        <div class="actions">
          <div class="btn-group">
            <a class="btn btn-default btn-sm" href="javascript:;" data-toggle="dropdown">
              <i class="fa fa-user"></i> User <i class="fa fa-angle-down"></i>
            </a>
            <ul class="dropdown-menu" role="menu">
              <li>
                <a href="javascript:;">
                  <i class="icon-user"></i> New User </a>
              </li>
              <li>
                <a href="javascript:;">
                  <i class="icon-present"></i> New Event <span class="badge badge-success">4</span>
                </a>
              </li>
              <li>
                <a href="javascript:;">
                  <i class="icon-basket"></i> New order </a>
              </li>
              <li class="divider">
              </li>
              <li>
                <a href="javascript:;">
                  <i class="icon-flag"></i> Pending Orders <span class="badge badge-danger">4</span>
                </a>
              </li>
              <li>
                <a href="javascript:;">
                  <i class="icon-users"></i> Pending Users <span class="badge badge-warning">12</span>
                </a>
              </li>
            </ul>
          </div>
          <a href="javascript:;" class="btn btn-default btn-sm">
            <i class="fa fa-plus"></i> Add </a>
          <a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;" data-original-title="" title="">
          </a>
        </div>
      </div>
      <div class="portlet-body">
        <table class="table table-hover table-light gtreetable" id="gtreetable">
          <thead>
          <tr>
            <th>
              name
            </th>
          </tr>
          </thead>
        </table>
      </div>
    </div>
    <!-- END PORTLET-->
  </div>
</div>
<!-- END PAGE CONTENT-->
<!-- END PAGE CONTENT-->

</body>
</html>
