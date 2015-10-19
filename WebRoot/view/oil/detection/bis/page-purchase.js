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
                            if (value == 1) {
                                return "柴油";
                            }
                            if (value == 2) {
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
                        field: 'update_time', title: 'update_time', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.update_time;
                        }
                    },
                    {
                        field: 'state', title: '状态(0：删除 1：审核中 2：审核通过)', align: 'center', sortable: true,
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
                    {
                        field: 'user_id', title: '用户id', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.user_id;
                        }
                    },
                    {
                        field: 'product_id', title: '产品id', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.product_id;
                        }
                    },
                ]]
            }
        },
        init: function () {
            $("#quality_standard").combobox({
                url: '/dic/dataJson.do?group_code=quality_standard',
                valueField: 'id',
                textField: 'name'
                //multiple:true,
            });

            _box = new YDataGrid(_this.config);
            _box.init();
        }
    }
    return _this;
}();

$(function () {
    jeecg.purchase.init();
});