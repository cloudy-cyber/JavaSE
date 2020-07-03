package club.banyuan.July2.Homework.Recommend;


/**
 * @author zhangbenchao
 * @date 2020/7/2 8:48 下午
 * 文件描述：
 */
public class UnknownPersonException extends RuntimeException{
    private final String message;

    public UnknownPersonException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
