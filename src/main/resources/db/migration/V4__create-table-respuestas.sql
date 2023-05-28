CREATE TABLE respuestas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje MEDIUMTEXT NOT NULL,
    topico BIGINT NOT NULL,
    fecha_creacion date NOT NULL,
    usuario bigint NOT NULL,
    solucion tinyINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (topico) REFERENCES topicos(id),
    FOREIGN KEY (usuario) REFERENCES usuarios(id)
)