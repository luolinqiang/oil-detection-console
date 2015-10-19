$package('jeecg.discoveryCar');
jeecg.discoveryCar = function () {
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
                title: '找车信息',
                url: 'dataList.do',
                columns: [[
                    {field: 'id', checkbox: true},
                    {
                        field: 'real_name', title: '用户', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.real_name;
                        }
                    },
                    {
                        field: 'goods', title: '货物', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.goods;
                        }
                    },
                    {
                        field: 'weight', title: '重量', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.weight;
                        }
                    },
                    {
                        field: 'price', title: '价格', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.price;
                        }
                    },
                    {
                        field: 'need_tank_desc', title: '所需罐体', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.need_tank_desc;
                        }
                    },
                    {
                        field: 'delivery_time', title: '发货时间', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.delivery_time;
                        }
                    },
                    {
                        field: 'remark', title: '备注', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.remark;
                        }
                    },
                    {
                        field: 'sender_name', title: '发货人姓名', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.sender_name;
                        }
                    },
                    {
                        field: 'sender_phone', title: '发货人手机', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.sender_phone;
                        }
                    },
                    {
                        field: 'origin_name', title: '始发地', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.origin_name;
                        }
                    },
                    {
                        field: 'dest_name', title: '目的地', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.dest_name;
                        }
                    },
                    {
                        field: 'download_contract', title: '是否下载合同范本', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "否";
                            }
                            if (value == 1) {
                                return "是";
                            }
                            return row.download_contract;
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
                ]],
                toolbar: [
                    {
                        id: 'btnedit', iconCls: '', text: '列表', btnType: 'authRole', handler: function () {
                    }
                    }
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
    jeecg.discoveryCar.init();
});