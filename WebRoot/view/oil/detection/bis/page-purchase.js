$package('jeecg.purchase');
jeecg.purchase = function () {
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
                title: '采购商管理',
                url: 'dataList.do',
                columns: [[
                    {field: 'id', checkbox: true},
                    {
                        field: 'oil_type', title: '油类型', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 31) {
                                return "柴油";
                            }
                            if (value == 32) {
                                return "汽油";
                            }
                            return row.oil_type;
                        }
                    },
                    {
                        field: 'purchase_type', title: '采购类型', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 1) {
                                return "采购需求";
                            }
                            if (value == 2) {
                                return "代采申请";
                            }
                            return row.purchase_type;
                        }
                    },
                    {
                        field: 'quality_standard_desc', title: '质量标准', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.quality_standard_desc;
                        }
                    },
                    {
                        field: 'product_model_desc', title: '产品型号', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.product_model_desc;
                        }
                    },
                    {
                        field: 'number', title: '需求数量', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.number;
                        }
                    },
                    {
                        field: 'pay_type_desc', title: '付款方式', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.pay_type_desc;
                        }
                    },
                    {
                        field: 'delivery_type_desc', title: '提货方式', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.delivery_type_desc;
                        }
                    },
                    {
                        field: 'delivery_addr', title: '提货地址', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.delivery_addr;
                        }
                    },
                    {
                        field: 'conditions', title: '条件', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.conditions;
                        }
                    },
                    {
                        field: 'other_require', title: ' 其他要求', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.other_require;
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
                    //{
                    //    field: 'user_id', title: '用户id', align: 'center', sortable: true,
                    //    formatter: function (value, row, index) {
                    //        return row.user_id;
                    //    }
                    //},
                    //{
                    //    field: 'product_id', title: '产品id', align: 'center', sortable: true,
                    //    formatter: function (value, row, index) {
                    //        return row.product_id;
                    //    }
                    //},
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
                            //$("#audit-win").dialog({
                            //    title: '发货操作',
                            //    href: '/supplier/list.shtml',
                            //    iconCls: 'icon-edit',
                            //    modal: true,
                            //    closed: true
                            //});
                            //$("#audit-win").dialog("open");
                            var record = _box.utils.getCheckedRows();
                            if (!_box.utils.checkSelectOne(record)) {
                                return;
                            }
                            jeecg.ajaxJson("/purchase/save.do?id=" + record[0].id + "&state=2", [], function (data) {
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
                            jeecg.ajaxJson("/purchase/save.do?id=" + record[0].id + "&state=1", [], function (data) {
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
                        id: 'btnsupsel',
                        text: '选择供应商',
                        iconCls: 'icon-edit',
                        btnType: 'audit',
                        handler: function () {
                            var recordParent = _box.utils.getCheckedRows();
                            if (!_box.utils.checkSelectOne(recordParent)) {
                                return;
                            }
                            $("#supplier-select-win").dialog({
                                title: '选择供应商',
                                href: '/supplier/listSelect.do',
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
                                            jeecg.ajaxJson("/order/save.do?purchaseId=" + recordParent[0].id + "&supplierId=" + record[0].id, [], function (data) {
                                                if (data.success) {
                                                    _box.handler.refresh();
                                                    jeecg.alert('提示', "操作成功");
                                                } else {
                                                    jeecg.alert('提示', "操作失败");
                                                }
                                            });
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

            $("#pay_type").combobox({
                url: '/dic/dataJson.do?group_code=pay_type',
                valueField: 'id',
                textField: 'name'
            });

            $("#delivery_type").combobox({
                url: '/dic/dataJson.do?group_code=delivery_type',
                valueField: 'id',
                textField: 'name'
            });

            _box = new YDataGrid(_this.config);
            _box.init();
            $("#btn-search").trigger("click");
        }
    };
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
    jeecg.purchase.init();
});