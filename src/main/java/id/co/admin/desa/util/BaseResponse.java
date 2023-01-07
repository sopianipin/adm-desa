package id.co.admin.desa.util;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BaseResponse {
    Integer statusCode;
    String message;
    Date timestamp;
    String error;
    Object content;
}
