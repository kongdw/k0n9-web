<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>用户管理</title>
  <script src="${ctx}/assets/admin/js/table-ajax.js" type="text/javascript"></script>
  <script src="${ctx}/assets/global/scripts/datatable.js" type="text/javascript"></script>
</head>
<body>
<!-- BEGIN PAGE CONTENT-->
<div class="row" style="padding: 10px 0px 0px 0px">
  <div class="col-md-12">
    <!-- Begin: life time stats -->
    <div class="portlet light">
      <div class="portlet-title">
        <div class="caption">
          <i class="fa fa-shopping-cart"></i>用户列表
        </div>
        <div class="actions">
          <a href="${ctx}/a/sys/user/edit" class="btn default blue-hoki-stripe" data-toggle="modal" data-target="#ajax">
            <i class="fa fa-plus"></i><span class="hidden-480"> 添加用户 </span>
          </a>

          <div class="btn-group">
            <a class="btn default blue-hoki-stripe" href="javascript:;" data-toggle="dropdown">
              <i class="fa fa-share"></i>
              <span class="hidden-480">Tools</span>
              <i class="fa fa-angle-down"></i>
            </a>
            <ul class="dropdown-menu pull-right">
              <li>
                <a href="javascript:;">
                  Export to Excel </a>
              </li>
              <li>
                <a href="javascript:;">
                  Export to CSV </a>
              </li>
              <li>
                <a href="javascript:;">
                  Export to XML </a>
              </li>
              <li class="divider">
              </li>
              <li>
                <a href="javascript:;">
                  Print Invoices </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="portlet-body">
        <table class="table table-striped table-bordered table-hover" id="datatable_ajax" data-url="${ctx}/a/sys/user/list">
          <thead>
          <tr role="row">
            <th width="2%">
              <input type="checkbox" class="group-checkable">
            </th>
            <th width="10%">
              用户名
            </th>
            <th width="15%">
              email
            </th>
            <th width="15%">
              电话号
            </th>
            <th width="10%">
              注册时间
            </th>
            <th width="10%">
              状态
            </th>
            <th width="5%">
              已删除
            </th>
            <th width="5%">
              管理员
            </th>
            <th width="15%">
              操作
            </th>
          </tr>
          <tr role="row" class="filter">
            <td>
            </td>
            <td>
              <input type="text" class="form-control form-filter input-sm" name="search_username">
            </td>
            <td>
              <input type="text" class="form-control form-filter input-sm" name="search_email">
            </td>
            <td>
              <input type="text" class="form-control form-filter input-sm" name="search_phoneNumber">
            </td>
            <td>
              <div class="input-group date date-picker margin-bottom-5" data-date-format="yyyy-mm-dd">
                <input type="text" class="form-control form-filter input-sm" readonly
                       name="search_createDate" placeholder="From">
											<span class="input-group-btn">
											<button class="btn btn-sm default" type="button"><i
                          class="fa fa-calendar"></i></button>
											</span>
              </div>
            </td>
            <td>
              <div class="margin-bottom-5">

              </div>
            </td>
            <td>
              <select name="search_deleted" class="form-control form-filter input-sm">
                <option value="">请选择...</option>
                <option value="true">是</option>
                <option value="false">否</option>
              </select>
            </td>
            <td>
              <select name="search_isAdmin" class="form-control form-filter input-sm">
                <option value="">请选择...</option>
                <option value="true">是</option>
                <option value="false">否</option>
              </select>
            </td>
            <td>
              <div class="margin-bottom-5">
                <div class="btn-group-sm">
                  <button class="btn blue-hoki filter-submit fa fa-search">查询</button>
                  <button class="btn blue-hoki filter-cancel fa fa-times">重置</button>
                </div>
              </div>
            </td>
          </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <!-- End: life time stats -->
