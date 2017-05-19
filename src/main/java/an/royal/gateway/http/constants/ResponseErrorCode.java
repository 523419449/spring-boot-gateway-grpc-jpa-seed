package an.royal.gateway.http.constants;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by carl.huang on 19/05/2017.
 */
public enum ResponseErrorCode {

    USER_NOT_FOUND(10001);

    private int code;

    private ResponseErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static Optional<ResponseErrorCode> getStatus(int code) {
        return Arrays.stream(ResponseErrorCode.values()).findFirst();
    }
}
