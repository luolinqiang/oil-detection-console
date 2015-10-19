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
            <label class="ui-label">油类型:</label>
            <select class="easyui-combobox" name="oil_type" data-options="required:true">
                <option value="1" selected="selected">柴油</option>
                <option value="2">汽油</option>
            </select>
            <label class="ui-label">采购类型:</label>
            <select class="easyui-combobox" name="purchase_type" data-options="required:true">
                <option value="1" selected="selected">采购需求</option>
                <option value="2">代采申请</option>
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
            <div class="ftitle">采购商管理</div>
            <div class="fitem">
                <%--<label>油类型（1：柴油 2：汽油）</label>--%>
                <%--<input name="oil_type" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
                <%--missingMessage="请填写油类型（1：柴油 2：汽油）">--%>
                <label class="ui-label">油类型:</label>
                <select name="oil_type" class="easyui-combobox" data-options="required:true">
                    <option value="1" selected="selected">柴油</option>
                    <option value="2">汽油</option>
                </select>
            </div>
            <div class="fitem">
                <%--<label>采购类型（1：采购需求 2：代采申请）</label>--%>
                <%--<input name="purchase_type" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
                <%--missingMessage="请填写采购类型（1：采购需求 2：代采申请）">--%>
                <label class="ui-label">采购类型:</label>
                <select name="purchase_type" class="easyui-combobox" data-options="required:true">
                    <option value="1" selected="selected">采购需求</option>
                    <option value="2">代采申请</option>
                </select>
            </div>
            <div class="fitem">
                <label>质量标准</label>
                <%--<input name="quality_standard" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
                <%--missingMessage="请填写质量标准">--%>
                <select id="quality_standard" name="quality_standard" class="easyui-combobox" data-options="required:true"
                        missingMessage="请填写质量标准">
                </select>
            </div>
            <div class="fitem">
                <label>产品型号</label>
                <%--<input name="product_model" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
                <%--missingMessage="请填写产品型号">--%>
                <select name="product_model" class="easyui-combobox" data-options="required:true"
                        missingMessage="请填写产品型号">
                </select>
            </div>
            <div class="fitem">
                <label>需求数量</label>
                <input name="number" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写需求数量">
            </div>
            <div class="fitem">
                <label>付款方式</label>
                <%--<input name="pay_type" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
                <%--missingMessage="请填写付款方式">--%>
                <select name="pay_type" class="easyui-combobox" data-options="required:true" missingMessage="请填写付款方式">
                </select>
            </div>
            <div class="fitem">
                <label>提货方式</label>
                <%--<input name="delivery_type" type="text" maxlength="" class="easyui-validatebox" data-options=""--%>
                <%--missingMessage="请填写提货方式">--%>
                <select name="pay_type" class="delivery_type" data-options="required:true" missingMessage="请填写提货方式">
                </select>
            </div>
            <div class="fitem">
                <label>提货地址</label>
                <input name="delivery_addr" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写提货地址">
            </div>
            <div class="fitem">
                <label>条件</label>
                <input name="conditions" type="text" maxlength="65535" class="easyui-validatebox" data-options=""
                       missingMessage="请填写条件">
            </div>
            <div class="fitem">
                <label> 其他要求</label>
                <input name="other_require" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写 其他要求">
            </div>
            <div class="fitem">
                <label>创建时间</label>
                <input name="create_time" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写创建时间">
            </div>
            <div class="fitem">
                <label>update_time</label>
                <input name="update_time" type="text" maxlength="" class="easyui-validatebox"
                       data-options="required:true" missingMessage="请填写update_time">
            </div>
            <div class="fitem">
                <label>备注</label>
                <input name="remark" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写备注">
            </div>
            <div class="fitem">
                <label>用户id</label>
                <input name="user_id" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写用户id">
            </div>
            <div class="fitem">
                <label>产品id</label>
                <input name="product_id" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写产品id">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-purchase.js"></script>
</body>
</html>
