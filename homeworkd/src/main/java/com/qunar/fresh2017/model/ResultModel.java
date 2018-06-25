package com.qunar.fresh2017.model;

public class ResultModel<T> {

    static final ResultModel successEmptyResult = new ResultModel();

    static {
        successEmptyResult.setRet(true);
    }

    /**
     * 访问结果
     */
    private boolean ret;
    /**
     * 错误信息
     */
    private String errmsg;

    /**
     * 返回对象
     */
    private T data;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResultModel getErrorResult(String errmsg) {
        ResultModel resultModel = new ResultModel();
        resultModel.setRet(false);
        resultModel.setErrmsg(errmsg);
        return resultModel;
    }

    public static ResultModel getSuccessEmptyResult() {
        return successEmptyResult;
    }

    public static <T> ResultModel<T> getSuccessResult(T data) {
        ResultModel<T> resultModel = new ResultModel<T>();
        resultModel.setRet(true);
        resultModel.setData(data);
        resultModel.setErrmsg("");
        return resultModel;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "ret=" + ret +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}

