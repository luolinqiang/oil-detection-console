$package('jeecg.order');
jeecg.order = function () {
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
                title: '订单管理',
                url: 'dataList.do',
                columns: [[
                    {field: 'id', checkbox: true},
                    {
                        field: 'user_name', title: '用户', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.user_id;
                        }
                    },
                    {
                        field: 'product_name', title: '产品', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.product_id;
                        }
                    },
                    {
                        field: 'supplier_name', title: '供应商id', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.supplier_id;
                        }
                    },
                    {
                        field: 'order_type', title: '订单类型', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 1) {
                                return "直营订单";
                            }
                            if (value == 2) {
                                return "免费代采";
                            }
                            return row.order_type;
                        }
                    },
                    {
                        field: 'price', title: '单价', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.price;
                        }
                    },
                    {
                        field: 'number', title: '数量', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.number;
                        }
                    },
                    {
                        field: 'total_price', title: '订单总价', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.total_price;
                        }
                    },
                    {
                        field: 'pay_type_desc', title: '付款方式', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.pay_type;
                        }
                    },
                    {
                        field: 'delivery_type_desc', title: '提货方式', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.delivery_type;
                        }
                    },
                    {
                        field: 'car_number', title: '提货车牌号', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.car_number;
                        }
                    },
                    {
                        field: 'receiver_name', title: '收货人姓名', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.receiver_name;
                        }
                    },
                    {
                        field: 'receiver_phone', title: '收货人电话', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.receiver_phone;
                        }
                    },
                    {
                        field: 'receiver_addr', title: '收货人地址', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.receiver_addr;
                        }
                    },
                    {
                        field: 'other_require', title: '其他要求', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.other_require;
                        }
                    },
                    {
                        field: 'create_time', title: '下单时间', align: 'center', sortable: true,
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
                        field: 'arrival_time', title: '送达时间', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.arrival_time;
                        }
                    },
                    {
                        field: 'remark', title: '备注', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.remark;
                        }
                    },
                    {
                        field: 'state', title: '状态', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 1) {
                                return "审核中";
                            }
                            if (value == 2) {
                                return "未完成";
                            }
                            if (value == 3) {
                                return "已完成";
                            }
                            if (value == 4) {
                                return "交易取消";
                            }
                            return row.state;
                        }
                    },
                ]],
                toolbar: [
                    {
                        id: '',
                        text: '',
                        iconCls: '',
                        btnType: '',
                    },
                ]
            }
        },
        init: function () {
            _box = new YDataGrid(_this.config);
            _box.init();
        }
    }
    return _this;
}();

$(function () {
    jeecg.order.init();
});