package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alber on 2016/9/1.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
}
