package POJOs;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
@Jacksonized
@Builder
@Data
public class book {

    private String userId;
    private List< collectionOfIsbns> collectionOfIsbns;

}
