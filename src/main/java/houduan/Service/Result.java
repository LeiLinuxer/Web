package houduan.Service;

public class Result<T> {
    private Integer code; // 状态码
    private String message; // 提示信息
    private T data; // 业务数据

    // 成功静态方法（带数据）
    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    // 成功静态方法（无数据）
    public static Result<Void> success(String message) {
        return success(null, message);
    }

    // 失败静态方法
    public static Result<Void> fail(Integer code, String message) {
        Result<Void> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
// getter/setter省略
}