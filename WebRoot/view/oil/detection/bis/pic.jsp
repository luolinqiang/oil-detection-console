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
			<label class="ui-label">类型（1：banner 2：商品）:</label><input name="type" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">图片地址:</label><input name="pic_url" class="easyui-box ui-text" style="width:100px;">
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
		     	   <div class="ftitle">图片信息</div>
					<div class="fitem">
						<label>类型（1：banner 2：商品）</label>
						<input name="type" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写类型（1：banner 2：商品）">
					</div>
					<div class="fitem">
						<label>图片地址</label>
						<input name="pic_url" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写图片地址">
					</div>
					<div class="fitem">
						<label>归属id</label>
						<input name="owner_id" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写归属id">
					</div>
					<div class="fitem">
						<label>顺序</label>
						<input name="order" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写顺序">
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
						<label>状态(0:删除 1：有效)</label>
						<input name="state" type="text" maxlength="" class="easyui-validatebox" data-options="" missingMessage="请填写状态(0:删除 1：有效)">
					</div>
					<div class="fitem">
						<label>备注</label>
						<input name="remark" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写备注">
					</div>
					<div class="fitem">
						<label>点击进入的链接地址</label>
						<input name="link_url" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写点击进入的链接地址">
					</div>
					<div class="fitem">
						<label>文件内容</label>
						<input name="content" type="text" maxlength="16777215" class="easyui-validatebox" data-options="" missingMessage="请填写文件内容">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-pic.js"></script>
  </body>
</html>
