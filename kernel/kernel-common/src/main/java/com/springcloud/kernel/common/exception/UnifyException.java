package com.springcloud.kernel.common.exception;
/**
* @className UnifyException
* @description 通用异常类
* @author liuc
* @date 2019-11-01 14:24
* @since JDK 1.8
**/
public class UnifyException extends RuntimeException
{
    private static final long serialVersionUID = -9090450565739536330L;
    protected UnifyErrorCode errorCode;
    protected String customState;
    protected String msg;

    /**
     * 用错误信息构建未知类型的异常
     * 此方法构建的异常信息的Code为SysContants.UNKNOW_FAIL_CODE
     * @param
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException()
    {
        this(UnifyErrorCode.UNKNOW_FAIL);
    }

    public UnifyException(UnifyErrorCode errorCode) {
        this(errorCode, errorCode.getMsg());
    }

    /**
     * 用错误码和错误信息构建异常
     * @param code
     * @param msg
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(UnifyErrorCode code, String msg)
    {
        this(code, msg, null);
    }

    /**
     * 使用Unify异常和抛出的异常信息构建通用异常
     * @param code
     * @param e
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(UnifyErrorCode code, Throwable e)
    {
        this(code, code.getMsg(), e);
    }

    /**
     * 用错误信息构建未知类型的异常
     * 此方法构建的异常信息的Code为SysContants.UNKNOW_FAIL_CODE
     * @param
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(String msg)
    {
        this(UnifyErrorCode.UNKNOW_FAIL, msg);
    }

    /**
     * 用错误码和错误信息构建异常
     * @param code
     * @param msg
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(String code, String msg)
    {
        this(code, msg, null);
    }

    /**
     * 使用异常信息和抛出的异常构建通用异常
     * @param msg
     * @param e
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(String msg, Throwable e)
    {
        this(UnifyErrorCode.UNKNOW_FAIL, msg, e);
    }

    /**
     * 使用异常代码，异常说明和抛出的异常信息构建通用异常
     * @param msg
     * @param e
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(String code, String msg, Throwable e)
    {
        this(UnifyErrorCode.parse(code), msg, e);

        if (!this.errorCode.getCode().equalsIgnoreCase(code)) {
            this.customState = code;
        }
    }

    /**
     * 使用抛出的异常信息构建通用异常
     * @param e
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(Throwable e)
    {
        this(UnifyErrorCode.UNKNOW_FAIL, e);
    }

    /**
     * 使用异常代码，异常说明和抛出的异常信息构建通用异常
     * @param code
     * @param msg
     * @param e
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public UnifyException(UnifyErrorCode code, String msg, Throwable e)
    {
        super(e);
        this.errorCode = code;
        this.msg = msg;
    }

    @Override
    public String getMessage()
    {
        return this.msg;
    }

    public UnifyErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getCustomState() {
        return this.customState;
    }
}