</div>
</div>
<!-- END PAGE CONTENT-->
<script type="text/javascript">
    $(document).ready(function () {
      TableAjax.init("datatable_ajax");
    });
  <%--var dataTable_config = {--%>
    <%--//"bStateSave": true, //是否把获得数据存入cookie--%>
    <%--//"bLengthChange":false, //关闭每页显示多少条数据--%>
    <%--"bProcessing": true,--%>
    <%--"bAutoWidth": false,//自动宽度--%>
    <%--"bServerSide": true,--%>
    <%--"sAjaxSource": "<%=request.getContextPath()%>/get2",--%>
    <%--"fnServerData": retrieveData,--%>
    <%--"bPaginate": true,  //是否分页。--%>
    <%--"bFilter": false,--%>
    <%--"sPaginationType": "full_numbers",      //分页样式--%>
    <%--"pageLength": 10,--%>
    <%--"aoColumns": [{--%>
      <%--"mDataProp": "id",--%>
    <%--}, {--%>
      <%--"mDataProp": "rentRuleId"--%>
    <%--}, {--%>
      <%--"mDataProp": "ruleName"--%>
    <%--}, {--%>
      <%--"mDataProp": "isEnable"--%>
    <%--}, {--%>
      <%--"mDataProp": "id"--%>
    <%--},],--%>
    <%--"lengthMenu": [--%>
      <%--[10, 15, 20],--%>
      <%--[10, 15, 20] // 更改每页显示记录数--%>
    <%--],--%>

    <%--"language": {--%>
      <%--"lengthMenu": "  _MENU_ 条数据",--%>
      <%--"emptyTable": "表格中没有数据~",--%>
      <%--"info": "显示 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",--%>
      <%--"infoEmpty": "没有数据~",--%>
      <%--"infoFiltered": "(在 _MAX_ 条数据中查询)",--%>
      <%--"lengthMenu": "显示 _MENU_ 条数据",--%>
      <%--"search": "查询:",--%>
      <%--"zeroRecords": "没有找到对应的数据",--%>
      <%--"paginate": {--%>
        <%--"previous": "上一页",--%>
        <%--"next": "下一页",--%>
        <%--"last": "末页",--%>
        <%--"first": "首页"--%>
      <%--}--%>
    <%--},--%>
    <%--"columnDefs": [--%>
      <%--{--%>
        <%--sDefaultContent: '',--%>
        <%--aTargets: ['_all']--%>
      <%--}--%>
      <%--, {  // 设置默认值--%>
        <%--'orderable': false,--%>
        <%--aTargets: [0],--%>
      <%--},--%>
      <%--{--%>
        <%--aTargets: [0],--%>
        <%--"render": function (data, type, full, meta) {--%>
          <%--return '<input type="checkbox" class="group-checkable" data-set="#datatable_ajax .checkboxes"/>';--%>
        <%--}--%>
      <%--},--%>
    <%--],--%>
    <%--"order": [--%>
      <%--[1, "asc"]--%>
    <%--]--%>
  <%--};--%>

  <%--oTable = $('#datatable_ajax').dataTable(dataTable_config);--%>

  <%--function retrieveData(sSource, aoData, fnCallback) {--%>
    <%--//查询条件称加入参数数组--%>
    <%--var rentRuleId = document.getElementById('rentRuleId').value;--%>
    <%--//alert(rentRuleId);--%>
    <%--$.ajax({--%>
      <%--type: "POST",--%>
      <%--url: sSource,--%>
      <%--dataType: "json",--%>
      <%--data: "jsonParam=" + JSON.stringify(aoData) + "&isHistory=0&rentRuleId=" + rentRuleId,--%>
      <%--success: function (data) {--%>
        <%--//$("#url_sortdata").val(data.aaData);--%>
        <%--fnCallback(data); //服务器端返回的对象的returnObject部分是要求的格式--%>
      <%--}--%>
    <%--});--%>
  <%--}--%>
</script>
<div class="modal fade" id="ajax" role="basic" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
        <img src="${ctx}/assets/global/img/loading-spinner-grey.gif" alt="" class="loading">
											<span>
											&nbsp;&nbsp;Loading... </span>
      </div>
    </div>
  </div>
</div>
</body>
</html>
