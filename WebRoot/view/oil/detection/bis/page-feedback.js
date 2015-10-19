$package('jeecg.feedback');
jeecg.feedback = function () {
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
                title: '反馈',
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
                        field: 'content', title: '反馈内容', align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return row.content;
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
    jeecg.feedback.init();
});