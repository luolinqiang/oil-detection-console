$package('jeecg.dictionary');
jeecg.dictionary = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'字典信息',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'group_code',title:'分组编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.group_code;
							}
						},
					{field:'group_name',title:'分组名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.group_name;
							}
						},
					{field:'code',title:'编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.code;
							}
						},
					{field:'name',title:'名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.name;
							}
						},
					{field:'pid',title:'树的父节点',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.pid;
							}
						},
					{field:'create_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.create_time;
							}
						},
					{field:'update_time',title:'修改时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.update_time;
							}
						},
					{field:'state',title:'状态（0：删除 1：有效 2：停用）',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.state;
							}
						},
					{field:'remark',title:'描述',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remark;
							}
						},
					]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	jeecg.dictionary.init();
});