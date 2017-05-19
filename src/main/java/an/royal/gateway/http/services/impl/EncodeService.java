package an.royal.gateway.http.services.impl;

import an.royal.gateway.http.services.IEncodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * Created by carl.huang on 19/05/2017.
 */
@Service
public class EncodeService implements IEncodeService {
    private static final Logger log = LoggerFactory.getLogger(EncodeService.class);

    @Override
    public String encodeData(String data) {
        log.debug("Starting to encode data: {}", data);
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
