package an.royal.gateway.http.constants;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by carl.huang on 19/05/2017.
 */
public enum ResponseErrorCode {

    USER_NOT_FOUND("E1001", "user not found"),
    UNAUTHENTICATED_CLIENT("E1002", "Unauthenticated client"),
    ACCESS_DENY("E1003", "Access deny");

    private String code;
    private String title;

    private ResponseErrorCode(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public static Optional<ResponseErrorCode> getStatus(String code) {
        return Arrays.stream(ResponseErrorCode.values()).filter(r -> r.getCode().equals(code)).findFirst();
    }
    }
