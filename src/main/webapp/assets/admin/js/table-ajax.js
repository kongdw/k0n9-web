var TableAjax = function () {

    var initPickers = function () {
        //init date pickers
        $('.date-picker').datepicker({
            rtl: Metronic.isRTL(),
            autoclose: true,
            language: 'zh-CN'
        });
    }
    var handleRecords = function (table) {
        var $table = $("#" + table);
        var grid = new Datatable();
        var url = $table.attr("data-url");

        grid.init({
            src: $table,
            onSuccess: function (grid, response) {
                // grid:        grid object
                // response:    json object of server side ajax response
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error  
            },
            onDataLoad: function (grid) {

            },
            loadingMessage: '加载中...',
            dataTable: {
                // here you can define a typical datatable settings from http://datatables.net/usage/options
                // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
                // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
                // So when dropdowns used the scrollable div should be removed. 
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>t<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>",
                "bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.
                "lengthMenu": [
                    [10, 20, 50, 100, 150, -1],
                    [10, 20, 50, 100, 150, "All"] // change per page values here
                ],
                "pageLength": 10, // default record count per page
                "ajax": {
                    "type": "get",
                    "url": url // ajax source,

                },
                "columns": [
                    {
                        orderable: false,
                        data: null,
                        render: function (data, type, row) {
                            return '<input type="checkbox" name="id[]" value="' + row.id + '">';
                        }
                    },
                    {"data": "username"},
                    {"data": "email"},
                    {"data": "phoneNumber"},
                    {"data": "createDate"},
                    {"data": "status"},
                    {
                        orderable: false,
                        "data": null,
                        render: function (data, type, row) {
                            if (row.deleted == true) {
                                return '<input type="checkbox" checked value="' + row.id + '">';
                            }
                            return '<input type="checkbox" value="' + row.id + '">';
                        }
                    },
                    {
                        orderable: false,
                        "data": null,
                        render: function (data, type, row) {
                            if (row.isAdmin == true) {
                                return '<input type="checkbox" checked value="' + row.id + '">';
                            }
                            return '<input type="checkbox" value="' + row.id + '">';
                        }
                    },
                    {
                        "orderable": false,
                        "data": null,
                        "defaultContent": '<div class="btn-group-sm"><button class="btn blue-hoki fa fa-pencil">编辑</button><button class="btn blue-hoki fa fa-trash-o">删除</button></div>'
                    }
                ]
            }
        });

        // handle group actionsubmit button click
        grid.getTableWrapper().on('click', '.table-group-action-submit', function (e) {
            e.preventDefault();
            var action = $(".table-group-action-input", grid.getTableWrapper());
            if (action.val() != "" && grid.getSelectedRowsCount() > 0) {
                grid.setAjaxParam("customActionType", "group_action");
                grid.setAjaxParam("customActionName", action.val());
                grid.setAjaxParam("id", grid.getSelectedRows());
                grid.getDataTable().ajax.reload();
                grid.clearAjaxParams();
            } else if (action.val() == "") {
                Metronic.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'Please select an action',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            } else if (grid.getSelectedRowsCount() === 0) {
                Metronic.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'No record selected',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            }
        });
    }

    return {
        //main function to initiate the module
        initDataTableDefault: function(){
            $.extend($.fn.dataTable,{

            })
        },
        init: function (table) {
            initPickers();
            handleRecords(table);
        }
    };

}();