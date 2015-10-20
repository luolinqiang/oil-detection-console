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
                ]]
            }
        },
        init: function () {
            $("#quality_standard").combobox({
                url: '/dic/dataJson.do?group_code=quality_standard',
                valueField: 'id',
                textField: 'name'
            });

            $("#product_model").combobox({
                url: '/dic/dataJson.do?group_code=product_model',
                valueField: 'id',
                textField: 'name'
            });

            $("#color").combobox({
                url: '/dic/dataJson.do?group_code=color',
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
    jeecg.product.init();
});