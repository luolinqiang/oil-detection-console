$package('jeecg.pic');
jeecg.pic = function(){
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
  				title:'图片信息',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'type',title:'类型（1：banner 2：商品）',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.type;
							}
						},
					{field:'pic_url',title:'图片地址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.pic_url;
							}
						},
					{field:'owner_id',title:'归属id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.owner_id;
							}
						},
					{field:'order',title:'顺序',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.order;
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
					{field:'state',title:'状态(0:删除 1：有效)',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.state;
							}
						},
					{field:'remark',title:'备注',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remark;
							}
						},
					{field:'link_url',title:'点击进入的链接地址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.link_url;
							}
						},
					{field:'content',title:'文件内容',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.content;
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
	jeecg.pic.init();
});