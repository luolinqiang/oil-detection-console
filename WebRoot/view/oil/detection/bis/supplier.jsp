<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">类型（1：非直营 2：直营）:</label><input name="type" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">公司名:</label><input name="company_name" class="easyui-box ui-text" style="width:100px;">
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">供应商审核</div>
					<div class="fitem">
						<label>类型（1：非直营 2：直营）</label>
						<input name="type" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写类型（1：非直营 2：直营）">
					</div>
					<div class="fitem">
						<label>公司名</label>
						<input name="company_name" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写公司名">
					</div>
					<div class="fitem">
						<label>企业logo</label>
						<input name="company_logo" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写企业logo">
					</div>
					<div class="fitem">
						<label>联系人</label>
						<input name="contacts" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写联系人">
					</div>
					<div class="fitem">
						<label>联系电话</label>
						<input name="phone" type="text" maxlength="16" class="easyui-validatebox" data-options="" missingMessage="请填写联系电话">
					</div>
					<div class="fitem">
						<label>所在地id</label>
						<input name="area_id" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写所在地id">
					</div>
					<div class="fitem">
						<label>地址</label>
						<input name="address" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写地址">
					</div>
					<div class="fitem">
						<label>经营产品</label>
						<input name="operate_product" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写经营产品">
					</div>
					<div class="fitem">
						<label>油库名称</label>
						<input name="oil_name" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写油库名称">
					</div>
					<div class="fitem">
						<label>油库地址</label>
						<input name="oil_address" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写油库地址">
					</div>
					<div class="fitem">
						<label>企业类型</label>
						<input name="company_type" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写企业类型">
					</div>
					<div class="fitem">
						<label>企业简介</label>
						<input name="company_desc" type="text" maxlength="65535" class="easyui-validatebox" data-options="" missingMessage="请填写企业简介">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="create_time" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>修改时间</label>
						<input name="update_time" type="text" maxlength="" class="easyui-validatebox" data-options="required:true" missingMessage="请填写修改时间">
					</div>
					<div class="fitem">
						<label>状态(0：删除，1：正常)</label>
						<input name="state" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写状态(0：删除，1：正常)">
					</div>
					<div class="fitem">
						<label>扩展</label>
						<input name="remark" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写扩展">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-supplier.js"></script>
  </body>
</html>
