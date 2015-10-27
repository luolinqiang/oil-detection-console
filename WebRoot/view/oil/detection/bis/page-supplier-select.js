$package('jeecg.supplier');
jeecg.supplier.init = function () {

}

$(function () {
    var Grid = $('#data-list-select');
    //初始化表格
    var dataconfig = {
        //title: '选择供应商',
        iconCls: 'icon-save',
        fit: true,
        //height: dataGrid.height || 365,
        border: false,
        nowrap: true,
        autoRowHeight: false,
        striped: false,
        collapsible: false,
        remoteSort: false,
        pagination: true,
        rownumbers: true,
        singleSelect: false,
        checkOnSelect: false,
        selectOnCheck: false,
        url: "/supplier/dataList.do",
        method: 'post',
        loadMsg: 'Loading in ...',
        idField: 'id',
        columns: [[
            {field: 'id', checkbox: true},
            {
                field: 'type', title: '类型', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "非直营";
                    }
                    if (value == 2) {
                        return "直营";
                    }
                    return row.type;
                }
            },
            {
                field: 'company_name', title: '公司名', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.company_name;
                }
            },
            {
                field: 'company_logo', title: '企业logo', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.company_logo;
                }
            },
            {
                field: 'contacts', title: '联系人', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.contacts;
                }
            },
            {
                field: 'phone', title: '联系电话', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.phone;
                }
            },
            {
                field: 'area_id', title: '所在地id', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.area_id;
                }
            },
            {
                field: 'address', title: '地址', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.address;
                }
            },
            {
                field: 'operate_product', title: '经营产品', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.operate_product;
                }
            },
            {
                field: 'oil_name', title: '油库名称', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.oil_name;
                }
            },
            {
                field: 'oil_address', title: '油库地址', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.oil_address;
                }
            },
            {
                field: 'company_type_desc', title: '企业类型', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.company_type_desc;
                }
            },
            {
                field: 'company_desc', title: '企业简介', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.company_desc;
                }
            },
            {
                field: 'create_time', title: '创建时间', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.create_time;
                }
            },
            {
                field: 'update_time', title: '修改时间', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    return row.update_time;
                }
            },
            {
                field: 'state', title: '状态', align: 'center', sortable: true,
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "待审核";
                    }
                    if (value == 2) {
                        return "审核通过";
                    }
                    return row.state;
                }
            }
        ]],
        //toolbar: getToolbar(),
        onLoadSuccess: function () {
            Grid.datagrid('unselectAll');
            Grid.datagrid('uncheckAll');
        },
        onSelect: function (rowIndex, rowData) {
            //选择一行
            var rows = Grid.datagrid('getRows');
            $.each(rows, function (i) {
                if (i != rowIndex) {
                    Grid.datagrid('uncheckRow', i);
                    Grid.datagrid('unselectRow', i);
                }
            })
            Grid.datagrid('checkRow', rowIndex);
        }
    };
    alert(111)
    Grid.datagrid(dataconfig);
    //jeecg.supplier.init();
});