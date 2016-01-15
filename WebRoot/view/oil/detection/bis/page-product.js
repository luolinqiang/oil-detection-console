$package('jeecg.product');
jeecg.product = function () {
    var _box = null;
    var _this = {
        config: {
            event: {
                add: function () {
                    $('#typeIds_combobox').combobox('reload');
                    _box.handler.add();
                },
                edit: function () {
                    $('#typeIds_combobox').combobox('reload');
                    _box.handler.edit();
                }
            },
            dataGrid: {
                title: '产品管理',
                url: 'dataList.do',
                columns: [[
                    {field: 'id', checkbox: true},
                    {
                        field: 'supplier_name', title: '供应商', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {
                        field: 'type', title: '产品类型', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 1) {
                                return "柴油";
                            }
                            if (value == 2) {
                                return "汽油";
                            }
                            return row.type;
                        }
                    },
                    {
                        field: 'inventory', title: '库存', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.inventory;
                        }
                    },
                    {
                        field: 'name', title: '产品名称', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.name;
                        }
                    },
                    {
                        field: 'price', title: '价格', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.price;
                        }
                    },
                    {
                        field: 'quality_standard_desc', title: '质量标准', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.quality_standard;
                        }
                    },
                    {
                        field: 'product_model_desc', title: '产品型号', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.product_model;
                        }
                    },
                    {
                        field: 'product_addr', title: '提油地点', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.product_addr;
                        }
                    },
                    {
                        field: 'density', title: '密度', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.density;
                        }
                    },
                    {
                        field: 'flash_point', title: '闪点', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.flash_point;
                        }
                    },
                    {
                        field: 'cetane_number', title: '十六烷值', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.cetane_number;
                        }
                    },
                    {
                        field: 'cfpp', title: '冷滤点', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.cfpp;
                        }
                    },
                    {
                        field: 'color', title: '颜色', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.color;
                        }
                    },
                    {
                        field: 'boiling_range', title: '馏程', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.boiling_range;
                        }
                    },
                    {
                        field: 'details', title: '详情', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.details;
                        }
                    },
                    {
                        field: 'sulphur_content', title: '硫含量', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.sulphur_content;
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
                    },
                ]],
                toolbar: [
                    {
                        id: 'btnadd',
                        text: '添加',
                        iconCls: 'icon-add',
                        btnType: 'add',
                    },
                    {
                        id: 'btnedit',
                        text: '修改',
                        iconCls: 'icon-edit',
                        btnType: 'edit',
                    },
                    {
                        id: 'btnremove',
                        text: '删除',
                        iconCls: 'icon-remove',
                        btnType: 'remove',
                    },
                    {
                        id: 'btnauditok',
                        text: '审核通过',
                        iconCls: 'icon-ok',
                        btnType: 'audit',
                        handler: function () {
                            var record = _box.utils.getCheckedRows();
                            if (!_box.utils.checkSelectOne(record)) {
                                return;
                            }
                            jeecg.ajaxJson("/product/save.do?id=" + record[0].id + "&state=2", [], function (data) {
                                if (data.success) {
                                    _box.handler.refresh();
                                    jeecg.alert('提示', "操作成功");
                                } else {
                                    jeecg.alert('提示', "操作失败");
                                }
                            });
                        }
                    },
                    {
                        id: 'btnauditno',
                        text: '审核不通过',
                        iconCls: 'icon-no',
                        btnType: 'audit',
                        handler: function () {
                            var record = _box.utils.getCheckedRows();
                            if (!_box.utils.checkSelectOne(record)) {
                                return;
                            }
                            jeecg.ajaxJson("/product/save.do?id=" + record[0].id + "&state=1", [], function (data) {
                                if (data.success) {
                                    _box.handler.refresh();
                                    jeecg.alert('提示', "操作成功");
                                } else {
                                    jeecg.alert('提示', "操作失败");
                                }
                            });
                        }
                    },
                ]
            }
        },
        init: function () {
            $("#quality_standard").combobox({
                url: '/dic/dataJson.do?group_code=item_standard_diesel',
                valueField: 'id',
                textField: 'name'
            });

            $("#product_model").combobox({
                url: '/dic/dataJson.do?group_code=item_model_diesel',
                valueField: 'id',
                textField: 'name'
            });

            $("#color").combobox({
                url: '/dic/dataJson.do?group_code=color',
                valueField: 'id',
                textField: 'name'
            });

            $("#supplier-select-btn").click(function () {
                $("#supplier-select-win").dialog({
                    title: '选择供应商',
                    href: '/supplier/listSelect.shtml',
                    iconCls: 'icon-edit',
                    modal: true,
                    closed: true,
                    buttons: [
                        {
                            text: '选择',
                            handler: function () {
                                var record = Utils.getCheckedRows();
                                if (!Utils.checkSelectOne(record)) {
                                    return;
                                }
                                $("#supplier_id").val(record[0].id);
                                $("#supplier_name").val(record[0].company_name);
                                $("#supplier-select-win").dialog('close');
                            }
                        }, {
                            text: '关闭',
                            handler: function () {
                                $("#supplier-select-win").dialog('close');
                            }
                        }
                    ]
                });
                $("#supplier-select-win").dialog("open");
            });

            _box = new YDataGrid(_this.config);
            _box.init();
        }
    }
    return _this;
}();

//Grid 工具类
var Utils = {
    getCheckedRows: function () {
        return $("#supplier-supplier-dialog").datagrid('getChecked');
    },
    checkSelect: function (rows) {//检查grid是否有勾选的行, 有返回 true,没有返回true
        var records = rows;
        if (records && records.length > 0) {
            return true;
        }
        jeecg.alert('警告', '未选中记录.', 'warning');
        return false;

    },
    checkSelectOne: function (rows) {//检查grid是否只勾选了一行,是返回 true,否返回true
        var records = rows;
        if (!Utils.checkSelect(records)) {
            return false;
        }
        if (records.length == 1) {
            return true;
        }
        jeecg.alert('警告', '只能选择一行记录.', 'warning');
        return false;
    }
}

$(function () {
    jeecg.product.init();
});