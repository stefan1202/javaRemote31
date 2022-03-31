package ro.sda.javaremote31.springModule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookForm {

    private Integer id;
    @NotNull
    private Long author;

    @NotNull
    @Size(min = 5)
    private String title;

    @NotNull
    private String type;

    @NotNull
    @Min(5)
    @Max(500)
    private Integer pagesNumber;

}

