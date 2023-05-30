ALTER TABLE topicos
ADD CONSTRAINT unique_titulo UNIQUE (titulo(255));