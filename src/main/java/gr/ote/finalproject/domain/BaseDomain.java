package gr.ote.finalproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BaseDomain  implements Serializable {

    private Long id;
}
