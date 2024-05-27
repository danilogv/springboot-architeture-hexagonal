package com.danilo.springbootarchiteturehexagonal.domain.utility;

import java.util.Base64;

public class Functions {

    public static String decodedBase64(String oldValue) {
        return new String(Base64.getDecoder().decode(oldValue));
    }

}
