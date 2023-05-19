package POJOs;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class  collectionOfIsbns {

    private String isbn;

}
