package com.wanho.java146.enumpck;

/**
 * 转账业务 枚举值
 */
public enum TransferType {
    CURRENT_ACCOUNT_NOT_EXIST {
        @Override
        public String getMsg() {
            return "当前账号不存在";
        }
    },
    TARGET_ACCOUNT_NOT_EXIST {
        @Override
        public String getMsg() {
            return "目标账号不存在";
        }
    },
    INSUFFICIENT_BALANCE {
        @Override
        public String getMsg() {
            return "余额不足";
        }
    },
    TRANSFER_FAILED {
        @Override
        public String getMsg() {
            return "转账失败";
        }
    },
    SUCCESSFUL_TRANSFER {
        @Override
        public String getMsg() {
            return "转账成功";
        }
    };

    public abstract String getMsg() ;
}
