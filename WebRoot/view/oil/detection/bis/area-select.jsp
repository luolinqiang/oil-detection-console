<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<%--<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件"--%>
<%--data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false">--%>
<%--<form id="searchForm-select">--%>
<%--<p class="ui-fields">--%>
<%--<label class="ui-label">审核状态:</label>--%>
<%--<select class="easyui-combobox" name="state" data-options="required:true">--%>
<%--<option value="1" selected="selected">待审核</option>--%>
<%--<option value="2">审核通过</option>--%>
<%--</select>--%>
<%--<label class="ui-label">类型:</label>--%>
<%--<select class="easyui-combobox" name="type" data-options="">--%>
<%--<option value="" selected="selected"></option>--%>
<%--<option value="1">非直营</option>--%>
<%--<option value="2">直营</option>--%>
<%--</select>--%>
<%--<label class="ui-label">公司名:</label><input name="company_name" class="easyui-box ui-text"--%>
<%--style="width:100px;">--%>
<%--</p>--%>
<%--<a href="#" id="btn-search-select" class="easyui-linkbutton" iconCls="icon-search">查询</a>--%>
<%--</form>--%>
<%--</div>--%>
<!--  Search panel end -->

<!-- Data List -->
<%--<div region="center" border="false">--%>
<%--<table id="data-list-select"></table>--%>
<%--</div>--%>

<table id="supplier-supplier-dialog" class="easyui-datagrid" title="" style="width:780px;height:300px"
       data-options="singleSelect:true,collapsible:true,url:'/area/dataList.do',method:'post'">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:80,hidden:true">ID</th>
        <%--<th data-options="field:'type',width:100">类型</th>--%>
        <th data-options="field:'area_code',width:80,align:'right'">区域编码</th>
        <th data-options="field:'area_name',width:80,align:'right'">区域名称</th>
        <%--<th data-options="field:'state',width:60,align:'center'">状态</th>--%>
    </tr>
    </thead>
</table>

<%--<script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-supplier-select.js"></script>--%>
</body>
</html>
