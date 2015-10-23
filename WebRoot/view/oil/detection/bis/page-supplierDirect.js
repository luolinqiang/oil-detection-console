$package('jeecg.supplier');
jeecg.supplier = function () {
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
                title: '供应商管理',
                url: 'dataList.do',
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
                            return '<img src="/pic/show/' + row.company_logo + '.do" style="width: 50px;height: 50px;" alt="">';
                            //return row.company_logo;
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
                            jeecg.ajaxJson("/supplier/save.do?id=" + record[0].id + "&state=2", [], function (data) {
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
                            jeecg.ajaxJson("/supplier/save.do?id=" + record[0].id + "&state=1", [], function (data) {
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
            $("#company_type").combobox({
                url: '/dic/dataJson.do?group_code=company_type',
                valueField: 'id',
                textField: 'name'
            });

            _box = new YDataGrid(_this.config);
            _box.init();
        }
    }
    return _this;
}();

$(function () {
    jeecg.supplier.init();
});