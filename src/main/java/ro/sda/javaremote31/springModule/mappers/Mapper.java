package ro.sda.javaremote31.springModule.mappers;

public interface Mapper <E,D>{
    D convertToDto(E entity);
    E convertToEntity(D dto);
}
