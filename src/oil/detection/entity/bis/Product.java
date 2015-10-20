package oil.detection.entity.bis;import com.base.entity.BaseEntity;import java.math.BigDecimal;import java.util.Date;/** * <b>功能：</b>ProductEntity<br> */public class Product extends BaseEntity {    private java.lang.Integer id;//    private java.lang.Integer type;//   产品类型（1：汽油 2柴油）    private java.lang.Integer inventory;//   库存    private java.lang.String name;//   产品名称    private BigDecimal price;//   价格    private java.lang.Integer quality_standard;//   质量标准    private java.lang.Integer product_model;//   产品型号    private java.lang.Integer product_addr;//   提油地点    private BigDecimal density;//   密度    private BigDecimal flash_point;//   闪点    private BigDecimal cetane_number;//   十六烷值    private BigDecimal cfpp;//   冷滤点    private java.lang.Integer color;//   颜色    private java.lang.String boiling_range;//   馏程    private java.lang.Integer details_type;//   详情类型（1：链接 2：文本）    private java.lang.Object details;//   详情    private BigDecimal sulphur_content;//   硫含量    private Date create_time;//   创建时间    private Date update_time;//   修改时间    private java.lang.Integer state;//   状态(0：删除 1：暂存 2：发布)    private java.lang.String remark;//   备注    private java.lang.Integer supplier_id;//   供应商id    public java.lang.Integer getId() {        return this.id;    }    public void setId(java.lang.Integer id) {        this.id = id;    }    public java.lang.Integer getType() {        return this.type;    }    public void setType(java.lang.Integer type) {        this.type = type;    }    public java.lang.Integer getInventory() {        return this.inventory;    }    public void setInventory(java.lang.Integer inventory) {        this.inventory = inventory;    }    public java.lang.String getName() {        return this.name;    }    public void setName(java.lang.String name) {        this.name = name;    }    public BigDecimal getPrice() {        return this.price;    }    public void setPrice(BigDecimal price) {        this.price = price;    }    public java.lang.Integer getQuality_standard() {        return this.quality_standard;    }    public void setQuality_standard(java.lang.Integer quality_standard) {        this.quality_standard = quality_standard;    }    public java.lang.Integer getProduct_model() {        return this.product_model;    }    public void setProduct_model(java.lang.Integer product_model) {        this.product_model = product_model;    }    public java.lang.Integer getProduct_addr() {        return this.product_addr;    }    public void setProduct_addr(java.lang.Integer product_addr) {        this.product_addr = product_addr;    }    public BigDecimal getDensity() {        return this.density;    }    public void setDensity(BigDecimal density) {        this.density = density;    }    public BigDecimal getFlash_point() {        return this.flash_point;    }    public void setFlash_point(BigDecimal flash_point) {        this.flash_point = flash_point;    }    public BigDecimal getCetane_number() {        return this.cetane_number;    }    public void setCetane_number(BigDecimal cetane_number) {        this.cetane_number = cetane_number;    }    public BigDecimal getCfpp() {        return this.cfpp;    }    public void setCfpp(BigDecimal cfpp) {        this.cfpp = cfpp;    }    public java.lang.Integer getColor() {        return this.color;    }    public void setColor(java.lang.Integer color) {        this.color = color;    }    public java.lang.String getBoiling_range() {        return this.boiling_range;    }    public void setBoiling_range(java.lang.String boiling_range) {        this.boiling_range = boiling_range;    }    public java.lang.Integer getDetails_type() {        return this.details_type;    }    public void setDetails_type(java.lang.Integer details_type) {        this.details_type = details_type;    }    public java.lang.Object getDetails() {        return this.details;    }    public void setDetails(java.lang.Object details) {        this.details = details;    }    public BigDecimal getSulphur_content() {        return this.sulphur_content;    }    public void setSulphur_content(BigDecimal sulphur_content) {        this.sulphur_content = sulphur_content;    }    public Date getCreate_time() {        return create_time;    }    public void setCreate_time(Date create_time) {        this.create_time = create_time;    }    public Date getUpdate_time() {        return update_time;    }    public void setUpdate_time(Date update_time) {        this.update_time = update_time;    }    public java.lang.Integer getState() {        return this.state;    }    public void setState(java.lang.Integer state) {        this.state = state;    }    public java.lang.String getRemark() {        return this.remark;    }    public void setRemark(java.lang.String remark) {        this.remark = remark;    }    public java.lang.Integer getSupplier_id() {        return this.supplier_id;    }    public void setSupplier_id(java.lang.Integer supplier_id) {        this.supplier_id = supplier_id;    }}