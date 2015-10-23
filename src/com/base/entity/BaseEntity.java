package com.base.entity;


public class BaseEntity {

    /**
     * 状态枚举
     */
    public static enum STATE {
        ENABLE(0, "可用"), DISABLE(1, "禁用");
        public int key;
        public String value;

        private STATE(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static TYPE_COMMON get(int key) {
            TYPE_COMMON[] values = TYPE_COMMON.values();
            for (TYPE_COMMON object : values) {
                if (object.key == key) {
                    return object;
                }
            }
            return null;
        }
    }

    /**
     * 删除枚举
     */
    public static enum DELETED {
        NO(0, "未删除"), YES(1, "已删除");
        public int key;
        public String value;

        private DELETED(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static DELETED get(int key) {
            DELETED[] values = DELETED.values();
            for (DELETED object : values) {
                if (object.key == key) {
                    return object;
                }
            }
            return null;
        }
    }

    public static enum PIC_TYPE {
        BANNER(1, "banner"), PRODUCT(2, "商品"), SUPPLIER(3, "供应商");
        public int key;
        public String value;

        private PIC_TYPE(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static PIC_TYPE get(int key) {
            PIC_TYPE[] values = PIC_TYPE.values();
            for (PIC_TYPE object : values) {
                if (object.key == key) {
                    return object;
                }
            }
            return null;
        }
    }

    public static enum HOME_TYPE {
        BANNER(1, "banner"), DIRECTSALE(2, "直营专区"), CSBJ(3, "厂商报价"), LINK(4, "外链");
        public int key;
        public String value;

        private HOME_TYPE(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static HOME_TYPE get(int key) {
            HOME_TYPE[] values = HOME_TYPE.values();
            for (HOME_TYPE object : values) {
                if (object.key == key) {
                    return object;
                }
            }
            return null;
        }
    }

    public static enum STATE_COMMON {
        DELETE(0, "删除"), SAVE(1, "暂存"), PUBLICATION(2, "发布");
        public int key;
        public String value;

        private STATE_COMMON(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static STATE_COMMON get(int key) {
            STATE_COMMON[] values = STATE_COMMON.values();
            for (STATE_COMMON object : values) {
                if (object.key == key) {
                    return object;
                }
            }
            return null;
        }
    }

    public static enum TYPE_COMMON {
        ONE(1, "非自营"), TWO(2, "直营"), THREE(3, "THREE"), FORE(4, "FORE");
        public int key;
        public String value;

        private TYPE_COMMON(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static TYPE_COMMON get(int key) {
            TYPE_COMMON[] values = TYPE_COMMON.values();
            for (TYPE_COMMON object : values) {
                if (object.key == key) {
                    return object;
                }
            }
            return null;
        }
    }

}
