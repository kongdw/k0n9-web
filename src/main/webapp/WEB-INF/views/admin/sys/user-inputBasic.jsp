<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
</head>
<body>
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PORTLET-->
    <div class="portlet light bordered form-fit">
      <div class="portlet-title">
        <div class="caption font-blue">
          <i class="icon-speech font-blue"></i>
          <span class="caption-subject bold uppercase"> Textarea Autosize</span>
          <span class="caption-helper"></span>
        </div>
        <%--<div class="actions">--%>
          <%--<a href="javascript:;" class="btn btn-circle btn-default btn-sm">--%>
            <%--<i class="fa fa-pencil"></i> Edit </a>--%>
          <%--<a href="javascript:;" class="btn btn-circle btn-default btn-sm">--%>
            <%--<i class="fa fa-plus"></i> Add </a>--%>
          <%--<a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">--%>
            <%--<i class="icon-wrench"></i>--%>
          <%--</a>--%>
        <%--</div>--%>
      </div>
      <div class="portlet-body form">
        <form:form action="${ctx}/a/sys/user/edit" id="form-user" method="post" modelAttribute="entity" class="form-horizontal form-bordered">
          <div class="form-group">
            <label class="col-md-3 control-label">用户名</label>
            <div class="col-md-9">
              <form:input class="form-control input-sm" path="username"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">email</label>
            <div class="col-md-9">
              <form:input class="form-control input-sm" path="email"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">电话号码</label>
            <div class="col-md-9">
              <form:input class="form-control input-sm" path="phoneNumber"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">状态</label>
            <div class="col-md-9">
              <form:input class="form-control input-sm" path="status"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">是否删除</label>
            <div class="col-md-1">
              <form:checkbox class="form-control input-sm" path="deleted"/>
            </div>
            <label class="col-md-3 control-label">是否管理员</label>
            <div class="col-md-1">
              <form:checkbox class="form-control input-sm" path="isAdmin"/>
            </div>
          </div>
          <%--<div class="form-group">--%>
            <%--<label class="col-md-3 control-label">是否管理员</label>--%>
            <%--<div class="col-md-9">--%>
              <%--<form:checkbox class="form-control input-sm" path="isAdmin"/>--%>
            <%--</div>--%>
          <%--</div>--%>
          <div class="form-actions">
            <div class="row">
              <div class="col-md-offset-3 col-md-9">
                <button type="submit" class="btn red" data-post-dismiss="modal"><i class="fa fa-check"></i> 保存</button>
                <button type="button" class="btn default" data-dismiss="modal">取 消</button>
              </div>
            </div>
          </div>
        </form:form>
      </div>
    </div>
    <!-- END PORTLET-->
  </div>
</div>
</body>
</html>
