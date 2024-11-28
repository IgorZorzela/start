package com.curso.api.start;

import lombok.Data;
@Data
public class Ola {

private final Long id;
private final String content;

public Ola(long id, String content) {
    this.id = id;
    this.content = content;
}
}
