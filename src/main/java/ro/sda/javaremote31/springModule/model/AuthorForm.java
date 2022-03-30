package ro.sda.javaremote31.springModule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorForm {


    private Long id;

    @NotNull
    private String name;

    private String lastName;
    private String nationality;


}
