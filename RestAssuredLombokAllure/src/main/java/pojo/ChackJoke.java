package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChackJoke {
    String[] categories;
    String created_at;
    String icon_url;
    String id;
    String updated_at;
    String url;
    String value;
}
