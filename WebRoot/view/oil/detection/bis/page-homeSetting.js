$package('jeecg.homeSetting');
jeecg.homeSetting = function () {
    var _box = null;
    var _this = {
        config: {
            action: {
                save: "bannerSave.do"
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
                url: 'dataList.do',
                columns: [[
                    {field: 'id', checkbox: true},
                    {
                        field: 'target_id', title: '目标id', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return '<img src="/pic/show/' + row.target_id + '.do" style="width: 50px;height: 50px;" alt="">';
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
            _box = new YDataGrid(_this.config);
            _box.init();
        }
    }
    return _this;
}();

$(function () {
    jeecg.homeSetting.init();
});