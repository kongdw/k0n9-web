<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>测试系统</title>

</head>
<body>
<table id="grid-sys-area-index"></table>
<div id="grid-pager"></div>
<script type="text/javascript">
  $(document).ready(function () {
    $("#grid-sys-area-index").jqGrid({
      url: '${ctx}/a/sys/area/list',
      mtype: "GET",
      styleUI : 'Bootstrap',
      datatype: "json",
      jsonReader: {repeatitems: false, root: "list", total: "pages", records: "total"},
      colModel: [
        { label: 'ID', name: 'id', key: true,editable:true, width: 75 },
        { label: 'parentIds', name: 'parentIds',editable:true, width: 150 },
        { label: 'parent.id', name: 'parent.id',editable:true, width: 150 },
        { label: 'code', name: 'code',editable:true, width: 150 },
        { label: 'name', name: 'name',editable:true, width: 150 },
        { label: 'type', name: 'type',editable:true, width: 150 },
        { label: 'sort', name: 'sort',editable:true, width: 150 },
        { label:'remarks', name: 'remarks',editable:true, width: 150 }
      ],
      viewrecords: true,
      height: 250,
      rowNum: 20,
      pager: "#grid-pager",
      editurl:"${ctx}/a/sys/area/edit"
    });
    $('#grid-sys-area-index').navGrid('#grid-pager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {
          editCaption: "The Edit Dialog",
          recreateForm: true,
          checkOnUpdate : true,
          checkOnSubmit : true,
          closeAfterEdit: true,
          errorTextFormat: function (data) {
            return 'Error: ' + data.responseText
          }
        },
        // options for the Add Dialog
        {
          closeAfterAdd: true,
          recreateForm: true,
          errorTextFormat: function (data) {
            return 'Error: ' + data.responseText
          }
        },
        // options for the Delete Dailog
        {
          errorTextFormat: function (data) {
            return 'Error: ' + data.responseText
          }
        });
  });

</script>
</body>
</html>
