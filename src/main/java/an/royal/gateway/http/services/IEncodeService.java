package an.royal.gateway.http.services;

/**
 * Created by carl.huang on 19/05/2017.
 */
public interface IEncodeService {

    /**
     * Encode string data by base64.
     *
     * @param data
     * @return encoded data
     */
    String encodeData(String data);
}
