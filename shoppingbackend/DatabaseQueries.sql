Create Table category (
id IDENTITY,
name VARCHAR(150),
description VARCHAR (255),
image_url VARCHAR(150),
is_active BOOLEAN,

CONSTRAINT pk_category_id primary Key (id)
)