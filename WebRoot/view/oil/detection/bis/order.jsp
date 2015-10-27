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
            <label class="ui-label">用户id:</label><input name="user_id" class="easyui-box ui-text" style="width:100px;">
            <label class="ui-label">产品id:</label><input name="product_id" class="easyui-box ui-text"
                                                        style="width:100px;">
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
            <div class="ftitle">订单管理</div>
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
            <div class="fitem">
                <label>供应商id</label>
                <input name="supplier_id" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写供应商id">
            </div>
            <div class="fitem">
                <label>订单类型（1：直营订单 2：免费代采）</label>
                <input name="order_type" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写订单类型">
            </div>
            <div class="fitem">
                <label>单价</label>
                <input name="price" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写单价">
            </div>
            <div class="fitem">
                <label>数量</label>
                <input name="number" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写数量">
            </div>
            <div class="fitem">
                <label>订单总价</label>
                <input name="total_price" type="text" maxlength="" class="easyui-numberbox"
                       data-options="precision:2,groupSeparator:','" missingMessage="请填写订单总价">
            </div>
            <div class="fitem">
                <label>付款方式</label>
                <input name="pay_type" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写付款方式">
            </div>
            <div class="fitem">
                <label>提货方式</label>
                <input name="delivery_type" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写提货方式">
            </div>
            <div class="fitem">
                <label>提货车牌号</label>
                <input name="car_number" type="text" maxlength="16" class="easyui-validatebox" data-options=""
                       missingMessage="请填写提货车牌号">
            </div>
            <div class="fitem">
                <label>收货人姓名</label>
                <input name="receiver_name" type="text" maxlength="16" class="easyui-validatebox" data-options=""
                       missingMessage="请填写收货人姓名">
            </div>
            <div class="fitem">
                <label>收货人电话</label>
                <input name="receiver_phone" type="text" maxlength="16" class="easyui-validatebox" data-options=""
                       missingMessage="请填写收货人电话">
            </div>
            <div class="fitem">
                <label>收货人地址</label>
                <input name="receiver_addr" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写收货人地址">
            </div>
            <div class="fitem">
                <label>其他要求</label>
                <input name="other_require" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写其他要求">
            </div>
            <div class="fitem">
                <label>下单时间</label>
                <input name="create_time" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写下单时间">
            </div>
            <div class="fitem">
                <label>修改时间</label>
                <input name="update_time" type="text" maxlength="" class="easyui-validatebox"
                       data-options="required:true" missingMessage="请填写修改时间">
            </div>
            <div class="fitem">
                <label>送达时间</label>
                <input name="arrival_time" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写送达时间">
            </div>
            <div class="fitem">
                <label>备注</label>
                <input name="remark" type="text" maxlength="255" class="easyui-validatebox" data-options=""
                       missingMessage="请填写备注">
            </div>
            <div class="fitem">
                <label>状态</label>
                <input name="state" type="text" maxlength="" class="easyui-validatebox" data-options=""
                       missingMessage="请填写状态">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=basePath%>/view/oil/detection/bis/page-order.js"></script>
</body>
</html>
