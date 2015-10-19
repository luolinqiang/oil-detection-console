<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件"
     data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false">
    <form id="searchForm">
        <p class="ui-fields">
            <label class="ui-label">用户:</label><input name="real_name" class="easyui-box ui-text" style="width:100px;">
            <label class="ui-label">反馈内容:</label><input name="content" class="easyui-box ui-text" style="width:100px;">
        </p>
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </form>
</div>
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
            <div class="ftitle">反馈</div>
            <div class="fitem">
                <label>用户id</label>
                <input name="user_id" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写用户id">
            </div>
            <div class="fitem">
                <label>反馈内容</label>
                <input name="content" type="text" maxlength="65535" class="easyui-validatebox" data-options=""
                       missingMessage="请填写反馈内容">
            </div>
            <div class="fitem">
                <label>创建时间</label>
                <input name="create_time" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写创建时间">
            </div>
            <div class="fitem">
                <label>修改时间</label>
                <input name="update_time" type="text" maxlength="" class="easyui-validatebox"
                       data-options="required:true" missingMessage="请填写修改时间">
            </div>
            <div class="fitem">
                <label>状态（0：删除 1：有效）</label>
                <input name="state" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写状态（0：删除 1：有效）">
            </div>
            <div class="fitem">
                <label>备注</label>
                <input name="remark" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写备注">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-feedback.js"></script>
</body>
</html>
