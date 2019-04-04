package com.lh.starkey.myenum;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.myenum
 * @date:2019/3/29
 */
public enum ResultCode {

    /*公用返回状态*/
    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,10001,"操作失败!"),

    /*认证部分*/
    UNAUTHENTICATED(false,10002,"您还未登录!"),
    UNAUTHORISE(false,10003,"权限不足!"),
    USERNAMEORPASSWORDERROR(false,10004,"用户名或密码错误!"),
    USERNAME_IS_ERROR(false,10005,"用户名不存在!"),
    PASSWORD_IS_ERROR(false,10006,"密码错误!"),
    USERNAMEORPASSWORDISNULL(false,10007,"用户名或密码为空!"),
    LOCKEDACCOUNT(false,10008,"账户被锁定，请联系管理员!"),
    ERRORCOUNT_IS_MAX(false,10009,"错误次数已达上限，请稍后重试!"),
    LOGIN_TIMEOUT(false,10010,"登录超时，请重新登录!"),
    HMAC_ERROR(false,10011,"HMAC认证失败，请重试!"),
    TOKEN_IS_ILLEAGE(false,10012,"非法token!"),
    LOGINOUT_SUCCESS(false,10013,"退出登录成功!"),

    AUTH_USERNAME_NONE(false,20001,"请输入账号！"),
    AUTH_PASSWORD_NONE(false,20002,"请输入密码！"),
    AUTH_VERIFYCODE_NONE(false,20003,"请输入验证码！"),
    AUTH_ACCOUNT_NOTEXISTS(false,20004,"账号不存在！"),
    AUTH_CREDENTIAL_ERROR(false,20005,"账号或密码错误！"),
    AUTH_LOGIN_ERROR(false,20006,"登陆过程出现异常请尝试重新操作！"),
    AUTH_LOGIN_APPLYTOKEN_FAIL(false,20007,"申请令牌失败！"),
    AUTH_LOGIN_TOKEN_SAVEFAIL(false,20008,"存储令牌失败！"),
    AUTH_LOGIN_VERTIFYCODE_GENERATE(false,20009,"错误次数达到三次，请输入验证码！"),
    AUTH_VERTIFYCODE_ERROR(false,20010,"验证码不正确，请重试！"),
    AUTH_VERTIFYCODE_TIMEOUT(false,20011,"验证码已过期，请刷新获取新的验证码！"),
    AUTH_ACCOUNT_IS_FREEZING(false,20012,"账户被冻结，请联系管理员!"),

    INTERFACE_CALL_FAILED(false,30000,"接口调用失败"),
    INVALID_PARAM(false,30001,"非法参数！"),
    USER_INFORMATION_ACQUISITION_FAILED(false,30002,"从redis获取用户信息失败！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");







    //---用户操作返回码  2xxxx----
    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    private boolean success;
    //操作代码
    private int code;
    //提示信息
    private String message;

    ResultCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
