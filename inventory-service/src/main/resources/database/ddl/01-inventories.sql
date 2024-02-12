CREATE TABLE IF NOT EXISTS inventories (
    id SERIAL NOT NULL,
    sku VARCHAR(50) NOT NULL,
    quantity int NOT NULL,
    CONSTRAINT "pk_inventories" PRIMARY KEY (id)
);