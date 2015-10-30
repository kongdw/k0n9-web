<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title><sitemesh:write property='title'/></title>
  <script src="${ctx}/assets/plugins/jqGrid/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="${ctx}/assets/plugins/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
  <script src="${ctx}/assets/plugins/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
  <link href="${ctx}/assets/plugins/jqGrid/css/ui.jqgrid.css" rel="stylesheet" type="text/css">
  <link href="${ctx}/assets/plugins/jqGrid/css/ui.jqgrid-bootstrap-ui.css" rel="stylesheet" type="text/css">
  <link href="${ctx}/assets/plugins/jqGrid/css/ui.jqgrid-bootstrap.css" rel="stylesheet" type="text/css">
  <script type="text/javascript">
    var WEB_ROOT = "${ctx}";
  </script>
</head>
<body>
<sitemesh:write property='body'/>
</body>
</html>
