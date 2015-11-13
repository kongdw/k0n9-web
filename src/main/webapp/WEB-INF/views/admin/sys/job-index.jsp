<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>工作职务管理</title>
  <script type="text/javascript">
    var data = null;
    $(document).ready(function () {
      var tpl = $("#treeTableTpl").html();
      Mustache.parse(tpl);
      Metronic.blockUI();
      $.ajax({
        url: '${ctx}/a/sys/job/list',
        type: 'get',
        error: function () {
          alert('error');
        },
        success: function (data) {
          addRow("#treeTableList", tpl, data, "0", true);
          $("#treeTable").treeTable({expandLevel: 2});
        }
      });
      Metronic.unblockUI();
      <%--var data = ${fns:toJson(list)};--%>
      <%--var rootId = "${not empty parentId ? parentId : '0'}";--%>

    });
    function addRow(list, tpl, data, pid, root) {
      for (var i = 0; i < data.length; i++) {
        var row = data[i];
        if (row.parentId == pid) {
          $(list).append(Mustache.render(tpl, {
            pid: (root ? 0 : pid), row: row
          }));
          addRow(list, tpl, data, row.id);
        }
      }
    }
  </script>
</head>
<body>
<!-- BEGIN PAGE CONTENT-->
<div class="row" style="padding: 15px 0px;">
  <div class="col-md-12">
    <!-- BEGIN PORTLET-->
    <div class="portlet light bordered">
      <div class="portlet-title">
        <div class="caption font-purple-plum">
          <i class="icon-speech font-purple-plum"></i>
          <span class="caption-subject bold uppercase">工作职务管理</span>
          <span class="caption-helper"></span>
        </div>
      </div>
      <div class="portlet-body">
        <table class="table table-hover table-light" id="treeTable" data-url="" data-template="#treeTableTpl">
          <thead>
          <tr>
            <th>工作职责</th>
            <th>显示图标</th>
            <th>排序</th>
            <th>是否显示</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody id="treeTableList"></tbody>
        </table>
      </div>
    </div>
    <!-- END PORTLET-->
  </div>
</div>
<!-- END PAGE CONTENT-->
<!-- END PAGE CONTENT-->
<script id="treeTableTpl" type="x-tmpl-mustache">
  <tr id="{{row.id}}" pId="{{pid}}">
    <td><a href="${ctx}/sys/job/form?id={{row.id}}">{{row.name}}</a></td>
    <td>{{row.icon}}</td>
    <td>{{row.weight}}</td>
    <td>{{row.isShow}}</td>
    <td>
      <a href="${ctx}/sys/office/form?id={{row.id}}">修改</a>
      <a href="${ctx}/sys/office/delete?id={{row.id}}" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
      <a href="${ctx}/sys/office/form?parent.id={{row.id}}">添加下级机构</a>
    </td>
  </tr>
</script>
</body>
</html>
