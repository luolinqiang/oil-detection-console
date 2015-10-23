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
<%--<form id="searchForm">--%>
<%--<p class="ui-fields">--%>
<%--<label class="ui-label">类型:</label>--%>
<%--<select name="type" class="easyui-combobox" data-options="required:true">--%>
<%--<option value="1" selected="banner">柴油</option>--%>
<%--<option value="2">直营专区</option>--%>
<%--<option value="3">厂商报价</option>--%>
<%--<option value="4">外链</option>--%>
<%--</select>--%>
<%--<label class="ui-label">目标id:</label><input name="target_id" class="easyui-box ui-text"--%>
<%--style="width:100px;">--%>
<%--</p>--%>
<%--<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>--%>
<%--</form>--%>
<%--</div>--%>
<!--  Search panel end -->

<!-- Data List -->
<div region="center" border="false">
    <table id="data-list"></table>
</div>

<!-- Edit Win&Form -->
<div id="edit-win" class="easyui-dialog" title="" data-options="closed:true,iconCls:'icon-save',modal:true"
     style="width:400px;height:380px;">
    <form id="editForm" class="ui-form" method="post">
        <input class="hidden" name="id">

        <div class="ui-edit">
            <div class="ftitle">首页设置</div>
            <div class="fitem">
                <label>自定义设置json格式</label>
                <input name="remark" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="自定义设置json格式">
            </div>
            <div class="fitem">
                <label>排序</label>
                <input name="sort_desc" type="text" maxlength="" class="easyui-numberbox" data-options="required:true"
                       missingMessage="请填写排序">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-homeCustom.js"></script>
</body>
</html>
