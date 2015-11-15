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
<div class="row" style="padding: 15px 0px">
    <div class="col-md-12">
        <!-- Begin: life time stats -->
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-shopping-cart"></i>用户列表
                </div>
                <div class="actions">
                    <a href="javascript:;" class="btn default blue-hoki-stripe">
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
                <table class="table table-striped table-bordered table-hover" id="datatable_ajax">
                    <thead>
                    <tr role="row" class="heading">
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
                            <input type="text" class="form-control form-filter input-sm" name="order_id">
                        </td>
                        <td>
                            <div class="input-group date date-picker margin-bottom-5" data-date-format="yyyy-mm-dd">
                                <input type="text" class="form-control form-filter input-sm" readonly
                                       name="order_date_from" placeholder="From">
											<span class="input-group-btn">
											<button class="btn btn-sm default" type="button"><i
                                                    class="fa fa-calendar"></i></button>
											</span>
                            </div>
                        </td>
                        <td>
                            <input type="text" class="form-control form-filter input-sm" name="order_customer_name">
                        </td>
                        <td>
                            <input type="text" class="form-control form-filter input-sm" name="order_ship_to">
                        </td>
                        <td>
                            <div class="margin-bottom-5">
                                <input type="text" class="form-control form-filter input-sm" name="order_price_from"
                                       placeholder="From"/>
                            </div>
                        </td>
                        <td>
                            <div class="margin-bottom-5">
                                <input type="text" class="form-control form-filter input-sm margin-bottom-5 clearfix"
                                       name="order_quantity_from" placeholder="From"/>
                            </div>
                        </td>
                        <td>
                            <select name="order_status" class="form-control form-filter input-sm">
                                <option value="">Select...</option>
                                <option value="pending">Pending</option>
                                <option value="closed">Closed</option>
                                <option value="hold">On Hold</option>
                                <option value="fraud">Fraud</option>
                            </select>
                        </td>
                        <td>
                            <div class="margin-bottom-5">
                                <div class="btn-group-sm">
                                    <button class="btn blue-hoki filter-submit"><i class="fa fa-search"></i>查询</button>
                                    <button class="btn blue-hoki filter-cancel"><i class="fa fa-times"></i>重置</button>
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
        TableAjax.init();
    });
</script>

<script id="rowTpl" type="x-tmpl-mustache">
    <input type="checkbox" name="id[]" value="{{row.id}}">,
    {{row.username}},
    {{row.email}},
    {{row.phoneNumber}},
    {{row.createDate}},
    {{row.status}},
    {{row.deleted}},
    {{row.isAdmin}},
    <button class='btn btn-default'>修改</button>

</script>
</body>
</html>
