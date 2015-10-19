$package('jeecg.supplier');
jeecg.supplier = function(){
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
  				title:'供应商审核',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'type',title:'类型（1：非直营 2：直营）',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.type;
							}
						},
					{field:'company_name',title:'公司名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_name;
							}
						},
					{field:'company_logo',title:'企业logo',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_logo;
							}
						},
					{field:'contacts',title:'联系人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.contacts;
							}
						},
					{field:'phone',title:'联系电话',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.phone;
							}
						},
					{field:'area_id',title:'所在地id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.area_id;
							}
						},
					{field:'address',title:'地址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.address;
							}
						},
					{field:'operate_product',title:'经营产品',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.operate_product;
							}
						},
					{field:'oil_name',title:'油库名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.oil_name;
							}
						},
					{field:'oil_address',title:'油库地址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.oil_address;
							}
						},
					{field:'company_type',title:'企业类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_type;
							}
						},
					{field:'company_desc',title:'企业简介',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_desc;
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
					{field:'state',title:'状态(0：删除，1：正常)',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.state;
							}
						},
					{field:'remark',title:'扩展',align:'center',sortable:true,
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
	jeecg.supplier.init();
});