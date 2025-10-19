# Read All
SELECT * FROM videojuegos;

# Read 1
SELECT * FROM videojuegos WHERE id = 1

# Delete where
DELETE FROM videojuegos WHERE id = 2

# Update
UPDATE videojuegos
SET titulo = "Celeste2",
		genero = "Plataformas"
WHERE id LIKE 3

# Insert
INSERT INTO videojuegos(titulo, genero, plataforma, anio, valoracion) VALUES
("Amnesia", "Terror","PC",2010,10)