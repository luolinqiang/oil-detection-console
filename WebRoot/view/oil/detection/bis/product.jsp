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
            <label class="ui-label">产品类型:</label>
            <select class="easyui-combobox" name="oil_type" data-options="required:true">
                <option value="1" selected="selected">柴油</option>
                <option value="2">汽油</option>
            </select>
            <label class="ui-label">库存:</label><input name="inventory" class="easyui-box ui-text" style="width:100px;">
            <label class="ui-label">审核状态:</label>
            <select class="easyui-combobox" name="state" data-options="required:true">
                <option value="1" selected="selected">待审核</option>
                <option value="2">审核通过</option>
            </select>
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
            <div class="ftitle">产品管理</div>
            <div class="fitem">
                <label>产品类型</label>
                <select name="type" class="easyui-combobox" data-options="required:true">
                    <option value="1" selected="checked">柴油</option>
                    <option value="2">汽油</option>
                </select>
            </div>
            <div class="fitem">
                <label>库存</label>
                <input name="inventory" type="text" maxlength="" class="easyui-validatebox"
                       data-options="precision:2,groupSeparator:','"
                       missingMessage="请填写库存">
            </div>
            <div class="fitem">
                <label>产品名称</label>
                <input name="name" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写产品名称">
            </div>
            <div class="fitem">
                <label>价格</label>
                <input name="price" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写价格">
            </div>
            <div class="fitem">
                <label>质量标准</label>
                <select id="quality_standard" name="quality_standard" class="easyui-combobox"
                        data-options="required:true"
                        style="width: 50px" missingMessage="请填写质量标准">
                </select>
            </div>
            <div class="fitem">
                <label>产品型号</label>
                <select id="product_model" name="product_model" class="easyui-combobox" data-options="required:true"
                        style="width: 50px" missingMessage="请填写产品型号">
                </select>
            </div>
            <div class="fitem">
                <label>提油地点</label>
                <input name="product_addr" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写提油地点">
            </div>
            <div class="fitem">
                <label>密度</label>
                <input name="density" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写密度">
            </div>
            <div class="fitem">
                <label>闪点</label>
                <input name="flash_point" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写闪点">
            </div>
            <div class="fitem">
                <label>十六烷值</label>
                <input name="cetane_number" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写十六烷值">
            </div>
            <div class="fitem">
                <label>冷滤点</label>
                <input name="cfpp" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写冷滤点">
            </div>
            <div class="fitem">
                <label>颜色</label>
                <select id="color" name="color" class="easyui-combobox"
                        data-options="required:true"
                        style="width: 50px" missingMessage="请填写颜色">
                </select>
            </div>
            <div class="fitem">
                <label>馏程</label>
                <input name="boiling_range" type="text" maxlength="32" class="easyui-validatebox" data-options=""
                       missingMessage="请填写馏程">
            </div>
            <div class="fitem">
                <label>详情</label>
                <input name="details" type="text" maxlength="65535" class="easyui-validatebox" data-options=""
                       missingMessage="请填写详情">
            </div>
            <div class="fitem">
                <label>硫含量</label>
                <input name="sulphur_content" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写硫含量">
            </div>
            <div class="fitem">
                <label>供应商</label>
                <input id="supplier_id" class="hidden" name="supplier_id">
                <input id="supplier_name" name="supplier_name" type="text" maxlength="" class="easyui-validatebox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写供应商">
                <a href="#" id="supplier-select-btn" class="easyui-linkbutton" iconCls="icon-search">选择</a>
            </div>
            <%--<div class="fitem">--%>
            <%--<label>供应商id</label>--%>
            <%--<input name="supplier_id" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
            <%--missingMessage="请填写供应商id">--%>
            <%--</div>--%>
        </div>
    </form>
</div>

<!-- Edit Win&Form -->
<div id="supplier-select-win" class="easyui-dialog" title="" data-options="closed:true,iconCls:'icon-save',modal:true"
     style="width:800px;height:380px;">
</div>
<script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-product.js"></script>
</body>
</html>
