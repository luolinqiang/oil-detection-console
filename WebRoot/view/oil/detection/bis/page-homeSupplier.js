$package('jeecg.homeSetting');
jeecg.homeSetting = function () {
    var _box = null;
    var _this = {
        config: {
            action: {
                save: "supplierSave.do"
            },
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
                title: '首页设置',
                url: 'dataList.do?type=2',
                columns: [[
                    {field: 'id', checkbox: true},
                    {
                        field: 'target_id', title: '目标id', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {
                        field: 'sort_desc', title: '排序', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.sort_desc;
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
                                return "暂存"
                            }
                            if (value == 2) {
                                return "已发布"
                            }
                            return row.state;
                        }
                    },
                ]]
            }
        },
        init: function () {
            $("#target_id").combobox({
                url: '/supplier/dataJson.do?type=2',
                valueField: 'id',
                textField: 'company_name'
            });

            _box = new YDataGrid(_this.config);
            _box.init();
        }
    }
    return _this;
}();

$(function () {
    jeecg.homeSetting.init();
});