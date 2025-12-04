package top.wby.common;

import lombok.Data;

@Data
public class Result {
    private String code;
    private String message;
    private Long total;
    private Object data;
    public static Result fail(){
        return result(400,"操作失败",0L,null);
    }
    public static Result fail(Object data){
        return result(400,"操作失败",0L,data);
    }
    public static Result success(){
        return result(200,"操作成功",0L,null);
    }
    public static Result success(Object data,String  message){
        return result(200,message,0L,data);
    }
    public static Result success(Object data){
        return result(200,"操作成功",0L,data);
    }
    public static Result success(Object data,Long total ){
        return result(200,"操作成功",total,data);
    }
    public static Result result(int code, String message,Long total, Object data){
        Result result = new Result();
        result.setCode(code+"");
        result.setMessage(message);
        result.setTotal(total);
        result.setData(data);
        return result;
    }
}
