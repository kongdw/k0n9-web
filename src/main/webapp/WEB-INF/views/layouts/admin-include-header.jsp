<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<script src="${ctx}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>

<link href="${ctx}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/plugins/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->

<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css"/>

<!-- BEGIN THEME STYLES -->
<link href="${ctx}/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="${ctx}/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/global/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="${ctx}/assets/img/favicon.ico" />
<script type="text/javascript">
    var WEB_ROOT = "${ctx}";
</script>