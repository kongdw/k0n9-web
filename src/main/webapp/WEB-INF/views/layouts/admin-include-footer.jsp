<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!--[if lt IE 9]>
<script src="${ctx}/assets/global/plugins/respond.min.js"></script>
<script src="${ctx}/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${ctx}/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="${ctx}/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${ctx}/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${ctx}/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${ctx}/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/bootstrap-gtreetable/bootstrap-gtreetable.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/admin/js/table-tree.js" type="text/javascript" ></script>
<script src="${ctx}/assets/global/plugins/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/global/plugins/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script>
  jQuery(document).ready(function() {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    QuickSidebar.init(); // init quick sidebar
    Demo.init(); // init demo features
    TableTree.init();
  });
</script>