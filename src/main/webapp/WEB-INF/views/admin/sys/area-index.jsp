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
    <table id="tree"></table>
    <div id="pager"></div>
  </div>
</div>
<!-- END PAGE CONTENT-->
<script type="text/javascript">
  jQuery(document).ready(function($) {
    jQuery('#tree').jqGrid({
      "width":800,
      "hoverrows":false,
      "viewrecords":false,
      "gridview":true,
      "url": WEB_ROOT +'/a/sys/area/list',
      "editurl" : WEB_ROOT +"/a/sys/area/edit",
      "ExpandColumn":"name",
      "height":"auto",
      "scrollrows":true,
      "treeGrid":true,
      "treedatatype":"json",
      "treeGridModel":"adjacency",
      "loadonce":true,
      "rowNum":1000,
      jsonReader: {repeatitems: false, root: "list", total: "total", records: "pages"},
      "treeReader":{
        "parent_id_field":"parentId",
        "level_field":"level",
        "leaf_field":"isLeaf",
        "expanded_field":"expanded",
        "loaded":"loaded",
        "icon_field":"icon"
      },
      "datatype":"json",
      "colModel":[
        {
          "name":"code",
          "label":"区域编码",
          "width":170,
          "editable":true
        },
        {
          "name":"name",
          "label":"区域名称",
          "width":170,
          "editable":true
        },{
          "name":"type",
          "label":"区域类型",
          "width":90,
          "editable":true
        },{
          "name":"remarks",
          "label":"备注",
          "width":90,
          "editable":true
        },{
          "name":"parentId",
          "hidden":true
        }
      ],
      "pager":"#pager"
    });
    // nable add
    jQuery('#tree').jqGrid('navGrid','#pager',
        {
          "edit":true,
          "add":true,
          "del":true,
          "search":false,
          "refresh":true,
          "view":false,
          "excel":false,
          "pdf":false,
          "csv":false,
          "columns":false
        },
        {"drag":true,"resize":true,"closeOnEscape":true,"dataheight":150},
        {"drag":true,"resize":true,"closeOnEscape":true,"dataheight":150}
    );
    jQuery('#tree').jqGrid('bindKeys');
  });
</script>
</body>
</html>
